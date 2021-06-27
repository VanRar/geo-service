package ru.netology.sender;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationServiceImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.netology.entity.Country.*;


class MessageSenderImplTest {

    @Test
    void sendRussia() {
        //Set<Country> expected = Set.of(RUSSIA, GERMANY, USA, BRAZIL);
        String expected = "Добро пожаловать";

        LocalizationServiceImpl localizationServiceImpl = Mockito.mock(LocalizationServiceImpl.class);

        Mockito.when(localizationServiceImpl.locale(RUSSIA))
                .thenReturn("Добро пожаловать");

        GeoServiceImpl geoServiceImpl = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoServiceImpl.byIp("172.0.32.11"))
                .thenReturn(new Location("Moscow", RUSSIA, null, 0));

        MessageSender messageSender = new MessageSenderImpl(geoServiceImpl, localizationServiceImpl);

        Map<String, String> headers = new HashMap<>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.0.32.11");
        String actual = messageSender.send(headers);
        assertEquals(expected, actual);

    }

    @Test
    void sendUSA() {
        String expected = "Welcome";

        LocalizationServiceImpl localizationServiceImpl = Mockito.mock(LocalizationServiceImpl.class);

        Mockito.when(localizationServiceImpl.locale(USA))
                .thenReturn("Welcome");

        GeoServiceImpl geoServiceImpl = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoServiceImpl.byIp("96.44.183.149"))
                .thenReturn(new Location("New York", Country.USA, " 10th Avenue", 32));

        MessageSender messageSender = new MessageSenderImpl(geoServiceImpl, localizationServiceImpl);

        Map<String, String> headers = new HashMap<>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.44.183.149");
        String actual = messageSender.send(headers);
        assertEquals(expected, actual);

    }

    @Test
    void sendGERMANY() {
        String expected = "Welcome";

        LocalizationServiceImpl localizationServiceImpl = Mockito.mock(LocalizationServiceImpl.class);

        Mockito.when(localizationServiceImpl.locale(GERMANY))
                .thenReturn("Welcome");


        GeoServiceImpl geoServiceImpl = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoServiceImpl.byIp("86.44.183.149"))
                .thenReturn(new Location(" ", GERMANY, " 10th ", 2));

        MessageSender messageSender = new MessageSenderImpl(geoServiceImpl, localizationServiceImpl);

        Map<String, String> headers = new HashMap<>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "86.44.183.149");
        String actual = messageSender.send(headers);
        assertEquals(expected, actual);

    }

    @Test
    void sendBRAZIL() {
        String expected = "Welcome";

        LocalizationServiceImpl localizationServiceImpl = Mockito.mock(LocalizationServiceImpl.class);

        Mockito.when(localizationServiceImpl.locale(BRAZIL))
                .thenReturn("Welcome");

        GeoServiceImpl geoServiceImpl = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoServiceImpl.byIp("16.44.183.149"))
                .thenReturn(new Location("New", BRAZIL, "Ave", 45));

        MessageSender messageSender = new MessageSenderImpl(geoServiceImpl, localizationServiceImpl);

        Map<String, String> headers = new HashMap<>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "16.44.183.149");
        String actual = messageSender.send(headers);
        assertEquals(expected, actual);

    }
}