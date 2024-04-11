import animal.*;
import enumerated.AnimalEnum;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Application {

    public static void main(String[] args) {
        CreateAnimalServiceImpl service = new CreateAnimalServiceImpl();
        Map<String,List<Animal>> animals = service.create(AnimalEnum.CAT, 2);
        SearchServiceImpl searchService = new SearchServiceImpl();
        AnimalRepository animalRepository = new AnimalRepositoryImpl();

        List<Animal> animalList = new ArrayList<>();
        for (Map.Entry <String,List<Animal>> animal: animals.entrySet()) {
            animalList.addAll(animal.getValue());
            for (Animal a: animalList){
                searchService.checkLeapYearAnimal(a);
            }
        }

        //System.out.println(animalRepository.findLeapYearNames(animalList));

       System.out.println(animalRepository.findOlderAnimal(animalList, 2));

        //System.out.println(searchService.getClass()); //class animal.SearchServiceImpl
//System.out.println(searchService.getClass().getSimpleName());

/*        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);*/
    }

}