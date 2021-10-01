package domain.cardealer.sale.commands;

import co.com.sofka.domain.generic.Command;
import domain.cardealer.sale.values.SaleDate;
import domain.cardealer.sale.values.SaleId;

public class CreateSale extends Command {

    private final SaleId saleId;
    private final SaleDate saleDate;


    public CreateSale(SaleId saleId, SaleDate saleDate) {
        this.saleId = saleId;
        this.saleDate = saleDate;
    }

    public SaleId saleId() {
        return saleId;
    }

    public SaleDate saleDate() {
        return saleDate;
    }
}
