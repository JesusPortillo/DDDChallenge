package domain.cardealer.sale.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.cardealer.sale.values.SaleDate;

public class SaleCreated extends DomainEvent {

    private final SaleDate saleDate;

    public SaleCreated(SaleDate saleDate) {
        super("domain.cardealer.sale.SaleCreated");
        this.saleDate = saleDate;
    }

    public SaleDate getSaleDate() {
        return saleDate;
    }
}
