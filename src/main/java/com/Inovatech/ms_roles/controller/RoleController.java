package com.Inovatech.ms_roles.controller;

import com.Inovatech.ms_roles.dto.ChangeRoleRequest;
import com.Inovatech.ms_roles.dto.DefaultRoleRequest;
import com.Inovatech.ms_roles.dto.RoleResponse;
import com.Inovatech.ms_roles.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @PostMapping("/default")
    public RoleResponse createDefaultRole(
            @RequestBody DefaultRoleRequest request) {

        return roleService.createDefaultRole(
                request
        );
    }

    @GetMapping
    public List<RoleResponse> getAllRoles() {

        return roleService.getAllRoles();
    }

    @GetMapping("/{email}")
    public RoleResponse getRoleByEmail(
            @PathVariable String email) {

        return roleService.getRoleByEmail(email);
    }

    @PutMapping("/change")
    public RoleResponse changeRole(
            @RequestBody ChangeRoleRequest request) {

        return roleService.changeRole(request);
    }
}
