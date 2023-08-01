package zenith.codes.projects.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "orders",
        uniqueConstraints = {
        @UniqueConstraint(
                name = "ordernumber_unique",
                columnNames = "orderNumber"
        )})
public class Order { //buyuk resimdeki veriler ana siparis

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String orderNumber;

    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderItems> orderItemsList; //siparis edilecek itemlerin listesi

}
