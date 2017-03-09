package spittr.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import spittr.data.Spitter;
import spittr.data.UserForm;
import spittr.persistance.SpitterRepository;

@Controller
@RequestMapping("/spitter")
public class SpitterController {

	
	
	private SpitterRepository spitterRepository;

	@Autowired
	  public SpitterController(SpitterRepository spitterRepository) {
	    this.spitterRepository = spitterRepository;
	  }

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegistrationForm(Model model) {
		UserForm userForm = new UserForm();
		model.addAttribute("userForm", userForm);
		return "registerForm";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerNewUser(@Valid UserForm userForm, Errors errors, RedirectAttributes model) {

		if (errors.hasErrors()) {
			return "registerForm";
		}

		Spitter spitter = userForm.toSpitter();
		
		System.out.println("Nowy spitter:");
		System.out.println(spitter);

		spitterRepository.save(spitter);

		model.addAttribute("login", spitter.getUsername());
		model.addFlashAttribute("user", spitter);
		return "redirect:/spitter/{login}";
	}

	@RequestMapping(value = "/{login}", method = RequestMethod.GET)
	public String showProfile(@PathVariable("login") String username, Model model) {

		if (!model.containsAttribute("user")) {
			Spitter spitter = spitterRepository.findByUsername(username);
			model.addAttribute("user", spitter);
		}

		return "user";

	}

}
