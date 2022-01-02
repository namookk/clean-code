package com.houseutils.repository;

import com.houseutils.entity.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author namookk
 */
//@Repository
public interface ApartmentRepository extends JpaRepository<Apartment, Long> {
}
