package com.GestionEquipe.GestionEquipe.ServicesImpl;

import org.springframework.stereotype.Service;

import com.GestionEquipe.GestionEquipe.Services.IDiscussionService;

@Service
public class DiscussionService implements IDiscussionService {
//    @Autowired
//    private DiscussionRepository discussionRepository;
//
//    @Override
//    public Discussion saveDisc(Discussion discussion) {
//        Discussion discussionToReturn = discussionRepository.save(discussion);
//        return discussionToReturn;
//    }
//
//    //@Override
//    // public Discussion updateDiscussion(Discussion discussion, Integer id) {
//    // Discussion discussionDB
//    //= discussionRepository.findById(id).get();
//
//
//
//    // Read all raws
//
//    @Override public List<Discussion> fetchDiscList()
//    {
//        return (List<Discussion>)
//                discussionRepository.findAll();
//    }
//
//    //read raw by id
//    @Override
//
//    public Discussion getDiscById(Integer id)
//    {
//        return discussionRepository.findById(id).orElse(null);
//    }
//    // Delete raw by id
//    @Override
//    public void deleteDiscById(Integer id)
//    {
//        discussionRepository.deleteById(id);
//    }
//    //delete all raws
//    @Override
//    public void deleteDisc(Discussion discussion)
//    {
//        discussionRepository.deleteAll();
//    }

}