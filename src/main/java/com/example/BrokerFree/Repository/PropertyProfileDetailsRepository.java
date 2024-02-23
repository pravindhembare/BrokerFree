package com.example.BrokerFree.Repository;

import com.example.BrokerFree.Model.PropertyProfileDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyProfileDetailsRepository extends JpaRepository<PropertyProfileDetails, Long> {
}
