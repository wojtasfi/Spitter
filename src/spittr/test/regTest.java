package spittr.test;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

import spittr.data.Spittle;
import spittr.data.SpittleRepository;
import spittr.web.SpitterController;

public class regTest {

	
	@Test
	public void regForm() throws Exception{
		
		SpitterController controller = new SpitterController();
		MockMvc mockMvc = standaloneSetup(controller).build();
		
		mockMvc.perform(get("/spitter/register"))
				.andExpect(view().name("registerForm"));
	}
}
