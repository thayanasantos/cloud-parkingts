package one.digitalinnovation.parkingts.controller;

import one.digitalinnovation.parkingts.controller.dto.ParkingDTO;
import one.digitalinnovation.parkingts.controller.mapper.ParkingMapper;
import one.digitalinnovation.parkingts.model.Parking;
import one.digitalinnovation.parkingts.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parking")

public class ParkingController {

    private final ParkingService parkingService;
    private final ParkingMapper parkingMapper;
    //@Autowired
        public ParkingController(ParkingService parkingService, ParkingMapper parkingMapper) {
        this.parkingService = parkingService;
        this.parkingMapper = parkingMapper;
    }

    @GetMapping
    public ResponseEntity<List<ParkingDTO>> findAll(){
       List<Parking> parkingList = parkingService.findAll();
        List<ParkingDTO> result = parkingMapper.toParkingDTOList(parkingList);
        return ResponseEntity.ok(result);
}
    @GetMapping("/{id}")
    public ResponseEntity<ParkingDTO> findAll(@PathVariable String id){
        Parking parking = parkingService.findById(id);
        ParkingDTO result = parkingMapper.toParkingDTO(parking);
        return  ResponseEntity.ok(result);
    }
    @PostMapping
    public ResponseEntity<ParkingDTO> create(@RequestBody ParkingDTO dto){
        var parkingCreate = parkingMapper.toParking(dto);
        var parking = parkingService.create(parkingCreate);
        var result = parkingMapper.toParkingDTO(parking);
        return  ResponseEntity.status(HttpStatus.CREATED).body(result);
    }


}
