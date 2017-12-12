package oath.server.controller;

import java.util.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import oath.server.model.Chicken;
import oath.server.repository.ChickenRepo;


@RestController
@RequestMapping("/chicken")
public class ChickenController {

	
	ChickenRepo chickenRepo = new ChickenRepo();
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity<Collection<Chicken>> getChickens() {
		return new ResponseEntity<>(chickenRepo.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Chicken> getChicken(@PathVariable int id) {
		Chicken chicken = chickenRepo.findById(id);

		if (chicken != null) {
			return new ResponseEntity<>(chicken, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	

}
