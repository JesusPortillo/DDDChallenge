package domain.cardealer.sale.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.cardealer.sale.Sale;
import domain.cardealer.sale.commands.UpdateCar;

public class UpdateCarUseCase extends UseCase<RequestCommand<UpdateCar>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<UpdateCar> updateCarRequestCommand) {
        var command = updateCarRequestCommand.getCommand();

    }
}
