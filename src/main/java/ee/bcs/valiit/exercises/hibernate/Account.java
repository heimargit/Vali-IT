package ee.bcs.valiit.exercises.hibernate;


import javax.persistence.*;

@Table(name = "account")

@Entity
public class Account {
    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY) - lisatakse juhul, kui tabelis on id column
   // @Column(name = "account_number")
    private String accountNumber; //nimetused siin peavad võrduma tabelis olevate columnide nimedega. Javas camelcase = SQLis SQLi süntaks (nt _ kasutamine)
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
