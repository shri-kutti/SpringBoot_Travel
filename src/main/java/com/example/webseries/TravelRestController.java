package com.example.webseries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TravelRestController {

    @Autowired
    private TravelService travelService;

    @PostMapping("/addTravel")
    public ResponseEntity<String> addTravel(@RequestBody TravelModel travel){
        return new ResponseEntity<>(travelService.upsertTravel(travel), HttpStatus.ACCEPTED);
    }

    @GetMapping("/travel")
    public ResponseEntity<List<TravelModel>> getAllTravel(){
        return new ResponseEntity<>(travelService.getAllTravel(),HttpStatus.OK);
    }

    @GetMapping("/travel/{id}")
    public ResponseEntity<TravelModel> getByID(@PathVariable(name = "id") String id){
        return new ResponseEntity<>(travelService.getById(id),HttpStatus.OK);
    }


    @PutMapping("/travel/{id}")
    public ResponseEntity<String> updateSeries(@PathVariable(name = "id") String id,@RequestBody TravelModel travel){
        travel.setId(id);
        return new ResponseEntity<>(travelService.upsertTravel(travel), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteSeries(@PathVariable(name = "id") String id){
        return new ResponseEntity<>(travelService.deleteTravel(id),HttpStatus.OK);
    }

}
