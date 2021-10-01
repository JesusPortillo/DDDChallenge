package domain.cardealer.loan.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.cardealer.generics.Age;
import domain.cardealer.generics.Email;
import domain.cardealer.generics.Name;
import domain.cardealer.loan.values.LoanerId;

public class LoanerAdded extends DomainEvent {

    private final LoanerId loanerId;
    private final Name name;
    private final Email email;
    private final Age age;

    public LoanerAdded(LoanerId loanerId, Name name, Email email, Age age) {
        super("domain.cardealer.loan.loancreated");
        this.loanerId = loanerId;
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public LoanerId getLoanerId() {
        return loanerId;
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
