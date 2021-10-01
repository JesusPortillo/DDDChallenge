package domain.cardealer.loan;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import domain.cardealer.generics.Age;
import domain.cardealer.generics.Email;
import domain.cardealer.generics.Name;
import domain.cardealer.loan.entities.CoSign;
import domain.cardealer.loan.entities.Debtor;
import domain.cardealer.loan.entities.Loaner;
import domain.cardealer.loan.events.LoanCreated;
import domain.cardealer.loan.events.LoanerAdded;
import domain.cardealer.loan.values.*;
import domain.cardealer.sale.Sale;
import domain.cardealer.sale.SaleChange;
import domain.cardealer.sale.events.CustomerAdded;
import domain.cardealer.sale.events.CustomerUpdated;
import domain.cardealer.sale.values.CustomerId;
import domain.cardealer.sale.values.SaleId;
import domain.cardealer.loan.values.SaleVerified;

import java.util.List;
import java.util.Objects;

public class Loan extends AggregateEvent<LoanId> {

    protected SaleId saleId;
    protected LoanDate loanDate;
    protected TimeToPay timeToPay;
    protected LoanIsPaid loanIsPaid;
    protected IsAprobed isAprobed;
    protected SaleVerified saleVerified;
    protected Loaner loaner;
    protected CoSign coSign;
    protected Debtor debtor;

    public Loan(LoanId entityId, LoanDate loanDate, TimeToPay timeToPay, LoanIsPaid loanIsPaid,
                IsAprobed isAprobed, SaleVerified saleVerified) {
        super(entityId);
        appendChange(new LoanCreated(loanDate, timeToPay, loanIsPaid, isAprobed, saleVerified)).apply();
    }

    private Loan(LoanId entityId){
        super(entityId);
        subscribe(new LoanChange(this));
    }

    public static Loan from(LoanId loanId, List<DomainEvent> events){
        Loan loan = new Loan(loanId);
        events.forEach(loan::applyEvent);
        return loan;
    }

    public void addLoaner(LoanerId loanerId, Name name, Email email, Age age){
        Objects.requireNonNull(loanerId);
        Objects.requireNonNull(name);
        Objects.requireNonNull(email);
        Objects.requireNonNull(age);
        appendChange(new LoanerAdded(loanerId, name, email, age)).apply();
    }

    public void updateCustomer(SaleId saleId, CustomerId customerId, Name name, Email email, Age age){
        Objects.requireNonNull(saleId);
        Objects.requireNonNull(customerId);
        Objects.requireNonNull(name);
        Objects.requireNonNull(email);
        Objects.requireNonNull(age);
        appendChange(new CustomerUpdated(saleId, customerId, name, email, age)).apply();
    }

}
