package stack;

public class StackException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public StackException(){
		super("Stack Exception Occured");
	}
	public StackException(String msg){
		super(msg);
	}
}
