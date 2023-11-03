package com.emp;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.emp.Repository.EmpRepos;
import com.emp.entity.Employee;

@SpringBootApplication
public class SpringJpaEmployeeApplication implements CommandLineRunner{
	@Autowired
	private EmpRepos er;
	public static void main(String[] args) {
		SpringApplication.run(SpringJpaEmployeeApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		Employee e1=new Employee();
		Scanner sc=new Scanner(System.in);
		int op=1;
		while(op==1)
		{
		System.out.println("enter what operation you want to perform");
		System.out.println("\n 1. add new employee details \n 2. display employee details by id  \n 3. display all employee details \n 4. delete employee by id \n 5. check employee by id \n 6. update emp details by id ");
		int ch=sc.nextInt();
		switch(ch)
		{
		case 1:
			   int n=1;
			   while(n==1)
		       {
			   System.out.println("enter name");
		       e1.setName(sc.next());
		       System.out.println("enter age");
		       e1.setAge(sc.nextInt());
		       er.save(e1);
		       System.out.println("successfully added");
		       System.out.println("if you want to continue press 1");
		       n=sc.nextInt();
		       }
			   break;

		case 2:
			   System.out.println("enter id to display details");
		       Employee fe= er.findById(sc.nextInt()).get();
		       System.out.println(fe);
		       break;
		       
		case 3:
			System.out.println("all employee details ");
		       List<Employee> lc=er.findAll();
		       lc.forEach((cc)->{
			   System.out.println(cc.toString());});
		       break;
		       
		case 4 :
			   System.out.println("enter id  to delete details of emp");
                er.deleteById(sc.nextInt());
                break;
		case 5:
			   System.out.println("enter id to chek employee with id present or not");
		        Boolean status=er.existsById(sc.nextInt());
		        System.out.println(status? "id is present":"id not present");
		        break;
		case 6:
			   System.out.println("enter id ");
		       Employee ee=er.findById(sc.nextInt()).get();
		       System.out.println("enter updated name");
		       ee.setName(sc.next());
		       System.out.println("enter age");
		       ee.setAge(sc.nextInt());
		       er.save(ee);
		       break;
		}
		System.out.println("if you want to continue operation again 1");
		op=sc.nextInt();
		}
	}
}
