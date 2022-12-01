package com.Backend.Flights.Model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "flights")
@Data
@AllArgsConstructor
public class Flight {

    @Id
    
    private String id;

    @Column(name = "Origin")
   
    private String origin;

    @Column(name = "Destination")
    
    private String destination;

    @Column(name="departureDate")
    
    private Date departureDate;

    @Column(name="arriveDate")
    
    private Date arriveDate;

    @Column(name="aeroline")
    
    private String aeroline;

    @Column(name = "price")
    
    private int price;

    @Column(name = "allowLuggage")
    private boolean allowLuggage;

    @Column(name = "oneWayOrRoundTrip")
    private Boolean oneWayOrRoundTrip;

    @Column(name = "scales" )
    private int scales;
}