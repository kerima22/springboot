package com.pfe.demo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pfe.demo.Entity.ERole;
import com.pfe.demo.Entity.Role;



public interface RoleRepository extends JpaRepository <Role, Integer>{
	 Optional<Role> findByNomRole(ERole name);

}
