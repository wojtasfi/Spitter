package spittr.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import spittr.entity.Spittle;
import spittr.service.SpitterService;
import spittr.web.SpittleNotFoundException;

@RestController
@RequestMapping("/spittles")
public class SpittleRestController {

	private SpitterService spitterService;

	@Autowired
	public SpittleRestController(SpitterService spitterService) {

		this.spitterService = spitterService;

	}

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public List<Spittle> spittles() {

		return spitterService.findAllSpittles();

	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Spittle> addSpittle(@RequestBody Spittle spittle, UriComponentsBuilder ucb) {

		Spittle savedSpittle = spitterService.saveSpittle(spittle);

		HttpHeaders headers = new HttpHeaders();

		URI locationUri = ucb.path("/spittles/").path(String.valueOf(spittle.getSpittleId())).build().toUri();
		headers.setLocation(locationUri);

		ResponseEntity<Spittle> responseEntity = new ResponseEntity<Spittle>(savedSpittle, headers, HttpStatus.CREATED);
		return responseEntity;

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public Spittle spittleById(@PathVariable("id") long id) {
		Spittle spittle = spitterService.findSpittleById(id);

		if (spittle == null) {
			throw new SpittleNotFoundException(id);
		}
		return spittle;
	}

}
