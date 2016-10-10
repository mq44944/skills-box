## 值与变量
值(val) : 赋值后不可变
val值名称:类型= xxx

变量(var) : 赋值后可以改变
var 变量名称 : 类型 = xxx
 
一般不需要显式指定类型，因为可以从赋值中推断出类型

## 基本类型
Byte Char Short Int
Long Float Double Boolean
并无基本类型与包装类型之分常类型
 
  
## 方法定义
def  方法名(参数名 : 参数类型) : 返回类型 = { 
    //block内最后  为返回值
}
  
当返回值为Unit时可以定义为: 
def  法名(参数名 : 参数类型) { 

}
## 方法注意
没有参数的方法可以不带圆括号访问 
Scala没有静态方法，通过object来实现

## 控制语句
条件表达式(if) 
if(x > 0) 1 else -1
val a = if(x > 0) 1 else -1

循环表达式(for,while,to,until,Range没有continue与break) 
for(i <- 1 to 10) println(i)
for(i <- 1 until 20 if i % 2 == 0) println(i)
1 to 4
Range(1, 2, 3, 4)
1 until 4
Range(1, 2, 3)

语句终止(分行写时可以不用分号)
 
Lazy value
lazy val val_name = val_value
用到时才会去初始化
 

默认参数 
带名参数(赋值时顺序可以定义时顺序不 致)
变长参数( : _*)
 
## 异常处理
try { 
    block(redis)
} catch{
    case e : Exception => System.err.println(e) //should use log in production 
    case _ => //should never happen
}finally { 
    this.close(pool, redis)
}
 
## 定长数组
val array_name = new Array[T](length) 
val array_name = Array(“”,””)
通过( )访问，不是[ ]
 
## 变量数组
import scala.collection.mutable.ArrayBuffer
val buff = ArrayBuffer[T]()
 +=/++=/insert/remove/toArray/sum/max/reverse

## 遍历数组
for(i <- 0 until array_name.length)
for(i <- array_name) 事实上会更多的使 map、filter等等来操作

## Map(可变与不可变)
不可变 val age = Map(“Jack” -> 20,”Lucy” ->”18” )
可变 val age = scala.collection.mutable.Map( ... ) 
初始化 val m = scala.collection.mutable.Map[String,Int]()
 
## Map操作
取值 map(key),更好的 式map.getOrElse(key,default)
更新 map(key)=value / += / -=
迭代 for((k,v) <- map){ },也可单独取key或者value for((k,_) <- map) / for((-,v) <- map) 也可使 map.keySet 或者 map.values
 
## 元组
( ) 包含 系列的值 通过._取值，下标从1开始，例如 t._1 迭代 for(elem <- t.productIterator)