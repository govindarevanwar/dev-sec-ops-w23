package org.dnyanyog.service;

import java.util.List;

import org.dnyanyog.dto.LoginRequest;
import org.dnyanyog.dto.LoginResponse;
import org.dnyanyog.encryption.EncryptionService;
import org.dnyanyog.entity.Users;
import org.dnyanyog.repo.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.dnyanyog.common.ResponseCodes;


@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	UsersRepository userRepo;
	
	@Autowired
	EncryptionService encryptionservice;

	public LoginResponse validateUser(LoginRequest loginRequest) throws Exception {

		LoginResponse response = new LoginResponse();
		System.out.println(EncryptionService.encrypt(loginRequest.getPassword()));
		List<Users> liUser = userRepo.findByUsernameAndPassword(
				loginRequest.getUsername(), 
				EncryptionService.encrypt(loginRequest.getPassword())
				);
		
		if(liUser.size()==1)
		{
			response.setStatus(ResponseCodes.ADD_CUSTOMER_SUCCESS_CODE);
			response.setMessage(ResponseCodes.ADD_CUSTOMER_SUCCESS_MESSAGE);
		}else {
			response.setStatus(ResponseCodes.ADD_CUSTOMER_ERROR_CODE);
			response.setMessage(ResponseCodes.ADD_CUSTOMER_ERROR_MESSAGE);
		}
		return response;
	}
}
