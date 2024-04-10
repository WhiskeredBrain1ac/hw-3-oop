package exception;

public class InvalidAnimalBirthDateException extends AbstractAnimalException {

    public InvalidAnimalBirthDateException(String breed) {
        super("У животного " + breed + " не указана дата его рождения.");
    }

}
