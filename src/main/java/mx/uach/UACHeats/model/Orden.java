package mx.uach.UACHeats.model;

import lombok.Data;

@Data
public class Orden {
    private double price;
    private String currency;
    private String method;
    private String intent;
    private String description;
}
