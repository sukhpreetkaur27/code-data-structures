package com.code.ds.string;

public class FirstStringOccurrence {

  public int strStr(String haystack, String needle) {
    int index = -1;
    int parentLen = haystack.length();
    int childLen = needle.length();
    int right = 0;
    int left = 0;
    int j = 0;
    while (right < parentLen) {
      if (haystack.charAt(right) == needle.charAt(j)) {
        right++;
        j++;
      } else {
        left++;
        right = left;
        j = 0;
      }

      if (j == childLen) {
        if (right - left == j) {
          index = left;
          break;
        }
        j = 0;
      }
    }
    return index;
  }

  public static void main(String[] args) {
    FirstStringOccurrence obj = new FirstStringOccurrence();
    int i = obj.strStr("leetcode", "leeto");
//    int i = obj.strStr("sadbutsad", "sad");
    System.out.println(i);
  }

}
