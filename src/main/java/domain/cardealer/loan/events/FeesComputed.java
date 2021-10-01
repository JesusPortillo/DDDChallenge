package domain.cardealer.loan.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.cardealer.loan.values.AmountToPayPerMonth;
import domain.cardealer.loan.values.LoanId;
import domain.cardealer.loan.values.TimeToPay;
import domain.cardealer.sale.values.Total;

public class FeesComputed extends DomainEvent {

    private final AmountToPayPerMonth amountToPayPerMonth;

    public FeesComputed(AmountToPayPerMonth amountToPayPerMonth) {
        super("domain.cardealer.loan.feescomputed");
        this.amountToPayPerMonth = amountToPayPerMonth;
    }

    public AmountToPayPerMonth getAmountToPayPerMonth() {
        return amountToPayPerMonth;
    }
}
