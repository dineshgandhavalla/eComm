package com.spring.service;

import java.util.ArrayList;
import java.util.List;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.CartDAO;
import com.spring.dao.UserDAO;
import com.spring.model.Cart;
import com.spring.model.Order;
import com.spring.model.Users;


@Service
public class MailServiceImpl implements MailService {

	 @Autowired
	    JavaMailSender mailSender;
	 @Autowired
	 	CartDAO cartDAO;
	 @Autowired
	 	UserDAO userDAO;
	 
	  @SuppressWarnings("unchecked")
	@Transactional
	    public void sendEmail(int userid) {
			 
	        Users userOrder = userDAO.getUser(userid);
	        
	        List<Cart> cart = cartDAO.getCartByUser(userid);
	        
	 
	        MimeMessagePreparator preparator = getContentWtihAttachementMessagePreparator(userOrder,cart);
	 
	        try {
	            mailSender.send(preparator);
	            System.out.println("Message With Attachement has been sent.............................");
	            } catch (MailException ex) {
	            System.err.println(ex.getMessage());
	        }
	    }
	 
	
	  private MimeMessagePreparator getContentWtihAttachementMessagePreparator(final Users userOrder,final List<Cart> cart) {
	 
	        MimeMessagePreparator preparator = new MimeMessagePreparator() {
	 
	            public void prepare(MimeMessage mimeMessage) throws Exception {
	                MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
	 
	                helper.setSubject("Your order has been placed");
	                helper.setFrom("naveen.chilakala0123@gmail.com");
	                helper.setTo(userOrder.getEmail());
	                ArrayList<String> list = new ArrayList<String>();
	                for(Cart c:cart)
	                {
	                
	                	list.add(	"Dear " + userOrder.getName()
	                        + ", thank you for placing order. Your order id is " + c.getOrderId() + ".");
	                
	                
	                }
	                String listString = "";

	                for (String s : list)
	                {
	                    listString += s + "\t";
	                }

	                System.out.println(listString);
	                
	                helper.setText(listString);
	    	      
	                
	               
	 
	                // Add a resource as an attachment
	               /* helper.addAttachment("cutie.png", new ClassPathResource("rv_1-gito-1.jpg"));
	 */
	            }
	        };
	        return preparator;
	    }
	 

}