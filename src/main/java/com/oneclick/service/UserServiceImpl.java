package com.oneclick.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.oneclick.dto.CalculateDTO;
import com.oneclick.dto.ImpactDTO;
import com.oneclick.dto.UserRegistrationDto;
import com.oneclick.entity.ImpactEntity;
import com.oneclick.entity.NewUser;
import com.oneclick.repository.ImpactRepository;
import com.oneclick.repository.UserRepository;



@Service
public class UserServiceImpl implements UserService{
@Autowired
UserRepository userRepo;
@Autowired
ImpactRepository impactrepo;
	

	@Override
	public NewUser addUser(UserRegistrationDto userRegistrationDto) {
		// TODO Auto-generated method stub
		NewUser user=new NewUser(userRegistrationDto.getUsername(),userRegistrationDto.getPassword(),userRegistrationDto.getEmail());
		userRepo.save(user);
		return user;
	}
	
	public NewUser findUser(UserRegistrationDto userRegistrationDto) {
		
		
		NewUser user=userRepo.findByEmail(userRegistrationDto.getEmail());
		return user;
		
	}

	public void updateUser(ImpactDTO impactDto) {
		List<CalculateDTO> calculateDTO=impactDto.getCalculateDto();
		calculateDTO.stream().forEach(t->{
			//if exists update else add
			ImpactEntity existingOne=impactrepo.findByResourceName(t.getResource());
			if(existingOne==null) {
				ImpactEntity entity=new ImpactEntity();
				entity.setEmail(impactDto.getEmail());
				entity.setQuantity(t.getQuantity());
				entity.setResource(t.getResource());
				entity.setCO2e(t.getCO2e());
				entity.setSO2e(t.getSO2e());
				impactrepo.save(entity);
			}
			else {
				existingOne.setQuantity(t.getQuantity());
				existingOne.setCO2e(t.getCO2e());
				existingOne.setSO2e(t.getSO2e());
				impactrepo.save(existingOne);
			}
		
		
		});
		
		 
	}

	public ImpactEntity addImpact(String email) {
		ImpactEntity imp=new ImpactEntity(0.0,email);
		ImpactEntity newEntity=impactrepo.save(imp);
		return newEntity;
		
	}

	public List<ImpactEntity> findImpact(String email) {
		// TODO Auto-generated method stub
		List<ImpactEntity> imp=impactrepo.findByEmail(email);
		return imp;
	}
}
