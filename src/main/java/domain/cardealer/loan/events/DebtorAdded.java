package domain.cardealer.loan.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.cardealer.generics.Age;
import domain.cardealer.generics.Email;
import domain.cardealer.generics.Name;
import domain.cardealer.loan.values.CoSignId;
import domain.cardealer.loan.values.DebtorId;

public class DebtorAdded extends DomainEvent {

    private final DebtorId debtorId;
    private final Name name;
    private final Email email;
    private final Age age;

    public DebtorAdded(DebtorId debtorId, Name name, Email email, Age age) {
        super("domain.cardealer.loan.debtoradded");
        this.debtorId = debtorId;
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public DebtorId getDebtorId() {
        return debtorId;
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
