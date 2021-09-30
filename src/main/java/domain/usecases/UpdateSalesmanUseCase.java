package domain.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.cardealer.sale.Sale;
import domain.cardealer.sale.commands.UpdateSalesman;

public class UpdateSalesmanUseCase extends UseCase<RequestCommand <UpdateSalesman>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateSalesman> updateSalesmanRequestCommand) {
        var command = updateSalesmanRequestCommand.getCommand();
        var sale = Sale.from(command.getSaleId(), retrieveEvents());
        sale.updateSalesman(command.getSaleId(),command.getSalesmanId(),command.getName(),
                command.getEmail(), command.getAge());
        emit().onResponse(new ResponseEvents(sale.getUncommittedChanges()));
    }
}
