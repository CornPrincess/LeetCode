// Source : https://leetcode.com/problems/short-encoding-of-words/submissions/
// Author : cornprincess
// Date   : 2020-03-28

/***************************************************************************************************** 
 *
 * Given a list of words, we may encode it by writing a reference string S and a list of indexes A.
 * 
 * For example, if the list of words is ["time", "me", "bell"], we can write it as S = "time#bell#" 
 * and indexes = [0, 2, 5].
 * 
 * Then for each index, we will recover the word by reading from the reference string from that index 
 * until we reach a "#" character.
 * 
 * What is the length of the shortest reference string S possible that encodes the given words?
 * 
 * Example:
 * 
 * Input: words = ["time", "me", "bell"]
 * Output: 10
 * Explanation: S = "time#bell#" and indexes = [0, 2, 5].
 * 
 * Note:
 * 
 * 	1 <= words.length <= 2000.
 * 	1 <= words[i].length <= 7.
 * 	Each word has only lowercase letters.
 * 
 ******************************************************************************************************/

class A {
    public static void main(String[] args) {
        Integer i = 3;
        System.out.println(i);
        test(i);
        System.out.println(i);
    }

    public static void test(Integer i) {
        i = 3 * i;
        System.out.println("test: " + i);
        // 0000 0100 -- 1111 1011 --
        // 110
        System.out.println(~4);
    }
}
