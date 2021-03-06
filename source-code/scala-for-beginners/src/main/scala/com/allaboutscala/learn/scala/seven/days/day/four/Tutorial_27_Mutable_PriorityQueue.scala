package com.allaboutscala.learn.scala.seven.days.day.four

/**
  * Created by Nadim Bahadoor on 15/10/2018.
  *
  * The content was inspired by the original tutorial below, and feedback from readers at http://allaboutscala.com.
  *
  * Tutorial: Learn How To Use Scala's Mutable PriorityQueue
  *
  * [[http://allaboutscala.com/tutorials/chapter-7-beginner-tutorial-using-scala-mutable-collection/scala-tutorial-learn-use-mutable-priorityqueue/ Tutorial]]
  *
  *
  * Copyright 2016 - 2019 Nadim Bahadoor (http://allaboutscala.com)
  *
  * Licensed under the Apache License, Version 2.0 (the "License"); you may not
  * use this file except in compliance with the License. You may obtain a copy of
  * the License at
  *
  *  [http://www.apache.org/licenses/LICENSE-2.0]
  *
  * Unless required by applicable law or agreed to in writing, software
  * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
  * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
  * License for the specific language governing permissions and limitations under
  * the License.
  */
object Tutorial_27_Mutable_PriorityQueue extends App {

  println("Step 1: How to declare a case class to represent Donut object")
  case class Donut(name: String, price: Double)



  println("\nStep 2: How to declare a function which defines the ordering of a PriorityQueue of Donut objects")
  def donutOrder(d: Donut) = d.price
  // NOTE: to order by lowest first, you can do -d.price



  println("\nStep 3: How to initialize a PriorityQueue of Donut objects and specify the Ordering")
  implicit val doubleOrdering = Ordering.Double.TotalOrdering
  import scala.collection.mutable.PriorityQueue
  val priorityQueue1 = PriorityQueue(
    Donut("Plain Donut", 1.50),
    Donut("Strawberry Donut", 2.0),
    Donut("Chocolate Donut", 2.50))(Ordering.by(donutOrder))
  println(s"Elements of priorityQueue1 = $priorityQueue1")



  println("\nStep 4: How to add an element to PriorityQueue using enqueue method")
  priorityQueue1.enqueue(Donut("Vanilla Donut", 1.0))
  println(s"Elements of priorityQueue1 after enqueue method is called = $priorityQueue1")



  println("\nStep 5: How to add an element to PriorityQueue using +=")
  priorityQueue1 += Donut("Krispy Kreme Donut", 1.0)
  println(s"Elements of priorityQueue1 after enqueue method is called = $priorityQueue1")



  println("\nStep 6: How to remove an element from PriorityQueue using the dequeue method")
  val donutDequeued: Donut = priorityQueue1.dequeue()
  println(s"Donut element dequeued = $donutDequeued")
  // NOTE: the highest element in the queue order by price was removed
  println(s"Elements of priorityQueue1 after dequeued method is called = $priorityQueue1")



  println("\nStep 7: How to initialize an empty PriorityQueue")
  val emptyPriorityQueue = PriorityQueue.empty[String]
  println(s"Empty emptyPriorityQueue = $emptyPriorityQueue")

}
