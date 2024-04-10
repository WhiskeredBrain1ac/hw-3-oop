package animal;

import exception.InvalidAnimalBirthDateException;
import exception.InvalidAnimalException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class SearchServiceImplTest {

    SearchServiceImpl searchService = new SearchServiceImpl();

    @org.junit.jupiter.api.Test
    @DisplayName("Проверяем високосный год")
    void checkLeapYearAnimal() {
        Animal cat = new Cat("Тульский красавец", "Семён", 700.0, "Любопытный", LocalDate.of(2012, 11, 11));
        boolean leapYear = searchService.checkLeapYearAnimal(cat);
        assertTrue(leapYear);
    }

    @Test
    @DisplayName("Проверяем невискосный год")
    void checkNonLeapYearAnimal() {
        Animal cat = new Cat("Тульский красавец", "Семён", 700.0, "Любопытный", LocalDate.of(2013, 11, 11));
        boolean leapYear = searchService.checkLeapYearAnimal(cat);
        assertFalse(leapYear);
    }

    @Test
    @DisplayName("Объект животного пустой")
    void checkAnimalObjectForEmptiness() {
        InvalidAnimalException e = assertThrows(InvalidAnimalException.class, () -> searchService.checkLeapYearAnimal(null));
        assertEquals("На вход пришёл некорректный объект животного. Текущее время: " + LocalDate.now() + ".", e.getMessage());
    }

    @Test
    @DisplayName("Объект животного не пустой")
    void checkAnimalObjectForNonEmptiness() {
        Animal cat = new Cat("Тульский красавец", "Семён", 700.0, "Любопытный", LocalDate.of(2013, 11, 11));
        assertDoesNotThrow(() -> searchService.checkLeapYearAnimal(cat));
    }

    @Test
    @DisplayName("Дата дня рождения НЕ заполнена")
    void checkBirthDateForEmptiness() {
        Animal cat = new Cat("Тульский красавец", "Семён", 700.0, "Любопытный", null);
        InvalidAnimalBirthDateException e = assertThrows(InvalidAnimalBirthDateException.class, () -> searchService.checkLeapYearAnimal(cat));
        assertEquals("У животного " + cat.getBreed() + " не указана дата его рождения.", e.getMessage());
    }

    @Test
    @DisplayName("Дата дня рождения заполнена")
    void checkBirthDateForNonEmptiness() {
        Animal cat = new Cat("Тульский красавец", "Семён", 700.0, "Любопытный", LocalDate.of(2013, 11, 11));
        assertDoesNotThrow(() -> searchService.checkLeapYearAnimal(cat));
    }

}