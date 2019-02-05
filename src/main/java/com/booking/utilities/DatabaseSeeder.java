package com.booking.utilities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.booking.model.HostelAllocation;
import com.booking.repos.AllocationRepository;

@Component
public class DatabaseSeeder implements CommandLineRunner {

	@Autowired
	private AllocationRepository allocationRepository;
	
	@Override
	public void run(String... args) throws Exception {
		List<HostelAllocation> allocations = new ArrayList<>();

		allocations.add(new HostelAllocation("York", 200.04, 1));
		allocations.add(new HostelAllocation("Hove", 100.78, 3));
		allocations.add(new HostelAllocation("Grace", 75.99, 3));
		allocations.add(new HostelAllocation("Newham", 305.65, 4));
		allocations.add(new HostelAllocation("Catford", 430.34, 2));
		
		allocationRepository.saveAll(allocations);
	}

	public AllocationRepository getAllocationRepository() {
		return allocationRepository;
	}

	public void setAllocationRepository(AllocationRepository allocationRepository) {
		this.allocationRepository = allocationRepository;
	}

}
