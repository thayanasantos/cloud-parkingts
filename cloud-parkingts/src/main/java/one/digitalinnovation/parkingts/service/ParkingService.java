package one.digitalinnovation.parkingts.service;

import one.digitalinnovation.parkingts.model.Parking;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

public class ParkingService {
    private static Map<String, Parking> parkingMap = new HashMap();

    static {
        var id = getUUID();
        Parking parking = new Parking(id, "DMS-1111", "SC", "CELTA", "PRETO");
        parkingMap.put(id, parking);
    }
    public List<Parking> findAll(){
         return parkingMap.values().stream().collect(Collectors.toList());
    }
    private static String getUUID() {
        return UUID.randomUUID().toString().replace("-", " ");

    }
}
