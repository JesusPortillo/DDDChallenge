package domain.cardealer.loan.commands;

import co.com.sofka.domain.generic.Command;
import domain.cardealer.generics.Age;
import domain.cardealer.generics.Email;
import domain.cardealer.generics.Name;
import domain.cardealer.loan.values.CoSignId;
import domain.cardealer.loan.values.LoanId;

public class AddCoSign extends Command {

    private final LoanId loanId;
    private final CoSignId coSignId;
    private final Name name;
    private final Email email;
    private final Age age;

    public AddCoSign(LoanId loanId, CoSignId coSignId, Name name, Email email, Age age) {
        this.loanId = loanId;
        this.coSignId = coSignId;
        this.name = name;
        this.email = email;
        this.age = age;
    }


    public LoanId getLoanId() {
        return loanId;
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
