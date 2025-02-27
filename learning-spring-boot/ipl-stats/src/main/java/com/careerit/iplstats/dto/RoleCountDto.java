package com.careerit.iplstats.dto;

import com.careerit.iplstats.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleCountDto {

    private Role role;
    private long count;


}
