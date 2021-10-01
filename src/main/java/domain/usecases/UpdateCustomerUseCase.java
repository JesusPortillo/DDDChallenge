package domain.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.cardealer.sale.Sale;
import domain.cardealer.sale.commands.UpdateCustomer;

public class UpdateCustomerUseCase extends UseCase<RequestCommand<UpdateCustomer>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateCustomer> updateCustomerRequestCommand) {
        var command = updateCustomerRequestCommand.getCommand();
        var sale = Sale.from(command.getSaleId(), retrieveEvents());
        sale.updateCustomer(command.getSaleId(),command.getCustomerId(),command.getName(),
                command.getEmail(), command.getAge());
        emit().onResponse(new ResponseEvents(sale.getUncommittedChanges()));
    }
}
