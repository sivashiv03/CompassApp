package com.compassdev.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.compassdev.dao.CustomerRepository;
import com.compassdev.model.CustomerMaster;

@Controller
public class AssesmentController {

	@Autowired
	private CustomerRepository customerRepository;

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
	
	/*
	 * @GetMapping("/getAssessmentScope") public String getAssessmentPage() { return
	 * "AsessmentScope"; }
	 */


}
