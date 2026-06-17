package com.Inovatech.ms_roles.service;

import com.Inovatech.ms_roles.dto.ChangeRoleRequest;
import com.Inovatech.ms_roles.dto.DefaultRoleRequest;
import com.Inovatech.ms_roles.dto.RoleResponse;
import com.Inovatech.ms_roles.entity.UserRoleEntity;
import com.Inovatech.ms_roles.enums.UserRole;
import com.Inovatech.ms_roles.repository.RoleRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RoleServiceTest {

    @Mock
    private RoleRepository roleRepository;

    @InjectMocks
    private RoleService roleService;

    @Test
    void createDefaultRoleTest() {

        DefaultRoleRequest request = new DefaultRoleRequest();
        request.setEmail("test@test.cl");

        when(roleRepository.save(any())).thenAnswer(i -> i.getArgument(0));

        RoleResponse response =
                roleService.createDefaultRole(request);

        assertEquals("test@test.cl", response.getEmail());
        assertEquals("DEVELOPER", response.getRole());

        verify(roleRepository).save(any());
    }

    @Test
    void getAllRolesTest() {

        List<UserRoleEntity> roles = List.of(
                UserRoleEntity.builder()
                        .email("admin@test.cl")
                        .role(UserRole.ADMIN)
                        .build()
        );

        when(roleRepository.findAll()).thenReturn(roles);

        List<RoleResponse> result =
                roleService.getAllRoles();

        assertEquals(1, result.size());
        assertEquals("ADMIN", result.get(0).getRole());
    }

    @Test
    void getRoleByEmailTest() {

        UserRoleEntity role =
                UserRoleEntity.builder()
                        .email("admin@test.cl")
                        .role(UserRole.ADMIN)
                        .build();

        when(roleRepository.findByEmail("admin@test.cl"))
                .thenReturn(Optional.of(role));

        RoleResponse response =
                roleService.getRoleByEmail("admin@test.cl");

        assertEquals("ADMIN", response.getRole());
    }

    @Test
    void getRoleByEmailNotFoundTest() {

        when(roleRepository.findByEmail("x@test.cl"))
                .thenReturn(Optional.empty());

        assertThrows(
                NoSuchElementException.class,
                () -> roleService.getRoleByEmail("x@test.cl")
        );
    }

    @Test
    void changeRoleTest() {

        UserRoleEntity role =
                UserRoleEntity.builder()
                        .email("dev@test.cl")
                        .role(UserRole.DEVELOPER)
                        .build();

        when(roleRepository.findByEmail("dev@test.cl"))
                .thenReturn(Optional.of(role));

        ChangeRoleRequest request =
                new ChangeRoleRequest();

        request.setEmail("dev@test.cl");
        request.setRole("ADMIN");

        RoleResponse response =
                roleService.changeRole(request);

        assertEquals("ADMIN", response.getRole());

        verify(roleRepository).save(role);
    }
}