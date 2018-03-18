/*
  https://app.codility.com/programmers/lessons/3-time_complexity/frog_jmp/
*/

def jumpCount(start: Int, finish: Int, distance: Int): Int = {
  Math.ceil((finish - start).toDouble / distance).toInt
}

val (start, finish, distance) = (10, 85, 30)

jumpCount(start, finish, distance) // 3