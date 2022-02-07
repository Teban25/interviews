package com.quickreview.interviews.service;

import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2ClientBuilder;
import com.amazonaws.services.ec2.model.*;
import com.quickreview.interviews.model.InstanceDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AWSExamples {

    public List<InstanceDto> describeInstances() {
        AmazonEC2 ec2 = AmazonEC2ClientBuilder.defaultClient();
        boolean done = false;
        List<InstanceDto> instancesDtos = new ArrayList<>();

        DescribeInstancesRequest describeInstancesRequest = new DescribeInstancesRequest();
        while (!done) {
            DescribeInstancesResult response = ec2.describeInstances(describeInstancesRequest);

            for (Reservation reservation : response.getReservations()) {
                for (Instance instance : reservation.getInstances()) {
                    InstanceDto instanceDto = new InstanceDto();
                    if (instance.getTags() != null && !instance.getTags().isEmpty()) {
                        Map<String, String> tags = new HashMap<>();
                        for (Tag tag: instance.getTags()) {
                            tags.put(tag.getKey(), tag.getValue());
                        }
                        instanceDto.setTags(tags);
                    }
                    instanceDto.setInstanceId(instance.getInstanceId());
                    instanceDto.setImageId(instance.getImageId());
                    instanceDto.setInstanceType(instance.getInstanceType());
                    instanceDto.setStateName(instance.getState().getName());
                    instanceDto.setMonitoringState(instance.getMonitoring().getState());
                    instancesDtos.add(instanceDto);
                }
            }

            describeInstancesRequest.setNextToken(response.getNextToken());

            if (response.getNextToken() == null) {
                done = true;
            }
        }

        return instancesDtos;
    }
}
