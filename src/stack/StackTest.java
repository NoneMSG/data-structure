package stack;

public class StackTest {

	public static void main(String[] args) {

		try {
			Stack<String> stack = new Stack<String>();
			stack.push("Hello");
			stack.push("World");
			stack.push("!!!");
			stack.push("java");
			stack.push(".");

			while (stack.isEmpty() == false) {
				System.out.println((String) stack.pop());
			}

			System.out.println("======================================");

			stack = new Stack<String>();
			stack.push("Hello");

			System.out.println(stack.pop());
			System.out.println(stack.pop());

		} catch (StackException ex) {
			System.out.println(ex);
		}
	}

}
