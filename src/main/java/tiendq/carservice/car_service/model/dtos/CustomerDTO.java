package tiendq.carservice.car_service.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tiendq.carservice.car_service.model.entities.Wallet;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {

    private String name;


    private String phone;


    private String address;

    private Wallet wallet;
}
