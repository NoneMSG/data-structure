package cal;

import java.util.Arrays;

import list.DoublyLinkedList;
import list.List;
import stack.Stack;
import stack.StackException;
import tree.LinkedTree;
import tree.LinkedTree.TreeNode;

public class Calulator {
	public static void main(String[] args) {
		try {
			//string postfixed of object 
			InfixToPostFixEvalution toPostfix = new InfixToPostFixEvalution();
			
			String val = "2*3*(2+4)+9"; 
			String postFixed = toPostfix.convertToPostfix(val);
			System.out.println(postFixed);
			
			//tree 자료구조에 수식을 저장하기 위한 tree
			LinkedTree<String> tree = LinkedTree.toExpressionTree(postFixed);
			//dlinkedlist를 이용하여 데이터를 트리를 탐색하며 데이터를 리스트에 받아온다.
			List<String> list = new DoublyLinkedList<String>();
			tree.traversalPostorder(list);
			//출력
			System.out.println(Arrays.toString(list.toArray()));
			
			//리스트에 담겨있는 트리를 계산하기 위한 함수
			double result =0;
			result = tree.calc(tree.getRoot());
			//결과출력
			System.out.println(result);
					
			
		} catch (StackException e) {
			System.out.println(e);
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

// package cal;
//
// import stack.Stack;
// import stack.StackException;
//
// public class Calulator {
// public static void main(String[] args) {
// try{
// InfixToPostFixEvalution toPostfix = new InfixToPostFixEvalution();
//
// Stack<Character> s = new Stack<Character>();
// Stack<Double> ns = new Stack<Double>();
// String val = "2*3*(2+4)+9";
// System.out.println(toPostfix.convertToPostfix(val));
// String postFixed = toPostfix.convertToPostfix(val);
// for (int i = postFixed.length() - 1; i >= 0; --i) {
// s.push(postFixed.charAt(i));}
//
// while (!(s.isEmpty())) {
// if (!isOp(s.peek())) {
// // System.out.println("숫자스택맨위"+s.peek());
// ns.push(Double.parseDouble(Character.toString(s.pop())));
// // System.out.println("size"+ns.size());
// } else {
//
// switch (s.pop()) {
// case '*': {
// //System.out.println("1*peek:"+ns.peek());
// double a = ns.pop();
// //System.out.println("2*peek:"+ns.peek());
// double b = ns.pop();
// double c = b * a;
// // System.out.println("곱샘"+c);
// ns.push(c);
// //System.out.println("result peek: "+ns.peek());
// break;
// }
// case '/': {
// double a = ns.pop();
// double b = ns.pop();
// double c = a / b;
// ns.push(c);
// // System.out.println("나누기"+c);
// break;
// }
// case '+': {
// double a = ns.pop();
// double b = ns.pop();
// double c = a + b;
// // System.out.println("플러스"+c);
// ns.push(c);
// break;
// }
// case '-': {
// double a = ns.pop();
// double b = ns.pop();
// double c = a - b;
// // System.out.println("빼기"+c);
// ns.push(c);
// break;
// }
// }
// }
// }System.out.println(ns.pop());
//
// }
// catch (StackException e) {
// e.printStackTrace();
// }
// }
// public static boolean isOp(char op) {
// switch (op) {
// case '*':
// return true;
// case '/':
// return true;
// case '+':
// return true;
// case '-':
// return true;
// default:
// return false;
// }
// }
// }
