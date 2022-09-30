package springbootstarter.topic;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {
    private List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic("spring", "Spring Framework","Spring Framework Description"),
                new Topic("java", "Core Java Framework","Core Java Framework Description"),
                new Topic("object", "Object Framework","Object Framework Description")
        )
    );

    public List<Topic> getAllTopics() {
        return topics;
    }

    public Topic getTopic(String id){
        return topics.stream().filter(topic -> topic.getId().equals(id)).findFirst().get();
    }

    public void addTopic(Topic topic){
        topics.add(topic);
//    public int addTopic(Topic topic) {
//        int a = topics.size();
//        topics.add(topic);
//        int b = topics.size();
//        return b-a;

    }


    public List<Topic> updateTopic(String id, Topic topic) {
        //System.out.printf(topic.getDescription());
        for (int i = 0; i< topics.size(); i++){
            Topic oldTopic = topics.get(i);
            if (oldTopic.getId().equalsIgnoreCase(id)){
                topics.set(i, topic);
            }
        }
        return topics;
    }

    public List<Topic> removeTopic(String id) {
        for (int i = 0; i< topics.size(); i++){
            Topic oldTopic = topics.get(i);
            if (oldTopic.getId().equalsIgnoreCase(id)){
                topics.remove(i);
            }
        }
        return topics;
    }
}
