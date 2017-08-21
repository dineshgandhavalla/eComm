package com.spring.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Blob;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
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

import com.spring.dao.CategoryDAO;
import com.spring.dao.ProductDAO;
import com.spring.dao.SupplierDAO;
import com.spring.model.Category;
import com.spring.model.Product;
import com.spring.service.ProductService;
 
@Controller
public class ProductController {
	
	@Autowired
	ProductDAO productDAO;

	@Autowired
	CategoryDAO categoryDAO;
	@Autowired
	SupplierDAO supplierDAO;
	
	private Path path;
	

	
	@Autowired
	private ProductService productService;
	
	
	   @RequestMapping(value="/product")
		public String setupForm(Map<String, Object> map,Model model)
		{
		   Product product = new Product();
			map.put("product", product);
			map.put("productList",productService.getAllProduct());
			model.addAttribute("categoryList", categoryDAO.list());
			model.addAttribute("supplierList", supplierDAO.list());
			return "Product";
		}
	
	
	@RequestMapping(value="/product.do", method=RequestMethod.POST)
	public String doActions(RedirectAttributes attributes,HttpServletRequest request,@ModelAttribute ("product")Product product, BindingResult result, @RequestParam String action, Map<String, Object> map,Model model)
            		throws Exception
	{
		Product productResult = new Product();
		 if (action.equals("Add"))
		 {
			 productResult = product;
			 MultipartFile file = product.getImage();
				String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		        path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\"+product.getId()+".jpg");
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
		        productService.add(product);
		 }
			 
		 if (action.equals("Edit"))
				 {
			 productService.edit(product);
			 productResult = product;
			
		 }
		 if (action.equals("Delete")){
			 productService.delete(product.getId());
			 productResult = new Product();
			
		 }
		 if (action.equals("Search")){
			 Product searchedProduct = productService.getProduct(product.getId());
			 productResult = searchedProduct!=null ? searchedProduct : new Product();
			
		}
		map.put("product", productResult);
		map.put("productList", productService.getAllProduct());
		model.addAttribute("categoryList", categoryDAO.list());
		model.addAttribute("supplierList", supplierDAO.list());
		return "Product";
	}


}
