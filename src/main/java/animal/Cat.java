package animal;

import java.time.LocalDate;

public class Cat extends Pet {

    public Cat(String breed, String name, Double cost, String character, LocalDate birthDate) {
        super(breed, name, cost, character, birthDate);
    }

    public Cat(LocalDate birthDate) {
        super(birthDate);
    }

}