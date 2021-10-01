package domain.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import domain.cardealer.loan.Loan;
import domain.cardealer.loan.commands.CreateLoan;
import domain.cardealer.loan.events.LoanCreated;
import domain.cardealer.loan.values.*;
import domain.cardealer.sale.Sale;
import domain.cardealer.sale.commands.CreateSale;
import domain.cardealer.sale.events.SaleCreated;
import domain.cardealer.sale.values.SaleDate;
import domain.cardealer.sale.values.SaleId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class CreateLoanUseCaseTest {

    @Test
    void createLoanEscenary(){
        //arrange
        var loan = new Loan(
                new LoanId("212"),
                new LoanDate(),
                new TimeToPay("12"),
                new LoanIsPaid(false),
                new IsAprobed(false),
                new SaleVerified(false)
        );

        var command = new CreateLoan(
                LoanId.of("xxxx"),
                new LoanDate(),
                new TimeToPay("12"),
                new LoanIsPaid(false),
                new IsAprobed(false),
                new SaleVerified(false)

        );

        var useCase = new CreateLoanUseCase();

        //act

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert

        var event = (LoanCreated)events.get(0);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String time = dtf.format(LocalDateTime.now());
        Assertions.assertEquals(time, event.getLoanDate().value());
        Assertions.assertEquals("12", event.getTimeToPay().value());
        Assertions.assertEquals(false, event.getLoanIsPaid().value());
        Assertions.assertEquals(false, event.getIsAprobed().value());
        Assertions.assertEquals(false, event.getSaleVerified().value());
    }
}