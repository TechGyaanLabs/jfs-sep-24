package com.careerit.cj.day20;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Contact {
    private String id;
    private String name;
    private String email;
    private String mobile;
    private boolean deleted;
}
