package musicstore;

public class TimePeriodInvalidException extends Exception{

    public TimePeriodInvalidException(String message){
        super(message);
        System.out.println(message);
    }

}
