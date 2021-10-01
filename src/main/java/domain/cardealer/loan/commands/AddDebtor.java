package domain.cardealer.loan.commands;

import co.com.sofka.domain.generic.Command;
import domain.cardealer.generics.Age;
import domain.cardealer.generics.Email;
import domain.cardealer.generics.Name;
import domain.cardealer.loan.Loan;
import domain.cardealer.loan.values.DebtorId;
import domain.cardealer.loan.values.LoanId;

public class AddDebtor extends Command {

    private final LoanId loanId;
    private final DebtorId debtorId;
    private final Name name;
    private final Email email;
    private final Age age;

    public AddDebtor(LoanId loanId, DebtorId debtorId, Name name, Email email, Age age) {
        this.loanId = loanId;
        this.debtorId = debtorId;
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public LoanId getLoanId() {return loanId;}

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
