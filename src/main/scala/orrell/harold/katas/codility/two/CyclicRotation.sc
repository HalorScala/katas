import java.time.{LocalDateTime, LocalTime}

/*
    https://app.codility.com/programmers/lessons/2-arrays/cyclic_rotation/
*/

def offset(length: Int, rotations: Int) = length - (rotations % length)

object Solution {
  def solution(a: Array[Int], k: Int): Array[Int] = {
    if (k < 1) {
      return a
    }
    val (newEnd, newStart) = a.splitAt(offset(a.length, k))
    newStart ++ newEnd
  }
}


LocalTime.now

val array: Array[Int] = Array(1, 2, 3, 4, 5)



Solution.solution(array, 0)
Solution.solution(array, 1)
Solution.solution(array, 3)
Solution.solution(array, 5)
Solution.solution(array, 6)
Solution.solution(array, 7)


offset(5, 4)
offset(5, 5)
offset(5, 6)