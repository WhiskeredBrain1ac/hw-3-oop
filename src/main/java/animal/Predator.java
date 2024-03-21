package animal;

public class Predator extends AbstractAnimal {
    public Predator(String name, String breed, Double cost, String character) {
        super(breed, name, cost, character);
    }

    @Override
    public String toString() {
        return "Хищное животное " +
                ", имя '" + name + '\'' +
                " порода '" + breed + '\'' +
                ", стоимость " + cost +
                ", характер '" + character + '\'' +
                '}';
    }

}
