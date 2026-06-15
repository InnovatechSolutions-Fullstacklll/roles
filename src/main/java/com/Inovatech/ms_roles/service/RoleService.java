package com.Inovatech.ms_roles.service;

import com.Inovatech.ms_roles.dto.ChangeRoleRequest;
import com.Inovatech.ms_roles.dto.DefaultRoleRequest;
import com.Inovatech.ms_roles.dto.RoleResponse;
import com.Inovatech.ms_roles.entity.UserRoleEntity;
import com.Inovatech.ms_roles.enums.UserRole;
import com.Inovatech.ms_roles.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleResponse createDefaultRole(
            DefaultRoleRequest request) {

        UserRoleEntity role = UserRoleEntity.builder()
                .email(request.getEmail())
                .role(UserRole.DEVELOPER)
                .build();

        roleRepository.save(role);

        return RoleResponse.builder()
                .email(role.getEmail())
                .role(role.getRole().name())
                .build();
    }

    public List<RoleResponse> getAllRoles() {

        return roleRepository.findAll()
                .stream()
                .map(r -> RoleResponse.builder()
                        .email(r.getEmail())
                        .role(r.getRole().name())
                        .build())
                .toList();
    }

    public RoleResponse getRoleByEmail(
            String email) {

        UserRoleEntity role =
                roleRepository.findByEmail(email)
                        .orElseThrow();

        return RoleResponse.builder()
                .email(role.getEmail())
                .role(role.getRole().name())
                .build();
    }

    public RoleResponse changeRole(
            ChangeRoleRequest request) {

        UserRoleEntity role =
                roleRepository.findByEmail(
                                request.getEmail())
                        .orElseThrow();

        role.setRole(
                UserRole.valueOf(
                        request.getRole()
                )
        );

        roleRepository.save(role);

        return RoleResponse.builder()
                .email(role.getEmail())
                .role(role.getRole().name())
                .build();
    }
}