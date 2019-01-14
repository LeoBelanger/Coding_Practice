// Question #747: Largest Number at Least Twice of Others
class Solution {
    public int dominantIndex(int[] nums) {
        if(nums.length < 2) {
            return 0;
        }

        int largestIndex = 0;
        int largestVal = nums[0];
        int secondLargestVal = 0;

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] >= largestVal) {
                secondLargestVal = largestVal;
                largestVal = nums[i];
                largestIndex = i;
            }
            else if(nums[i] > secondLargestVal) {
                secondLargestVal = nums[i];
            }
        }
        if(largestVal >= 2 * secondLargestVal) {
            return largestIndex;
        } else {
            return -1;
        }
    }
}
/* The trick for this is to simply go through the array once keeping track of the
 * current largest value, and second largest value. After going through the array once,
 * simply check if the largest is at least twice larger than the seocnd largest. This is
 * O(n) since you go through the array once for N integers.
 */


// Question #66: Plus One
class Solution {
    public int[] plusOne(int[] digits) {
        int size = digits.length;

        for(int i = size - 1; i >= 0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] res = new int[size + 1];
        res[0] = 1;
        return res;
    }
}
/* Pretty straight forward. Only thing is to watch out for case when array
 * contains all 9's. In this case just create a new array of size + 1 and
 * set the first index to 1.
 */


// Question #28: Implement strStr() ie. Find starting index of substring in string
class Solution {
    public int strStr(String haystack, String needle) {
        int stringLength = haystack.length();
        int subStrLength = needle.length();
        int j = 0;

        if(needle.equals("")) {
            return 0;
        }

        for(int i = 0; i < stringLength; i++) {
            if(haystack.charAt(i) == needle.charAt(j)) {
                if(j == subStrLength - 1) {
                    return i - j;
                }
                j++;
            } else {
                i = i - j;
                j = 0;
            }
        }
        return -1;
    }
}
/* The main thing to remember for this was to reset i back to i - j after failing.
 * Eitherwise you wouldnt check all possible substrings.
 */


// Question #14: Longest Common Prefix
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";

        Arrays.sort(strs);
        int len = strs[0].length();
        char[] first = strs[0].toCharArray();
        char[] last  = strs[strs.length - 1].toCharArray();

        int i = 0;
        while (i < len && first[i] == last[i]) {
            i++;
        }

        return strs[0].substring(0, i);
    }
}
/* The main thing to remember here is that the smallest length string is the max
 * length substring. The trick I used was to loop while each substring matched,
 * once first[i] != last[i], simply exit the loop and return the substring from 0 to i.
 */


// Question #344: Reverse String
class Solution {
    public String reverseString(String s) {
        int startingIndex = 0;
        int endingIndex = s.length() - 1;

        char[] reverseString = s.toCharArray();

        while (startingIndex < endingIndex) {
            char temp = reverseString[startingIndex];
            reverseString[startingIndex] = reverseString[endingIndex];
            reverseString[endingIndex] = temp;
            startingIndex++;
            endingIndex--;
        }

        return String.copyValueOf(reverseString);
    }
}
//Self Explanitory
