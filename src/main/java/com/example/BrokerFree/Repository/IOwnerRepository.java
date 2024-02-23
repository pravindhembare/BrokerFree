package com.example.BrokerFree.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BrokerFree.Model.Owner;


@Repository
public interface IOwnerRepository extends JpaRepository<Owner,Integer> {

	public Owner findByOemail(String email);
	
	public Owner findByOemailAndOpassword(String oemail, String opassword);
	
}
