package one.digitalinnovation.parkingts.controller.mapper;

import one.digitalinnovation.parkingts.controller.dto.ParkingDTO;
import one.digitalinnovation.parkingts.model.Parking;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ParkingMapper {

    private static  final ModelMapper MODEL_MAPPER = new ModelMapper();

    public ParkingDTO parkingDTO(Parking parking){
        return ModelMapper.map(parking, ParkingDTO.class);
    }





    public List<ParkingDTO> parkingDTOList(List<Parking> parkingList){
        return parkingList.stream().map(this::parkingDTO).collect(Collectors.toList());

    }
}
