package domain.cardealer.sale.commands;

import co.com.sofka.domain.generic.Command;
import domain.cardealer.generics.Age;
import domain.cardealer.generics.Email;
import domain.cardealer.generics.Name;
import domain.cardealer.sale.values.CustomerId;
import domain.cardealer.sale.values.SaleId;

public class AddCustomer extends Command {

    private final SaleId saleId;
    private final CustomerId customerId;
    private  final Name name;
    private  final Email email;
    private  final Age age;

    public AddCustomer(SaleId saleId, CustomerId customerId, Name name, Email email, Age age) {
        this.saleId = saleId;
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.age = age;

    }

    public SaleId getSaleId() {
        return saleId;
    }

    public CustomerId getCustomerId() {
        return customerId;
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
