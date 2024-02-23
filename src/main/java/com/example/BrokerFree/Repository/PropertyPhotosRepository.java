package com.example.BrokerFree.Repository;

import com.example.BrokerFree.Model.PropertyPhotos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyPhotosRepository extends JpaRepository<PropertyPhotos, Long> {
}
