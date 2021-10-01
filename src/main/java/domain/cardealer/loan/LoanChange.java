package domain.cardealer.loan;

import co.com.sofka.domain.generic.EventChange;
import domain.cardealer.loan.entities.CoSign;
import domain.cardealer.loan.entities.Debtor;
import domain.cardealer.loan.entities.Loaner;
import domain.cardealer.loan.events.*;

public class LoanChange extends EventChange {

    public LoanChange(Loan loan){
        apply((LoanCreated event) ->{
            loan.loanDate = event.getLoanDate();
            loan.timeToPay = event.getTimeToPay();
            loan.loanIsPaid = event.getLoanIsPaid();
            loan.isAprobed = event.getIsAprobed();
            loan.saleVerified = event.getSaleVerified();
        });

        apply((LoanerAdded event)->{
            loan.loaner = new Loaner(event.getLoanerId(), event.getName(), event.getEmail(), event.getAge());
        });

        apply((LoanerUpdated event)->{
            loan.loaner = new Loaner(event.getLoanerId(), event.getName(), event.getEmail(), event.getAge());
        });

        apply((CoSignAdded event)->{
            loan.coSign = new CoSign(event.getCoSignId(), event.getName(), event.getEmail(), event.getAge());
        });

        apply((CoSignUpdated event)->{
            loan.coSign = new CoSign(event.getCoSignId(), event.getName(), event.getEmail(), event.getAge());
        });

        apply((DebtorAdded event)->{
            loan.debtor = new Debtor(event.getDebtorId(), event.getName(), event.getEmail(), event.getAge());
        });

        apply((DebtorUpdated event)->{
            loan.debtor = new Debtor(event.getDebtorId(), event.getName(), event.getEmail(), event.getAge());
        });
    }
}
