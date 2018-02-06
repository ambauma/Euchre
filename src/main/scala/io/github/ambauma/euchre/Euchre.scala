package io.github.ambauma.euchre

import io.github.ambauma.euchre.CardSet._
import io.github.ambauma.euchre.Name._
import io.github.ambauma.euchre.Suit._

import scala.collection.SortedSet
import scala.util.Random

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
    val normalCards = Suit.all.map(usualCards).reduce(_ ++ _)
    val extraCards = cardSets.flatMap(cardSet => addCards(cardSet))
    normalCards ++ extraCards
  }

  /**
    * Shuffles cards
    * @param cards  The set of cards to shuffle
    * @param seed   Optional parameter to set the seed.  Defaults to system current time
    * @return the cards, shuffled
    */
  def shuffle(cards: Iterable[Card], seed : Long = System.currentTimeMillis()): List[Card] = {
    new Random(seed).shuffle(cards.toList)
  }

  /**
    * Deals the specified number of cards from the cards passed.
    * @param numberOfCards  number of cards to return
    * @param cards  cards to choose from for dealing
    * @return specified number of random cards from cards given and remainder of cards not chosen
    */
  def deal(numberOfCards:Int, cards:Iterable[Card]) : (List[Card],List[Card]) = {
    val c = cards.toList
    return (c.slice(0, numberOfCards), c.slice(numberOfCards, c.length))
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
