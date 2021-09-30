package domain.cardealer.sale.entities;

import co.com.sofka.domain.generic.Entity;
import domain.cardealer.generics.Age;
import domain.cardealer.generics.Email;
import domain.cardealer.generics.Name;
import domain.cardealer.sale.values.CustomerId;

public class Customer extends Entity<CustomerId> {

    protected Name name;
    protected Email email;
    protected Age age;

    public Customer(CustomerId entityId, Name name, Email email, Age age) {
        super(entityId);
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public Name Name() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Email Email() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public Age getAge() {
        return age;
    }

    public void updateCustomer(Name name, Email email){
        setName(name);
        setEmail(email);
    }
}
