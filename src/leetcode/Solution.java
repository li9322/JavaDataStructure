package leetcode;

import jdk.nashorn.internal.IntDeque;

import java.util.Stack;

/**
 * @DESCRIPTION:
 * @USER: li
 * @DATE: 2021/04/12 21:15
 */
public class Solution {
    private  Stack<Character> stack=new Stack();
    public  boolean isValid(String s){
        for (int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if (c=='(' || c=='[' || c=='{')
                stack.push(c);
            else {
                char topChar=(char)stack.pop();
                if (topChar=='(' && c!=')')
                    return false;
                if (topChar=='[' && c!=']')
                    return false;
                if (topChar=='{' && c!='}')
                    return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s="[{}]";
//        System.out.println(isValid(s));
    }
}
