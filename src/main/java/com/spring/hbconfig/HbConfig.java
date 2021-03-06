package com.spring.hbconfig;

import java.util.Properties;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.spring.dao.CategoryDAO;
import com.spring.dao.CategoryDAOImpl;
import com.spring.dao.ProductDAO;
import com.spring.dao.ProductDAOImpl;
import com.spring.dao.SupplierDAO;
import com.spring.dao.SupplierDAOImpl;
import com.spring.model.Card;
import com.spring.model.Cart;
import com.spring.model.Category;
import com.spring.model.Order;
import com.spring.model.Product;
import com.spring.model.Supplier;
import com.spring.model.Users;

@Configuration
@ComponentScan("com.spring")
@EnableTransactionManagement
public class HbConfig {

	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
		dataSource.setUsername("sa");
		dataSource.setPassword(""); 
		System.out.println("Datasource");
		return dataSource;

	}

	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		/*properties.put("hbm2ddl.auto", "create");*/
		properties.put("hibernate.hbm2ddl.auto", "update");
		System.out.println("Hibernate Properties");
		return properties;

	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClasses(Users.class);
		sessionBuilder.addAnnotatedClasses(Category.class);
		sessionBuilder.addAnnotatedClasses(Product.class);
		sessionBuilder.addAnnotatedClasses(Supplier.class);
		sessionBuilder.addAnnotatedClasses(Cart.class);
		sessionBuilder.addAnnotatedClasses(Card.class);
		sessionBuilder.addAnnotatedClasses(Order.class);
		System.out.println("Session");
		
		return sessionBuilder.buildSessionFactory();
		
	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		System.out.println("Transaction");
		return transactionManager;
	}

	
	@Autowired
	@Bean(name = "supplierDAO")
	public SupplierDAO getSupplierDetailsDAO(SessionFactory sessionFactory) {
			return new SupplierDAOImpl(sessionFactory);
	}
	
	@Autowired
	@Bean(name = "categoryDAO")
	public CategoryDAO getcategoryDetailsDAO(SessionFactory sessionFactory) {
			return new CategoryDAOImpl(sessionFactory);
	}
	
	@Autowired
	@Bean(name = "productDAO")
	public ProductDAO getproductDetailsDAO(SessionFactory sessionFactory) {
			return new ProductDAOImpl(sessionFactory);
	}
	
	@Bean
    public JavaMailSender getMailSender(){
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        //Using gmail       
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername("naveen.chilakala0123@gmail.com");
        mailSender.setPassword("naveen007");
         
        Properties javaMailProperties = new Properties();
        javaMailProperties.put("mail.smtp.starttls.enable", "true");
        javaMailProperties.put("mail.smtp.auth", "true");
        javaMailProperties.put("mail.transport.protocol", "smtp");
        javaMailProperties.put("mail.debug", "true");
         
         
        mailSender.setJavaMailProperties(javaMailProperties);
        return mailSender;
    }
}