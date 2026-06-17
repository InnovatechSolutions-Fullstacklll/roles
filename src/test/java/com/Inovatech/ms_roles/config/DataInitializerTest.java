package com.Inovatech.ms_roles.config;

import com.Inovatech.ms_roles.repository.RoleRepository;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class DataInitializerTest {

    @Test
    void initRolesBeanCreationTest() throws Exception {

        RoleRepository repository =
                mock(RoleRepository.class);

        DataInitializer initializer =
                new DataInitializer(repository);

        initializer.initRoles();

        verifyNoMoreInteractions(repository);
    }
}