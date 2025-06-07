package main.java.io.github.xerosandones.leetcode.valid_anagram;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {

  public static boolean isAnagramHash(String s, String t) {
    HashMap<Character, Integer> string1 = new HashMap<>();
    HashMap<Character, Integer> string2 = new HashMap<>();

    for (char c : s.toCharArray()) {
      string1.put(c, string1.getOrDefault(c, 0) +1);
    }
    for (char c : t.toCharArray()) {
      string2.put(c, string2.getOrDefault(c, 0) +1);
    }
    return string1.equals(string2);
  }

  public static boolean isAnagramSort(String s, String t) {
    char[] string1 = s.toCharArray();
    char[] string2 = t.toCharArray();

    Arrays.sort(string1);
    Arrays.sort(string2);

    return Arrays.equals(string1, string2);
  }

  public static void main(String[] args) {
    System.out.println(isAnagramHash("hi", "ih"));
    System.out.println(isAnagramSort("hi", "ih"));
  }
}
