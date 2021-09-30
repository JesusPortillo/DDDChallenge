package domain.cardealer.sale.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.cardealer.generics.Age;
import domain.cardealer.generics.Email;
import domain.cardealer.generics.Name;
import domain.cardealer.sale.values.SaleId;
import domain.cardealer.sale.values.SalesmanId;

public class SalesmanUpdated extends DomainEvent {

    private final SaleId saleId;
    private final SalesmanId salesmanId;
    private final Name name;
    private final Email email;
    private final Age age;


    public SalesmanUpdated(SaleId saleId, SalesmanId salesmanId, Name name, Email email, Age age) {
        super("domain.cardealer.sale.salesmanupdated");
        this.saleId = saleId;
        this.salesmanId = salesmanId;
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public SaleId getSaleId() {
        return saleId;
    }

    public SalesmanId getSalesmanId() {
        return salesmanId;
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
