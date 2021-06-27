package ru.netology.i18n;

import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;

import static org.junit.jupiter.api.Assertions.*;

class LocalizationServiceImplTest {

    @Test
    void locale() {
        String expected = "Добро пожаловать";

        LocalizationServiceImpl localizationService = new LocalizationServiceImpl();
        String actual = localizationService.locale(Country.RUSSIA);

        assertEquals(expected, actual);
    }

    @Test
    void localeNotRUSSIA() {
        String expected = "Welcome";

        LocalizationServiceImpl localizationService = new LocalizationServiceImpl();
        String actual = localizationService.locale(Country.GERMANY);

        assertEquals(expected, actual);
    }
}