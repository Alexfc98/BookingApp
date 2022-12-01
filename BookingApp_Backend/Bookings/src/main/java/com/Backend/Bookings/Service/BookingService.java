package com.Backend.Bookings.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Backend.Bookings.Exceptions.RecordNotFoundException;
import com.Backend.Bookings.Model.Booking;
import com.Backend.Bookings.Repository.BookingRepository;

@Service
public class BookingService {

    @Autowired
    BookingRepository repository;

    public List<Booking> getAllBookings()
    {
        List<Booking> UserList = repository.findAll();

        if(UserList.size() > 0) {
            return UserList;
        } else {
            return new ArrayList<Booking>();
        }
    }

    public Booking getBookingtById(String id) throws RecordNotFoundException {
        Optional<Booking> flight = repository.findById(id);

        if(flight.isPresent()) {
            return flight.get();
        } else {
            throw new RecordNotFoundException("No item record exist for given id",id);
        }
    }

    public Booking createBooking(Booking entity){
        entity = repository.save(entity);
        return entity;
    }

    public void deleteBookingById(String id) throws RecordNotFoundException
    {
        Optional<Booking> item = repository.findById(id);

        if(item.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No item record exist for given id",id);
        }
    }

    public Booking UpdateBooking(Booking entity) throws RecordNotFoundException
    {
        Optional<Booking> item = repository.findById(entity.getId());

        if(item.isPresent())
        {
            Booking newEntity = item.get();
            //newEntity.setId(entity.getId());
            newEntity.setPassengerID(entity.getPassengerID());
            newEntity.setFlightID(entity.getFlightID());
            newEntity.setNumberOfPassengers(entity.getNumberOfPassengers());


            newEntity = repository.save(newEntity);

            return newEntity;
        } else {
            throw new RecordNotFoundException("Item not found",entity.getId());
        }
    }
}
