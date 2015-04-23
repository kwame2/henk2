package henkel2.tutorial.mvc;

import henkel2.tutorial.core.entities.BlogEntry;
import henkel2.tutorial.core.services.BlogEntryService;
import henkel2.tutorial.rest.mvc.BlogEntryController;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.hasItem;

public class BlogEntryControllerTest {
	
	@InjectMocks
	private BlogEntryController controller;
	
	@Mock
	private BlogEntryService service;
	
	private MockMvc mockMvc;
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}
	
	
	 /*@Test
	    public void test() throws Exception {
	        mockMvc.perform(post("/test")
	                .content("{\"title\":\"Test Blog Title\"}")
	                .contentType(MediaType.APPLICATION_JSON)
	        ).andExpect(jsonPath("$.title", is("Test Blog Title")))
	                .andDo(print());
	    }*/
	
	@Test
	public void getExistingBlogTest() throws Exception{
		
		BlogEntry entry = new BlogEntry();
		entry.setId(1L);
		entry.setTitle("Fanck Corneille is the best");
		
		when(service.find(1L)).thenReturn(entry);
		
		mockMvc.perform(get("/rest/blog-entries/1"))
			.andDo(print())
			.andExpect(jsonPath("$.title",is(entry.getTitle())))
			.andExpect(jsonPath("$.links[*].href", hasItem(endsWith("/blog-entries/1"))))
			.andExpect(status().isOk());
	}
	
	@Test
	public void getNotExistingBlogTest() throws Exception{
		
		BlogEntry entry = new BlogEntry();
		entry.setId(1L);
		entry.setTitle("Fanck Corneille is the best");
		
		when(service.find(1L)).thenReturn(null);
		
		mockMvc.perform(get("/rest/blog-entries/1"))
			
			.andExpect(status().isNotFound());
	}
}
