package io.github.ambauma.euchre

object Name extends Enumeration {
  type Name = Value

  val Joker = Value(1, "Joker")
  val Ace = Value(2, "A")
  val King = Value(3, "K")
  val Queen = Value(4, "Q")
  val Jack = Value(5, "J")
  val Ten = Value(6, "10")
  val Nine = Value(7, "9")
  val Eight = Value(8, "8")
  val Seven = Value(9, "7")

}
