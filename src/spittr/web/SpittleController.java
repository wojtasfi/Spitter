package spittr.web;

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

import spittr.data.Spitter;
import spittr.data.Spittle;
import spittr.persistance.SpitterRepository;
import spittr.persistance.SpittleRepository;

@Controller
@RequestMapping("/spittles")
public class SpittleController {

	@Autowired
	private SpittleRepository spittleRepository;

	@Autowired
	private SpitterRepository spitterRepository;

	@RequestMapping(method = RequestMethod.GET)
	public String spittles(Model model) {

		List<Spittle> spittleList = spittleRepository.findAll();

		model.addAttribute("spittleList", spittleList);

		return "spittles";

	}

	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public String showSpittle(@RequestParam("spittle_id") long spittleId, Model model) {

		model.addAttribute(spittleRepository.findOne(spittleId));

		return "spittle";

	}

	@RequestMapping(value = "/{spittleId}", method = RequestMethod.GET)
	public String spittle(@PathVariable("spittleId") long spittleId, Model model) {

		Spittle spittle = (Spittle) spittleRepository.findOne(spittleId);

		if (spittle == null) {
			throw new SpittleNotFoundException();
		}
		model.addAttribute(spittle);

		return "spittle";

	}

	@RequestMapping(method = RequestMethod.POST)
	public String addSpittle(Spittle spittle, Model model) {

		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String spitterUsername = user.getUsername();

		Spitter spitter = spitterRepository.findByUsername(spitterUsername);
		spittle.setSpitter(spitter);
		spittle.setSpitterUsername(spitter.getUsername());
		spittle.setTime(new Time(System.currentTimeMillis()));
		spittle.setLatitude(0.0);
		spittle.setLongitude(0.0);

		spittleRepository.save(spittle);

		return "redirect:/spittles";

	}

}
