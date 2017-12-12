package oath.server.auth.service;

import java.util.ArrayList;
import java.util.List;

import oath.server.auth.model.AppUser;


public class AppUserRepo {
	
	private static List<AppUser> allAppUsers = makeAppUsers();

	public List<AppUser> findAll() {
		return allAppUsers;
	}
	
	public AppUser findByUserName(String name) {
		for(AppUser appUser: allAppUsers) {
			if(appUser.getUsername().equals(name)) return appUser;
		}
		return null;
	}

	private static List<AppUser> makeAppUsers() {
		ArrayList<AppUser> all = new ArrayList<AppUser>();

		all.add(new AppUser("margepw", "marge","marge@simpsons.com",true,true,true,true));
		all.add(new AppUser("bartpw", "bart","bart@simpsons.com",false,true,true,true));
		all.add(new AppUser("lisapw", "lisa","lisa@simpsons.com",true,false,true,true));
		all.add(new AppUser("homerpw", "homer","homer@simpsons.com",true,true,false,true));
		all.add(new AppUser("maggiepw", "maggie","maggie@simpsons.com",true,true,true,false));

		
		return all;
	}
}
