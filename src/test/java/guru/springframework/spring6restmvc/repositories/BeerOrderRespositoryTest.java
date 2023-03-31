package guru.springframework.spring6restmvc.repositories;

import guru.springframework.spring6restmvc.entities.Beer;
import guru.springframework.spring6restmvc.entities.BeerOrder;
import guru.springframework.spring6restmvc.entities.BeerOrderShipment;
import guru.springframework.spring6restmvc.entities.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class BeerOrderRespositoryTest {

    @Autowired
    BeerOrderRepository beerOrderRespository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    BeerRepository beerRepository;

    Customer testCustomer;
    Beer testBeer;


    @Transactional
    @Test
    void testBeerOrders() {
        System.out.println(beerOrderRespository.count());
        System.out.println(customerRepository.count());
        System.out.println(beerRepository.count());
        System.out.println(testCustomer.getName());
        System.out.println(testBeer.getBeerName());

        BeerOrder beerOrder = BeerOrder.builder()
                .customerRef("test order")
                .customer(testCustomer)
                .beerOrderShipment(BeerOrderShipment.builder()
                        .trackingNumber("12345r")
                        .build())
                .build();

        BeerOrder savedBeerOrder = beerOrderRespository.save(beerOrder);

        System.out.println(savedBeerOrder.getCustomerRef());
    }

    @BeforeEach
    void setUp() {
        testCustomer = customerRepository.findAll().get(0);
        testBeer = beerRepository.findAll().get(0);
    }
}