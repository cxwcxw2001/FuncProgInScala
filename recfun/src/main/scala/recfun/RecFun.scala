package recfun

object RecFun extends RecFunInterface {

  def main(args: Array[String]): Unit = {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(s"${pascal(col, row)} ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int) : Int = {
    if (c == r) 1
    else if (c == 0) 1
    else pascal(c-1, r-1) + pascal(c, r-1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def balanceIter(chars: List[Char], stack: List[Char]): Boolean = {
      if (chars.isEmpty)
        stack.isEmpty
      else if (chars.head == '(')
        balanceIter(chars.tail,  chars.head +: stack)
      else if (chars.head == ')')
        ! (stack.isEmpty) && stack.head == '(' && balanceIter(chars.tail, stack.tail)
      else
        balanceIter(chars.tail, stack)
    }

    val initialStack = List()
    balanceIter(chars, initialStack)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    if (money == 0) 1
    else if (money < 0) 0
    else if (coins.isEmpty) 0
    else countChange(money - coins.head, coins) + countChange(money, coins.tail)
  }
}
