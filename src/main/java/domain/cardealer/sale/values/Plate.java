package domain.cardealer.sale.values;

import co.com.sofka.domain.generic.Identity;
import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Plate extends Identity{

    public Plate(){}

    public Plate(String id){
        super(id);
    }

    public static Plate of(String id){
        return new Plate(id);
    }
}
