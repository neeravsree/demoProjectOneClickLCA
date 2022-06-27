package com.oneclick.controller;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oneclick.dto.CalculateDTO;
import com.oneclick.dto.ImpactDTO;
import com.oneclick.dto.UserRegistrationDto;
import com.oneclick.entity.ImpactEntity;
import com.oneclick.entity.NewUser;
import com.oneclick.model.ConfigMeta;
import com.oneclick.model.Impact;
import com.oneclick.model.ImpactDetails;
import com.oneclick.model.ImpactDetailsMeta;
import com.oneclick.model.Resource;
import com.oneclick.model.ResourceList;
import com.oneclick.service.UserServiceImpl;

@Controller
public class HomeController {

	
	@Autowired
	UserServiceImpl userService;
	
	@Autowired
	ConfigMeta configValues;
	  @PostConstruct 
	  public  void init() throws Exception {
	  
	  ObjectMapper jsonMapper=new ObjectMapper(); 
	  InputStream input=this.getClass().getClassLoader()
              .getResourceAsStream("configuration.json"); 
	  configValues=jsonMapper.readValue(input, ConfigMeta.class);
	 
	  }
	 
	  
	  private List<ResourceList> getResources(){
		  List<ResourceList> resourceList=new ArrayList<ResourceList>();
		  List<Resource> resources=configValues.getResources();
		  int i=1;
		  if(null!=resources) {
			  for(Resource resource:resources)
			  {
				  resourceList.add(new ResourceList(i,resource.getName()));
				  i++;
			  }
		  }
		return resourceList;
	  }
	  
	@RequestMapping("home")
	public String home() {
		
		return "home";
	}
	
	@PostMapping("/addUser")
	public ModelAndView addUser(UserRegistrationDto user)
	{
		ModelAndView model=new ModelAndView("/home");
		NewUser existinguser=userService.findUser(user);
		
		if(null==existinguser)
		{
			NewUser userInput=userService.addUser(user);
			//ImpactEntity impEntity=userService.addImpact(user.getEmail());
			model.addObject("message","User Added Successfully");
			
		}
		else {
			model.addObject("message","user exists!!!");	
		}
		return model;
	}
	
	@PatchMapping("/impact/{email}")
	public void updateUserImpact(@RequestBody ImpactDTO impactDto,@PathVariable("email") String emailId) {
		
		impactDto.setEmail(emailId);
		userService.updateUser(impactDto);
		
	}
	
	@RequestMapping("/newUser")
	public String newUser() {
		return "newuser";
	}
	
	@RequestMapping("/initiallogin")
	public String initiallogin() {
		return "login";
	}
	@RequestMapping("/logout")
	public String logout() {
		return "home";
	}
	
	@PostMapping("/login")
		public ModelAndView login(UserRegistrationDto user) {
		NewUser existinguser=userService.findUser(user);
		List<ImpactEntity> impact=userService.findImpact(user.getEmail());
		
		ModelAndView model=null;
			
		 if(null!=existinguser&&existinguser.getPassword().equalsIgnoreCase(user.getPassword())) {
		
			 List<ResourceList> resList=getResources();
			 List<String> resourcename=new ArrayList<String>();
		for(ResourceList resource:resList)
		{
			resourcename.add(resource.getName());
		}
		
		
		 model = new ModelAndView("/mainpage","command",new ResourceList());
		
		  
		    	model.addObject("calculatedimpact",impact);
		   
			model.addObject("resources",resourcename);
			model.addObject("useremail",existinguser.getEmail());
		}
		 else {	
		 model = new ModelAndView("/login","command",new ResourceList());
		 }
			return model;
		
	}
	
	@PostMapping("/calculate")
	
		public ResponseEntity<List <ImpactDetails>> calculate(@RequestBody List<CalculateDTO> calculateDTO) {
		List<ImpactDetails> impactDetails=new ArrayList<ImpactDetails>();	
		try {
				List<Resource> resources=configValues.getResources();
				double so2e=0.0;
				double co2e=0.0;
				
				ImpactDetailsMeta meta=new ImpactDetailsMeta();
				for(CalculateDTO calculateItm:calculateDTO) {
					
					for (Resource r:resources) {
						if(r.getName().equals(calculateItm.getResource())){
							for(Impact impact:r.getImpacts()) {
								so2e=Double.parseDouble(impact.getImpactAP_kgSO2e())*calculateItm.getQuantity();
								co2e=Double.parseDouble(impact.getImpactGWP100_kgCO2e())*calculateItm.getQuantity();
								impactDetails.add(new ImpactDetails(r.getName(),so2e,co2e));
								meta.setImpactDetails(impactDetails);
							}
						}
					}
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			return ResponseEntity.ok(impactDetails);
		}
	}

