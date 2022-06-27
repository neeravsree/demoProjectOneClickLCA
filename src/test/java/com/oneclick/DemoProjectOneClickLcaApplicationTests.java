package com.oneclick;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oneclick.controller.HomeController;
import com.oneclick.dto.UserRegistrationDto;
import com.oneclick.entity.ImpactEntity;
import com.oneclick.entity.NewUser;
import com.oneclick.model.ConfigMeta;
import com.oneclick.repository.ImpactRepository;
import com.oneclick.repository.UserRepository;
import com.oneclick.service.UserServiceImpl;



@WebMvcTest(controllers = HomeController.class)
class DemoProjectOneClickLcaApplicationTests {

	@Autowired
	  private MockMvc mockMvc;

	@MockBean
	ConfigMeta meta;
	@MockBean
	private UserServiceImpl userservice;
	
	@MockBean
	private UserRepository userrepo;
	
	@MockBean 
	ImpactRepository impactrepo;
	@Test
	public void addUser() throws Exception {
	   String uri = "/addUser";
	   UserRegistrationDto dto = new UserRegistrationDto();
	   dto.setPassword("password");
	   dto.setEmail("def@gmail.com");
	   NewUser user = new NewUser();
	   dto.setUsername("sree");
	   dto.setPassword("password");
	   dto.setEmail("def@gmail.com");
	   ImpactEntity impEntity=new ImpactEntity();
	   impEntity.setEmail(dto.getEmail());
	   impEntity.setTotalUserimpact(0.0);
	   String inputJson = mapToJson(dto);
	   Mockito.when(userservice.addUser(dto)).thenReturn(user);
	   Mockito.when(userservice.addImpact(dto.getEmail())).thenReturn(impEntity);
	   MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(uri)
	      .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
	   
	   int status = mvcResult.getResponse().getStatus();
	   assertEquals(200, status);
		
	}

	 private String mapToJson(Object obj) throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper();
    return objectMapper.writeValueAsString(obj);
 }

}
