package com.example.BrokerFree.Repository;

import com.example.BrokerFree.Model.PropertyBasicDetails;
import com.example.BrokerFree.Model.PropertyLocationDetails;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyLocationDetailsRepository extends JpaRepository<PropertyLocationDetails, Long> {
		
}
