package mx.uach.UACHeats.dto;

import lombok.Data;

@Data
public class ResponseDTO {
    private float amount;
    private int invoiceNumber;
    private String date;
    private String OrderDescription;
    private int orderId;
}
