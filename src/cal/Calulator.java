package cal;

import stack.Stack;
import stack.StackException;

public class Calulator {

	public static void main(String[] args) {
		InfixToPostFixEvalution toPostfix = new InfixToPostFixEvalution();
		try {
			Stack<Character> s = new Stack<Character>();
			Stack<Double> ns = new Stack<Double>();
			String val = "2*3*(2+4)+9";
			System.out.println(toPostfix.convertToPostfix(val));
			String postFixed = toPostfix.convertToPostfix(val);
			for (int i = postFixed.length() - 1; i >= 0; --i) {
				s.push(postFixed.charAt(i));
			}
			while (!(s.isEmpty())) {

				if (!isOp(s.peek())) {
					try {
						// System.out.println("숫자스택맨위"+s.peek());
						ns.push(Double.parseDouble(Character.toString(s.pop())));
						// System.out.println("size"+ns.size());

					} catch (StackException e) {

					}
				} else {

					switch (s.pop()) {
					case '*': {
						//System.out.println("1*peek:"+ns.peek());
						double a = ns.pop();
						//System.out.println("2*peek:"+ns.peek());
						double b = ns.pop();
						double c = b * a;
						// System.out.println("곱샘"+c);
						ns.push(c);
						//System.out.println("result peek: "+ns.peek());
						break;
					}
					case '/': {
						double a = ns.pop();
						double b = ns.pop();
						double c = a / b;
						ns.push(c);
						// System.out.println("나누기"+c);
						break;
					}
					case '+': {
						double a = ns.pop();
						double b = ns.pop();
						double c = a + b;
						// System.out.println("플러스"+c);
						ns.push(c);
						break;
					}
					case '-': {
						double a = ns.pop();
						double b = ns.pop();
						double c = a - b;
						// System.out.println("빼기"+c);
						ns.push(c);
						break;
					}
					}
				}
			}System.out.println(ns.pop());

		} 
		catch (StackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public static boolean isOp(char op) {
		switch (op) {
		case '*':
			return true;
		case '/':
			return true;
		case '+':
			return true;
		case '-':
			return true;
		default:
			return false;
		}
	}
}
