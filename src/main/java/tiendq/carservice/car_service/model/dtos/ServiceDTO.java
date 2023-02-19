package tiendq.carservice.car_service.model.dtos;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class ServiceDTO {

    @NotNull
    @Size(max = 500)
    private String name;

    @NotNull
    private double fee;
}
