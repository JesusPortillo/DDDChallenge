package domain.cardealer.sale.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.cardealer.generics.Age;
import domain.cardealer.generics.Email;
import domain.cardealer.generics.Name;
import domain.cardealer.sale.values.SalesmanId;

public class SalesmanAdded extends DomainEvent {

    private final SalesmanId salesmanId;
    private final Name name;
    private final Email email;
    private final Age age;

    public SalesmanAdded(SalesmanId salesmanId, Name name, Email email, Age age) {
        super("domain.cardealer.sale.salesmanadded");
        this.salesmanId = salesmanId;
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public SalesmanId getSalesmanId() {
        return salesmanId;
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
