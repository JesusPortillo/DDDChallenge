package domain.cardealer.sale.entities;

import co.com.sofka.domain.generic.Entity;
import domain.cardealer.generics.Email;
import domain.cardealer.sale.values.SalesmanId;
import domain.cardealer.generics.Name;

public class Salesman extends Entity<SalesmanId> {

    protected Name name;
    protected Email email;

    public Salesman(SalesmanId entityId, Name name, Email email) {
        super(entityId);
        this.name = name;
        this.email = email;
    }

    public Name SalesmanName() {
        return name;
    }

    public void setSalesmanName(Name name) {
        this.name = name;
    }

    public Email SalesmanEmail() {
        return email;
    }

    public void setSalesmanEmail(Email email) {
        this.email = email;
    }

    public void updateSalesman(Name name, Email email){
        setSalesmanName(name);
        setSalesmanEmail(email);
    }
}
