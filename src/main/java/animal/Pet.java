package animal;

import java.time.LocalDate;

public class Pet extends AbstractAnimal {

    public Pet(String breed, String name, Double cost, String character, LocalDate birthDate) {
        super(breed, name, cost, character, birthDate);
    }

    public Pet(LocalDate birthDate) {
        super(birthDate);
    }

    @Override
    public String toString() {
        return "Одомашненное животное," +
                " имя '" + name + '\'' +
                ", порода '" + breed + '\'' +
                ", стоимость " + cost +
                ", характер '" + character + '\'' +
                ", дата рождения = '" + birthDate + '\'' +
                '}';
    }

}
