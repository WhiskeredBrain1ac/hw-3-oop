package animal;

import java.util.Comparator;

public class SortByDates implements Comparator<Animal> {

    @Override
    public int compare(Animal o1, Animal o2) {
        return o1.getBirthDate().getYear() - o2.getBirthDate().getYear();
    }

}
