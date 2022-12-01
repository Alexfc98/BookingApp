package com.Backend.Bookings.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "bookings")
@Data
@AllArgsConstructor
public class Booking {

    @Id
    private String id;


    //Se debe asociar el Id del pasajero (User).
    @Column(name = "passengerID")
    
    private String passengerID;

    @Column(name = "numberOfPassengers")
    private int numberOfPassengers;


    //Se debe asociar el Id de vuelo.
    @Column(name = "flightID")
    
    private String flightID;

}
