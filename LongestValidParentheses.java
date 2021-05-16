package com.test.week05;

public class LongestValidParentheses {

    /*dp[i] 表示以 i 结尾的最长有效括号；
    当 s[i] 为 (,dp[i] 必然等于 0，因为不可能组成有效的括号；
    那么 s[i] 为 )
    1:当 s[i-1] 为 (，那么 dp[i] = dp[i-2] + 2；
    2:当 s[i-1] 为 ) 并且 s[i-dp[i-1] - 1] 为 (，那么 dp[i] = dp[i-1] + 2 + dp[i-dp[i-1]-2]
    */
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) return 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') stack.push(i);
            else {
                stack.pop();
                if (stack.isEmpty()) stack.push(i);
                else {
                    res = Math.max(res, i - stack.peek());
                }
            }
        }
        return res;
    }
}
