package com.mitrais.more.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mitrais.more.api.models.Privilege;


public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {
	Privilege findByName(String name);
}
