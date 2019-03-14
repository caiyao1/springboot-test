package com.example.springboottest;

import com.example.springboottest.entity.Course;
import com.example.springboottest.entity.Elective;
import com.example.springboottest.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback(value=false)
public class SpringbootTestApplicationTests {

    @PersistenceContext
	private EntityManager em;
	@Test
	public void addCourseStudentTest() {
		Course c1=new Course("java程序设计");
		em.persist(c1);
		Course c2=new Course("数据库原理");
		em.persist(c2);
		Student s1=new Student("欢欢");
		em.persist(s1);
		Student s2=new Student("盈盈");
		em.persist(s2);
	}

	@Test
	public void addCourseStudentTest1(){
		var c1=em.find(Course.class, 1);
		var s1=em.find(Student.class, 2);
		Elective e1=new Elective();
		e1.setCourse(c1);
		e1.setStudent(s1);
		em.persist(e1);
	}
}
