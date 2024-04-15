package com.example.OnlineTicketBooking.JWTSecurity.config;

import com.example.OnlineTicketBooking.JWTSecurity.RoleAndPermission.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.example.OnlineTicketBooking.JWTSecurity.RoleAndPermission.Permission;


@Configuration
@EnableWebSecurity
public class SecurityFilter {

    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrfConfig -> csrfConfig.disable())
                .sessionManagement(sessionMangConfig -> sessionMangConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests( authConfig -> {
                    authConfig.requestMatchers(HttpMethod.POST, "/auth/authenticate").permitAll();
                    authConfig.requestMatchers(HttpMethod.POST, "/auth/register").permitAll();
                    authConfig.requestMatchers("/error").permitAll();

                    //authConfig.requestMatchers(HttpMethod.POST, "/user/add_user").hasAuthority(Permission.ADD_USER.name());
                    authConfig.requestMatchers(HttpMethod.DELETE, "/user/delete_user").hasAuthority(Role.USER.name());
                    authConfig.requestMatchers(HttpMethod.PUT, "/user/update_user").hasAuthority(Permission.UPDATE_USER.name());
                    authConfig.requestMatchers(HttpMethod.POST, "/admin/add_seat").hasAuthority(Permission.SAVE_SEAT.name());
                    authConfig.requestMatchers(HttpMethod.PUT, "/admin/update_seat").hasAuthority(Permission.UPDATE_SEAT.name());
                    authConfig.requestMatchers(HttpMethod.DELETE, "/admin/delete_seat").hasAuthority(Permission.DELETE_SEAT.name());
                    authConfig.requestMatchers(HttpMethod.POST, "/admin/add_passenger").hasAuthority(Permission.SAVE_PASSENGER.name());
                    authConfig.requestMatchers(HttpMethod.DELETE, "/admin/delete_passenger").hasAuthority(Permission.DELETE_SEAT.name());
                    authConfig.requestMatchers(HttpMethod.POST, "/user/book_ticket").hasAuthority(Permission.BOOK_TICKET.name());
                    authConfig.requestMatchers(HttpMethod.DELETE, "/user/cancel_ticket").hasAuthority(Permission.CANCEL_BOOKING.name());
                    authConfig.requestMatchers(HttpMethod.GET, "/admin/read_all+seats").hasAuthority(Permission.READ_ALL_SEATS.name());
                    authConfig.requestMatchers(HttpMethod.GET, "/admin/read_all_passengers").hasAuthority(Permission.READ_ALL_PASSENGERS.name());
                    authConfig.requestMatchers(HttpMethod.GET, "/user/available_seats").hasAuthority(Permission.SAVE_USER.name());




                    authConfig.anyRequest().denyAll();


                });

        return http.build();

    }
}
