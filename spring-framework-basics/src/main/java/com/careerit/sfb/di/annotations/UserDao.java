package com.careerit.sfb.di.annotations;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDao {


        public List<String> getUsers(){
            // This is a dummy implementation, in real time this data will come from database
            return new ArrayList<>(List.of("Krish","Manoj","John","Smith"));
        }
}
