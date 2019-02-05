package com.booking.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.model.HostelAllocation;

@Repository
public interface AllocationRepository extends JpaRepository<HostelAllocation, Long> {
	
	List<HostelAllocation> findByPricePerDayLessThan(double price);
	List<HostelAllocation> findByPricePerDayGreaterThan(double price);

}
