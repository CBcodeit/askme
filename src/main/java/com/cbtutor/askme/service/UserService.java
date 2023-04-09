package com.cbtutor.askme.service;

import com.cbtutor.askme.enums.Topic;
import com.cbtutor.askme.modal.Student;
import com.cbtutor.askme.modal.TeachingAssistant;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Getter
public class UserService {

    private static List<Student> students = new ArrayList<>();
    private static List<TeachingAssistant> teachingAssistants = new ArrayList<>();

    public static List<Student> createStudent(){
        students.add(new Student(1,"Virat",90));
        students.add(new Student(2,"Shubman",80));
        students.add(new Student(3,"Pant",70));
        return students;
    }

    public static List<TeachingAssistant> createTeachingAssistant(){
        TeachingAssistant t1= new TeachingAssistant(1,"Sachin",600);
        t1.getTopicSet().add(Topic.HLD);
        t1.getTopicSet().add(Topic.DSA);
        TeachingAssistant t2= new TeachingAssistant(1,"Laxman",440 );
        t2.getTopicSet().add(Topic.ADMISSION);
        TeachingAssistant t3= new TeachingAssistant(1,"Rahul",300);
        t3.getTopicSet().add(Topic.LLD);
        t3.getTopicSet().add(Topic.DSA);
        teachingAssistants.add(t1);
        teachingAssistants.add(t2);
        teachingAssistants.add(t3);
        return teachingAssistants;
    }
}
