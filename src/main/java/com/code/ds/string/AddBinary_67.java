package com.code.ds.string;

public class AddBinary_67 {

  /**
   * Time: O(max(n,m))<br>
   * Space: O(max(n,m))
   * @param a
   * @param b
   * @return
   */
  public String add(String a, String b) {
    int aLen = a.length();
    int bLen = b.length();
    if (aLen < bLen) {
      return add(b, a);
    }

    StringBuilder sb = new StringBuilder();

    int carry = 0;
    for (int aIndex = aLen - 1, bIndex = bLen - 1; aIndex > -1; aIndex--) {
      if (a.charAt(aIndex) == '1') {
        carry++;
      }
      if (bIndex > -1 && b.charAt(bIndex--) == '1') {
        carry++;
      }

      if (carry % 2 == 1) {
        sb.append('1');
      } else {
        sb.append('0');
      }

      carry /= 2;
    }

    if (carry == 1) {
      sb.append('1');
    }

    sb.reverse();

    return sb.toString();
  }

  public static void main(String[] args) {
    String a = "1";
    String b = "111";
    System.out.println(a);
    System.out.println("+");
    System.out.println(b);
    System.out.println();
    AddBinary_67 obj = new AddBinary_67();
    String ans = obj.add(a, b);
    System.out.println("Ans. = " + ans);
  }

}
