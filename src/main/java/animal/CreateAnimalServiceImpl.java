package animal;

import exception.AnimalException;

import java.util.Random;

public class CreateAnimalServiceImpl implements CreateAnimalService {

    @Override
    public void create(String type, int amount) {
        for (int i = 0; i < amount; i++) {
            createAnimal(type);
        }
    }

    @Override
    public void create(String type) {
        int amount = 10;
        do {
            createAnimal(type);
            amount--;
        }
        while (amount > 0);
    }


    public void createAnimal(String type) {
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
    }

}
