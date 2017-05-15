package recursion;

public class FibonacciTest {
	public static long count=0;
	public static int next=0;
	public static int second=0;
	public static int first=1;
	public static void main(String[] args) {
//		for( int i = 0 ; i <= 30 ; ++i){
//			System.out.println(fibonacci(i)+" call: "+count+", ");
//		}
		//System.out.println("fibonacci: "+fibonacci(40)+" func call: "+count+", ");
		System.out.println(fibonacciLoop(7));
	}
	public static int fibonacciLoop(int n){
		
		for(int i = 0 ; i < n ; ++i){
			if(i<=1){
				next=i;
			}else{
				next = first+second;
				first = second;
				second = next;
			}
		}
		return next;
	}
	public static int fibonacci(int num){
		//System.out.println((count++) +" call");
		count++;
		if(num==0){
			return 0;
		}
		if( num ==1 ){
			return 1;
		}
		return fibonacci(num-1)+fibonacci(num-2);
	}
}
