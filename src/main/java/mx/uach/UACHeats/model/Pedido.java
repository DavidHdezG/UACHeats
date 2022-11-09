package mx.uach.UACHeats.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "pedidos")
public class Pedido {
    @Id
    @Column(name = "id_pedido")
    private Integer id;
    @Column
    private Integer idCliente;
    @Column
    private Integer idProducto;
    @Column
    private Integer cantidadProducto;
    @Column
    private String horaEntrega;
    @Column
    private String estadoPedido;
    @Column
    private float total;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Pedido pedido = (Pedido) o;
        return id != null && Objects.equals(id, pedido.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
