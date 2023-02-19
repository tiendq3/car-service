package tiendq.carservice.car_service.service;

import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import tiendq.carservice.car_service.exception.NotFoundException;
import tiendq.carservice.car_service.model.dtos.OrderDTO;
import tiendq.carservice.car_service.model.entities.Customer;
import tiendq.carservice.car_service.model.entities.Order;
import tiendq.carservice.car_service.model.entities.Service;
import tiendq.carservice.car_service.model.entities.Staff;
import tiendq.carservice.car_service.model.enums.EStatus;
import tiendq.carservice.car_service.repository.*;

import java.util.Date;


//@Service
@Component
@Data
public class OrderService {

    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;

    private final ProductRepository productRepository;

    private final ServiceRepository serviceRepository;

    private final CustomerRepository customerRepository;

    private final StaffRepository staffRepository;

    @Transactional
    public void createOrder(OrderDTO orderDTO) {
        Order order = modelMapper.map(orderDTO, Order.class);
        //
        Customer existCustomer = customerRepository.findByPhone(orderDTO.getCustomer().getPhone());
        if (existCustomer == null) {
            customerRepository.save(orderDTO.getCustomer());
            order.setCustomer(orderDTO.getCustomer());
        } else
            order.setCustomer(existCustomer);

        productRepository.saveAll(orderDTO.getProducts());

        double totalPrice = 0;
        for (Service service : orderDTO.getServices()) {
            Service existService = serviceRepository.findById(service.getId()).orElse(null);
            if (existService == null) throw new NotFoundException("not found service by " + service.getId());
            totalPrice += existService.getFee();
        }
        order.setTimeOrder(new Date());
        order.setTotalPrice(totalPrice);
        orderRepository.save(order);
    }

    public void insertStaffToOrder(Long idStaff, Long idOrder) {
        Order order = orderRepository.findById(idOrder).orElse(null);
        Staff staff = staffRepository.findById(idStaff).orElse(null);
        if (order == null) throw new NotFoundException("not found order by " + idOrder);
        if (staff == null) throw new NotFoundException("not found order by " + idStaff);
        order.getStaffs().add(staff);
        orderRepository.save(order);
    }

    public void updateOrder(Long id, String note, Date timeEstimate, EStatus status) {
        Order order = orderRepository.findById(id).orElse(null);
        if (order == null) throw new NotFoundException("not found order by " + id);
        Customer customer = customerRepository.findById(order.getCustomer().getId()).orElse(null);
        if (customer == null) throw new NotFoundException("order has no customer");

        order.setNote(note);
        order.setTimeEstimate(timeEstimate);
        order.setStatus(order.getStatus());
        if (status.equals(EStatus.COMPLETED)) {
            if (customer.getWallet().getBalance() < order.getTotalPrice())
                throw new RuntimeException("Insufficient customer balance");
            customer.getWallet().setBalance(customer.getWallet().getBalance() - order.getTotalPrice());
        }
        customerRepository.save(customer);
        orderRepository.save(order);
    }
}
