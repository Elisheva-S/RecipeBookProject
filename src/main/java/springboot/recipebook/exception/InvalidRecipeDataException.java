package springboot.recipebook.exception;
public class InvalidRecipeDataException extends Exception{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public InvalidRecipeDataException(String msg) {
super(msg);
}
}
