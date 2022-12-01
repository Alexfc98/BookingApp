package com.Backend.Flights.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Backend.Flights.Exceptions.RecordNotFoundException;
import com.Backend.Flights.Model.Flight;
import com.Backend.Flights.Repository.FlightRepository;

@Service
public class FlightService {

    @Autowired
    FlightRepository repository;


    public List<Flight> getAllFlights()
    {
        List<Flight> UserList = repository.findAll();

        if(UserList.size() > 0) {
            return UserList;
        } else {
            return new ArrayList<Flight>();
        }
    }

    public Flight getFlightById(String id) throws RecordNotFoundException {
        Optional<Flight> flight = repository.findById(id);

        if(flight.isPresent()) {
            return flight.get();
        } else {
            throw new RecordNotFoundException("No item record exist for given id",id);
        }
    }

    public Flight createFlight(Flight entity){
        entity = repository.save(entity);
        return entity;
    }

    public void deleteFlightById(String id) throws RecordNotFoundException
    {
        Optional<Flight> item = repository.findById(id);

        if(item.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No item record exist for given id",id);
        }
    }

    public Flight UpdateFlight(Flight entity) throws RecordNotFoundException
    {
        Optional<Flight> item = repository.findById(entity.getId());

        if(item.isPresent())
        {
            Flight newEntity = item.get();
            //newEntity.setId(entity.getId());
            newEntity.setOrigin(entity.getOrigin());
            newEntity.setDestination(entity.getDestination());
            newEntity.setDepartureDate(entity.getDepartureDate());
            newEntity.setArriveDate(entity.getArriveDate());
            newEntity.setAeroline(entity.getAeroline());
            newEntity.setPrice(entity.getPrice());
            newEntity.setAllowLuggage(entity.isAllowLuggage());
            newEntity.setScales(entity.getScales());

            newEntity = repository.save(newEntity);

            return newEntity;
        } else {
            throw new RecordNotFoundException("Item not found",entity.getId());
        }
    }

    public List<Flight> getByOrigin(String origin){
        List<Flight> list = repository.getByOrigin(origin);
        return list;
    }

    public List<Flight> getByDestination(String destination){
        List<Flight> list = repository.getByDestination(destination);
        return list;
    }

    public List<Flight> getByallowLuggage(boolean luggage){
        List<Flight> list = repository.getByallowLuggage(luggage);
        return list;
    }

    public List<Flight> getByScales(int scales){
        List<Flight> list = repository.getByScales(scales);
        return list;
    }

    public List<Flight> getOrderByPriceASC(){
        List<Flight> list = repository.getOrderByPriceASC();
        return list;
    }

    public List<Flight> getOrderByPriceDESC(){
        List<Flight> list = repository.getOrderByPriceDESC();
        return list;
    }

    public List<Flight> getOrderByPriceRange(int limitPrice){
        List<Flight> list = repository.getOrderByPriceRange(limitPrice);
        return list;
    }

    public List<Flight> getOrderByAeroline(String aeroline){
        List<Flight> list = repository.getOrderByAeroline(aeroline);
        return list;
    }

    public List<Flight> getByDate(Date date){
        List<Flight> list = repository.getByDate(date);
        return list;
    }

}

