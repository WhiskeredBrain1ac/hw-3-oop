package animal;

import java.time.LocalDate;

public class Predator extends AbstractAnimal {
    public Predator(String breed, String name, Double cost, String character, LocalDate birthDate) {
        super(breed, name, cost, character, birthDate);
    }

    public Predator(LocalDate birthDate) {
        super(birthDate);
    }

    @Override
    public String toString() {
        return "Хищное животное," +
                " имя '" + name + '\'' +
                ", порода '" + breed + '\'' +
                ", стоимость " + cost +
                ", характер '" + character + '\'' +
                ", дата рождения = '" + birthDate + '\'' +
                '}';
    }

}
