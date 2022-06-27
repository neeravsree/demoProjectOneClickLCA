package com.oneclick.service;

import com.oneclick.dto.UserRegistrationDto;
import com.oneclick.entity.NewUser;

public interface UserService {

	NewUser addUser(UserRegistrationDto user);
}
