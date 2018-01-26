package io.github.ambauma.euchre

object CardSet extends Enumeration {
  type CardSet = Value

  val IncludeEights = Value
  val IncludeSevens = Value
  val IncludeJoker = Value
}
