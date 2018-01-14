package io.github.ambauma.euchre

import io.github.ambauma.euchre.Suit._
import io.github.ambauma.euchre.Name._

case class Card(suit: Suit, name: Name) extends Ordered[Card] {

  override def compare(that: Card): Int = {
    val suitCompare:Int = this.suit.compareTo(that.suit)
    if (suitCompare == 0) {
      return this.name.compareTo(that.name)
    } else {
      return suitCompare
    }
  }

  override def toString: String = {
    return name.toString + suit.toString
  }
}
