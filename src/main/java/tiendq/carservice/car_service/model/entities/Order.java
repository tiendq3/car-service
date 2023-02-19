package tiendq.carservice.car_service.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tiendq.carservice.car_service.model.enums.EStatus;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany
    private Set<Product> products;

    @ManyToMany
    private Set<Service> services;

    @ManyToMany
    private Set<Staff> staffs;

    @Column(name = "note")
    private String note;

    @Column(name = "time_order")
    private Date timeOrder;

    @Column(name = "time_estimate")
    private Date timeEstimate;

    @Column(name = "status")
    private EStatus status;

    @Column(name = "total_price")
    private double totalPrice;
}
