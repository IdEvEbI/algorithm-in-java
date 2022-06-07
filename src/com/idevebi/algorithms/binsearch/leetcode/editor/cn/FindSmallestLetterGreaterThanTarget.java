package com.idevebi.algorithms.binsearch.leetcode.editor.cn;

/**
 * 744. 寻找比目标字母大的最小字母
 */
public class FindSmallestLetterGreaterThanTarget {
    public static void main(String[] args) {
        Solution solution = new FindSmallestLetterGreaterThanTarget().new Solution();

        char letter = solution.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'a');
        System.out.println(letter);

        letter = solution.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'c');
        System.out.println(letter);

        letter = solution.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'f');
        System.out.println(letter);

        letter = solution.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'j');
        System.out.println(letter);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public char nextGreatestLetter(char[] letters, char target) {
            int right = letters.length - 1;

            // 如果目标字符比所有字符都大
            if (target >= letters[right]) {
                return letters[0];
            }

            int left = 0;
            while (left < right) {
                int mid = left + (right - left) / 2;

                if (letters[mid] <= target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            return letters[left];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}