package com.compassdev.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.compassdev.dao.CustomerRepository;
import com.compassdev.dao.LookUpRepository;
import com.compassdev.model.CustomerMaster;
import com.compassdev.model.StreamProcessLookup;

@Controller
public class AssesmentController {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private LookUpRepository lookUpRepository;
	
	
	@GetMapping("/sampleInsert")
	public @ResponseBody String bulkcreate(){
		// save a single Customer
		CustomerMaster master = new CustomerMaster();
		master.setCustomerName("TCS");
		master.setIndustry("Information Tech");
		customerRepository.save(master);
		return "Customers are created Succesfully";

	}

	@GetMapping("/getCustomer/{customerId}")
	public @ResponseBody CustomerMaster getCustomer(@PathVariable(value = "customerId") String customerId){
		// save a single Customer
		Optional<CustomerMaster> customer = customerRepository.findById(Long.valueOf(customerId));
		return customer.get();

	}

	@GetMapping("/getAllCustomer")
	public @ResponseBody List<CustomerMaster> getAllCustomer(){
		// save a single Customer
		Iterable<CustomerMaster> customer = customerRepository.findAll();
		List<CustomerMaster> result = new ArrayList<>();
		customer.forEach(result::add);
		return result;

	}


	@PostMapping("/addCustomer")
	public String addUser(CustomerMaster customerMaster, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "index";
		}
		customerRepository.save(customerMaster);
		return "redirect:/getCustomerLandingPage";
	}


	@GetMapping("/getCustomerLandingPage")
	public String getCustomerMaster(Model model) {
		CustomerMaster customerMaster = new CustomerMaster();
		model.addAttribute("customerMaster",customerMaster);	
		//model.addAttribute("customerId",customerId);
		return "CustomerMasterForm";
	}


	@PostMapping("/addCustomerAjax")
	public @ResponseBody ResponseEntity<?> addCustomer(@RequestBody CustomerMaster customerMaster) {
		com.compassdev.model.ResponseBody<String> result = new com.compassdev.model.ResponseBody<>();
		try {
			customerRepository.save(customerMaster);
			result.setErrorCode(200);
			result.setErrorMessage("Success");
			
		}catch (Exception e) {
			result.setErrorCode(500);
			result.setErrorMessage("Unexpected Error occurred");
		}
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/")
	public String getHome(Model model) {
		return "home";
	}
	
	@GetMapping("/getProcessByStream/{streamName}")
	public @ResponseBody ResponseEntity<?> getProcessByStream(@PathVariable(value = "streamName") String streamName){
		// save a single Customer
		com.compassdev.model.ResponseBody<List<StreamProcessLookup>> result = new com.compassdev.model.ResponseBody<>();
		List<StreamProcessLookup> processList = lookUpRepository.findAll();
		processList = processList.stream().filter(processResult -> processResult.getStreamCode().equals(streamName)).collect(Collectors.toList());
		result.setErrorCode(200);
		result.setErrorMessage("Success");
		result.setResultBody(processList);
		return ResponseEntity.ok(result);

	}
	
	@GetMapping("/getAllCustomers")
	public @ResponseBody ResponseEntity<?> getAllCustomers(){
		// save a single Customer
		com.compassdev.model.ResponseBody<List<CustomerMaster>> result = new com.compassdev.model.ResponseBody<>();
		List<CustomerMaster> customer = customerRepository.findAll();
		result.setErrorCode(200);
		result.setErrorMessage("Success");
		result.setResultBody(customer);
		return ResponseEntity.ok(result);

	}


}
