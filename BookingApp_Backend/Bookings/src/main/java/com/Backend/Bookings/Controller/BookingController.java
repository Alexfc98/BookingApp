package com.Backend.Bookings.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Backend.Bookings.Exceptions.RecordNotFoundException;
import com.Backend.Bookings.Model.Booking;
import com.Backend.Bookings.Service.BookingService;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    BookingService service;

    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings() {
        List<Booking> list = service.getAllBookings();

        return new ResponseEntity<List<Booking>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable("id") String id)
            throws RecordNotFoundException {
        Booking entity = service.getBookingtById(id);

        return new ResponseEntity<Booking>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestBody Booking myItem){
        Booking created = service.createBooking(myItem);
        return new ResponseEntity<Booking>(created, new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Booking> UpdateBooking(@RequestBody Booking myItem)
            throws RecordNotFoundException {
        Booking updated = service.UpdateBooking(myItem);
        return new ResponseEntity<Booking>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteFlightById(@PathVariable("id") String id)
            throws RecordNotFoundException {
        service.deleteBookingById(id);
        return HttpStatus.ACCEPTED;
    }
}
