package io.github.ambauma.euchre

import org.scalatest._

class AppSpec extends FlatSpec with Matchers {
  "Euchre" should "print a 33 card set " in {
    val set = Euchre.createSet(Array(CardSet.IncludeEights, CardSet.IncludeSevens, CardSet.IncludeJoker))
    assert(set.toString ==
      "AC, KC, QC, JC, 10C, 9C, 8C, 7C \n" +
      "AS, KS, QS, JS, 10S, 9S, 8S, 7S\n" +
      "AD, KD, QD, JD, 10D, 9D, 8D, 7D\n" +
      "AH, KH, QH, JH, 10H, 9H, 8H, 7H\n" +
      "Joker")
  }

  "Euchre" should "print a 32 card set " in {
    val set = Euchre.createSet(Array(CardSet.IncludeEights, CardSet.IncludeSevens))
    assert(set.toString ==
      "AC, KC, QC, JC, 10C, 9C, 8C, 7C \n" +
      "AS, KS, QS, JS, 10S, 9S, 8S, 7S\n" +
      "AD, KD, QD, JD, 10D, 9D, 8D, 7D\n" +
      "AH, KH, QH, JH, 10H, 9H, 8H, 7H")
  }

  "Euchre" should "print a 28 card set " in {
    val set = Euchre.createSet(Array(CardSet.IncludeEights))
    assert(set.toString ==
      "AC, KC, QC, JC, 10C, 9C, 8C\n" +
      "AS, KS, QS, JS, 10S, 9S, 8S\n" +
      "AD, KD, QD, JD, 10D, 9D, 8D\n" +
      "AH, KH, QH, JH, 10H, 9H, 8H")
  }

  "Euchre" should "print a 24 card set " in {
    val set = Euchre.createSet(None)
    assert(set.toString() == "TreeSet(AC, KC, QC, JC, 10C, 9C, AS, KS, QS, JS, 10S, 9S, AD, KD, QD, JD, 10D, 9D, " +
      "AH, KH, QH, JH, 10H, 9H)")
  }
}
