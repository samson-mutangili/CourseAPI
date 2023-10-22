package com.samson.courseapi.topic;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	private List<Topic> topics = Arrays.asList(
			new Topic("Spring", "Spring Framework", "Spring framework description"),
			new Topic("Java", "Core Java", "Core Java description"),
			new Topic("Javascript", "JavaScript", "Javascript description")
			);
	
	public List<Topic> getAllTopics(){
		return topics;
	}
}
