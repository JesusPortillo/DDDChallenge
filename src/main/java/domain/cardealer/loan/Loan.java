package domain.cardealer.loan;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import domain.cardealer.loan.entities.CoSign;
import domain.cardealer.loan.entities.Debtor;
import domain.cardealer.loan.entities.Loaner;
import domain.cardealer.loan.events.LoanCreated;
import domain.cardealer.loan.values.*;
import domain.cardealer.sale.Sale;
import domain.cardealer.sale.SaleChange;
import domain.cardealer.sale.values.SaleId;
import domain.cardealer.loan.values.SaleVerified;

import java.util.List;

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

    public Loan(LoanId entityId, LoanDate loanDate) {
        super(entityId);
        appendChange(new LoanCreated(loanDate)).apply();
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

}
