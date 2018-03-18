/*
  https://app.codility.com/programmers/lessons/3-time_complexity/tape_equilibrium/
*/

val array = Array(3, 1, 2, 4, 3)


def difference(ints: Array[Int], i: Int) = {
  val (first, second) = ints.splitAt(i)
  Math.abs(first.sum - second.sum)
}

difference(array, 1) // 7
difference(array, 2) // 1
difference(array, 3) // 5
difference(array, 4) // 7