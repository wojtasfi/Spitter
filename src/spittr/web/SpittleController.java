package spittr.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spittr.data.Spittle;
import spittr.data.SpittleRepository;

@Controller
@RequestMapping("/spittles")
public class SpittleController {

	private static final String MAX_LONG_AS_STRING = Long.toString(Long.MAX_VALUE);
	@Autowired
	private SpittleRepository repo;

	public SpittleController(SpittleRepository repo) {
		this.repo = repo;

	}

	/*
	 * @RequestMapping(method=RequestMethod.GET) public String spittles(Model
	 * model){ model.addAttribute("spittleList",
	 * repo.findSpittle(Long.MAX_VALUE, 20)); return "spittles"; }
	 */

	@RequestMapping(method = RequestMethod.GET)
	public List<Spittle> spittles(@RequestParam(value = "max", defaultValue = "238900") long max,
			@RequestParam(value = "count", defaultValue = "20") int count) {

		return repo.findSpittle(max, count);

	}

	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public String showSpittle(@RequestParam("spittle_id") long spittleId, Model model) {

		model.addAttribute(repo.findOne(spittleId));

		return "spittle";

	}

	@RequestMapping(value = "/{spittleId}", method = RequestMethod.GET)
	public String spittle(@PathVariable("spittleId") long spittleId, Model model) {

		Spittle spittle = (Spittle) repo.findOne(spittleId);
		model.addAttribute(spittle);

		return "spittle";

	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String addSpittle(@RequestParam("message") String message){
		repo.addSpittle(message);
		
		return "redirect:/spittles";
		
	}

}
