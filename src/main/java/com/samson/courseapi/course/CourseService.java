package com.samson.courseapi.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
//	private List<Course> topics = new ArrayList<>(Arrays.asList(
//			new Course("Spring", "Spring Framework", "Spring framework description"),
//			new Course("Java", "Core Java", "Core Java description"),
//			new Course("Javascript", "JavaScript", "Javascript description")
//			));
	
	public List<Course> getAllCourses(String id){
		//return topics;
		List<Course> courses = new ArrayList<>();
		courseRepository.findByTopicId(id).forEach(courses::add);
		
		return courses;
	}
	
	public Optional<Course> getCourse(String id) {
		//return topics.stream().filter(t ->t.getId().equals(id)).findFirst().get();
		return courseRepository.findById(id);
	}

	public void addCourse(Course topic) {
		//topics.add(topic);	
		
		((CrudRepository<Course, String>) courseRepository).save(topic);
	}

	public void updateCourse(Course course) {
		
//		for(int i=0; i < topics.size(); i++) {
//			Topic t = topics.get(i);
//			
//			//update if id equals to id in the parameter
//			if(t.getId().equals(id)) {
//				topics.set(i, topic);
//			}
//		}
		
		//update the topic. It compares the id to do either an insert or an update
		courseRepository.save(course);
		
	}

	public void deleteCourse(String id) {
		//topics.removeIf(t -> t.getId().equals(id));
		courseRepository.deleteById(id);
	}

	
}
