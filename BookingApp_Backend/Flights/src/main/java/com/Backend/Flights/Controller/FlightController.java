package com.Backend.Flights.Controller;

import java.sql.Date;
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

import com.Backend.Flights.Exceptions.RecordNotFoundException;
import com.Backend.Flights.Model.Flight;
import com.Backend.Flights.Service.FlightService;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    FlightService service;


    @GetMapping
    public ResponseEntity<List<Flight>> getAllFlights() {
        List<Flight> list = service.getAllFlights();

        return new ResponseEntity<List<Flight>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Flight> getFlightById(@PathVariable("id") String id)
            throws RecordNotFoundException {
        Flight entity = service.getFlightById(id);

        return new ResponseEntity<Flight>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Flight> createFlight(@RequestBody Flight myItem){
        Flight created = service.createFlight(myItem);
        return new ResponseEntity<Flight>(created, new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Flight> UpdateFlight(@RequestBody Flight myItem)
            throws RecordNotFoundException {
        Flight updated = service.UpdateFlight(myItem);
        return new ResponseEntity<Flight>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteFlightById(@PathVariable("id") String id)
            throws RecordNotFoundException {
        service.deleteFlightById(id);
        return HttpStatus.ACCEPTED;
    }

    @GetMapping("/{origin}")
    public ResponseEntity<List<Flight>> getByOrigin(@PathVariable("origin") String origin) {
        List<Flight> list = service.getByOrigin(origin);

        return new ResponseEntity<List<Flight>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{destination}")
    public ResponseEntity<List<Flight>> getByDestination(@PathVariable("origin") String destination) {
        List<Flight> list = service.getByDestination(destination);

        return new ResponseEntity<List<Flight>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{luggage}")
    public ResponseEntity<List<Flight>> getByallowLuggage(@PathVariable("luggage")boolean luggage) {
        List<Flight> list = service.getByallowLuggage(luggage);

        return new ResponseEntity<List<Flight>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{scales}")
    public ResponseEntity<List<Flight>> getByScales(@PathVariable("scales") int scales) {
        List<Flight> list = service.getByScales(scales);

        return new ResponseEntity<List<Flight>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{priceASC}")
    public ResponseEntity<List<Flight>> getByPriceASC() {
        List<Flight> list = service.getOrderByPriceASC();

        return new ResponseEntity<List<Flight>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{priceDESC}")
    public ResponseEntity<List<Flight>> getByPriceDESC() {
        List<Flight> list = service.getOrderByPriceDESC();

        return new ResponseEntity<List<Flight>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{limitPrice}")
    public ResponseEntity<List<Flight>> getByPriceRange(@PathVariable("limitPrice") int limitPrice) {
        List<Flight> list = service.getOrderByPriceRange(limitPrice);

        return new ResponseEntity<List<Flight>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{aeroline}")
    public ResponseEntity<List<Flight>> getByAeroline(@PathVariable("aeroline") String aeroline) {
        List<Flight> list = service.getOrderByAeroline(aeroline);

        return new ResponseEntity<List<Flight>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{departureDate}")
    public ResponseEntity<List<Flight>> getByDate(@PathVariable("departureDate")Date departureDate) {
        List<Flight> list = service.getByDate(departureDate);

        return new ResponseEntity<List<Flight>>(list, new HttpHeaders(), HttpStatus.OK);
    }

}
