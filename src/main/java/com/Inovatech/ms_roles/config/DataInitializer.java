package com.Inovatech.ms_roles.config;

import com.Inovatech.ms_roles.entity.UserRoleEntity;
import com.Inovatech.ms_roles.enums.UserRole;
import com.Inovatech.ms_roles.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class DataInitializer {

    private final RoleRepository roleRepository;

    @Bean
    CommandLineRunner initRoles() {

        return args -> {

            if(roleRepository.findByEmail(
                            "admin@inovatech.cl")
                    .isEmpty()) {

                roleRepository.save(
                        UserRoleEntity.builder()
                                .email(
                                        "admin@inovatech.cl")
                                .role(
                                        UserRole.ADMIN)
                                .build()
                );
            }

            if(roleRepository.findByEmail(
                            "master@inovatech.cl")
                    .isEmpty()) {

                roleRepository.save(
                        UserRoleEntity.builder()
                                .email(
                                        "master@inovatech.cl")
                                .role(
                                        UserRole.MASTER)
                                .build()
                );
            }
        };
    }
}
