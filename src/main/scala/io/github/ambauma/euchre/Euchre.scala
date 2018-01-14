package io.github.ambauma.euchre

import io.github.ambauma.euchre.CardSet._
import io.github.ambauma.euchre.Suit._
import io.github.ambauma.euchre.Name._

import scala.collection.SortedSet

object Euchre {
  def createSet(cardSets: Iterable[CardSet]): SortedSet[Card] = {
    val normalCards : SortedSet[Card] = Suit.all.map(suit => usualCards(suit)).reduce(_ ++ _)
    val extraCards = cardSets.flatMap(cardSet => addCards(cardSet))
    normalCards ++ extraCards
  }

  def addCards(cardSet: CardSet): SortedSet[Card] = {
    cardSet match {
      case CardSet.IncludeSevens => eachSuitOf(Name.Seven)
      case CardSet.IncludeEights => eachSuitOf(Name.Eight)
      case CardSet.IncludeJoker => SortedSet(Card(Suit.Clubs, Name.Joker))
    }
  }

  def eachSuitOf(name: Name): SortedSet[Card] = {
    SortedSet(Card(Suit.Clubs, name), Card(Suit.Hearts, name), Card(Suit.Diamonds, name), Card(Suit.Spades, name))
  }

  def usualCards(suit: Suit): SortedSet[Card] = {
    return SortedSet(Card(suit, Name.Ace), Card(suit, Name.King), Card(suit, Name.Queen),
      Card(suit, Name.Jack), Card(suit, Name.Ten), Card(suit, Name.Nine))
  }
}
