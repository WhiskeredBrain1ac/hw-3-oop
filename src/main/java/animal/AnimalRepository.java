package animal;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface AnimalRepository {

    Map<String, LocalDate> findLeapYearNames(List<Animal> animals);

    Map<Animal, Integer> findOlderAnimal(List<Animal> animals, int n);

    Map<String, Integer> findDuplicate(List<Animal> animals);

    void findAverageAge(List<Animal> animals);

    List<Animal> findOldAndExpensive(List<Animal> animals);

    List<String> findMinConstAnimals(List<Animal> animals);

}
