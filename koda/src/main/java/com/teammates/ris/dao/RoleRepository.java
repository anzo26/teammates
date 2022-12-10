package com.teammates.ris.dao;

import com.teammates.ris.models.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findByName(String role_admin);
}
