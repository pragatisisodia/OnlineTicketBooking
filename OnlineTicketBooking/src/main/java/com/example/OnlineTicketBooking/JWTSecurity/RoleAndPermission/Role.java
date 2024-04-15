package com.example.OnlineTicketBooking.JWTSecurity.RoleAndPermission;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;
@Getter
public enum Role {
    USER(Arrays.asList(Permission.BOOK_TICKET,Permission.CANCEL_BOOKING,Permission.UPDATE_USER,Permission.SAVE_USER,Permission.SAVE_PASSENGER,Permission.DELETE_PASSENGER,Permission.AVAILABLE_SEATS,Permission.DELETE_USER)),
    ADMIN(Arrays.asList(Permission.SAVE_SEAT,Permission.READ_ALL_PASSENGERS,Permission.READ_ALL_USERS,Permission.READ_ALL_SEATS,Permission.UPDATE_SEAT,Permission.DELETE_SEAT));

    private List<Permission> permissions;

    Role(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}
