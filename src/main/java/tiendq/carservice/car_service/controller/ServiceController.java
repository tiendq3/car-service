package tiendq.carservice.car_service.controller;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import tiendq.carservice.car_service.model.dtos.ServiceDTO;
import tiendq.carservice.car_service.service.ServiceLogic;

@RestController
@Data
public class ServiceController {
    private final ServiceLogic serviceLogic;

    @PostMapping("api/v1/services")
    @ResponseStatus(HttpStatus.CREATED)
    public void insertService(ServiceDTO serviceDTO) {
        serviceLogic.insertService(serviceDTO);
    }
}
