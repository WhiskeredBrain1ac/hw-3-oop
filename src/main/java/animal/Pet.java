package animal;

public class Pet extends AbstractAnimal {
    public Pet(String name, String breed, Double cost, String character) {
        super(breed, name, cost, character);
    }

    @Override
    public String toString() {
        return "Одомашненное животное " +
                ", имя '" + name + '\'' +
                " порода '" + breed + '\'' +
                ", стоимость " + cost +
                ", характер '" + character + '\'' +
                '}';
    }

}
