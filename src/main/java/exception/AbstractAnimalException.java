package exception;

public abstract class AbstractAnimalException extends RuntimeException {

    protected String message;

    public AbstractAnimalException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
