package animal;

import enumerated.AnimalEnum;
import exception.AnimalException;

import java.util.*;

public class CreateAnimalServiceImpl implements CreateAnimalService {

    @Override
    public Map<String, List<Animal>> create(AnimalEnum animalEnum, int amount) {
        Map<String, List<Animal>> animalsMap = new HashMap<>();
        for (int i = 0; i < amount; i++) {
            animalsMap.putAll(createAnimal(animalEnum));
        }
        return animalsMap;
    }

    @Override
    public Map<String, List<Animal>> create(AnimalEnum animalEnum) {
        int amount = 10;
        List<Animal> animals = new ArrayList<>();
        Map<String, List<Animal>> animalsMap = new HashMap<>();
        do {
            animalsMap.putAll(createAnimal(animalEnum));
            amount--;
        }
        while (amount > 0);
        return animalsMap;
    }

    public Map<String, List<Animal>> createAnimal(AnimalEnum animalEnum) {
        List<Animal> animals = new ArrayList<>();
        Map<String, List<Animal>> animalsMap = new HashMap<>();
        Random random = new Random();
        String name = names.get(random.nextInt(names.size()));
        String breed = breeds.get(random.nextInt(breeds.size()));
        Double cost = costs.get(random.nextInt(costs.size()));
        String character = characters.get(random.nextInt(characters.size()));
        Animal animal;
        switch (animalEnum) {
            case CAT:
                animal = new Cat(breed, name, cost, character, getBirthDate());
                animals.add(animal);
                animalsMap.put(breed, animals);
                System.out.println(animal);
                break;
            case DOG:
                animal = new Dog(breed, name, cost, character, getBirthDate());
                animals.add(animal);
                animalsMap.put(breed, animals);
                System.out.println(animal);
                break;
            case SHARK:
                animal = new Shark(breed, name, cost, character, getBirthDate());
                animals.add(animal);
                animalsMap.put(breed, animals);
                System.out.println(animal);
                break;
            case WOLF:
                animal = new Wolf(breed, name, cost, character, getBirthDate());
                animals.add(animal);
                animalsMap.put(breed, animals);
                System.out.println(animal);
                break;
            default:
                throw new AnimalException();
        }
        return animalsMap;
    }

}
