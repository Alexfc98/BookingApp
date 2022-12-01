package com.Backend.Flights.Repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Backend.Flights.Model.Flight;



public interface FlightRepository extends JpaRepository<Flight,String> {

    @Query(
            value = "SELECT * FROM flights Where origin = ?",nativeQuery = true
    )
    public List<Flight> getByOrigin(String origin);

    @Query(
            value = "SELECT * FROM flights Where destination = ?",nativeQuery = true
    )
    public List<Flight> getByDestination(String destination);

    @Query(
            value = "SELECT * FROM flights Where allowLuggage = ?",nativeQuery = true
    )
    public List<Flight> getByallowLuggage(boolean luggage);

    @Query(
            value = "SELECT * FROM flights Where scales <= ?",nativeQuery = true
    )
    public List<Flight> getByScales(int scales);

    @Query(
            value = "SELECT * FROM flights ORDER BY price ASC",nativeQuery = true
    )
    public List<Flight> getOrderByPriceASC();

    @Query(
            value = "SELECT * FROM flights ORDER BY price DESC",nativeQuery = true
    )
    public List<Flight> getOrderByPriceDESC();

    @Query(
            value = "SELECT * FROM flights where price <= ?",nativeQuery = true
    )
    public List<Flight> getOrderByPriceRange(int limitPrice);

    @Query(
            value = "SELECT * FROM flights where aeroline = ?",nativeQuery = true
    )
    public List<Flight> getOrderByAeroline(String aeroline);

    @Query(
            value = "SELECT * FROM flights where departureDate = ?",nativeQuery = true
    )
    public List<Flight> getByDate(Date departureDate);
}
