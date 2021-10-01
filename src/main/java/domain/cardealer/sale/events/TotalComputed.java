package domain.cardealer.sale.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.cardealer.sale.entities.Car;
import domain.cardealer.sale.values.Total;

import java.util.List;

public class TotalComputed extends DomainEvent {

    private final Total total;

    public TotalComputed(Total total) {
        super("domain.cardealer.sale.totalcomputed");
        this.total = total;
    }

    public Total getTotal() {
        return total;
    }
}
