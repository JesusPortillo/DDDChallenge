package domain.cardealer.sale.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.cardealer.generics.Age;
import domain.cardealer.generics.Email;
import domain.cardealer.generics.Name;
import domain.cardealer.sale.values.CustomerId;

public class CustomerAdded extends DomainEvent {

    private final CustomerId customerId;
    private  final Name name;
    private  final Email email;
    private  final Age age;

    public CustomerAdded(CustomerId customerId, Name name, Email email, Age age) {
        super("domain.cardealer.sale.customeradded");
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.age = age;

    }

    public CustomerId getCustomerId() {
        return customerId;
    }

    public Name getName() {
        return name;
    }

    public Email getEmail() {
        return email;
    }

    public Age getAge() {
        return age;
    }
}
