package domain.cardealer.loan;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import domain.cardealer.generics.Age;
import domain.cardealer.generics.Email;
import domain.cardealer.generics.Name;
import domain.cardealer.loan.entities.CoSign;
import domain.cardealer.loan.entities.Debtor;
import domain.cardealer.loan.entities.Loaner;
import domain.cardealer.loan.events.*;
import domain.cardealer.loan.values.*;
import domain.cardealer.sale.Sale;
import domain.cardealer.sale.SaleChange;
import domain.cardealer.sale.events.CustomerAdded;
import domain.cardealer.sale.events.CustomerUpdated;
import domain.cardealer.sale.values.CarPrice;
import domain.cardealer.sale.values.CustomerId;
import domain.cardealer.sale.values.SaleId;
import domain.cardealer.loan.values.SaleVerified;
import domain.cardealer.sale.values.Total;

import java.util.List;
import java.util.Objects;

public class Loan extends AggregateEvent<LoanId> {

    protected SaleId saleId;
    protected LoanDate loanDate;
    protected TimeToPay timeToPay;
    protected LoanIsPaid loanIsPaid;
    protected IsAprobed isAprobed;
    protected SaleVerified saleVerified;
    protected AmountToPayPerMonth amountToPayPerMonth;
    protected Loaner loaner;
    protected CoSign coSign;
    protected Debtor debtor;

    public Loan(LoanId entityId, LoanDate loanDate, TimeToPay timeToPay, LoanIsPaid loanIsPaid,
                IsAprobed isAprobed, SaleVerified saleVerified, AmountToPayPerMonth amountToPayPerMonth) {
        super(entityId);
        appendChange(new LoanCreated(loanDate, timeToPay, loanIsPaid, isAprobed, saleVerified, amountToPayPerMonth)).apply();
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

    public void updateLoaner(LoanId loanId, LoanerId loanerId, Name name, Email email, Age age){
        Objects.requireNonNull(loanId);
        Objects.requireNonNull(loanerId);
        Objects.requireNonNull(name);
        Objects.requireNonNull(email);
        Objects.requireNonNull(age);
        appendChange(new LoanerUpdated(loanId, loanerId, name, email, age)).apply();
    }

    public void addCoSign(CoSignId coSignId, Name name, Email email, Age age){
        Objects.requireNonNull(coSignId);
        Objects.requireNonNull(name);
        Objects.requireNonNull(email);
        Objects.requireNonNull(age);
        appendChange(new CoSignAdded(coSignId, name, email, age)).apply();
    }

    public void updateCosign(LoanId loanId, CoSignId coSignId, Name name, Email email, Age age){
        Objects.requireNonNull(loanId);
        Objects.requireNonNull(coSignId);
        Objects.requireNonNull(name);
        Objects.requireNonNull(email);
        Objects.requireNonNull(age);
        appendChange(new CoSignUpdated(loanId, coSignId, name, email, age)).apply();
    }

    public void addDebtor(DebtorId debtorId, Name name, Email email, Age age){
        Objects.requireNonNull(debtorId);
        Objects.requireNonNull(name);
        Objects.requireNonNull(email);
        Objects.requireNonNull(age);
        appendChange(new DebtorAdded(debtorId, name, email, age)).apply();
    }

    public void updateDebtor(LoanId loanId, DebtorId debtorId, Name name, Email email, Age age){
        Objects.requireNonNull(loanId);
        Objects.requireNonNull(debtorId);
        Objects.requireNonNull(name);
        Objects.requireNonNull(email);
        Objects.requireNonNull(age);
        appendChange(new DebtorUpdated(loanId, debtorId, name, email, age)).apply();
    }

    public void extendTimeToPay(LoanId loanId, TimeToPay timeToPay){
        Objects.requireNonNull(timeToPay);
        appendChange(new TimeToPayExtended(loanId, timeToPay)).apply();
    }

    public void computeFees(AmountToPayPerMonth amountToPayPerMonth){
        Objects.requireNonNull(amountToPayPerMonth);
        appendChange(new FeesComputed(amountToPayPerMonth)).apply();
    }
    public void sendMessageByExtendTime(String message){
        appendChange(new MessageSended(message)).apply();
    }
}
