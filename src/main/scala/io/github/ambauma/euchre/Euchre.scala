// Copyright (C) 2017-2018 - Andrew Baumann
// All rights reserved.
package io.github.ambauma.euchre

import io.github.ambauma.euchre.CardSet._
import io.github.ambauma.euchre.Suit._
import io.github.ambauma.euchre.Name._

import scala.collection.SortedSet

/**
  * The primary library functions of the game
  */
object Euchre {

  /** Creates a set of cards
    *
    * @param cardSets what types of cards will be in the game
    * @return a set of cards
    */
  def createSet(cardSets: Iterable[CardSet]): SortedSet[Card] = {
    val normalCards : SortedSet[Card] = Suit.all.map(usualCards).reduce(_ ++ _)
    val extraCards = cardSets.flatMap(cardSet => addCards(cardSet))
    normalCards ++ extraCards
  }

  private def addCards(cardSet: CardSet): SortedSet[Card] = {
    cardSet match {
      case CardSet.IncludeSevens => eachSuitOf(Name.Seven)
      case CardSet.IncludeEights => eachSuitOf(Name.Eight)
      case CardSet.IncludeJoker => SortedSet(Card(Suit.Clubs, Name.Joker))
    }
  }

  private def eachSuitOf(name: Name): SortedSet[Card] = {
    SortedSet(Card(Suit.Clubs, name), Card(Suit.Hearts, name), Card(Suit.Diamonds, name), Card(Suit.Spades, name))
  }

  private def usualCards(suit: Suit): SortedSet[Card] = {
    SortedSet(Card(suit, Name.Ace), Card(suit, Name.King), Card(suit, Name.Queen),
      Card(suit, Name.Jack), Card(suit, Name.Ten), Card(suit, Name.Nine))
  }
}
