package com.learning.springbootsqs.service;

import com.learning.springbootsqs.config.AwsSQSConfig;
import com.learning.springbootsqs.model.Employee;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SQSService {

    @Autowired
    SqsTemplate sqsTemplate;

    public String postMessage(String msg) {
        sqsTemplate.send(sqsSendOptions ->
                        sqsSendOptions
                                .queue("EmployeeQueue")
                                .payload(msg)
                );
        return msg;
    }

    public void postEmployee(Employee employee) {
        sqsTemplate.send(sqsSendOptions ->
                sqsSendOptions
                        .queue("EmployeeQueue")
                        .payload(employee)
        );
    }
}
