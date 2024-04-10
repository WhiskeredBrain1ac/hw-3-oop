package animal;

import enumerated.AnimalEnum;
import exception.AnimalException;

import java.time.LocalDate;
import java.util.ArrayList;
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


    default List<Animal> create(AnimalEnum animalEnum) {
        int amount = 10;
        List<Animal> animals = new ArrayList<>();
        while (amount > 0) {
            Random random = new Random();
            String name = names.get(random.nextInt(names.size()));
            String breed = breeds.get(random.nextInt(breeds.size()));
            Double cost = costs.get(random.nextInt(costs.size()));
            String character = characters.get(random.nextInt(characters.size()));

            switch (animalEnum) {
                case CAT:
                    Cat cat = new Cat(breed, name, cost, character, getBirthDate());
                    animals.add(cat);
                    System.out.println(cat);
                    break;
                case DOG:
                    Dog dog = new Dog(breed, name, cost, character, getBirthDate());
                    animals.add(dog);
                    System.out.println(dog);
                    break;
                case SHARK:
                    Shark shark = new Shark(breed, name, cost, character, getBirthDate());
                    animals.add(shark);
                    System.out.println(shark);
                    break;
                case WOLF:
                    Wolf wolf = new Wolf(breed, name, cost, character, getBirthDate());
                    animals.add(wolf);
                    System.out.println(wolf);
                    break;
                default:
                    throw new AnimalException();
            }
            amount--;
        }
        return animals;
    }

    List<Animal> create(AnimalEnum animalEnum, int amount);

    default LocalDate getBirthDate() {
        Random random = new Random();
        int randNumber = random.nextInt(30 - 1) + 1;
        LocalDate birthDate = LocalDate.now().minusYears(randNumber).minusWeeks(randNumber);
        return birthDate;
    }

}
