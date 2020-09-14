package toOffer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author: create by hsw
 * @description: toOffer
 * @date:2020/6/11
 **/
public class LeetCodeHandler {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix3(new String[]{"aa","a"}));
    }


    /**
     * 14. 最长公共前缀 -分治法
     * LCP
     * @param strs
     * @return
     */
    public static String longestCommonPrefix3(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }

        return LCP(strs, 0, strs.length - 1);
    }


    private static String LCP(String[] strs, int start,int end ) {
        if (start == end) {
            return strs[start];
        } else {
            int mid = (end - start) / 2 + start;
            String lcpLeft = LCP(strs, start, mid);
            String lcpRight = LCP(strs, mid + 1, end);
            return longestPrefix(lcpLeft, lcpRight);
        }
    }
    /**
     * 14. 最长公共前缀 -横向扫描
     * LCP
     * @param strs
     * @return
     */
    public static String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String longest = strs[0];
        for (int i = 1; i < strs.length; i++) {
            longest = longestPrefix(longest, strs[i]);
        }
        return longest;
    }

    public static String longestPrefix(String str1, String str2) {
        int min = Math.min(str1.length(), str2.length());
        for (int i = 0; i < min; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return str1.substring(0, i);
            }
        }

        return str1.substring(0, min);
    }

    private static boolean midJug(String[] strs, int mid) {

        return false;
    }

        /**
         * 14. 最长公共前缀
         * @param strs
         * @return
         */
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        int minLen = Integer.MAX_VALUE;
        String minStr = "";
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < minLen) {
                minLen = strs[i].length();
                minStr = strs[i];
            }
        }
        for (int i = 0; i < minLen; i++) {
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() <= i || strs[0].charAt(i)!=(strs[j].charAt(i))) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return minStr;
    }
    /**
     * 739 递减栈#
     * @param T
     * @return
     */
    public static int[] dailyTemperatures2(int[] T) {
        LinkedList<Integer> stack = new LinkedList<>();
        int[] res = new int[T.length];
        int index = -1;
        for (int t : T) {
            index++;
            while (!stack.isEmpty() && T[stack.peek()] < t) {
                int curIndex = stack.pop();
                res[curIndex] = index - curIndex;
            }
            stack.push(index);
        }
        return res;
    }

    /**
     * 739
     * @param T
     * @return
     */
    public static int[] dailyTemperatures(int[] T) {
        if (T.length == 1) {
            T[0] = 0;
            return T;
        }
        for (int i = 0; i < T.length; i++) {
            int count = 0;
            int tempT = T[i];
                for (int j = i + 1; j < T.length; j++) {
                    count++;
                    if (T[j] > tempT) {
                        break;
                    } else if (j == T.length - 1) {
                        count = 0;
                    }
                }
            T[i]=count;
        }

        return T;
    }

    public static int subtractProductAndSum(int n) {

        int a=1;
        int b=0;

        while(n!=0) {
            a*=(n%10);
            b+=(n%10);
            n=n/10;
        }
        return a-b;
    }

    public static String defangIPaddr(String address) {

        return address.replace(".", "[.]");
    }

    public static int findNumbers(int[] nums) {
        int count =0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int place =0;
            while(num!=0) {
                num = num /10;
                place ++;
            }
            if(place%2==0) count ++;

        }

        return count;
    }

    public static int[] decompressRLElist(int[] nums) {
//        int[] result = new int[32];
        ArrayList<Integer> list = new ArrayList<>();
        int t = 0;
        for (int i = 0; i * 2 + 1 < nums.length; i++) {
            for (int j = nums[2 * i]; j > 0; j--) {
//                result[t++] = nums[2 * i + 1];
                list.add(nums[2 * i + 1]);
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }


}
