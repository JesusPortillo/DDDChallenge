package domain.cardealer.loan.values;

import co.com.sofka.domain.generic.Identity;

public class CoSignId extends Identity {

    public CoSignId(){}

    public CoSignId(String id){
        super(id);
    }

    public static CoSignId of(String id){
        return new CoSignId(id);
    }
}
