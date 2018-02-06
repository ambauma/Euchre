package io.github.ambauma.euchre

import org.scalatest.{FlatSpec, Matchers}

class ShuffleSpec extends FlatSpec with Matchers {
  val cards = List(Card(Suit.Clubs, Name.King),
    Card(Suit.Spades, Name.Queen),
    Card(Suit.Diamonds, Name.Jack),
    Card(Suit.Hearts, Name.Ten))

  "Euchre" should "shuffle with a seed" in {
    val shuffled = Euchre.shuffle(cards,0L)
    assert(Card(Suit.Hearts, Name.Ten) == shuffled(0))
    assert(Card(Suit.Clubs, Name.King) == shuffled(1))
    assert(Card(Suit.Spades, Name.Queen) == shuffled(2))
    assert(Card(Suit.Diamonds, Name.Jack) == shuffled(3))
  }

  "Euchre" should "when shuffled with a seed should be stable" in {
    val shuffled = Euchre.shuffle(cards,0L)
    assert(Card(Suit.Hearts, Name.Ten) == shuffled(0))
    assert(Card(Suit.Clubs, Name.King) == shuffled(1))
    assert(Card(Suit.Spades, Name.Queen) == shuffled(2))
    assert(Card(Suit.Diamonds, Name.Jack) == shuffled(3))
    val shuffledAgain = Euchre.shuffle(cards, 0L)
    assert(Card(Suit.Hearts, Name.Ten) == shuffledAgain(0))
    assert(Card(Suit.Clubs, Name.King) == shuffledAgain(1))
    assert(Card(Suit.Spades, Name.Queen) == shuffledAgain(2))
    assert(Card(Suit.Diamonds, Name.Jack) == shuffledAgain(3))
  }

  "Euchre" should "shuffle without a seed" in {
    val shuffled = Euchre.shuffle(cards)
    shuffled.contains(cards(0))
    shuffled.contains(cards(1))
    shuffled.contains(cards(2))
    shuffled.contains(cards(3))
  }

  "Euchre" should "when shuffled without a seed should not be stable " in {
    val shuffled1 = Euchre.shuffle(cards)
    val shuffled2 = Euchre.shuffle(cards)
    val shuffled3 = Euchre.shuffle(cards)
    assert(shuffled1.intersect(shuffled2).length == 4)
    assert(shuffled2.intersect(shuffled3).length == 4)
    assert(false == (shuffled1(0) equals shuffled2(0) equals shuffled3(0)))
    assert(false == (shuffled1(1) equals shuffled2(1) equals shuffled3(1)))
    assert(false == (shuffled1(2) equals shuffled2(2) equals shuffled3(2)))
    assert(false == (shuffled1(3) equals shuffled2(3) equals shuffled3(3)))
  }
}
