package com.example.BrokerFree.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.BrokerFree.Model.Property;

@Repository
public interface IPropertyRepository extends JpaRepository<Property,Integer> 
{
	
}
