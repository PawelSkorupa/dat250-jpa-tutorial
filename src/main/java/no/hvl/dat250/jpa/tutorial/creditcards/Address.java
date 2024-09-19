package no.hvl.dat250.jpa.tutorial.creditcards;

import java.util.Collection;
import java.util.Set;

import jakarta.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;

    private Integer number;

    @ManyToMany
    @JoinTable(
            name = "address_owner",
            joinColumns = @JoinColumn(name = "address_id"),
            inverseJoinColumns = @JoinColumn(name = "owner_id"))
    private Set<Customer> owners;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Set<Customer> getOwners() {
        return owners;
    }

    public void setOwners(Set<Customer> customers) {
        this.owners = customers;
    }
}
