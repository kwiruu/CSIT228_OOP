public class InvalidAgeException extends Exception{
    public InvalidAgeException() {
        super("WOW NO INPUT FOR THE EXCEPTION");
    }

    InvalidAgeException(String msg){
        super(msg);
    }
}
