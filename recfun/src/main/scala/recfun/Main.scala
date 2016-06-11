package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (c == 0 || r==c) 1
    if (r == 0) {
      if (c == 0) 1 else 0
    } else pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    var counter = 0
    def find(charsEdited: List[Char]): Boolean = {
      if (charsEdited.isEmpty) counter == 0
      if (charsEdited.head == '(') counter = counter + 1
      else if (charsEdited.head == ')') counter = counter - 1

      if (counter < 0) false
      else find(charsEdited.tail)
    }
    find(chars)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    if (money == 0) 1
    else if (money < 0) 0
    else if (coins.isEmpty) 0
    else {
      countChange(money - coins.head, coins) + countChange(money, coins.tail)
    }


  }
}
