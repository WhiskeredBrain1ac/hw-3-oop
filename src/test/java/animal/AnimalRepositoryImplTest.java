package animal;

import exception.EmptyObjectException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AnimalRepositoryImplTest {

    AnimalRepositoryImpl animalRepository = new AnimalRepositoryImpl();

    List<Animal> animals = new ArrayList<>(List.of(
            new Cat("Тульский красавец", "Семён", 700.0, "Любопытный", LocalDate.of(2015, 11, 11)),
            new Cat("Рязанский вороной", "Антонина", 7700.0, "Добрый", LocalDate.of(2013, 3, 8)),
            new Dog("Дворовый пёс", "Лев", 900.0, "Ласковый", LocalDate.of(2021, 3, 8)),
            new Cat("Тульский красавец", "Семён", 700.0, "Любопытный", LocalDate.of(2015, 11, 11))
    ));

    List<Animal> animalsLeapYear = new ArrayList<>(List.of(
            new Cat("Тульский красавец", "Семён", 700.0, "Любопытный", LocalDate.of(2008, 11, 11)),
            new Cat("Рязанский вороной", "Антонина", 7700.0, "Добрый", LocalDate.of(2013, 3, 8)),
            new Dog("Дворовый пёс", "Лев", 900.0, "Ласковый", LocalDate.of(2021, 3, 8)),
            new Cat("Тульский красавец", "Семён", 700.0, "Любопытный", LocalDate.of(2016, 11, 11))
    ));

    @Test
    @DisplayName("Високосный год. Нет животных, родившихся в високосный год.")
    void findLeapYearNames() {
        assertDoesNotThrow(() -> animalRepository.findLeapYearNames(animals));
    }

    @Test
    @DisplayName("Високосный год. Не пустой объект. C високосными.")
    void findNonLeapYearNames() {
        assertDoesNotThrow(() -> animalRepository.findLeapYearNames(animalsLeapYear));
    }

    @Test
    @DisplayName("Високосный год. На входе пустой список.")
    void findLeapYearNamesByEmptiness() {
        ArrayList<Animal> animalsList = new ArrayList<Animal>();
        EmptyObjectException runtimeException = assertThrows(EmptyObjectException.class, () -> animalRepository.findLeapYearNames(null));
        assertEquals("На вход пришёл пустой объект/список.", runtimeException.getMessage());
    }

    @Test
    void findOlderAnimal() {
        assertDoesNotThrow(() -> animalRepository.findOlderAnimal(animals, 15));
    }

    @Test
    void findOlderAnimalByEmptiness() {
        EmptyObjectException runtimeException = assertThrows(EmptyObjectException.class, () -> animalRepository.findOlderAnimal(null, 15));
        assertEquals("На вход пришёл пустой объект/список.", runtimeException.getMessage());
    }

    @Test
    void findDuplicate() {
        assertDoesNotThrow(() -> animalRepository.findDuplicate(animals));
    }

    @Test
    void findDuplicateByEmptiness() {
        EmptyObjectException runtimeException = assertThrows(EmptyObjectException.class, () -> animalRepository.findDuplicate(null));
        assertEquals("На вход пришёл пустой объект/список.", runtimeException.getMessage());
    }

}