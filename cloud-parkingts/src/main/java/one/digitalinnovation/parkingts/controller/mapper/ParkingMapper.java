package one.digitalinnovation.parkingts.controller.mapper;

import one.digitalinnovation.parkingts.controller.dto.ParkingCreateDTO;
import one.digitalinnovation.parkingts.controller.dto.ParkingDTO;
import one.digitalinnovation.parkingts.model.Parking;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ParkingMapper {

    private static  final ModelMapper MODEL_MAPPER = new ModelMapper();

    public ParkingDTO toparkingDTO(Parking parking){
        return MODEL_MAPPER.map(parking, ParkingDTO.class);
    }

    public List<ParkingDTO> parkingDTOList(List<Parking> parkingList){
        return parkingList.stream().map(this::toparkingDTO).collect(Collectors.toList());

    }

  
    public List<ParkingDTO> toParkingDTOList(List<Parking> parkingList) {
        return null;
    }

        public ParkingDTO toParkingDTO(Parking parking) {
        return null;
    }

    public Parking toParking(ParkingDTO dto) {
        return MODEL_MAPPER.map(dto, Parking.class);
    }

    public void parkingDTO(Parking parking) {
    }

    public Parking toParkingCreate(ParkingCreateDTO dto) {
        return MODEL_MAPPER.map(dto, Parking.class);
    }
}
