package ee.bcs.valiit.exercises.hibernate;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "account")

@Entity
public class Account {
    @Id
    private String accountNr;
    private Double balance;
    private String ownerName;
    private Boolean lock;

    public String getAccountNr(){
        return accountNr;
    }
}
