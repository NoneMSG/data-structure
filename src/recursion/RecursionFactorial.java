package recursion;

public class RecursionFactorial {

	public static void main(String[] args) {
		
		for(int i = 1 ;  i <= 9 ; ++i){
			System.out.println(i+"!="+factorial(i));
		}
	}

	public static int factorial(int n) {
		if (n == 1) {
			return 1;
		} else {
			return n * (factorial(n - 1));
		}
	}
}
