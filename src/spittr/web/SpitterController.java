package spittr.web;

import java.io.File;
import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import spittr.data.SpittleRepository;
import spittr.data.User;
import spittr.data.UserForm;

@Controller
@RequestMapping("/spitter")
public class SpitterController {

	@Autowired
	private SpittleRepository spittleRepository;

	public SpitterController() {
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

		User user = userForm.toUser();
		try {

			MultipartFile profilePicture = userForm.getProfilePicture();

			profilePicture.transferTo(new File("C:\\Users\\wojci\\Desktop\\spittr\\tmp\\uploads\\" + user.getLogin()));

		} catch (IOException e) {
			e.printStackTrace();
		}

		spittleRepository.save(user);

		model.addAttribute("login", user.getLogin());
		model.addFlashAttribute("user", user);
		return "redirect:/spitter/{login}";
	}

	@RequestMapping(value = "/{login}", method = RequestMethod.GET)
	public String showProfile(@PathVariable("login") String login, Model model) {

		if (!model.containsAttribute("user")) {
			User user = spittleRepository.findUser(login);
			model.addAttribute("user", user);
		}

		return "user";

	}

}
