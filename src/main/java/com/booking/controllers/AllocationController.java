package com.booking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.booking.model.HostelAllocation;
import com.booking.repos.AllocationRepository;

@RestController
@RequestMapping(value = "/allocations")
public class AllocationController {
	
	@Autowired
	private AllocationRepository allocationRepository;	
		
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<HostelAllocation> getAll(){
		return allocationRepository.findAll();
	}
	
	@RequestMapping(value = "/reduced/{price}", method = RequestMethod.GET)
	public List<HostelAllocation> reduced(@PathVariable double price){
		return allocationRepository.findByPricePerDayLessThan(price);			
				
	}
	
	@RequestMapping(value = "/premium/{price}", method = RequestMethod.GET)
	public List<HostelAllocation> premium(@PathVariable double price){		
		return allocationRepository.findByPricePerDayGreaterThan(price);
		
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public List<HostelAllocation> create(@RequestBody HostelAllocation hostelAllocation){
		
		allocationRepository.save(hostelAllocation);
		
		return allocationRepository.findAll();
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public List<HostelAllocation> remove(@PathVariable long id){
		
		allocationRepository.deleteById(id);
		
		return allocationRepository.findAll();
	}

	@RequestMapping(value = "/")
	public String home() {
		
		return "index";
	}
}
