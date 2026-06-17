package com.Inovatech.ms_roles.controller;

import com.Inovatech.ms_roles.dto.DefaultRoleRequest;
import com.Inovatech.ms_roles.dto.RoleResponse;
import com.Inovatech.ms_roles.service.RoleService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RoleControllerTest {

    @Mock
    private RoleService roleService;

    @InjectMocks
    private RoleController roleController;

    @Test
    void getAllRolesTest() {

        RoleService service = mock(RoleService.class);

        RoleController controller =
                new RoleController(service);

        when(service.getAllRoles())
                .thenReturn(List.of());

        List<RoleResponse> result =
                controller.getAllRoles();

        assertNotNull(result);
    }

    @Test
    void createDefaultRoleTest() {

        RoleService service = mock(RoleService.class);

        RoleController controller =
                new RoleController(service);

        DefaultRoleRequest request =
                new DefaultRoleRequest();

        request.setEmail("test@test.cl");

        when(service.createDefaultRole(request))
                .thenReturn(
                        RoleResponse.builder()
                                .email("test@test.cl")
                                .role("DEVELOPER")
                                .build()
                );

        RoleResponse response =
                controller.createDefaultRole(request);

        assertEquals("DEVELOPER",
                response.getRole());
    }
}