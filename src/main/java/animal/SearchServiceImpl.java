package animal;

import exception.InvalidAnimalBirthDateException;
import exception.InvalidAnimalException;

public class SearchServiceImpl implements SearchService {
    @Override
    public boolean checkLeapYearAnimal(Animal animal) {
        if (animal == null) throw new InvalidAnimalException();
        if (animal.getBirthDate() == null) throw new InvalidAnimalBirthDateException(animal.getBreed());
        int birthDate = animal.getBirthDate().getYear();
        if ((birthDate % 4 == 0) && (birthDate % 100 != 0) || (birthDate % 400 == 0)) {
            System.out.println("Животное " + animal.getName() + " появилось на свет в ВИСОКОСНЫЙ год.");
            return true;
        } else {
            System.out.println("Животное " + animal.getName() + " появилось на свет в НЕВИСОКОСНЫЙ год.");
            return false;
        }
    }

}
