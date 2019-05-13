package com.school.school_service.Controller;

import com.school.school_service.model.StudentInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;

@RestController
public class SchoolServiceController {
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/getSchoolDetails/{schoolname}", method = RequestMethod.GET)
    public String getStudents(@PathVariable String schoolname)
    {
        System.out.println("Getting School details for " + schoolname);

        String response = restTemplate.exchange("http://student-service/api/getStudentDetailsForSchool/{schoolname}",
                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}, schoolname).getBody();

        System.out.println("Response Received as " + response);

        return "School Name -  " + schoolname + " \n Student Details " + response;
    }

    @RequestMapping(value = "/api/addStudent", method = RequestMethod.POST)
    public StudentInfo getStudents(@Valid @RequestBody StudentInfo studentInfo)
    {
        System.out.println("Getting School details for " + studentInfo);
        final String uri ="http://student-service/api/addStudent";
            StudentInfo studentInfoResponse=restTemplate.postForObject(uri,studentInfo,StudentInfo.class);
        return studentInfoResponse;
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
