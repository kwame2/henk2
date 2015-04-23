package henkel2.tutorial.rest.mvc;

import henkel2.tutorial.core.entities.BlogEntry;
import henkel2.tutorial.core.services.BlogEntryService;
import henkel2.tutorial.rest.resources.BlogEntryResource;
import henkel2.tutorial.rest.resources.asm.BlogEntryResourceAsm;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/rest/blog-entries")
public class BlogEntryController {
	
	private BlogEntryService service;
	
	public BlogEntryController(BlogEntryService service){
		this.service = service;
	}
	
	@RequestMapping(value="/{blogEntryId}", method=RequestMethod.GET)
	public ResponseEntity<BlogEntryResource> getBlogEntry(@PathVariable Long blogEntryId){
		
		BlogEntry blogEntry = service.find(blogEntryId);
		
		if(blogEntry != null){
			BlogEntryResource res = new BlogEntryResourceAsm().toResource(blogEntry);
			return new ResponseEntity<BlogEntryResource>(res, HttpStatus.OK);
		}else{
			return new ResponseEntity<BlogEntryResource>(HttpStatus.NOT_FOUND);
		}
		
		
		
	}
	
}
