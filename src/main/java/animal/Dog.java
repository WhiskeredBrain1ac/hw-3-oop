package animal;

import java.time.LocalDate;

public class Dog extends Pet {
    public Dog(String breed, String name, Double cost, String character, LocalDate birthDate) {
        super(breed, name, cost, character, birthDate);
    }

    public Dog(LocalDate birthDate) {
        super(birthDate);
    }

}
