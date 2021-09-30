package domain.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.cardealer.sale.Sale;
import domain.cardealer.sale.commands.AddSalesman;

public class AddSalesmanUseCase extends UseCase<RequestCommand<AddSalesman>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddSalesman> addSalesmanRequestCommand) {
        var command = addSalesmanRequestCommand.getCommand();
        var sale = Sale.from(command.getSaleId(), retrieveEvents(command.getSalesmanId().value()));
        sale.addSalesman(command.getSalesmanId(), command.getName(), command.getEmail(), command.getAge());
        emit().onResponse(new ResponseEvents(sale.getUncommittedChanges()));
    }
}

