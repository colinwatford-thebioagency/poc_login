package oath.server.controller;

import java.util.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import oath.server.auth.model.AppUser;
import oath.server.auth.service.AppUserRepo;
import oath.server.model.Chicken;
import oath.server.repository.ChickenRepo;


@RestController
@RequestMapping("/user")
public class UserController {

	
	AppUserRepo userRepo = new AppUserRepo();
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity<Collection<AppUser>> getChickens() {
		return new ResponseEntity<>(userRepo.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<AppUser> getChicken(@PathVariable String id) {
		AppUser appUser = userRepo.findByUserName(id);

		if (appUser != null) {
			return new ResponseEntity<>(appUser, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	

}
