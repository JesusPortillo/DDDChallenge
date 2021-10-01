package domain.cardealer.loan.commands;

import co.com.sofka.domain.generic.Command;
import domain.cardealer.generics.Age;
import domain.cardealer.generics.Email;
import domain.cardealer.generics.Name;
import domain.cardealer.loan.values.LoanId;
import domain.cardealer.loan.values.LoanerId;

public class AddLoaner extends Command {

    private  final LoanId loanId;
    private final LoanerId loanerId;
    private final Name name;
    private final Email email;
    private final Age age;

    public AddLoaner(LoanId loanId, LoanerId loanerId, Name name, Email email, Age age) {
        this.loanId = loanId;
        this.loanerId = loanerId;
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public LoanId getLoanId() {
        return loanId;
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
