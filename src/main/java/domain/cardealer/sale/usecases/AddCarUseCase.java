package domain.cardealer.sale.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.cardealer.sale.Sale;
import domain.cardealer.sale.commands.AddCar;

public class AddCarUseCase extends UseCase<RequestCommand<AddCar>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddCar> addCarRequestCommand) {
        var command = addCarRequestCommand.getCommand();
        var sale = Sale.from(command.getSaleId(), retrieveEvents(command.getPlate().value()));
        sale.addCar(command.getPlate(), command.getCarModel(), command.getCarPrice(), command.getCarColor(),
                command.getCategory());
        emit().onResponse(new ResponseEvents(sale.getUncommittedChanges()));
    }
}
