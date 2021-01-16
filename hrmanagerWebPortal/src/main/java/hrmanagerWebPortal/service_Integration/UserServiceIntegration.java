package hrmanagerWebPortal.service_Integration;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import hrmanagerWebPortal.constants.URLs;
import hrmanagerWebPortal.dto.User;

@Repository
public class UserServiceIntegration {

	public User getUser(User Loginuser) {
		try {
			
		RestTemplate restTemplate = new RestTemplate();
		User user=restTemplate.getForObject(URLs.GET_USER+Loginuser.getUsername().toLowerCase(), User.class);
		return user;
		
		}catch(NullPointerException e) {
			return null;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
