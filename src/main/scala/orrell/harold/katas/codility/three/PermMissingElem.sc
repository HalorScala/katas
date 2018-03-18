import java.time.LocalTime

/*
  https://app.codility.com/programmers/lessons/3-time_complexity/perm_missing_elem/

  This is interesting because the constant space constraint means that
  the most natural solution probably isn't going to cut it

  If we can attack this with a foldLeft which means one stack frame and only the next
  iteration's parameters as the space cost.

  The procedure is to add the contents of the received array and subtract from the sum of
  an array of the same 'N' but without the missing number.

  Alternatively we keep a running tally and subtract each element in the received
  array in turn from the known total.

  The other consideration is that as the array is N can go up to 100K,
  the sum of an array containing every integer up until then is 5*10E9
  i.e. out of range of int storage, so we need a test case to test the worst case scenario


  Also, we can never exit early from the iteration (something which fold would prevent anyway)
  as we won't be able to know the missing element unil we've checked each element of the incoming
  array.

*/

val maxN: Int = 100000

def missingElementApproach1(array: Array[Int]): Int = {
  val n: Long = array.length + 1
  println(s"n $n")
  val midPoint: Double = (n.toDouble + 1) / 2
  println(s"dbl $midPoint")
  val total: Long = (midPoint*n).toLong
  println(s"total $total")
//  val sum = array.map(_.toLong).sum
//  println(s"sum $sum")
//  (total - sum).toInt

  //avoid the need to convert the array into Longs
  //as total is the first
  array.foldLeft(total)((tally, next) => (tally - next)).toInt
}

def missingElement(array: Array[Int]): Int = {
  val n: Double = array.length + 1
  val total = ((n + 1) / 2 *n)
  array.foldLeft(total)((tally, next) => (tally - next)).toInt
}

LocalTime.now

val missing4 = Array(2, 3, 1, 5)
missingElement(missing4) // 4

val missing5 = Array(2, 3, 1, 4)
missingElement(missing5)

val missing3 = Array(2, 1, 4)
missingElement(missing3)

missingElement((1 to 99999).toArray) //100,000

//conversions recap
val long: Long = 5*10E9.toLong
val int: Int = 1
long - int // -> long
int - long // -> long
long / 2 // -> long
long/ 2.0 // -> dbl
2.5 / 2 // -> dbl

/* Comments:

  Once again I'm reminded how horrible floating point arithmetic is in the jvm

  The need for double conversion to take into account odd sized arrays really threw me because both
  my simple test cases had an even number of elements in.

  - recap of rhe rules of arithmetic with doubles/longs/ints etc
    //conversions recap
    val long: Long = 5*10E9.toLong
    val int: Int = 1
    long - int // -> long
    int - long // -> long
    long / 2 // -> long
    long/ 2.0 // -> dbl
    2.5 / 2 // -> dbl

  Takeaway points:
    - the resulting type when applying an operator to two numbers is the broader of the two
    - for you to get a fractional result from a division of a literal primitive, you must
      include a decimal place e.g. '.0'
    - as seen above, if you start with a double as an innermost operand, the type will propagate through
      the computation, and the answer will we as you expect saving for floating point errors

 */