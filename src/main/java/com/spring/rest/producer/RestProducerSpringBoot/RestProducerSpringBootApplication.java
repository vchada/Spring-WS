package com.spring.rest.producer.RestProducerSpringBoot;

import java.util.HashMap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestProducerSpringBootApplication {

	public static HashMap<Long,Student> studentMap;
	 
	public static void main(String[] args)
	{
		
		  studentMap=new HashMap<Long,Student>();
		 
	      Student one=new Student("venkata","math");
	      studentMap.put(new Long(one.getId()),one);
	 
	      SpringApplication.run(RestProducerSpringBootApplication.class, args);
	 
	      Student two=new Student("Chada","history");
	      studentMap.put(new Long(two.getId()),two);
	      
	}
}
