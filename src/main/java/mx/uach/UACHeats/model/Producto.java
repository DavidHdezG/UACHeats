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
@Table(name = "productos")
public class Producto {

    @Id
    @Column
    private int id_producto;
    @Column
    private int idCategoria;
    @Column
    private String nombre;
    @Column
    private String descripcion;

    @Column
    private float precio;
    @Column
    private int tiempoPreparacion;
    @Column
    private boolean disponible;
    private int cantidad;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Producto producto = (Producto) o;
        return false;
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
