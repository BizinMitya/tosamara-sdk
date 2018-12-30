package exception;

public class APIResponseException extends Exception {

    private int code;

    public APIResponseException(int code) {
        super("Response code is " + code);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
