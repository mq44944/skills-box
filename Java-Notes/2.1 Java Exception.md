<http://www.oschina.net/translate/10-java-exception-and-error-interview-questions-answers-programming>

<http://www.runoob.com/java/java-exceptions.html>

* [Java 异常处理及其应用](http://www.ibm.com/developerworks/cn/java/j-lo-exception/)
* [Java 异常处理的误区和经验总结](http://www.ibm.com/developerworks/cn/java/j-lo-exception-misdirection/)
* [异常以及异常处理框架探析](http://www.ibm.com/developerworks/cn/java/j-lo-exceptionframework/index.html)


### 实际应用中的处理异常的经验与总结  
1. 处理运行时异常时，采用合理逻辑去规避的同时辅助try-catch处理  
2. 在多重catch语句后可以加上一个Exception异常，以处理未发现的异常。
3. 对于不确定的代码，也可以加上try-catch处理潜在异常。
4. 尽量去处理异常，不能一味的只用printStackTrance去打印输出
5. 具体如何去处理异常，要根据不同的业务需求和异常类型去决定。
6. 尽量添加finally语句块去释放占用的资源