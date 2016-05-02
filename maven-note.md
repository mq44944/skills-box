Apache Maven 是一个项目管理和构建自动化工具，它包含了一个项目对象模型 (Project Object Model)，一组标准集合，一个项目生命周期(Project Lifecycle)，一个依赖管理系统(Dependency Management System)和用来运行定义在生命周期阶段(phase)中插件(plugin)目标(goal)的逻辑。
*********
 
Maven 遵循约定优于配置的概念，它给项目提供一系列的默认行为。它要求在没有定制之前，所有的项目都有如下的结构：  

	${basedir}	存放 pom.xml和所有的子目录  
	${basedir}/src/main/java	项目的 java源代码  
	${basedir}/src/main/resources	项目的资源，比如说 property文件  
	${basedir}/src/test/java	项目的测试类，比如说 JUnit代码  
	${basedir}/src/test/resources	测试使用的资源  
一个 Maven 项目在默认情况下会产生 JAR 文件，编译后 的 classes文件 会放在 ${basedir}/target/classes下面， JAR 文件会放在 ${basedir}/target下面。
    
### 什么是构建生命周期
构建生命周期是一组阶段的序列（sequence of phases），每个阶段定义了目标被执行的顺序。这里的阶段是生命周期的一部分。

举例说明，一个典型的 Maven 构建生命周期是由以下几个阶段的序列组成的：
   
阶段	处理	描述   
	
	prepare-resources	资源拷贝	本阶段可以自定义需要拷贝的资源  
	compile	编译	本阶段完成源代码编译  
	package	打包	本阶段根据 pom.xml 中描述的打包配置创建 JAR / WAR 包  
	install	安装	本阶段在本地 / 远程仓库中安装工程包  
 
### Default (or Build) 生命周期
这是 Maven 的主要生命周期，被用于构建应用。包括下面的 23 个阶段。
![...](http://7xi2wq.com1.z0.glb.clouddn.com/maven_lifecycle.png)
### Maven常用命令
	创建Maven的普通java项目：   
    mvn archetype:create
    -DgroupId=packageName 
    -DartifactId=projectName  
   
	创建Maven的Web项目：
    mvn archetype:create 
    -DgroupId=packageName
    -DartifactId=webappName 
    -DarchetypeArtifactId=maven-archetype-webapp    
    
    自动创建项目：
    mvn archetype:generate
    
    mvn jar:jar   打jar包
	mvn install -Dmaven.test.skip=true 给任何目标添加maven.test.skip 属性就能跳过测试 
	mvn compile 编译你的项目 
	mvn clean install 删除再编译 
	mvn -version/-v  显示版本信息 
	mvn package      生成target目录，编译、测试代码，生成测试报告，生成jar/war文件 
	mvn jetty:run    运行项目于jetty上
	mvn compile      编译 
	mvn test         编译并测试 
	mvn clean        清空生成的文件 
	mvn site         生成项目相关信息的网站 
	mvn idea:idea                将项目转化为IDEA项目 
	mvn -e            显示详细错误 信息. 
	mvn validate        验证工程是否正确，所有需要的资源是否可用。 
	mvn test-compile    编译项目测试代码。 。 
	mvn integration-test     在集成测试可以运行的环境中处理和发布包。 
	mvn verify        运行任何检查，验证包是否有效且达到质量标准。     
	mvn generate-sources    产生应用需要的任何额外的源代码，如xdoclet。 

在应用程序用使用多个存储库 

	<repositories>    
	    <repository>      
	        <id>Ibiblio</id>      
	        <name>Ibiblio</name>      
	        <url>http://www.ibiblio.org/maven/</url>    
	    </repository>    
	    <repository>      
	        <id>PlanetMirror</id>      
	        <name>Planet Mirror</name>      
	        <url>http://public.planetmirror.com/pub/maven/</url>    
	    </repository>  
	</repositories> 



### 参考资料
* [Maven 教程| 极客学院 Wiki](http://wiki.jikexueyuan.com/project/maven/)  
