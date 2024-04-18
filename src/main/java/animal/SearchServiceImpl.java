package animal;

import exception.InvalidAnimalBirthDateException;
import exception.InvalidAnimalException;

import java.time.LocalDate;

public class SearchServiceImpl implements SearchService {
    @Override
    public boolean checkLeapYearAnimal(Animal animal) {
        if (animal == null) throw new InvalidAnimalException();
        if (animal.getBirthDate() == null) throw new InvalidAnimalBirthDateException(animal.getBreed());
        LocalDate birthDate = animal.getBirthDate();
        if (birthDate.isLeapYear()) {
            System.out.println("Животное " + animal.getBreed() + " с кличкой " + animal.getName() + " появилось на свет в ВИСОКОСНЫЙ год.");
            return true;
        } else {
            System.out.println("Животное " + animal.getBreed() + " с кличкой " + animal.getName() + " появилось на свет в НЕВИСОКОСНЫЙ год.");
            return false;
        }
    }

}
