package rjb.springservices.msbreweryclient.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import rjb.springservices.msbreweryclient.web.client.BreweryClient;
import rjb.springservices.msbreweryclient.web.model.BeerDto;
import rjb.springservices.msbreweryclient.web.model.ClientDto;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient client;

    @Test
    void getBeerById() {
        BeerDto beerDto = client.getBeerById(UUID.randomUUID());

        assertNotNull(beerDto);
    }

    @Test
    void saveNewBeer() {
        BeerDto beerDto = BeerDto.builder().id(UUID.randomUUID()).beerName("Black Goat").beerStyle("Lager").build();

        URI uri = client.saveNewBeer(beerDto);

        assertNotNull(uri);

        System.out.println(uri.toString());
    }

    @Test
    void updateBeer() {
        BeerDto beerDto = BeerDto.builder().id(UUID.randomUUID()).beerName("Black Goat").beerStyle("Lager").build();

        client.updateBeer(UUID.randomUUID(), beerDto);
    }

    @Test
    void deleteBeer() {
        client.deleteBeer(UUID.randomUUID());
    }

    @Test
    void getClientById() {
        ClientDto clientDto = client.getClientById(UUID.randomUUID());

        assertNotNull(clientDto);
    }

    @Test
    void saveNewClient() {
        ClientDto clientDto = ClientDto.builder().id(UUID.randomUUID()).name("Lerxst").build();

        URI uri = client.saveNewClient(clientDto);

        assertNotNull(uri);

        System.out.println(uri.toString());
    }

    @Test
    void updateClient() {
        ClientDto clientDto = ClientDto.builder().id(UUID.randomUUID()).name("Lerxst").build();

        client.updateClient(UUID.randomUUID(), clientDto);
    }

    @Test
    void deleteClient() {
        client.deleteClient(UUID.randomUUID());
    }
}