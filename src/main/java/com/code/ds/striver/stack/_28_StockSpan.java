package com.code.ds.striver.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Design an algorithm that collects daily price quotes for some stock and returns the span of that stock's price for the current day.

The span of the stock's price in one day is the maximum number of consecutive days (starting from that day and going backward) 
for which the stock price was less than or equal to the price of that day.

For example, if the prices of the stock in the last four days is [7,2,1,2] and the price of the stock today is 2, 
then the span of today is 4 because starting from today, the price of the stock was less than or equal 2 for 4 consecutive days.
Also, if the prices of the stock in the last four days is [7,34,1,2] and the price of the stock today is 8, 
then the span of today is 3 because starting from today, the price of the stock was less than or equal 8 for 3 consecutive days.
Implement the StockSpanner class:

StockSpanner() Initializes the object of the class.
int next(int price) Returns the span of the stock's price given that today's price is price.
 

Example 1:

Input
["StockSpanner", "next", "next", "next", "next", "next", "next", "next"]
[[], [100], [80], [60], [70], [60], [75], [85]]
Output
[null, 1, 1, 1, 2, 1, 4, 6]

Explanation
StockSpanner stockSpanner = new StockSpanner();
stockSpanner.next(100); // return 1
stockSpanner.next(80);  // return 1
stockSpanner.next(60);  // return 1
stockSpanner.next(70);  // return 2
stockSpanner.next(60);  // return 1
stockSpanner.next(75);  // return 4, because the last 4 prices (including today's price of 75) were less than or equal to today's price.
stockSpanner.next(85);  // return 6
 

Constraints:

1 <= price <= 105
At most 104 calls will be made to next.
 * 
 * @author sukh
 *
 */
public class _28_StockSpan {

  private Deque<int[]> stack;

  public _28_StockSpan() {
    stack = new ArrayDeque<>();
  }

  /**
   * Time: O(1) <br>
   * Even though there is a while loop in next, that while loop can only run n
   * times total across the entire algorithm. Each element can only be popped off
   * the stack once, and there are up to n elements.
   * 
   * This is called amortized analysis - if you average out the time it takes for
   * next to run across n calls, it works out to be O(1)O(1). If one call to next
   * takes a long time because the while loop runs many times, then the other
   * calls to next won't take as long because their while loops can't run as long.
   * 
   * Space: O(n) <br>
   * In the worst case scenario for space (when all the stock prices are
   * decreasing), the while loop will never run, which means the stack grows to a
   * size of n.
   * 
   * @param price
   * @return
   */
  public int next(int price) {
    int days = 1;
    while (!stack.isEmpty() && stack.peek()[0] <= price) {
      days += stack.pop()[1];
    }
    stack.push(new int[] { price, days });
    return days;
  }

}
