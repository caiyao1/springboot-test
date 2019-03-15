package com.example.springboottest.repository;

import com.example.springboottest.entity.Course;
import com.example.springboottest.entity.Elective;
import com.example.springboottest.entity.Student;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class ElectiveRepository {
    @PersistenceContext
    private EntityManager em;
    public void addElective(){
        Course c1=new Course("软件工程导论");
        em.persist(c1);
        Student s1=new Student("妮妮");
        em.persist(s1);
        var c2=em.find(Course.class, 2);
        var s2=em.find(Student.class, 1);
        Elective e1=new Elective();
        e1.setCourse(c2);
        e1.setStudent(s2);
        em.persist(e1);
    }

}
