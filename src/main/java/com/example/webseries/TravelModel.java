package com.example.webseries;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name="travel_table")
public class TravelModel {
    @Id
    private String id;
    private String name;
    private String description;

}
