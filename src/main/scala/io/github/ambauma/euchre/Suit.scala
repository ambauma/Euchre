package io.github.ambauma.euchre
import io.github.ambauma.euchre

object Suit extends Enumeration {
  type Suit = Value

  val Clubs = Value(1, "C")
  val Spades = Value(2, "S")
  val Diamonds = Value(3, "D")
  val Hearts = Value(4, "H")

  def all() : Iterable[Suit] = {
    return Iterable[Suit](Clubs, Spades, Diamonds, Hearts)
  }
}
