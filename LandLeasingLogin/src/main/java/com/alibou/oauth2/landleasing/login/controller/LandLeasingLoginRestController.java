package com.alibou.oauth2.landleasing.login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibou.oauth2.landleasing.dbtest.Student;
import com.alibou.oauth2.landleasing.dbtest.StudentRepo;

@RestController
@RequestMapping("/dynamic/api/profile")
public class LandLeasingLoginRestController {
	@Autowired
	StudentRepo studentRepo;
	 @Autowired
	    private JdbcTemplate jdbcTemplate;
  @GetMapping
  public ResponseEntity<String> sayHello() {
    return ResponseEntity.ok("Thank you for login Land Leasing Site");
  }
  @GetMapping("/test")
	public List<Student> getStudent() {
		List<Student> students=studentRepo.findAll();
		System.out.println("under rest controller");
		   students.forEach(System.out :: println);
		return students;
		
	}
  @GetMapping(path="/test2")
	public List<Student> getStudentList() {
		 String sql = "SELECT * FROM Student where id in (1,2)";
       
	        List<Student> students = jdbcTemplate.query(sql,
	                BeanPropertyRowMapper.newInstance(Student.class));
	         
	        students.forEach(System.out :: println);
		//List<Student> students1=studentRepo.findAll();
		return students;
		
	}
}
