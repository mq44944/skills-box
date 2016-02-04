准备工作

1) 官网下载并安装Android Studio，并通过其中的AVD manager和SDK manager下载配置相应的安卓模拟器和安卓开发包。

2) 官网下载Android NDK。用于支持与原生C++代码混编。

3) 官网下载并安装JAVA JDK。可以通过terminal或者cmd输入java -version进行检测。

4) 官网下载Cocos2d-x。

5) Windows 系统还需要官网下载并安装python。Mac自带python。


开干正事

1) 打开terminal或者cmd，运行cd进入你的cocos2d-x文件夹，我的就是cd ~/Documents/cocos2d-x-3.8。

2) 运行./setup.py，进行环境配置。在运行该命令时可能需要更高权限，因此需要在命令前加sudo，也就是sudo ./setup.py （可能会要求输入管理员密码）。在这一步中会配置COCOS_CONSOLE_ROOT, COCOS_TEMPLATES_ROOT环境变量。还会检查是否配置了ANDROID_SDK_ROOT和NDK_ROOT两个环境变量，如果之前没有配置过会要求进行配置。如果配置过当然也可以视需要对其进行修改。Mac可以通过以下两条命令进行配置：export ANDROID_SDK_ROOT="/Users/你的用户名/Libray/android/sdk"和export NDK_ROOT="你的android ndk存放路径"。可以打开Android Studio进入Preferences->Appearance & Behavior->System Settings->Android SDK看看里面路径是否和环境变量配置一致。

最后还会要求运行source Users/XXX/.bash_profile使配置生效。

3) 运行 cocos new HelloWorld -p com.memeda.HelloWorld -l cpp -d ~/Documents，新建HelloWorld项目。由于我们通过第二步配置好了环境，cocos命令才能在任意目录下运行。

4) 运行cd进入新建的项目目录下，我的是cd ~/Documents/HelloWorld。注意如果在上一步命令中写的是-d ~/Documents/HelloWorld，那么要进入第二层HelloWorld才行，也就是cd ~/Documents/HelloWorld/HelloWorld。

5) 运行cocos compile -p android --android-studio，进行编译。这一步会在proj.android-studio/app下生成一个libs文件夹，里面是编译出来的libcocos2dcpp.so库文件。注意命令里含有--android-studio，这是专门针对Android Studio进行编译。如果不运行这一步，原生C++代码无法运行。

另外还要注意，如果不是新建的HelloWorld项目，而是已经添加了其他C++源文件的项目，那么直接运行这一步会出现如下报错：error: undefined reference to 'vtable for XXX'。其中XXX就是某个源文件名。这是因为编译器没有在Android.mk文件里面找到相关源文件的地址。所以解决办法就是在这一步之前再添一步，用vi，或者nano，或者其他你喜欢的方式打开proj.android-studio/app/jni/Android.mk，往里面添加相关源文件地址（只要你打开这个mk文件一看就秒懂）。

6) 打开Android Studio，加载已有项目，也就是载入HelloWorld下面的proj.android-studio文件夹（这是cocos2d-x 3.7版之后才出现的，原来只有proj.android文件夹）。

7) 打开模拟器，运行项目，成功！
cocos run -s HelloWorld -p android --android-studio

