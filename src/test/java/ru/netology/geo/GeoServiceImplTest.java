package ru.netology.geo;

import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

import static org.junit.jupiter.api.Assertions.*;

class GeoServiceImplTest {

    @Test
    void byIp() {
        Location expected = new Location("Moscow", Country.RUSSIA, "Lenina", 15);
        GeoServiceImpl geoService = new GeoServiceImpl();

        Location actual = geoService.byIp("172.0.32.11");
//что бы не переопределять метод сравнения и вообще не лезть в класс, сравним значения, которые нас в первую очередь интересуют
        //правда про заглушки тут немного не понял
        assertEquals(expected.getCountry(), actual.getCountry());
    }
}