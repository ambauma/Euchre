package io.github.ambauma.euchre

object Name extends Enumeration {
  type Name = Value

  val Joker = Value("Joker")
  val Ace = Value("A")
  val King = Value("K")
  val Queen = Value("Q")
  val Jack = Value("J")
  val Ten = Value("10")
  val Nine = Value("9")
  val Eight = Value("8")
  val Seven = Value("7")

}
