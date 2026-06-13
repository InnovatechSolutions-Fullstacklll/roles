package com.Inovatech.ms_roles.repository;

import com.Inovatech.ms_roles.entity.UserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class RoleRepository extends JpaRepository<UserRoleEntity, Long> {

    public Optional<UserRoleEntity> findByEmail(String email);
}
