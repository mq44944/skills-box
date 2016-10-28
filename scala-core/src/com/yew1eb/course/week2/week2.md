
## 类(class)
声明类( 个源 件中可以包含很多类，并且可以都是public级别) 
getter 和 setter
构造函数(primary constructor & auxiliary constructor)
继承(extends) 
重写父类方法(override def) 
重写字段(override val , override var)

## 抽象类(abstract class)
类的 个或者多个 法没有没完整的定义 声明抽象 法不需要加abstract关键字,只需要不写 法体
 类重写 类的抽象 法时不需要加override  类可以声明抽象字段(没有初始值的字段)  类重写 类的抽象字段时不需要加override


特质(trait) —对 下JAVA8的接 
 字段和 为的集合
 混 类中
通过with关键字， 个类可以扩展多个特质
 4
 •
• •
• •
trait 续
 当做接 
 带有具体实现的接 
 带有特质的对象
 特质从左到右被构造
 5
 • •
apply 法 单例对象
 6
 •
包(package com.xx.data)
  持嵌套，下层可以访问上层作 域中的名称
 可串联
 顶部标记
 包对象
包可 性 包在任何地 都可以引 ，作 域 该语句所在块的末尾 重命名引 成员(xx => yy)
隐藏 法(xx => _)
 动引 (java.lang._ scala._ Predef._)
• • • • • • •
• •
 7
 •
•
标准 法(match) 使 守卫
匹配类型
模式匹配
• •
 8
 •
• •
case class(多 在模式匹配中)
构造器中的每 个类型都为val， 不建议 var。 不 new就可以直接产 对象(为什么?apply 法)
 9
 • • •
按 读取
按字符读取
从 络读取
 件访问
 10
 SparkContext.scala RDD.scala
Spark
 11
 Option
String Interpolation

