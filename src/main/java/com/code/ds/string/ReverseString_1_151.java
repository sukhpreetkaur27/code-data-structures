package com.code.ds.string;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseString_1_151 {

  /**
   * Time: O(n)<br>
   * Space: O(n)
   * @param s
   * @return
   */
  public String reverse(String s) {
    List<String> words = Arrays.asList(s.split("\\s+"));
    Collections.reverse(words);
    String reverse = String.join(" ", words);
    return reverse;
  }

}
