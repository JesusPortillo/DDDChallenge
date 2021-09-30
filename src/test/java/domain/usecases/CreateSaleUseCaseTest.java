package domain.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import domain.cardealer.sale.Sale;
import domain.cardealer.sale.commands.CreateSale;
import domain.cardealer.sale.events.SaleCreated;
import domain.cardealer.sale.values.SaleDate;
import domain.cardealer.sale.values.SaleId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class CreateSaleUseCaseTest {

    @Test
    void createSaleEscenary(){
        //arrange
        var sale = new Sale(
                new SaleId("212"),
                new SaleDate()
        );

        var command = new CreateSale(
            SaleId.of("xxxx"),
            new SaleDate()
        );

        var useCase = new CreateSaleUseCase();

        //act

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert

        var event = (SaleCreated)events.get(0);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String time = dtf.format(LocalDateTime.now());
        Assertions.assertEquals(time, event.getSaleDate().value());
    }
}