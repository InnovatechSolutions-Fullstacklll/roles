package com.Inovatech.ms_roles.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoleResponse {

    private String email;

    private String role;

}
