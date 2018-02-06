package io.github.ambauma.euchre

import org.scalacheck.Prop._
import org.scalacheck.{Gen, Properties}

object CreateSetCheck extends Properties("Euchre") {
  val standardSet : Iterable[Card] = everyNormalCard

  val possibleChoices = Gen.oneOf(Iterable[CardSet.Value](),
    Iterable[CardSet.Value](CardSet.IncludeJoker),
    Iterable(CardSet.IncludeSevens),
    Iterable(CardSet.IncludeEights),
    Iterable(CardSet.IncludeSevens, CardSet.IncludeJoker),
    Iterable(CardSet.IncludeEights, CardSet.IncludeJoker),
    Iterable(CardSet.IncludeSevens, CardSet.IncludeEights),
    Iterable(CardSet.IncludeSevens, CardSet.IncludeEights, CardSet.IncludeJoker))

  property("createSet") = forAll(possibleChoices) {cardSetInput => val cards = Euchre.createSet(cardSetInput)
    standardSet.toSet.subsetOf(cards)
  }

  def everyNormalCard() : Iterable[Card] = {
    everyNormalCardOf(Suit.Clubs) ++
      everyNormalCardOf(Suit.Spades) ++
      everyNormalCardOf(Suit.Diamonds) ++
      everyNormalCardOf(Suit.Hearts)
  }

  def everyNormalCardOf(suit : Suit.Value) : Iterable[Card] = {
    Iterable(Card(suit, Name.King), Card(suit, Name.Queen), Card(suit, Name.Jack), Card(suit, Name.Ten),
      Card(suit, Name.Nine))
  }
}
