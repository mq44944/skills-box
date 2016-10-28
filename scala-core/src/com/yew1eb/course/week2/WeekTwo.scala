package com.yew1eb.course.week2

/**
  * @author zhouhai
  */

class WeekTwo {

}

class Person {
  var name: String = _
  //会生成getter和setter方法
  val age = 10
  //只会生成getter方法
  private[this] val gender = "male"
}

//1.主构造器直接跟在类名后面，主构造器中的参数，最后会被编译成字段
//2.主构造器执行的时候，会执行类中的所有语句
//3.假设参数声明时不带val和var，那么相当于private[this]!!
class Person2(val name: String, val age: Int) {
  println("this is the primary constructor!")
  var gender: String = _

  //1.附属构造器名称为this
  //2.每一个附属构造器必须首先调用已经存在的子构造器或者附属构造器
  def this(name: String, age: Int, gender: String) {
    this(name, age)
    this.gender = gender
  }
}

class Student(name: String, age: Int, val major: String) extends Person2(name, age) {
  println("this is the subclass of Person, major is : " + major)

  override def toString = "Override toString..."
}

object WeekTwo {
  def main(args: Array[String]) {
    val p = new Person
    p.name = "Jack"
    println(p.name + " : " + p.age)

    val p2 = new Person2("Jack", 20, "male")
    println(p2.name + ":" + p2.gender)

    val stu = new Student("Justin", 30, "Math")
    println(stu.toString)
  }
}