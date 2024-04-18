package exception;

public class EmptyObjectException extends AbstractAnimalException{

    public EmptyObjectException() {
        super("На вход пришёл пустой объект/список.");
    }

}
