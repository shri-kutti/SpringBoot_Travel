package com.example.webseries;

import java.util.List;

public interface TravelService {
    public String upsertTravel(TravelModel series);

    public List<TravelModel> getAllTravel();

    public TravelModel getById(String id);


    public String deleteTravel(String id);


}
