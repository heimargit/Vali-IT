package ee.bcs.valiit.exercises.hibernate;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "account")

@Entity
public class Account {
    @Id
   // @Column(name = "account_number")
    private String accountNumber;
    private Double balance;
    private String ownerName;
    private Boolean lock;




    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNr(String accountNr) {
        this.accountNumber = accountNr;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public Boolean getLock() {
        return lock;
    }

    public void setLock(Boolean lock) {
        this.lock = lock;
    }
}
