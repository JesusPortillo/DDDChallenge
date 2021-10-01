package domain.cardealer.loan.entities;

import co.com.sofka.domain.generic.Entity;
import domain.cardealer.generics.Age;
import domain.cardealer.generics.Email;
import domain.cardealer.generics.Name;
import domain.cardealer.loan.values.LoanerId;

public class Loaner extends Entity<LoanerId> {

    protected Name name;
    protected Email email;
    protected Age age;

    public Loaner(LoanerId entityId, Name name, Email email, Age age) {
        super(entityId);
        this.name = name;
        this.email = email;
        this.age = age;

    }

    public Name name() {
        return name;
    }

    public void updateName(Name name) {
        this.name = name;
    }

    public Email email() {
        return email;
    }

    public void updateEmail(Email email) {
        this.email = email;
    }

    public Age age() {
        return age;
    }

    public void updateAge(Age age) {
        this.age = age;
    }

    public void updateLoaner(Name name, Email email, Age age){
        updateName(name);
        updateEmail(email);
        updateAge(age);
    }
}
