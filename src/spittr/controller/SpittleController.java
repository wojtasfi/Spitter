package spittr.controller;

import java.sql.Time;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spittr.entity.Spitter;
import spittr.entity.Spittle;
import spittr.service.SpitterService;
import spittr.web.SpittleNotFoundException;

@Controller
@RequestMapping("/spittles")
public class SpittleController {

	private SpitterService spitterService;

	@Autowired
	public SpittleController(SpitterService spitterService) {

		this.spitterService = spitterService;
		
		}

	@RequestMapping(method = RequestMethod.GET)
	public String spittles(Model model) {

		List<Spittle> spittleList = spitterService.findAllSpittles();

		model.addAttribute("spittleList", spittleList);

		return "spittles";

	}

	
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public String showSpittle(@RequestParam("spittle_id") long spittleId, Model model) {

		model.addAttribute(spitterService.findSpittleById(spittleId));

		return "spittle";

	}

	@RequestMapping(value = "/{spittleId}", method = RequestMethod.GET)
	public String spittle(@PathVariable("spittleId") long spittleId, Model model) {

		Spittle spittle = (Spittle) spitterService.findSpittleById(spittleId);

		if (spittle == null) {
			throw new SpittleNotFoundException(spittleId);
		}
		model.addAttribute(spittle);

		return "spittle";

	}

	@RequestMapping(method = RequestMethod.POST)
	public String addSpittle(Spittle spittle, Model model) {

		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String spitterUsername = user.getUsername();
		Spitter spitter = spitterService.findByUsername(spitterUsername);
		spittle.setSpitter(spitter);
		spittle.setSpitterUsername(spitter.getUsername());

		spittle.setTime(new Time(System.currentTimeMillis()));
		spittle.setLatitude(0.0);
		spittle.setLongitude(0.0);

		spitter.addSpittle(spittle);
		spitterService.saveSpittle(spittle);
		spitterService.saveSpitter(spitter);

		return "redirect:/spittles";

	}
	
	

}
