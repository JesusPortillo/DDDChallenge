package domain.cardealer.loan.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.cardealer.generics.Age;
import domain.cardealer.generics.Email;
import domain.cardealer.generics.Name;
import domain.cardealer.loan.values.CoSignId;

public class CoSignAdded extends DomainEvent {

    private final CoSignId coSignId;
    private final Name name;
    private final Email email;
    private final Age age;

    public CoSignAdded(CoSignId coSignId, Name name, Email email, Age age) {
        super("domain.cardealer.loan.cosignadded");
        this.coSignId = coSignId;
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public CoSignId getCoSignId() {
        return coSignId;
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
