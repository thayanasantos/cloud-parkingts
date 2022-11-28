package one.digitalinnovation.parkingts.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import one.digitalinnovation.parkingts.controller.dto.ParkingCreateDTO;
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
@Api(tags = "ParkingController")

public class ParkingController {

    private final ParkingService parkingService;
    private final ParkingMapper parkingMapper;
    //@Autowired
        public ParkingController(ParkingService parkingService, ParkingMapper parkingMapper) {
        this.parkingService = parkingService;
        this.parkingMapper = parkingMapper;
    }

    @GetMapping
    @ApiOperation("Find all parkings")
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
    public ResponseEntity<ParkingDTO> create(@RequestBody ParkingCreateDTO dto){
        var parkingCreate = parkingMapper.toParkingCreate(dto);
        var parking = parkingService.create(parkingCreate);
        var result = parkingMapper.toParkingDTO(parking);
        return  ResponseEntity.status(HttpStatus.CREATED).body(result);
    }


}
