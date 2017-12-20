package com.atul.persistent.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atul.persistent.model.Role;

public interface RoleDao extends JpaRepository<Role,Long> {
	
	 List<Role> findByRoleName(String roleName);

}
