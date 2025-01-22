package org.test.service;

import org.springframework.stereotype.Service;
import org.test.model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class StudentService {

    //Todo - use data jpa
    private List<Student> studentFinalList=new ArrayList<>();
    private HashMap<String,Student> studentHashMap=new HashMap<>();

    public List<Student> getAllStudents() {
        return studentFinalList;
    }

    public List<Student> getAllStudentsByName(String name) {
        List<Student> studentList=new ArrayList<>();
        for(Student student:studentFinalList) {
            if(student.getName().toLowerCase().equals(name.toLowerCase()))
                studentList.add(student);
        }
        return studentList;
    }

    public void addStudent(Student student) throws RuntimeException {
        if(!studentHashMap.containsKey(student.getPhoneNumber())){
            studentFinalList.add(student);
            studentHashMap.put(student.getPhoneNumber(),student);
        }
        else{
            throw new RuntimeException("Entry with phone number : "+student.getPhoneNumber()+" already exists.");
        }
    }

    public void deleteStudent(String phoneNumber) {
        if(studentHashMap.containsKey(phoneNumber)){
            studentFinalList.removeIf(student -> student.getPhoneNumber().equals(phoneNumber));
            studentHashMap.remove(phoneNumber);
        }
        else{
            throw new RuntimeException("No entry present with phone number : "+phoneNumber);
        }
    }

    public void updateStudent(Student student, String phoneNumber) {
        if(studentHashMap.containsKey(phoneNumber)) {
            Student studentToUpdate = studentHashMap.get(phoneNumber);
            studentToUpdate.setAge(student.getAge());
            studentToUpdate.setName(student.getName());
            studentToUpdate.setClassName(student.getClassName());
            studentToUpdate.setPhoneNumber(student.getPhoneNumber());
            studentHashMap.remove(phoneNumber);
            studentHashMap.put(student.getPhoneNumber(),studentToUpdate);
        }
        else{
            throw new RuntimeException("No entry present with phone number : "+phoneNumber);
        }
    }
}
