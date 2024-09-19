package no.hvl.dat250.jpa.tutorial.creditcards.driver;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import no.hvl.dat250.jpa.tutorial.creditcards.*;

import java.io.IOException;
import java.util.*;

public class CreditCardsMain {

  static final String PERSISTENCE_UNIT_NAME = "jpa-tutorial";

  public static void main(String[] args) {
    try (EntityManagerFactory factory = Persistence.createEntityManagerFactory(
        PERSISTENCE_UNIT_NAME); EntityManager em = factory.createEntityManager()) {
      em.getTransaction().begin();
      createObjects(em);
      em.getTransaction().commit();
    }

  }

  private static void createObjects(EntityManager em) {
    Customer customer = new Customer();
    customer.setName("Max Mustermann");

    Address address = new Address();
    address.setStreet("Inndalsveien");
    address.setNumber(28);
    Set<Customer> addressOwners = new HashSet<>();
    addressOwners.add(customer);
    address.setOwners(addressOwners);

    Set<Address> addresses = new HashSet<>();
    addresses.add(address);
    customer.setAddresses(addresses);

    Pincode pincode = new Pincode();
    pincode.setCode("123");
    pincode.setCount(1);

    CreditCard creditCard1 = new CreditCard();
    creditCard1.setNumber(12345);
    creditCard1.setBalance(-5000);
    creditCard1.setCreditLimit(-10000);
    creditCard1.setPincode(pincode);

    CreditCard creditCard2 = new CreditCard();
    creditCard2.setNumber(123);
    creditCard2.setBalance(1);
    creditCard2.setCreditLimit(2000);
    creditCard2.setPincode(pincode);

    Set<CreditCard> creditCards = new HashSet<>();
    creditCards.add(creditCard1);
    creditCards.add(creditCard2);

    Bank bank = new Bank();
    bank.setName("Pengebank");
    bank.setOwnedCards(creditCards);
    em.persist(bank);

    creditCard1.setOwningBank(bank);
    creditCard2.setOwningBank(bank);

    customer.setCreditCards(creditCards);

    em.persist(customer);
    em.persist(address);
    em.persist(pincode);
    em.persist(creditCard1);
    em.persist(creditCard2);
  }
}
