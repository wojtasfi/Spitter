package spittr.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import spittr.entity.Spitter;
import spittr.service.SpitterService;

@Controller
@RequestMapping("/spitter")
public class SpitterController {

	
	@Autowired
	private SpitterService spitterService;
	

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegistrationForm(Model model) {
		Spitter spitter = new Spitter();
		model.addAttribute("spitter", spitter);
		return "registerForm";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerNewUser(@Valid Spitter spitter, Errors errors, RedirectAttributes model) {

		if (errors.hasErrors()) {
			return "registerForm";
		}
		System.out.println(spitter.getId());

		spitterService.saveSpitter(spitter);

		model.addAttribute("login", spitter.getUsername());
		model.addFlashAttribute("user", spitter);
		return "redirect:/spitter/{login}";
	}

	@RequestMapping(value = "/{login}", method = RequestMethod.GET)
	public String showProfile(@PathVariable("login") String username, Model model) {

		if (!model.containsAttribute("user")) {
			Spitter spitter = spitterService.findByUsername(username);
			model.addAttribute("user", spitter);
		}

		return "user";

	}

}
