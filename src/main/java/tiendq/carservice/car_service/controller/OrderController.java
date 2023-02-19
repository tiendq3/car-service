package tiendq.carservice.car_service.controller;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tiendq.carservice.car_service.model.dtos.OrderDTO;
import tiendq.carservice.car_service.model.enums.EStatus;
import tiendq.carservice.car_service.service.OrderService;

import javax.validation.Valid;
import java.util.Date;

@RestController
@Data
public class OrderController {

    private final OrderService orderService;

    @PostMapping("api/v1/admin/orders")
    @ResponseStatus(HttpStatus.CREATED)
    public void createOrder(@RequestBody @Valid OrderDTO orderDTO) {
        orderService.createOrder(orderDTO);
    }

    @PutMapping("api/v1/admin/orders/{idOrder}/insert-staffs/{idStaff}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void insertStaffToOrder(@PathVariable Long idStaff, @PathVariable Long idOrder) {
        orderService.insertStaffToOrder(idStaff, idOrder);
    }

    @PutMapping("api/v1/admin/orders/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateOrder(@PathVariable Long id,
                            @RequestParam String note,
                            @RequestParam Date timeEstimate,
                            @RequestParam EStatus status) {
        orderService.updateOrder(id, note, timeEstimate, status);
    }
}
