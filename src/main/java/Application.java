import animal.Animal;
import animal.CreateAnimalServiceImpl;
import animal.SearchServiceImpl;
import enumerated.AnimalEnum;

import java.time.LocalDate;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        CreateAnimalServiceImpl service = new CreateAnimalServiceImpl();
        List<Animal> animals = service.create(AnimalEnum.CAT, 2);
        SearchServiceImpl searchService = new SearchServiceImpl();
        for (Animal animal : animals) {
            searchService.checkLeapYearAnimal(animal);
        }

        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
    }

}