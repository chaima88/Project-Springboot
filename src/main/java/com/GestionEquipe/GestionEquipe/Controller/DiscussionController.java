package com.GestionEquipe.GestionEquipe.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/disc")
public class DiscussionController {

//    @Autowired
//    private IDiscussionService iDiscussionService;
//
//    @Autowired
//    private EquipeRepository equipeRepository;
//
//    @PostMapping("/save")
//    public Discussion SaveDiscussion(@RequestBody Discussion discussion){
//        Discussion discussionToReturn = iDiscussionService.saveDisc(discussion);
//        Equipe equipe = equipeRepository.findById(discussion.getEquipe().getIdEquipe()).get();
//        equipe.setDiscussion(discussionToReturn);
//        equipeRepository.saveAndFlush(equipe);
//        return discussionToReturn;
//    }
//
//
//    // Read raw by id
//
//    @GetMapping("/allDisc")
//
//    public List<Discussion> fetchDiscussionList()
//    {
//        return iDiscussionService.fetchDiscList();
//    }
//
//    // Read All Raws
//    @GetMapping("/getbyid/{id}")
//
//    public Discussion getDiscussionById(@PathVariable("id")
//                                      Integer id)
//    {
//        return iDiscussionService.getDiscById(id);
//
//    }
//    // Delete raw by id
//    @DeleteMapping("/delDisc/{id}")
//
//    public String deleteDiscussionById(@PathVariable("id")
//                                        Integer id)
//    {
//        iDiscussionService.deleteDiscById(
//                id);
//        return "Deleted by id Successfully";
//    }
//
//
//
//    //delete all raws
//
//    @DeleteMapping("/deleteAll")
//    public String deleteDiscussion(Discussion discussion)
//    {
//        iDiscussionService.deleteDisc(discussion);
//        return "Deleted Successfully";
//    }
}
