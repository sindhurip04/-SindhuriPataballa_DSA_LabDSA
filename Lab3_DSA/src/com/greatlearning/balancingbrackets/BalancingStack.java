package com.greatlearning.balancingbrackets;

import java.util.Scanner;
import java.util.Stack;

public class BalancingStack {
	public static int balancedBrackets(String s) {
		Stack<Character> st = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '(' || ch == '[' || ch == '{') {
				st.push(ch);
			} else if (ch == ')' && st.peek() == '(') {
				st.pop();
			} else if (ch == ']' && st.peek() == '[') {
				st.pop();
			} else if (ch == '}' && st.peek() == '{') {
				st.pop();
			}
		}
		return st.isEmpty() ? 1 : 0;
	}

	public static void main(String[] Args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the string:");
		String input = sc.nextLine();
		int result = balancedBrackets(input);
		if (result == 1) {
			System.out.println("The entered String has Balanced Brackets");
		} else {
			System.out.println("The entered Strings do not contain Balanced Brackets");
		}
		sc.close();
	}
}
