package com.mitrais.more.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mitrais.more.api.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Role findByName(String name);
}
