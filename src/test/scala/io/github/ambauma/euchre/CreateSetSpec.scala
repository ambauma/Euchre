package io.github.ambauma.euchre

import org.scalatest._

class CreateSetSpec extends FlatSpec with Matchers {
  "Euchre" should "print a 33 card set " in {
    val set = Euchre.createSet(Array(CardSet.IncludeEights, CardSet.IncludeSevens, CardSet.IncludeJoker))
    assert(set.toString() == "TreeSet(Joker, AC, KC, QC, JC, 10C, 9C, 8C, 7C, AS, KS, QS, JS, 10S, 9S, 8S, 7S, AD, KD, QD, JD, 10D, 9D, 8D, 7D, " +
      "AH, KH, QH, JH, 10H, 9H, 8H, 7H)")
  }

  "Euchre" should "print a 32 card set " in {
    val set = Euchre.createSet(Array(CardSet.IncludeEights, CardSet.IncludeSevens))
    assert(set.toString() == "TreeSet(AC, KC, QC, JC, 10C, 9C, 8C, 7C, AS, KS, QS, JS, 10S, 9S, 8S, 7S, AD, KD, QD, JD, 10D, 9D, 8D, 7D, " +
      "AH, KH, QH, JH, 10H, 9H, 8H, 7H)")
  }

  "Euchre" should "print a 28 card set " in {
    val set = Euchre.createSet(Array(CardSet.IncludeEights))
    assert(set.toString() == "TreeSet(AC, KC, QC, JC, 10C, 9C, 8C, AS, KS, QS, JS, 10S, 9S, 8S, AD, KD, QD, JD, 10D, 9D, 8D, " +
      "AH, KH, QH, JH, 10H, 9H, 8H)")
  }

  "Euchre" should "print a 24 card set " in {
    val set = Euchre.createSet(None)
    assert(set.toString() == "TreeSet(AC, KC, QC, JC, 10C, 9C, AS, KS, QS, JS, 10S, 9S, AD, KD, QD, JD, 10D, 9D, " +
      "AH, KH, QH, JH, 10H, 9H)")
  }
}
