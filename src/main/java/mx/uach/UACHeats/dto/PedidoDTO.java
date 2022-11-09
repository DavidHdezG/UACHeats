package mx.uach.UACHeats.dto;

import lombok.Data;
import mx.uach.UACHeats.model.CarroCompras;

import java.util.List;
@Data
public class PedidoDTO {
    private String descripcion;
    private List<CarroCompras> productos;
    private String usuarioEmail;
    private String usuarioName;
}
