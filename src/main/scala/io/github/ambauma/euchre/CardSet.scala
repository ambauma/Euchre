// Copyright (C) 2017-2018 - Andrew Baumann
// All rights reserved.
package io.github.ambauma.euchre

object CardSet extends Enumeration {
  type CardSet = Value

  val IncludeEights = Value
  val IncludeSevens = Value
  val IncludeJoker = Value
}
