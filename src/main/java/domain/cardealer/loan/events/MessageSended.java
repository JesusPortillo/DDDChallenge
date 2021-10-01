package domain.cardealer.loan.events;

import co.com.sofka.domain.generic.DomainEvent;

public class MessageSended extends DomainEvent {

    private final String message;
    public MessageSended(String message) {
        super("domain.cardealer.loan.messagesended");
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
