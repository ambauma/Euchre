// Copyright (C) 2017-2018 - Andrew Baumann
// All rights reserved.
package io.github.ambauma.euchre

object Suit extends Enumeration {
  type Suit = Value

  val Clubs = Value("C")
  val Spades = Value("S")
  val Diamonds = Value("D")
  val Hearts = Value("H")

  def all() : Iterable[Suit] = {
    Iterable[Suit](Clubs, Spades, Diamonds, Hearts)
  }
}
