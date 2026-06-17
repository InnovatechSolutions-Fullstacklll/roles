package com.Inovatech.ms_roles.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DtoTest {

    @Test
    void roleResponseTest() {

        RoleResponse response =
                RoleResponse.builder()
                        .email("test@test.cl")
                        .role("ADMIN")
                        .build();

        assertEquals("ADMIN",
                response.getRole());
    }

    @Test
    void changeRoleRequestTest() {

        ChangeRoleRequest request =
                new ChangeRoleRequest();

        request.setEmail("a@a.cl");
        request.setRole("MASTER");

        assertEquals("MASTER",
                request.getRole());
    }

}