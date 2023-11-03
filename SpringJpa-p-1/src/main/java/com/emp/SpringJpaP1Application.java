package com.emp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.emp.entity.Company;
import com.emp.repos.CompRepos;

@SpringBootApplication
public class SpringJpaP1Application implements  CommandLineRunner{
	@Autowired
	private CompRepos crp;
	public static void main(String[] args) {
		SpringApplication.run(SpringJpaP1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Company c1=new Company();
		crp.save(c1);
		/*c1.setName("Accenture");
		c1.setCity("hyderabad");
		
		crp.save(c1);
		
		Company c2=new Company();
		c2.setName("infosys");
		c2.setCity("banglore");
		Company c3=new Company();
		c3.setName("Deliote");
		c3.setCity("hyderabad");
		
		crp.saveAll(List.of(c2, c3));
		Integer id=1;
		Company ce=crp.findById(id).get();
		System.out.println(ce.toString());
		*/
		
		List<Company> lc=crp.findAll();
		lc.forEach((cc)->{
			System.out.println(cc.getName()+"  "+cc.getCity());
		}
		);
		
	}

}
