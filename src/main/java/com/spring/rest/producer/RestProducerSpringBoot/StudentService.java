package com.spring.rest.producer.RestProducerSpringBoot;

import java.util.HashMap;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rest/student")
public class StudentService 
{
	//Getting values in map using GET 
	@RequestMapping(value="/",method = RequestMethod.GET)
	public HashMap<Long,Student> getAllStudents()
	{
	      return RestProducerSpringBootApplication.studentMap;
	}
	
	//Getting student by ID
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Student getStudent(@PathVariable long id)
	{
		return RestProducerSpringBootApplication.studentMap.get(new Long(id));
	}
	
	//adding new values to the map via POST
	@RequestMapping(value="/add",method = RequestMethod.POST)
	public Student addStudent(@RequestBody Student newStudent)
	{
	 //@RequestParam(value="name") String name,@RequestParam(value="subject",defaultValue = "unknown") String subject
	   Student student=new Student(newStudent.getName(),newStudent.getSubject());
	   RestProducerSpringBootApplication.studentMap.put(new Long(student.getId()),student);
	   return student;
	 
	}
	
	//updating values using PUT 
	@RequestMapping(value="/update",method = RequestMethod.PUT)
	public Student updateStudent(@RequestBody Student student) throws Exception {
	 
	   if(RestProducerSpringBootApplication.studentMap.containsKey(new Long(student.getId())))
	   {
		   RestProducerSpringBootApplication.studentMap.put(new Long(student.getId()),student);
	   }
	   else
	   {
	      throw new Exception("Student "+student.getId()+" does not exists");
	   }
	 
	   return student;
	}
	
	//delete values using delete 
	@RequestMapping(value="/delete/{id}",method = RequestMethod.DELETE)
	public Student deleteStudent(@PathVariable long id) throws Exception {
	 
	   Student student;
	 
	   if(RestProducerSpringBootApplication.studentMap.containsKey(new Long(id))){
	      student=RestProducerSpringBootApplication.studentMap.get(new Long(id));
	      RestProducerSpringBootApplication.studentMap.remove(new Long(id));
	   }else{
	      throw new Exception("Student "+id+" does not exists");
	   }
	   return student;
	}
}
