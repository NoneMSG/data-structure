package recursion;

public class Recursion {

	public static void main(String[] args) {
		int count = 0 ; 
		recursion(count);
	}
	static public void recursion(int num){
		if(num>=3){
			return;
		}
		num++;
		System.out.println("recursive func called "+num);
		recursion(num);
	}
}
