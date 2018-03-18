/*
  https://app.codility.com/programmers/lessons/2-arrays/odd_occurrences_in_array/

  Preliminary notes.

  This can be done in O(n) time,
  in one traversal but and in O(n) space,
  or many traversals and constant space.

  a naive approach would be to search
  the whole collection once per element

  and a more efficient, less expressive approach would
  be to fold/accumulate
*/


val array = Array(9, 3, 9, 3, 9, 7, 9)
val oneTwoOne = Array(1, 2, 1)
val threeFourThreeThree = Array(3, 4, 3, 3)

//7 is unpaired

def unpaireds(as: Array[Int]): Set[Int] = {
  as.foldLeft(Set.empty[Int]) {(unpaired, next) =>
    if(unpaired(next)) {
      unpaired - next
    } else {
      unpaired + next
    }
  }
}

unpaireds(array)
unpaireds(oneTwoOne)
unpaireds(threeFourThreeThree)

/* Comments:
  trivial
 */