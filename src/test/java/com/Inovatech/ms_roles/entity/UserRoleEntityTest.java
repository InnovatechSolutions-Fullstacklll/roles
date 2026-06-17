package com.Inovatech.ms_roles.entity;

import com.Inovatech.ms_roles.enums.UserRole;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRoleEntityTest {

    @Test
    void entityTest() {

        UserRoleEntity entity =
                UserRoleEntity.builder()
                        .id(1L)
                        .email("test@test.cl")
                        .role(UserRole.ADMIN)
                        .build();

        assertEquals(1L, entity.getId());
        assertEquals(UserRole.ADMIN,
                entity.getRole());
    }
}