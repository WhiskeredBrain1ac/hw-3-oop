package animal;

import exception.EmptyObjectException;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AnimalRepositoryImpl implements AnimalRepository {

    @Override
    public Map<String, LocalDate> findLeapYearNames(List<Animal> animals) {
        if (animals == null || animals.isEmpty()) throw new EmptyObjectException();
        Map<String, LocalDate> animalsLeapYear = animals.stream()
                .filter(animal -> animal.getBirthDate().isLeapYear())
                .collect(Collectors.toMap(Animal::getBreed, Animal::getBirthDate));
        System.out.println(animalsLeapYear);
        if (animalsLeapYear == null || animalsLeapYear.isEmpty())
            System.out.print("Нет животных, родившихся в високосный год.");
        return animalsLeapYear;
    }

    @Override
    public Map<Animal, Integer> findOlderAnimal(List<Animal> animals, int n) {
        if (animals == null || animals.isEmpty()) throw new EmptyObjectException();
        Map<Animal, Integer> animalMap = animals
                .stream()
                .filter(animal -> animal.getAge() > n)
                .collect(Collectors.toMap(animal -> animal, Animal::getAge));
        if (animalMap.isEmpty())
            animals
                    .stream()
                    .max(Comparator.comparing(animal -> animal.getAge()))
                    .map(s -> animalMap.put(s, s.getAge()));
        return animalMap;
    }

    @Override
    public Map<String, Integer> findDuplicate(List<Animal> animals) {
        if (animals == null || animals.isEmpty()) throw new EmptyObjectException();
        Map<String, Integer> result = animals
                .stream()
                .collect(Collectors.groupingBy(Function.identity()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue().size() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toMap(animal -> animal.getBreed(), value -> 1, Integer::sum));
        return result;
    }

    @Override
    public void findAverageAge(List<Animal> animals) {
        System.out.println(animals.stream().mapToInt(Animal::getAge).average().getAsDouble());
    }

    @Override
    public List<Animal> findOldAndExpensive(List<Animal> animals) {
        Double averageCost = animals.stream().mapToDouble(Animal::getCost).average().getAsDouble();
        List<Animal> filteredList = animals
                .stream()
                .filter(animal -> animal.getAge() > 5)
                .filter(animal -> animal.getCost() > averageCost)
                .collect(Collectors.toList());
        return filteredList;
    }

    @Override
    public List<String> findMinConstAnimals(List<Animal> animals) {
        return animals
                .stream()
                .sorted(Comparator.comparingDouble(Animal::getCost))
                .limit(3)
                .map((n) -> n.getName())
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());
    }

}