package animal;

import exception.InvalidAnimalBirthDateException;
import exception.InvalidAnimalException;

public interface SearchService {

    boolean checkLeapYearAnimal(Animal animal) throws InvalidAnimalException, InvalidAnimalBirthDateException;

}
