package animal;

import enumerated.AnimalEnum;
import exception.AnimalException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreateAnimalServiceImpl implements CreateAnimalService {

    @Override
    public List<Animal> create(AnimalEnum animalEnum, int amount) {
        List<Animal> animals = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            animals.add(createAnimal(animalEnum));
        }
        return animals;
    }

    @Override
    public List<Animal> create(AnimalEnum animalEnum) {
        int amount = 10;
        List<Animal> animals = new ArrayList<>();
        do {
            animals.add(createAnimal(animalEnum));
            amount--;
        }
        while (amount > 0);
        return animals;
    }


    public Animal createAnimal(AnimalEnum animalEnum) {
        Random random = new Random();
        String name = names.get(random.nextInt(names.size()));
        String breed = breeds.get(random.nextInt(breeds.size()));
        Double cost = costs.get(random.nextInt(costs.size()));
        String character = characters.get(random.nextInt(characters.size()));
        Animal animal;
        switch (animalEnum) {
            case CAT:
                animal = new Cat(breed, name, cost, character, getBirthDate());
                System.out.println(animal);
                break;
            case DOG:
                animal = new Dog(breed, name, cost, character, getBirthDate());
                System.out.println(animal);
                break;
            case SHARK:
                animal = new Shark(breed, name, cost, character, getBirthDate());
                System.out.println(animal);
                break;
            case WOLF:
                animal = new Wolf(breed, name, cost, character, getBirthDate());
                System.out.println(animal);
                break;
            default:
                throw new AnimalException();
        }
        return animal;
    }

}
