package spittr.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spittr.data.SpittleRepository;
import spittr.data.User;

@Controller
@RequestMapping("/spitter")
public class SpitterController {

	private SpittleRepository repo;

	@Autowired
	public SpitterController(SpittleRepository repo) {
		this.repo = repo;
	}

	public SpitterController() {
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegistrationForm(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "registerForm";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerNewUser(@Valid User user, Errors errors) {
		System.out.println(errors);
		if (errors.hasErrors()) {
			return "registerForm";
		}
		repo.save(user);
		return "redirect:/spitter/" + user.getLogin();
	}

	@RequestMapping(value = "/{login}", method = RequestMethod.GET)
	public String showProfile(@PathVariable("login") String login, Model model) {
		User user = repo.findUser(login);

		model.addAttribute("user", user);

		return "user";

	}

}
