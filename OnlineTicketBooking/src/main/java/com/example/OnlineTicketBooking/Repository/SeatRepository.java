package com.example.OnlineTicketBooking.Repository;

import com.example.OnlineTicketBooking.models.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat,Integer> {
}
