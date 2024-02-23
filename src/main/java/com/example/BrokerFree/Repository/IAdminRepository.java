package com.example.BrokerFree.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BrokerFree.Model.Admin;


@Repository
public interface IAdminRepository extends JpaRepository<Admin, String> {

	public Admin findByEmailAndPassword(String email, String password);
	
	public Admin findByEmail(String email);
	
}
