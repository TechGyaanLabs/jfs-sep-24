package com.careerit.ljdbc;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Appointment {

    private int id;
    private String name;
    private String email;
    private String phone;
    private String age;
    private String location;
    private String date;
    private String time;
    private String doctorName;
    private String reason;

    public static void main(String[] args) {

        Appointment appointment = Appointment.builder()
                .id(1)
                .name("Krish")
                .email("krish@gmail.com")
                .phone("9876543210")
                .age("25")
                .location("Hyderabad")
                .date("2021-10-10")
                .time("10:00 AM")
                .doctorName("Dr. Ramesh")
                .reason("Fever")
                .build();
    }

}
