package cal;

import stack.Stack;
import stack.StackException;

public class Postfix {
	private String is;
	private Stack<Character> s;

	public String getter() {
		return this.is;
	}

	public Postfix(String str) {
		is = str;
		s = new Stack<Character>();
		String outputString = "";
		boolean fI = false;
		for (int i = 0; i < is.length(); ++i) {
			char ch = is.charAt(i);
			if (!isOperator(ch)) {
				outputString += Character.toString(ch);
				if (i == (is.length() - 1)) {
					while (!s.isEmpty()) {
						try {
							outputString += s.pop();
						} catch (StackException e) {
							System.out.print(1);
							System.out.println(e);
						}
					}
				} else {
					if (fI) {
						if (pMin(ch) && pMin((Character) s.peek())) {
							try {
								outputString += s.pop();
								s.push(ch);
								if (i == (is.length() - 1)) {
									while (!s.isEmpty()) {
										outputString += s.pop();
									}
								}
							} catch (StackException e) {
								System.out.print(1);
								System.out.println(e);
							}
						} else if (mDiv(ch) && mDiv((Character) s.peek())) {
							try {
								outputString += s.pop();
								s.push(ch);
								if (i == (is.length() - 1)) {
									while (!s.isEmpty()) {
										outputString += s.pop();
									}
								}
							} catch (StackException e) {
								System.out.print(3);
								System.out.println(e);
							}
						} else if (pMin(ch) && mDiv((Character) s.peek())) {
							try {
								outputString += s.pop();
								s.push(ch);
								if (i == (is.length() - 1)) {
									while (!s.isEmpty()) {
										outputString += s.pop();
									}
								}
							} catch (StackException e) {
								System.out.print(4);
								System.out.println(e);
							}
						} else if (mDiv(ch) && pMin((Character) s.peek())) {
							try {
								outputString += s.pop();
								s.push(ch);
								if (i == (is.length() - 1)) {
									while (!s.isEmpty()) {
										outputString += s.pop();
									}
								}
							} catch (StackException e) {
								System.out.print(5);
								System.out.println(e);
							}
						} else {
							try {
								outputString += s.pop();
								if (i == (is.length() - 1)) {
									while (!s.isEmpty()) {
										outputString += s.pop();
									}
								}
							} catch (StackException e) {
								System.out.print(6);
								System.out.println(e);
							}
						}
					}
				}
			} else {
				s.push(ch);
				fI = true;
			}
		}
		// System.out.println(outputString);
		is = outputString;
	}

	private boolean isOperator(char op) {
		switch (op) {
		case '*':
			return true;
		case '/':
			return true;
		case '-':
			return true;
		case '+':
			return true;
		case '(':
			return true;
		case ')':
			return true;
		default:
			return false;
		}
		// return false;
	}

	private boolean pMin(char op) {
		switch (op) {
		case '+':
			return true;
		case '-':
			return true;
		default:
			return false;
		}
	}

	private boolean mDiv(char op) {
		switch (op) {
		case '*':
			return true;
		case '/':
			return true;
		default:
			return false;
		}
	}
}
