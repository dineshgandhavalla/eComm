package com.spring.controller;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.spring.dao.ExclusiveDAO;
import com.spring.model.Exclusive;
import com.spring.service.ExclusiveService;
@Controller
public class ExclusiveController {

	@Autowired
	ExclusiveDAO exclusiveDAO;

	
	private Path path;
	

	
	@Autowired
	private ExclusiveService exclusiveService;
	
	
	   @RequestMapping(value="/exclusive")
		public String setupForm(Map<String, Object> map,Model model)
		{
		   Exclusive exclusive = new  Exclusive();
			map.put("exclusive", exclusive);
			map.put("exclusiveList",exclusiveService.getAllExclusive());
			return "Exclusive";
		}
	
	
	@RequestMapping(value="/exclusive.do", method=RequestMethod.POST)
	public String doActions(RedirectAttributes attributes,HttpServletRequest request,@ModelAttribute ("exclusive")Exclusive exclusive, BindingResult result, @RequestParam String action, Map<String, Object> map,Model model)
            		throws Exception
	{
		Exclusive exclusiveResult = new Exclusive();
		 if (action.equals("Add"))
		 {
			 exclusiveResult = exclusive;
			 MultipartFile file = exclusive.getEximage();
				String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		        path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\"+exclusive.getExid()+".jpg");
		        if (file != null && !file.isEmpty()) {
		            try {
		            	System.out.println("Image Saving Start");
		            	file.transferTo(new File(path.toString()));
		            	System.out.println("Image Saved");
		            } catch (Exception e) {
		                e.printStackTrace();
		                System.out.println("Error");
		                throw new RuntimeException("item image saving failed.", e);
		            }
		        }
		        exclusiveService.add(exclusive);
		 }
			 
		 if (action.equals("Edit"))
				 {
			 exclusiveService.edit(exclusive);
			 exclusiveResult = exclusive;
			
		 }
		 if (action.equals("Delete")){
			 exclusiveService.delete(exclusive.getExid());
			 exclusiveResult = new Exclusive();
			
		 }
		 if (action.equals("Search")){
			 Exclusive searchedExclusive = exclusiveService.getExclusive(exclusive.getExid());
			 exclusiveResult = searchedExclusive!=null ? searchedExclusive : new Exclusive();
			
		}
		map.put("exclusive", exclusiveResult);
		map.put("exclusiveList", exclusiveService.getAllExclusive());
		return "Exclusive";
	}

}
