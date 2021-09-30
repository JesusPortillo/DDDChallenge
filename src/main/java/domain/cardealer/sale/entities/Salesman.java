package domain.cardealer.sale.entities;

import co.com.sofka.domain.generic.Entity;
import domain.cardealer.generics.Age;
import domain.cardealer.generics.Email;
import domain.cardealer.sale.values.SalesmanId;
import domain.cardealer.generics.Name;

public class Salesman extends Entity<SalesmanId> {

    protected Name name;
    protected Email email;
    protected Age age;

    public Salesman(SalesmanId entityId, Name name, Email email, Age age) {
        super(entityId);
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public Age getAge() {
        return age;
    }

    public void setAge(Age age) {
        this.age = age;
    }

    public void updateSalesman(Name name, Email email, Age age){
        setName(name);
        setEmail(email);
        setAge(age);
    }
}
