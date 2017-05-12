package cal;
import stack.Stack;
import stack.StackException;

public class InfixToPostFixEvalution {
	//연산자 확인
    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^' || c == '(' || c == ')';
    }
    //연산순위
    private int getPrecedence(char ch) {
        switch (ch) {
        case '+':
        case '-':
            return 1;

        case '*':
        case '/':
            return 2;

        case '^':
            return 3;
        }
        return -1;
    }
    //피연산자 확인
    private boolean isOperand(char ch) {
        return (ch >= '0' && ch <= '9') ;
    }
    //infix to postfix 변환
    public String convertToPostfix(String infix) throws StackException {
        Stack<Character> stack = new Stack<Character>();
        //StringBuffer를 사용하여 메모리 절약... append()함수이용
        StringBuffer postfix = new StringBuffer(infix.length());
        
        char c;

        for (int i = 0; i < infix.length(); i++) {
            c = infix.charAt(i);

            if (isOperand(c)) {
                postfix.append(c);
            } else if (c == '(') {
                stack.push(c);
            }
            //괄호 연산자가 나오면 닫힐때 까지 pop으로 뺏다가 다시 넣는다
            else if (c == ')') {

                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() != '(')
                    return null;
                else if(!stack.isEmpty())
                    stack.pop();
            }
            else if (isOperator(c)) // 연산자넣기
            {
            	//스택이 안 비어있는 상태 && 연산자순위를 스택에 있는 연산자와 비교한다
                if (!stack.isEmpty() && getPrecedence(c) <= getPrecedence(stack.peek())) {
                    postfix.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }
        return postfix.toString();
    }
}