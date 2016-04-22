Apache Maven 是一套软件工程管理和整合工具。基于工程对象模型（POM）的概念，通过一个中央信息管理模块，Maven 能够管理项目的构建、报告和文档。
*********

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
1. 创建Maven的普通java项目：   

    mvn archetype:create
    -DgroupId=packageName 
    -DartifactId=projectName  
   
2. 创建Maven的Web项目：
 
    mvn archetype:create 
    -DgroupId=packageName
    -DartifactId=webappName 
    -DarchetypeArtifactId=maven-archetype-webapp    
    
3. 编译源代码： mvn compile 

4. 编译测试代码：mvn test-compile    

5. 运行测试：mvn test   

6. 产生site：mvn site   

7. 打包：mvn package   

8. 在本地Repository中安装jar：mvn install 

9. 清除产生的项目：mvn clean   

10. 生成eclipse项目：mvn eclipse:eclipse  

11. 生成idea项目：mvn idea:idea  

12. 组合使用goal命令，如只打包不测试：mvn -Dtest package   

13. 编译测试的内容：mvn test-compile  

14. 只打jar包: mvn jar:jar  

15. 只测试而不编译，也不测试编译：mvn test -skipping compile -skipping test-compile 
      ( -skipping 的灵活运用，当然也可以用于其他组合命令)  

********

常用命令：  

	mvn install -Dmaven.test.skip=true 给任何目标添加maven.test.skip 属性就能跳过测试 
	mvn jetty:run 调用 Jetty 插件的 Run 目标在 Jetty Servlet 容器中启动 web 应用 
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


	mvn deploy:deploy-file -DgroupId=com -DartifactId=client -Dversion=0.1.0 -Dpackaging=jar -Dfile=d:\client-0.1.0.jar -DrepositoryId=maven-repository-inner -Durl=ftp://xxxxxxx/opt/maven/repository/ 	

发布第三方Jar到本地库中

	mvn install:install-file -DgroupId=com -DartifactId=client -Dversion=0.1.0 -Dpackaging=jar -Dfile=d:\client-0.1.0.jar 
	-DdownloadSources=true 
	-DdownloadJavadocs=true 



### 参考资料
* [Maven 教程| 极客学院 Wiki](http://wiki.jikexueyuan.com/project/maven/)  
