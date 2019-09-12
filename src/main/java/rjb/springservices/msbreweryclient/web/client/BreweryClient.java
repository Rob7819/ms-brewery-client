package rjb.springservices.msbreweryclient.web.client;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import rjb.springservices.msbreweryclient.web.model.BeerDto;
import rjb.springservices.msbreweryclient.web.model.ClientDto;

import java.net.URI;
import java.util.UUID;

@ConfigurationProperties(prefix = "rjb.brewery", ignoreUnknownFields = false)
@Component
public class BreweryClient {

    public final String BEER_PATH_V1 = "/api/v1/beer/";
    public final String CUSTOMER_PATH_V1 = "/api/v1/customer/";

    public void setApihost(String apihost) {
        this.apihost = apihost;
    }

    private String apihost;

    private final RestTemplate restTemplate;

    public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public BeerDto getBeerById(UUID id){

        return restTemplate.getForObject(apihost + BEER_PATH_V1 + id.toString(), BeerDto.class);
    }

    public URI saveNewBeer(BeerDto beerDto){
        return restTemplate.postForLocation(apihost + BEER_PATH_V1, beerDto);
    }

    public void updateBeer(UUID id, BeerDto beerDto){
        restTemplate.put(apihost + BEER_PATH_V1 + id.toString(), beerDto);
    }

    public void deleteBeer(UUID id){
        restTemplate.delete(apihost + BEER_PATH_V1 + id.toString());
    }

    public ClientDto getClientById(UUID id){
        return restTemplate.getForObject(apihost + CUSTOMER_PATH_V1 + id.toString(), ClientDto.class);
    }

    public URI saveNewClient(ClientDto clientDto){
        return restTemplate.postForLocation(apihost + CUSTOMER_PATH_V1, clientDto);
    }

    public void updateClient(UUID id, ClientDto clientDto){
        restTemplate.put(apihost + CUSTOMER_PATH_V1 + id.toString(), clientDto);
    }

    public void deleteClient(UUID id){
        restTemplate.delete(apihost + CUSTOMER_PATH_V1 + id.toString());
    }
}
