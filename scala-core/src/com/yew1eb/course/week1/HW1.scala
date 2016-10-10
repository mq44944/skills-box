package com.yew1eb.course.week1

/**
  * @author zhouhai
  */
object HW1 {

  def signum(num: Int): Int = {
    if (num == 0) num
    else if (num > 0) 1
    else -1
  }

  def countdown(n: Int) {
    assert(n > 1, "n must larger than 1")
    for (i <- 0 until n) println(i)
  }

  def swap(array: Array[Int]) = {
    for (idx <- 0 until(if (array.length % 2 == 0) array.length else array.length - 1, 2)) {
      val tmp = array(idx)
      array(idx) = array(idx + 1)
      array(idx + 1) = tmp
    }
    array
  }

  def wordcount(content : String) : Map[String, Int] = {
    val counts = scala.collection.mutable.Map[String, Int]()
    for(word <- content.split(' ')){
      if (counts.contains(word))
        counts(word) = counts(word) + 1
      else
        counts += (word -> 1)
    }
    counts.toMap
  }

  def main(args: Array[String]) {
    println(signum(-100))
    for (i <- Range(10, -1, -1)) println(i)
    for (i <- 0 to 10 reverse) println(i)
    countdown(10)
  }
}

/*
1、个数字如果为正数，则它的signum为1;如果是负数，怎么signum为-1;如果是0，则signum 为0.编写个函数来计算这个值。
2、针对下列Java循环编写Scala版本  for(int i=10; i>=0;i- -) System.out.println(i)
3、编写 个过程countdown(n : Int), 打印从n-1到0的数字.(n > 1)
4、编写 个循环，讲整数数组中相邻的元素置换。如，Array(1,2,3,4,5)经过置换变为
  Array(2,1,4,3,5)
  5、任意给定 个语句( 定义，词与词之间以空格好分隔)，统计出每个词出现的次数。

 */