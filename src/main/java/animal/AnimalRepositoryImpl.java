package animal;

import exception.EmptyObjectException;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class AnimalRepositoryImpl implements AnimalRepository/*, Comparable*/ {

    @Override
    public Map<String, LocalDate> findLeapYearNames(List<Animal> animals) {
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

    /* findOlderAnimal
        На вход подается массив животных. При помощи цикла for найти всех животных,
        возраст которых старше N лет, где N аргумент метода. Метод должен возвращать Map<Animal,
       Integer>, которая содержит в качестве ключа животное, а в качестве значения возраст.
        Если при заданном значении поиска (передаваемый аргумент возраста) не было
        найдено ни одного животного, то вернуть нужно самого старшего из возможных.
        Данный кейс необходимо покрыть кейсами в тестах.*/
    @Override
    public Map<Animal, Integer> findOlderAnimal(List<Animal> animals, int n) {
        if (animals == null || animals.isEmpty()) throw new EmptyObjectException();
        Map<Animal, Integer> animalMap = new HashMap<>();
        //Collections.sort(animals);
        for (Animal animal : animals) {
            int age = Period.between(animal.getBirthDate(), LocalDate.now()).getYears();
            animalMap.put(animal, age);
        }
        return animalMap;
    }

    @Override
    public Map<String, Integer> findDuplicate(List<Animal> animals) {
        return Map.of();
    }


/*    @Override
    public int compareTo(Object o) {
        Animal animal = (Animal) o;
        int result = this.getBirthDate.compareTo(animal.getBirthDate());
        return result;
    }*/

}
