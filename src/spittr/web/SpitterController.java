package spittr.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
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
		System.out.println("register");
		User user = new User();
		model.addAttribute("user", user);
		return "registerForm";
	}

	/*
	 * @RequestParam("firstName") String firstName,
	 * 
	 * @RequestParam("lastName") String lastName,
	 * 
	 * @RequestParam("login") String login,
	 * 
	 * @RequestParam("password") String password
	 */

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerNewUser(@ModelAttribute("user") @Valid User user, Errors errors) {
		// User user = new User(firstName, lastName, login, password);
		System.out.println(errors);
		if (errors.hasErrors()) {
			return "registerForm";
		}
		repo.save(user);
		return "redirect:/spitter/" + user.getLogin(); // przeskakuje
														// automatycznie do
														// metody ponizej
	}

	@RequestMapping(value = "/{login}", method = RequestMethod.GET)
	public String showProfile(@PathVariable("login") String login, Model model) {
		User user = repo.findUser(login);

		model.addAttribute("user", user);
		// <c:out value="${user.login} itp

		return "user";

	}

}
