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

import spittr.data.Spitter;
import spittr.data.UserForm;
import spittr.data.SpitterRepository;

@Controller
@RequestMapping("/spitter")
public class SpitterController {

	
	@Autowired
	private SpitterRepository spitterRepository;

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

		Spitter spitter = userForm.toSpitter();
		try {

			MultipartFile profilePicture = userForm.getProfilePicture();

			profilePicture.transferTo(new File("C:\\Users\\wojci\\Desktop\\spittr\\tmp\\uploads\\" + spitter.getLogin()));

		} catch (IOException e) {
			e.printStackTrace();
		}

		spitterRepository.save(spitter);

		model.addAttribute("login", spitter.getLogin());
		model.addFlashAttribute("user", spitter);
		return "redirect:/spitter/{login}";
	}

	@RequestMapping(value = "/{login}", method = RequestMethod.GET)
	public String showProfile(@PathVariable("username") String username, Model model) {

		System.out.println(username);
		if (!model.containsAttribute("user")) {
			Spitter spitter = spitterRepository.findByUsername(username);
			model.addAttribute("user", spitter);
		}

		return "user";

	}

}
