package com.careerit.ljdbc.cbook;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Contact {

        private long id;
        private String name;
        private LocalDate dob;
        private String email;
        private String mobile;
        private String city;
        private boolean deleted;

}
