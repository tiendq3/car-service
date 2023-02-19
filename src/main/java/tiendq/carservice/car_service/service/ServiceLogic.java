package tiendq.carservice.car_service.service;

import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import tiendq.carservice.car_service.model.dtos.ServiceDTO;
import tiendq.carservice.car_service.model.entities.Service;
import tiendq.carservice.car_service.repository.ServiceRepository;

@Component
@Data
public class ServiceLogic {
    private final ServiceRepository serviceRepository;
    private final ModelMapper modelMapper;

    public void insertService(ServiceDTO serviceDTO) {
        Service service = modelMapper.map(serviceDTO, Service.class);
        serviceRepository.save(service);
    }
}
