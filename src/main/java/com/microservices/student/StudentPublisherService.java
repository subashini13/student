package com.microservices.student;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
/**
 * Creates a student message and publishes on student-detail topic.
 * 
 *Command to create kafka topic in docker.
 * kafka-topics.sh --create --bootstrap-server kafka:9092 --replication-factor 1 --topic student-detail --partitions 1
 * @author User
 *
 */
@Configuration
public class StudentPublisherService {

	private KafkaTemplate<Integer, Student> kafkaTemplate;
	private final String KAFKA_TOPIC = "student-detail";

	public StudentPublisherService(KafkaTemplate<Integer, Student> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public void sendStudentDetails(Student student) {
		System.out.println("came in!!" + student.getName());

		kafkaTemplate.send(KAFKA_TOPIC,student.getRoll_no(), student);

	}

}
