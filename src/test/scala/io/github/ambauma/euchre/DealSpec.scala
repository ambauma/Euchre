package io.github.ambauma.euchre

import org.scalatest.{FlatSpec, Matchers}

import scala.collection.SortedSet

class DealSpec extends FlatSpec with Matchers {

  val deck = Euchre.shuffle(Euchre.createSet(None), 0)

  "Euchre" should "deal 3 cards" in {
    val dealt:(List[Card],List[Card]) = Euchre.deal(3, deck)
    assert(dealt._1 != null)
    assert(dealt._1.length == 3)
    assert(dealt._2.length == 21)
    assert(dealt._1(0) == Card(Suit.Diamonds, Name.Ten))
    assert(dealt._1(1) == Card(Suit.Hearts, Name.Queen))
    assert(dealt._1(2) == Card(Suit.Clubs, Name.Ten))
  }

  "Euchre" should "deal 2 cards" in {
    val dealt:(List[Card],List[Card]) = Euchre.deal(2, deck)
    assert(dealt._1 != null)
    assert(dealt._1.length == 2)
    assert(dealt._2.length == 22)
    assert(dealt._1(0) == Card(Suit.Diamonds, Name.Ten))
    assert(dealt._1(1) == Card(Suit.Hearts, Name.Queen))
  }

  "Euchre" should "deal cards repeatedly " in {
    val dealtFirst = Euchre.deal(2, deck)
    println("First deal:  " + dealtFirst._1)
    assert(2 == dealtFirst._1.length)
    assert(22 == dealtFirst._2.length)
    val dealtSecond = Euchre.deal(3, dealtFirst._2)
    println("Second deal:  " + dealtSecond._1)
    assert(3 == dealtSecond._1.length)
    assert(19 == dealtSecond._2.length)
    assert(dealtFirst._1.intersect(dealtSecond._1).isEmpty)
    assert(dealtFirst._2.intersect(dealtSecond._2).length == 19)
    assert(dealtFirst._2.intersect(dealtSecond._1).length == 3)
    val dealtThird = Euchre.deal(2, dealtSecond._2)
    println("Third deal:  " + dealtThird._1)
    assert(2 == dealtThird._1.length)
    assert(17 == dealtThird._2.length)
    val dealtFourth = Euchre.deal(3, dealtThird._2)
    println("Fourth deal:  " + dealtFourth._1)
    assert(3 == dealtFourth._1.length)
    assert(14 == dealtFourth._2.length)
    println("Not dealt: " + dealtFourth._2)
  }
}
