package com.alibou.oauth2.landleasing.dbtest;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/dynamic/api/student")
public class StudentController {
	@Autowired
	StudentRepo studentRepo;
//	 @Autowired
//    private JdbcTemplate jdbcTemplate;

	@GetMapping
	public List<Student> getStudent() {
		List<Student> students=studentRepo.findAll();
		return students;
		
	}
	
//	 @GetMapping
//	  public ResponseEntity<String> sayHello() {
//	    return ResponseEntity.ok("Student Thank you for login Land Leasing Site");
//	  }
//	@GetMapping("/studentList")
//	public List<Student> getStudentList() {
//		 String sql = "SELECT * FROM Student where id in (1,2)";
//         
//	        List<Student> students = jdbcTemplate.query(sql,
//	                BeanPropertyRowMapper.newInstance(Student.class));
//	         
//	        students.forEach(System.out :: println);
//		//List<Student> students1=studentRepo.findAll();
//		return students;
//		
//	}
}