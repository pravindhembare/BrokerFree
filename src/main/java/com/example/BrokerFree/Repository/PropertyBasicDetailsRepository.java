package com.example.BrokerFree.Repository;

import com.example.BrokerFree.Model.Owner;
import com.example.BrokerFree.Model.PropertyBasicDetails;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyBasicDetailsRepository extends JpaRepository<PropertyBasicDetails, Long> {

    List<PropertyBasicDetails> findByOwner(Owner owner);
}
