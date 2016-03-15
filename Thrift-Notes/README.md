### Apache Thrift 跨语言服务开发框架
Thrift最初由Facebook研发，主要用于各个服务之间的RPC通信，支持跨语言，常用的语言比如C++, Java, Python, PHP, Ruby, Erlang, Perl, Haskell, C#, Cocoa, JavaScript, Node.js, Smalltalk, and OCaml都支持。Thrift是一个典型的CS（客户端/服务端）结构，客户端和服务端可以使用不同的语言开发。既然客户端和服务端能使用不同的语言开发，那么一定就要有一种中间语言来关联客户端和服务端的语言，没错，这种语言就是IDL（Interface Description Language）。

Apache Thrift 不仅支持定义 RPC 服务接口，还提供了支持 RPC 服务实现的完整的堆栈结构，并为 RPC 服务的 Server 端和 Client 端直接生成了可用代码。如下图描绘了 Thrift 的堆栈架构。  
![](http://images.cnitblog.com/blog/175043/201501/132207169643199.png)

#### 传输层（Transport）
传输层提供对网络 I/O 的抽象，通过 Transport 对客户端进行抽象，ServerTransport 对服务端进行抽象。

	TTransport  
		TBufferedTransport  
		TFramedTransport  
		TStreamTransport  
			TSocket  
			TTLSSocket  
		THttpClient
		TMemoryBuffer
		TNamedPipeClientTransport
	TServerTransport
		TServerSocket
		TTLSServerSocket
		TNamedPipeServerTransport
#### 协议层（Protocol）
协议层抽象了数据结构的定义，描述了如何组织数据以进行传输，包括 Encode 和 Decode 数据处理。所以，协议层负责实现数据的序列化和反序列化机制，例如序列化 Json, XML, Plain Text, Binary, Compact Binary 等。

协议层抽象了大量的读写操作接口，以供扩展。  

	public abstract void WriteMessageBegin(TMessage message);
	  public abstract void WriteMessageEnd();
	  public abstract void WriteStructBegin(TStruct struc);
	  public abstract void WriteStructEnd();
	  public abstract void WriteFieldBegin(TField field);
	  public abstract void WriteFieldEnd();
	  public abstract void WriteFieldStop();
	  public abstract void WriteMapBegin(TMap map);
	  public abstract void WriteMapEnd();
	  public abstract void WriteListBegin(TList list);
	  public abstract void WriteListEnd();
	  public abstract void WriteSetBegin(TSet set);
	  public abstract void WriteSetEnd();
	  public abstract void WriteBool(bool b);
	  public abstract void WriteByte(sbyte b);
	  public abstract void WriteI16(short i16);
	  public abstract void WriteI32(int i32);
	  public abstract void WriteI64(long i64);
	  public abstract void WriteDouble(double d);
	  public virtual void WriteString(string s);
	  public abstract void WriteBinary(byte[] b);
	  
	  public abstract TMessage ReadMessageBegin();
	  public abstract void ReadMessageEnd();
	  public abstract TStruct ReadStructBegin();
	  public abstract void ReadStructEnd();
	  public abstract TField ReadFieldBegin();
	  public abstract void ReadFieldEnd();
	  public abstract TMap ReadMapBegin();
	  public abstract void ReadMapEnd();
	  public abstract TList ReadListBegin();
	  public abstract void ReadListEnd();
	  public abstract TSet ReadSetBegin();
	  public abstract void ReadSetEnd();
	  public abstract bool ReadBool();
	  public abstract sbyte ReadByte();
	  public abstract short ReadI16();
	  public abstract int ReadI32();
	  public abstract long ReadI64();
	  public abstract double ReadDouble();
	  public virtual string ReadString();
	  public abstract byte[] ReadBinary();

#### 处理层（Processor）
Processor 封装了对输入输出流的读写操作，输入输出流也就代表着协议层处理的对象。Processor 接口定义的极其简单。  

	  public interface TProcessor
	  {
	    bool Process(TProtocol iprot, TProtocol oprot);
	  }
#### 服务层（Server）
Server 将所有功能整合到一起：

	创建一个 Transport；
	创建 Transport 使用的 I/O Protocol；
	为 I/O Protocol 创建 Processor；
	启动服务，等待客户端的连接；
通过抽象 TServer 类来提供上述整合。

	TServer
		TSimpleServer -- Simple single-threaded server for testing.
		TThreadedServer -- Server that uses C# threads (as opposed to the ThreadPool) when handling requests.
		TThreadPoolServer -- Server that uses C# built-in ThreadPool to spawn threads when handling requests.
		
  
****

	public TServer(TProcessor processor,
	              TServerTransport serverTransport,
	              TTransportFactory inputTransportFactory,
	              TTransportFactory outputTransportFactory,
	              TProtocolFactory inputProtocolFactory,
	              TProtocolFactory outputProtocolFactory,
	              LogDelegate logDelegate)
	    {
	    }
	
	    public abstract void Serve();
	    public abstract void Stop();
	  
#### Thrift 实例 
使用 Thrift 的过程：

	编写类似于结构体的消息格式定义，使用类似于 IDL 的语言定义。
	使用代码生成工具，生成目标语言代码。
	在程序中直接使用这些代码。	 
![](http://images.cnitblog.com/blog/175043/201501/132253028082227.png)

<http://www.cnblogs.com/gaochundong/p/apache_thrift.html>  
<http://wuchong.me/blog/2015/10/07/thrift-practice/>  
<http://qifuguang.me/2015/09/11/Thrift%E5%85%A5%E9%97%A8%E6%95%99%E7%A8%8B/>

#### 学习资源
* <http://dongxicheng.org/search-engine/thrift-framework-intro/>
* [Thrift Tutorial](http://thrift-tutorial.readthedocs.org/)
* [Thrift 入门教程](http://qifuguang.me/2015/09/11/Thrift%E5%85%A5%E9%97%A8%E6%95%99%E7%A8%8B/)
* [Apache Thrift - 可伸缩的跨语言服务开发框架 - IBM](https://www.ibm.com/developerworks/cn/java/j-lo-apachethrift/)
* [Thrift: The Missing Guide](https://diwakergupta.github.io/thrift-missing-guide/)