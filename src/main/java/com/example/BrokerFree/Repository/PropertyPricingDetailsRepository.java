package com.example.BrokerFree.Repository;

import com.example.BrokerFree.Model.PropertyPricingDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyPricingDetailsRepository extends JpaRepository<PropertyPricingDetails, Long> {
}
