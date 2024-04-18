import animal.*;
import enumerated.AnimalEnum;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Application {

    public static void main(String[] args) {
        CreateAnimalServiceImpl service = new CreateAnimalServiceImpl();
        Map<String, List<Animal>> animals = service.create(AnimalEnum.CAT, 10);
        SearchServiceImpl searchService = new SearchServiceImpl();
        AnimalRepository animalRepository = new AnimalRepositoryImpl();

        List<Animal> animalList = new ArrayList<>();
        for (Map.Entry<String, List<Animal>> animal : animals.entrySet()) {
            animalList.addAll(animal.getValue());
            for (Animal a : animalList) {
                searchService.checkLeapYearAnimal(a);
            }
        }
        List<Animal> animalsLeapYear = new ArrayList<>(List.of(
                new Cat("Тульский красавец", "Семён", 700.0, "Любопытный", LocalDate.of(2008, 11, 11)),
                new Cat("Рязанский вороной", "Антонина", 7700.0, "Добрый", LocalDate.of(2013, 3, 8)),
                new Dog("Дворовый пёс", "Лев", 900.0, "Ласковый", LocalDate.of(2021, 3, 8)),
                new Cat("Тульский красавец", "Семён", 700.0, "Любопытный", LocalDate.of(2008, 11, 11))
        ));
        System.out.println(animalRepository.findLeapYearNames(animalList));
        System.out.println(animalRepository.findOlderAnimal(animalList, 10));
        System.out.println(animalRepository.findDuplicate(animalsLeapYear));

        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
    }

}