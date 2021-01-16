package hrmanagerWebPortal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrmanagerWebPortal.dto.User;
import hrmanagerWebPortal.service_Integration.UserServiceIntegration;

@Service
public class UserService {

	@Autowired
	UserServiceIntegration serviceIntegration;
	
	public boolean isValidUser(User loginuser) {
		
		try {
		User user = serviceIntegration.getUser(loginuser);
		//if(user.equals(null))
			return user.equals(loginuser);
		}catch (Exception e) {
			return false;
		}
		
	}
}
