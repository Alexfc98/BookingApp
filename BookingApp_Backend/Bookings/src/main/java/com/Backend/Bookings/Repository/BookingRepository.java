package com.Backend.Bookings.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Backend.Bookings.Model.Booking;

public interface BookingRepository extends JpaRepository<Booking,String> {

    @Query(
            value = "SELCET * FROM booking WHERE passengerID = ?  ", nativeQuery = true
    )
    public List<Booking> getBookingsByPassengerID(String passengerID);


}