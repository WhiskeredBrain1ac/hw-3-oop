package animal;

import exception.AnimalException;

import java.util.Arrays;
import java.util.List;
import java.util.Random;


public interface CreateAnimalService {

    List<String> breeds = Arrays.asList("Белая акула", "Норвежская лесная", "Немецкая овчарка", "Акула-молот",
            "Ретривер", "Гривистый волк", "Красный волк", "Абиссинская кошка", "Сиамская кошка", "Австралийская овчарка");


    List<String> names = Arrays.asList("Елена", "Аврора", "Нина Ивановна", "Пётр", "Ивор",
            "Кристина", "Валерий", "Фруктоза", "Глицирин", "Анатолий");
    List<Double> costs = Arrays.asList(7.0, 18.80, 37.90, 9000.000, 100.60, 1000000.0, 170.10, 90.90, 300.50, 560.10);
    List<String> characters = Arrays.asList("ехидность", "двуличность", "любопытство", "капризность", "благородство",
            "пассивность", "наглость", "неряшливость", "корыстность", "неряшливость");


    default void create(String type) {
        int amount = 10;
        while (amount > 0) {
            Random random = new Random();
            String name = names.get(random.nextInt(names.size()));
            String breed = breeds.get(random.nextInt(breeds.size()));
            Double cost = costs.get(random.nextInt(costs.size()));
            String character = characters.get(random.nextInt(characters.size()));

            switch (type) {
                case "Cat":
                    Cat cat = new Cat(name, breed, cost, character);
                    System.out.println(cat);
                    break;
                case "Dog":
                    Dog dog = new Dog(name, breed, cost, character);
                    System.out.println(dog);
                case "Shark":
                    Shark shark = new Shark(name, breed, cost, character);
                    System.out.println(shark);
                case "Wolf":
                    Wolf wolf = new Wolf(name, breed, cost, character);
                    System.out.println(wolf);
                default:
                    throw new AnimalException("Unknown Animal");
            }
            amount--;
        }
    }


    void create(String type, int amount);
}
