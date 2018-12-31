package com.tamnhan.authorization.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tamnhan.authorization.model.AdminTamNhan;

public interface AdminTamNhanRepository extends JpaRepository<AdminTamNhan, Long>{
	
	AdminTamNhan getAdminTamNhanByEmail(String email);

}
