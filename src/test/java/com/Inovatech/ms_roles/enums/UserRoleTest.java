package com.Inovatech.ms_roles.enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRoleTest {

    @Test
    void enumValuesTest() {

        assertEquals(
                UserRole.ADMIN,
                UserRole.valueOf("ADMIN")
        );

        assertEquals(
                3,
                UserRole.values().length
        );
    }
}