package com.yew1eb.course.week1

object WeekOne {

  def add(x: Int, y: Int): Int = {
    x + y
  }

  def hello() {
    println("Hello Scala")
  }

  def sayName(name: String = "Jack") {
    println(name)
  }

  def sum(elems: Int*): Int = {
    var sum = 0
    for (elem <- elems) {
      sum += elem
    }
    sum
  }

  def mapFor() {
    val m = Map("Jack" -> 20, "BB" -> 3, "CC" -> 4, "Lucy" -> 18)
    for ((k, _) <- m) {
      println("key is " + k)
    }
    for (k <- m.keySet) {
      println("key is "+k)
    }
    for (v <- m.values) {
      println("value is " + v)
    }
    for ((k, v) <- m) {
      println("key is " + k + ", value is " + v)
    }
  }

  def main(args: Array[String]) {
    println(sum(1, 2, 3, 4, 5))
    println(add(1, 2))
    println(add(y = 10, x = 1))
    hello
    sayName()
    sayName("Lucy")
    mapFor

    val tuple = (1, "2", 2.3)
    println(tuple._3)
  }
}
