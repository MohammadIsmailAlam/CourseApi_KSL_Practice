package springbootstarter.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class TopicController {


    private TopicService topicService;

    TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @RequestMapping("/topics")
    public List<Topic> getAllTopics(){
        return topicService.getAllTopics();
    }

    @RequestMapping("/topics/{id}")
    public Topic getTopic(@PathVariable String id){

        return topicService.getTopic(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "topics")
    public void addTopic(@RequestBody Topic topic){

        topicService.addTopic(topic);


//    public int addTopic(@RequestBody Topic){
//       return topicService.addTopic(topic);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/update/{id}")
    public List<Topic> updateTopic(@RequestBody Topic topic, @PathVariable String id) {
        System.out.printf(id);
        return topicService.updateTopic(id, topic);

    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/delete/{id}")
    public List<Topic> deleteTopic(@PathVariable String id) {
        return topicService.removeTopic(id);

    }
}