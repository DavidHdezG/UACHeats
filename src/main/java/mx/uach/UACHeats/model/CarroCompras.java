package mx.uach.UACHeats.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class CarroCompras {
    @Id
    private int id;
    private int productId;
    private String productName;
    private int quantity;
    private float amount;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CarroCompras that = (CarroCompras) o;
        return false;
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
