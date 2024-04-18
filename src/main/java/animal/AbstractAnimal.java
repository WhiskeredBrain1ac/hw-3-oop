package animal;

import java.time.LocalDate;
import java.util.Objects;

public abstract class AbstractAnimal implements Animal {

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractAnimal that = (AbstractAnimal) o;
        return Objects.equals(breed, that.breed) && Objects.equals(name, that.name) && Objects.equals(cost, that.cost) && Objects.equals(character, that.character) && Objects.equals(birthDate, that.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(breed, name, cost, character, birthDate);
    }
}
