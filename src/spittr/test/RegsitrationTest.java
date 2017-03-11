package spittr.test;

public class RegsitrationTest {
	/*
	@Test
	public void register() throws Exception{
		SpitterRepository mockRepo = mock(SpitterRepository.class);
		
		Spitter unsaved = new Spitter("Wojtek", "Figas", "wfigas", "admin", "w@f.pl");
		Spitter saved = new Spitter(24L, "Wojtek", "Figas", "wfigas", "admin", "w@f.pl");
		
		when(mockRepo.save(unsaved)).thenReturn(saved);
		
		SpitterController controller = new SpitterController(mockRepo);
		
		MockMvc mockMvc = standaloneSetup(controller).build();
		
		mockMvc.perform(post("/spitter/register")
			.param("firstName", "Wojtek")
			.param("lastName", "Figas")
			.param("login", "wfigas")
			.param("password", "admin"))
			.andExpect(redirectedUrl("/spitter/wfigas"));
		verify(mockRepo, atLeastOnce()).save(unsaved);
	}
*/
}
