package animal;

import java.time.LocalDate;

public abstract class AbstractAnimal implements Animal {

    protected String breed; // порода
    protected String name; // имя
    protected Double cost; // цена в магазине
    protected String character; // характер

    protected LocalDate birthDate; // День рождения животного

    public AbstractAnimal(LocalDate birthDate) {
        this.birthDate = getBirthDate();
    }

    public AbstractAnimal(String breed, String name, Double cost, String character, LocalDate birthDate) {
        this.breed = breed;
        this.name = name;
        this.cost = cost;
        this.character = character;
        this.birthDate = birthDate;
    }

    @Override
    public String getBreed() {
        return breed;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Double getCost() {
        return cost;
    }

    @Override
    public String getCharacter() {
        return character;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString() {
        return "AbstractAnimal{" +
                "breed = '" + breed + '\'' +
                ", name = '" + name + '\'' +
                ", cost = " + cost +
                ", character = '" + character + '\'' +
                ", birthDate = '" + birthDate + '\'' +
                '}';
    }

}
