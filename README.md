# Euchre
Library to facilitate a Euchre game.

## Primary functions
```scala
:require target/scala-2.12/euchre_2.12-0.1.0.jar
import io.github.ambauma.euchre._
```

### Create Set
```scala
val set = Euchre.createSet(Array(CardSet.IncludeEights, CardSet.IncludeSevens))
set: scala.collection.SortedSet[io.github.ambauma.euchre.Card] = TreeSet(AC, KC, QC, JC, 10C, 9C, 8C, 7C, AS, KS, QS, JS, 10S, 9S, 8S, 7S, AD, KD, QD, JD, 10D, 9D, 8D, 7D, AH, KH, QH, JH, 10H, 9H, 8H, 7H)
```
### Shuffle
```scala
val shuffled = Euchre.shuffle(set)
shuffled: List[io.github.ambauma.euchre.Card] = List(10H, JC, 9D, 9S, 8D, 7C, 7H, QS, AH, QD, AD, KD, QC, 7S, 7D, JS, 10D, JD, QH, 9C, KS, JH, 8C, AC, 10C, KC, 8S, 9H, AS, 10S, 8H, KH)
```

### Deal
```
scala> val dealtTwo = Euchre.deal(2, shuffled)
dealtTwo: (List[io.github.ambauma.euchre.Card], List[io.github.ambauma.euchre.Card]) = (List(10H, JC),List(9D, 9S, 8D, 7C, 7H, QS, AH, QD, AD, KD, QC, 7S, 7D, JS, 10D, JD, QH, 9C, KS, JH, 8C, AC, 10C, KC, 8S, 9H, AS, 10S, 8H, KH))
scala> val dealtThree = Euchre.deal(3, dealtTwo._2)
dealtThree: (List[io.github.ambauma.euchre.Card], List[io.github.ambauma.euchre.Card]) = (List(9D, 9S, 8D),List(7C, 7H, QS, AH, QD, AD, KD, QC, 7S, 7D, JS, 10D, JD, QH, 9C, KS, JH, 8C, AC, 10C, KC, 8S, 9H, AS, 10S, 8H, KH))
```

## Definition of Done
 * Does the build pass (ScalaStyle, sCoverage)?
 * Has ScalaDoc been written for all public functions?
 * Is code coverage at 100%?
 * Review the code for readability
