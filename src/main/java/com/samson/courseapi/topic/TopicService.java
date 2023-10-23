package com.samson.courseapi.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	private List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("Spring", "Spring Framework", "Spring framework description"),
			new Topic("Java", "Core Java", "Core Java description"),
			new Topic("Javascript", "JavaScript", "Javascript description")
			));
	
	public List<Topic> getAllTopics(){
		//return topics;
		List<Topic> topics = new ArrayList<>();
		((CrudRepository<Topic, String>) topicRepository).findAll().forEach(topics::add);
		
		return topics;
	}
	
	public Optional<Topic> getTopic(String id) {
		//return topics.stream().filter(t ->t.getId().equals(id)).findFirst().get();
		return topicRepository.findById(id);
	}

	public void addTopic(Topic topic) {
		//topics.add(topic);	
		
		((CrudRepository<Topic, String>) topicRepository).save(topic);
	}

	public void updateTopic(String id, Topic topic) {
		
//		for(int i=0; i < topics.size(); i++) {
//			Topic t = topics.get(i);
//			
//			//update if id equals to id in the parameter
//			if(t.getId().equals(id)) {
//				topics.set(i, topic);
//			}
//		}
		
		//update the topic. It compares the id to do either an insert or an update
		topicRepository.save(topic);
		
	}

	public void deleteTopic(String id) {
		//topics.removeIf(t -> t.getId().equals(id));
		topicRepository.deleteById(id);
	}
}
