package com.Inovatech.ms_roles.repository;

import com.Inovatech.ms_roles.entity.UserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<UserRoleEntity, Long> {

    Optional<UserRoleEntity> findByEmail(String email);

}
