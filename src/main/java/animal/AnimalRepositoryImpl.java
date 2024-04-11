package animal;

import exception.EmptyObjectException;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class AnimalRepositoryImpl implements AnimalRepository {

    @Override
    public Map<String, LocalDate> findLeapYearNames(List<Animal> animals) {
        if (animals == null || animals.isEmpty()) throw new EmptyObjectException();
        Map<String, LocalDate> animalsLeapYear = new HashMap<>();
        for (Animal animal : animals) {
            LocalDate birthDate = animal.getBirthDate();
            if (birthDate.isLeapYear()) {
                String type = animal.getName() + ", " + animal.getBreed();
                animalsLeapYear.put(type, birthDate);
            }
        }
        if (animalsLeapYear == null || animalsLeapYear.isEmpty())
            System.out.print("Нет животных, родившихся в високосный год.");
        return animalsLeapYear;
    }

    @Override
    public Map<Animal, Integer> findOlderAnimal(List<Animal> animals, int n) {
        if (animals == null || animals.isEmpty()) throw new EmptyObjectException();
        Map<Animal, Integer> animalMap = new HashMap<>();
        for (Animal animal : animals) {
            int age = Period.between(animal.getBirthDate(), LocalDate.now()).getYears();
            if (age > n) animalMap.put(animal, age);
        }
        if (animalMap.isEmpty()) {
            Collections.sort(animals, new SortByDates());
            animalMap.put(animals.get(0), animals.get(0).getBirthDate().getYear());
        }
        return animalMap;
    }

    @Override
    public Map<String, Integer> findDuplicate(List<Animal> animals) {
        if (animals == null || animals.isEmpty()) throw new EmptyObjectException();
        Map<String, Integer> result = new HashMap<>();
        HashSet<Animal> animalHashSet = new HashSet<>();
        int count = 0;
        if (animals.isEmpty()) throw new EmptyObjectException();
        for (Animal animal : animals) {
            int defaultValue = 1;
            int cnt = result.getOrDefault(animal.getBreed(), defaultValue);
            if (!animalHashSet.add(animal)) {
                result.put(animal.getBreed(), cnt + 1);
            }
        }
        return result;
    }

}
