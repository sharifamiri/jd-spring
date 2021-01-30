package com.cybertek.controller;

import com.cybertek.model.Address;
import com.cybertek.model.ResponseWrapper;
import com.cybertek.model.Teacher;
import com.cybertek.repository.AddressRepository;
import com.cybertek.repository.ParentRepository;
import com.cybertek.repository.StudentRepository;
import com.cybertek.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ApiController {

    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ParentRepository parentRepository;
    @Autowired
    private AddressRepository addressRepository;

    @GetMapping("/teachers")
    public List<Teacher> readAllTeachers(){
        return teacherRepository.findAll();
    }

    @GetMapping("/students")
    public ResponseEntity<ResponseWrapper> readAllStudents(){
        return ResponseEntity
                .ok(new ResponseWrapper("students are successfully retrieved",
                        studentRepository.findAll()));
    }

    @GetMapping("/parents")
    public ResponseEntity<ResponseWrapper> readAllParents(){
        ResponseWrapper responseWrapper = new ResponseWrapper(true, "Parents are successfully retrieved",
                HttpStatus.ACCEPTED.value(), parentRepository.findAll());
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(responseWrapper);
    }

    @PutMapping("/address/{id}")
    public Address updateAddress(@PathVariable("id") Long id, @RequestBody Address address) throws Exception {
        Optional<Address> foundAddress = addressRepository.findById(id);
        if(!foundAddress.isPresent()){
            throw new Exception("Address does not exists");
        }

        address.setCurrentTemperature(new Address().consumeTemp(address.getCity()));
        address.setId(foundAddress.get().getId());

        return addressRepository.save(address);
    }
}
