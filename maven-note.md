Maven是基于项目对象模型(POM)，可以通过一小段描述信息来管理项目的构建，报告和文档的软件项目管理工具。
Maven 除了以程序构建能力为特色之外，还提供高级项目管理工具。由于 Maven 的缺省构建规则有较高的可重用性，
所以常常用两三行 Maven 构建脚本就可以构建简单的项目。由于 Maven 的面向项目的方法，
许多 Apache Jakarta 项目发文时使用 Maven，而且公司项目采用 Maven 的比例在持续增长。

*********

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
  
一般使用情况是这样，首先通过git下载代码到本机，然后执行mvn idea:idea生成idea项目文件，然后导入到idea就行了。


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


发布第三方Jar到本地库中： 

	mvn install:install-file -DgroupId=com -DartifactId=client -Dversion=0.1.0 -Dpackaging=jar -Dfile=d:\client-0.1.0.jar 
	
	
	-DdownloadSources=true 
	
	-DdownloadJavadocs=true 




