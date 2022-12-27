package com.example.webseries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TravelServiceImp implements TravelService {

    @Autowired
    private TravelRepository travelRepo;

    @Override
    public String upsertTravel(TravelModel travel) {
        travelRepo.save(travel);
        return "TravelSuccess!";
    }

    @Override
    public List<TravelModel> getAllTravel() {
        return travelRepo.findAll();
    }

    @Override
    public TravelModel getById(String id) {
        Optional<TravelModel> findById = travelRepo.findById(id);

        if(findById.isPresent())
            return findById.get();
        else
            return null;
    }

    @Override
    public String deleteTravel(String id) {
        if(travelRepo.existsById(id)){
            travelRepo.deleteById(id);
            return "Travel Deleted Successfully! "+id+"";
        } else{
            return "No record found";
        }
    }
}
