package com.yew1eb.thread; /**
 * Created by yew1eb on 2016/1/22 0022.
 */
/*
虽然线程池能大大提高服务器的并发性能，但使用它也会存在一定风险。与所有多线程应用程序一样，用线程池构建的应用程序容易产生各种并发问题，如对共享资源的竞争和死锁。此外，如果线程池本身的实现不健壮，或者没有合理地使用线程池，还容易导致与线程池有关的死锁、系统资源不足和线程泄漏等问题。

1．死锁
任何多线程应用程序都有死锁风险。造成死锁的最简单的情形是，线程A持有对象X的锁，并且在等待对象Y的锁，而线程B持有对象Y的锁，并且在等待对象X的锁。线程A与线程B都不释放自己持有的锁，并且等待对方的锁，这就导致两个线程永远等待下去，死锁就这样产生了。

虽然任何多线程程序都有死锁的风险，但线程池还会导致另外一种死锁。在这种情形下，假定线程池中的所有工作线程都在执行各自任务时被阻塞，它们都在等待某个任务A的执行结果。而任务A依然在工作队列中，由于没有空闲线程，使得任务A一直不能被执行。这使得线程池中的所有工作线程都永远阻塞下去，死锁就这样产生了。

2．系统资源不足
如果线程池中的线程数目非常多，这些线程会消耗包括内存和其他系统资源在内的大量资源，从而严重影响系统性能。

3．并发错误
线程池的工作队列依靠wait()和notify()方法来使工作线程及时取得任务，但这两个方法都难于使用。

如果编码不正确，可能会丢失通知，导致工作线程一直保持空闲状态，无视工作队列中需要处理的任务。因此使用这些方法时，必须格外小心，即便是专家也可能在这方面出错。最好使用现有的、比较成熟的线程池。例如，直接使用java.util.concurrent包中的线程池类。

4．线程泄漏
使用线程池的一个严重风险是线程泄漏。对于工作线程数目固定的线程池，如果工作线程在执行任务时抛出RuntimeException 或Error，并且这些异常或错误没有被捕获，那么这个工作线程就会异常终止，使得线程池永久失去了一个工作线程。如果所有的工作线程都异常终止，线程池就最终变为空，没有任何可用的工作线程来处理任务。

导致线程泄漏的另一种情形是，工作线程在执行一个任务时被阻塞，如等待用户的输入数据，但是由于用户一直不输入数据（可能是因为用户走开了），导致这个工作线程一直被阻塞。这样的工作线程名存实亡，它实际上不执行任何任务了。假如线程池中所有的工作线程都处于这样的阻塞状态，那么线程池就无法处理新加入的任务了。

5．任务过载
当工作队列中有大量排队等候执行的任务时，这些任务本身可能会消耗太多的系统资源而引起系统资源缺乏。

综上所述，线程池可能会带来种种风险，为了尽可能避免它们，使用线程池时需要遵循以下原则。

（1）如果任务A在执行过程中需要同步等待任务B的执行结果，那么任务A不适合加入到线程池的工作队列中。如果把像任务A一样的需要等待其他任务执行结果的任务加入到工作队列中，可能会导致线程池的死锁。

（2）如果执行某个任务时可能会阻塞，并且是长时间的阻塞，则应该设定超时时间，避免工作线程永久的阻塞下去而导致线程泄漏。在服务器程序中，当线程等待客户连接，或者等待客户发送的数据时，都可能会阻塞。可以通过以下方式设定超时时间：

◆调用ServerSocket的setSoTimeout(int timeout)方法，设定等待客户连接的超时时间，参见本章3.5.1节（SO_TIMEOUT选项）；
◆对于每个与客户连接的Socket，调用该Socket的setSoTimeout(int timeout)方法，设定等待客户发送数据的超时时间，参见本书第2章的2.5.3节（SO_TIMEOUT选项）。

（3）了解任务的特点，分析任务是执行经常会阻塞的I/O操作，还是执行一直不会阻塞的运算操作。前者时断时续地占用CPU，而后者对CPU具有更高的利用率。预计完成任务大概需要多长时间？是短时间任务还是长时间任务？

根据任务的特点，对任务进行分类，然后把不同类型的任务分别加入到不同线程池的工作队列中，这样可以根据任务的特点，分别调整每个线程池。

（4）调整线程池的大小。线程池的最佳大小主要取决于系统的可用CPU的数目，以及工作队列中任务的特点。假如在一个具有 N 个CPU的系统上只有一个工作队列，并且其中全部是运算性质（不会阻塞）的任务，那么当线程池具有 N 或 N+1 个工作线程时，一般会获得最大的 CPU 利用率。

如果工作队列中包含会执行I/O操作并常常阻塞的任务，则要让线程池的大小超过可用CPU的数目，因为并不是所有工作线程都一直在工作。选择一个典型的任务，然后估计在执行这个任务的过程中，等待时间（WT）与实际占用CPU进行运算的时间（ST）之间的比例WT/ST。对于一个具有N个CPU的系统，需要设置大约N×(1+WT/ST)个线程来保证CPU得到充分利用。

当然，CPU利用率不是调整线程池大小过程中唯一要考虑的事项。随着线程池中工作线程数目的增长，还会碰到内存或者其他系统资源的限制，如套接字、打开的文件句柄或数据库连接数目等。要保证多线程消耗的系统资源在系统的承载范围之内。

（5）避免任务过载。服务器应根据系统的承载能力，限制客户并发连接的数目。当客户并发连接的数目超过了限制值，服务器可以拒绝连接请求，并友好地告知客户：服务器正忙，请稍后再试。
*/
import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPooledServer implements Runnable{

    protected int          serverPort   = 8080;
    protected ServerSocket serverSocket = null;
    protected boolean      isStopped    = false;
    protected Thread       runningThread= null;
    protected ExecutorService threadPool =
            Executors.newFixedThreadPool(10);

    public ThreadPooledServer(int port){
        this.serverPort = port;
    }

    public void run(){
        synchronized(this){
            this.runningThread = Thread.currentThread();
        }
        openServerSocket();
        while(! isStopped()){
            Socket clientSocket = null;
            try {
                clientSocket = this.serverSocket.accept();
            } catch (IOException e) {
                if(isStopped()) {
                    System.out.println("Server Stopped.") ;
                    break;
                }
                throw new RuntimeException(
                        "Error accepting client connection", e);
            }
            this.threadPool.execute(
                    new WorkerRunnable(clientSocket,
                            "thread Pooled Server"));
        }
        this.threadPool.shutdown();
        System.out.println("Server Stopped.") ;
    }


    private synchronized boolean isStopped() {
        return this.isStopped;
    }

    public synchronized void stop(){
        this.isStopped = true;
        try {
            this.serverSocket.close();
        } catch (IOException e) {
            throw new RuntimeException("Error closing server", e);
        }
    }

    private void openServerSocket() {
        try {
            this.serverSocket = new ServerSocket(this.serverPort);
        } catch (IOException e) {
            throw new RuntimeException("Cannot open port 8080", e);
        }
    }
    public static void main(String args[]) {
        ThreadPooledServer server = new ThreadPooledServer(9000);
        new Thread(server).start();

        try {
            Thread.sleep(20 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Stopping Server");
        server.stop();
    }


}