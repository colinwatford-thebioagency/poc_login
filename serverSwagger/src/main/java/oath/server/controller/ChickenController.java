package oath.server.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import oath.server.model.Chicken;
import oath.server.repository.ChickenRepo;


@RestController
@RequestMapping("/chicken")
@Api(value="chicken rest endpoints")
public class ChickenController {

	
	ChickenRepo chickenRepo = new ChickenRepo();
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ApiOperation(value = "View all chickens", response = List.class)
	public ResponseEntity<Collection<Chicken>> getChickens() {
		return new ResponseEntity<>(chickenRepo.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "fetch a particular chickens by id", response = Chicken.class)
	public ResponseEntity<Chicken> getChickenById(@PathVariable int id) {
		Chicken chicken = chickenRepo.findById(id);

		if (chicken != null) {
			return new ResponseEntity<>(chicken, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	

}
