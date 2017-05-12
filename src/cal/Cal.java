package cal;

import stack.Stack;
import stack.StackException;

public class Cal {
	public static void main(String args[]) {
//()연산 미완성
		String question = "(1*2+3)/4";

		Postfix pf = new Postfix(question);
		System.out.println(pf.getter());
		int inputLength = pf.getter().length();
		String input = pf.getter();
		Stack<Character> s = new Stack<Character>();
		Stack<Double> ns = new Stack<Double>();

		// System.out.println(0+'*'); //42
		// System.out.println(0+'/'); //47
		// System.out.println(0+'+'); //43
		// System.out.println(0+'-'); //45

		for (int i = inputLength-1; i >=0; --i) {
			s.push(input.charAt(i));
		}
//		try{
//			while(!s.isEmpty())
//		System.out.print(s.pop());
//		}catch (StackException e){
//			
//		}
		
		while (!(s.isEmpty())) {

			if (!isOp(s.peek())) {
				try {
					//System.out.println("숫자스택맨위"+s.peek());
					ns.push(Double.parseDouble(Character.toString(s.pop())));
					//System.out.println("size"+ns.size());
					
				} catch (StackException e) {

				}
			} else {
				try {
					switch (s.pop()) {
					case '*': {
						double a = ns.pop();
						double b = ns.pop();
						double c = b*a;
						//System.out.println("곱샘"+c);
						 ns.push(c);
						 break;
					}
					case '/': {
						double a = ns.pop();
						double b = ns.pop();
						double c = b/a;
						ns.push(c);
						//System.out.println("나누기"+c);
						break;
					}
					case '+': {
						double a = ns.pop();
						double b = ns.pop();
						double c = a+b;
						//System.out.println("플러스"+c);
						ns.push(c);
						break;
					}
					case '-': {
						double a = ns.pop();
						double b = ns.pop();
						double c = a-b;
						//System.out.println("빼기"+c);
						ns.push(c);
						break;
					}
					}
				} catch (StackException e) {

				}
			}
		}
		
		try{
		 System.out.println("결과:"+ns.pop());
		 System.out.println("스택사이즈"+ns.size());
		}catch(StackException e){
			
		}
		// while (!(s.isEmpty())) {
		// try {
		// char v;
		// v = s.pop();
		// if (isOp(v)) {
		// op += v;
		// } else {
		// tempstr += v;
		// }
		// } catch (StackException e) {
		//
		// }
		// }
		// System.out.println(tempstr);
		// System.out.println(op);
		//
		// double a =
		// Double.parseDouble(Character.toString(tempstr.charAt(tempstr.length()-1)));
		// double b =
		// Double.parseDouble(Character.toString(tempstr.charAt(tempstr.length()-2)));
		// System.out.println(a);
		// System.out.println(b);
		// char oper= op.charAt(op.length()-1);
		// System.out.println(oper);
		// System.out.println(a+""+oper+""+b);
		//
		// for(int i = tempstr.length() ; i <= 0 ; --i){
		// for(int j = op.length() ; j <=0 ; --j){
		//
		// }
		// }
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
		case '(':
			return true;
		case ')':
			return true;
		default:
			return false;
		}
	}
}
