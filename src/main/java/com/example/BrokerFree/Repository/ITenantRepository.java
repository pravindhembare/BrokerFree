package com.example.BrokerFree.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.BrokerFree.Model.Tenant;

@Repository
public interface ITenantRepository extends JpaRepository<Tenant,Integer> {
	
	public Tenant findByTemail(String temail);

	public Tenant findByTemailAndTpassword(String temail, String tpassword);

}
