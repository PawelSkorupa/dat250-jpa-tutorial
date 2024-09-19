package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "owningBank")
    private Set<CreditCard> ownedCards;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<CreditCard> getOwnedCards() {
        return ownedCards;
    }

    public void setOwnedCards(Set<CreditCard> creditCards) {
        this.ownedCards = creditCards;
    }
}
