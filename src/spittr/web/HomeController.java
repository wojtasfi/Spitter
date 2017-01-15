package spittr.web;

//zeby method=GET działało
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


//@Controller to stereotyp @Componenet
@Controller
@RequestMapping({"/", "/homepage", "/Spitter/", "/Spitter"})
public class HomeController {
	
	@RequestMapping(method=GET)
	public String home(){
		return "home";
	}

}
