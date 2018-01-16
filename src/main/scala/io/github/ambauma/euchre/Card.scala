// Copyright (C) 2017-2018 - Andrew Baumann
// All rights reserved.
package io.github.ambauma.euchre

import io.github.ambauma.euchre.Suit._
import io.github.ambauma.euchre.Name._

case class Card(suit: Suit, name: Name) extends Ordered[Card] {

  override def compare(that: Card): Int = {
    val suitCompare:Int = this.suit.compareTo(that.suit)
    if (suitCompare == 0) {
      this.name.compareTo(that.name)
    } else {
      suitCompare
    }
  }

  override def toString: String = {
    this.name match {
      case Name.Joker => name.toString
      case _ => name.toString + suit.toString
    }
  }
}
