package exception;

import java.time.LocalDate;

public class InvalidAnimalException extends AbstractAnimalException {

    public InvalidAnimalException() {
        super("На вход пришёл некорректный объект животного. Текущее время: " + LocalDate.now() + ".");
    }

}