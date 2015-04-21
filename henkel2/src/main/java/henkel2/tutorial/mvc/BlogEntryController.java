package henkel2.tutorial.mvc;

import henkel2.tutorial.entities.BlogEntry;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class BlogEntryController {
	/*@RequestMapping("/test")
	public ResponseEntity<Object> test(){
		
		BlogEntry entry = new BlogEntry();
		entry.setTitle("This is the blog entry");
		return new ResponseEntity<Object>(entry, HttpStatus.OK);
	}*/
	
	/*@RequestMapping("/test")
	public @ResponseBody BlogEntry test(){
		
		BlogEntry entry = new BlogEntry();
		entry.setTitle("This is the blog entry");
		return entry;
	}*/

	@RequestMapping(value="/test", method=RequestMethod.POST)	
	public @ResponseBody BlogEntry test(@RequestBody BlogEntry entry){
		
		
			return entry;
	}
}
