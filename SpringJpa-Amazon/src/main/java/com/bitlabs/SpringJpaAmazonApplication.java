package com.bitlabs;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bitlabs.entity.Amazon;
import com.bitlabs.repository.amazonrepos;

@SpringBootApplication
public class SpringJpaAmazonApplication implements CommandLineRunner{
	private amazonrepos ar;
	
	public SpringJpaAmazonApplication(amazonrepos ar) {
		super();
		this.ar = ar;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaAmazonApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Amazon a=new Amazon();
		a.setName("shirt");
		ar.save(a);
		
	}

}
