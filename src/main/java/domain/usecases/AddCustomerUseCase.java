package domain.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.cardealer.sale.Sale;
import domain.cardealer.sale.commands.AddCustomer;


public class AddCustomerUseCase extends UseCase<RequestCommand<AddCustomer>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddCustomer> addCustomerRequestCommand) {
        var command = addCustomerRequestCommand.getCommand();
        var sale = Sale.from(command.getSaleId(), retrieveEvents(command.getCustomerId().value()));
        sale.addCustomer(command.getCustomerId(), command.getName(), command.getEmail(), command.getAge());
        emit().onResponse(new ResponseEvents(sale.getUncommittedChanges()));
    }
}
