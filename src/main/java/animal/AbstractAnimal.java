package animal;

import java.time.LocalDate;

public abstract class AbstractAnimal implements Animal,Comparable{

    protected String breed;
    protected String name;
    protected Double cost;
    protected String character;

    protected LocalDate birthDate;

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

    @Override
    public int compareTo(Animal animal) {
            int result = this.birthDate.compareTo(animal.getBirthDate());
            return result;
    }

}
