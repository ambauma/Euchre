package io.github.ambauma.euchre

import io.github.ambauma.euchre.CardSet._
import io.github.ambauma.euchre.Suit._
import io.github.ambauma.euchre.Name._

import scala.collection.SortedSet

object Euchre {
  def createSet(cardSets: Iterable[CardSet]): Option[SortedSet[Card]] = {
    val allSuits : Iterable[Suit] = Suit.all;
    val normalCards = allSuits.map(suit => usualCards(suit)).flatten
    val extraCards = cardSets.map(cardSet => addCards(cardSet)).flatten
    normalCards ++ extraCards
  }

  def addCards(cardSet: CardSet): Option[SortedSet[Card]] = {
    cardSet match {
      case CardSet.IncludeSevens => eachSuitOf(Name.Seven)
      case CardSet.IncludeEights => eachSuitOf(Name.Eight)
      case CardSet.IncludeJoker => Some(SortedSet(Card(Suit.Clubs, Name.Joker)))
    }
  }

  def eachSuitOf(name: Name): Option[SortedSet[Card]] = {
    Some(SortedSet(Card(Suit.Clubs, name), Card(Suit.Hearts, name), Card(Suit.Diamonds, name), Card(Suit.Spades, name)))
  }

  def usualCards(suit: Suit): Option[SortedSet[Card]] = {
    return Some(SortedSet(Card(suit, Name.Ace), Card(suit, Name.King), Card(suit, Name.Queen),
      Card(suit, Name.Jack), Card(suit, Name.Ten), Card(suit, Name.Nine)))
  }
}
