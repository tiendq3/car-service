package tiendq.carservice.car_service.model.dtos;

import lombok.Data;
import tiendq.carservice.car_service.model.entities.Customer;
import tiendq.carservice.car_service.model.entities.Product;
import tiendq.carservice.car_service.model.entities.Service;
import tiendq.carservice.car_service.model.entities.Staff;
import tiendq.carservice.car_service.model.enums.EStatus;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Data
public class OrderDTO {
    @NotNull
    private Customer customer;

    @NotNull
    private Set<Product> products;

    @NotNull
    private Set<Service> services;

    private Set<Staff> staffs;

    private String note;

    private Date timeOrder;

    private Date timeEstimate;

    private EStatus status;

    @NotNull
    private double totalPrice;
}
