package domain.cardealer.sale.entities;

import co.com.sofka.domain.generic.Entity;
import domain.cardealer.generics.Email;
import domain.cardealer.generics.Name;
import domain.cardealer.sale.values.CustomerId;

public class Customer extends Entity<CustomerId> {

    protected Name name;
    protected Email email;

    public Customer(CustomerId entityId, Name name, Email email) {
        super(entityId);
        this.name = name;
        this.email = email;
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

    public void updateCustomer(Name name, Email email){
        setName(name);
        setEmail(email);
    }
}
