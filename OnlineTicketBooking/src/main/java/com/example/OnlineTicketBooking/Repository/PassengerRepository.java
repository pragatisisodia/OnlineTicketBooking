package com.example.OnlineTicketBooking.Repository;

import com.example.OnlineTicketBooking.models.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger,String> {
}
