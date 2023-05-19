package com.GestionEquipe.GestionEquipe.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.GestionEquipe.GestionEquipe.Repository.MessageRepository;
import com.GestionEquipe.GestionEquipe.Services.IMessageService;
import com.GestionEquipe.GestionEquipe.dtos.MessageDto;
import com.GestionEquipe.GestionEquipe.model.Message;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private IMessageService iMessageService;

    @Autowired
    private MessageRepository  messageRepository;
   /* @PostMapping("/save")
    public Message SaveMessage(@RequestBody Message message){
        Message messageToReturn = iMessageService.saveMes(message);
        return messageToReturn;
    }*/
    @PostMapping("/save")
    public Message SaveMessage(@RequestParam("destinataire")Integer recipientId, @RequestBody MessageDto message){
        Message messageToReturn = iMessageService.saveMes(recipientId, message);
        return messageToReturn;
    }
    /*@PutMapping("/update/{id}")
    public Message updateMessage(@RequestBody Message message,
                                         @PathVariable("id") Integer id)
    {
        return iMessageService.updateMes(message,id);
    }*/

    // Read raw by id

    @GetMapping("/getAll")

    public List<Message> fetchMessageList(@RequestParam("destinataire")Integer recipientId)
    {
        return iMessageService.fetchMesList(recipientId);
    }

    // Read All Raws
    @GetMapping("/getbyid/{id}")

    public Message getMessage(@PathVariable("id")
                                      Integer id)
    {
        return iMessageService.getMesById(id);

    }
    // Delete raw by id
    @DeleteMapping("/deleteByid/{id}")

    public String deleteMessageById(@PathVariable("id")
                                        Integer id)
    {
        iMessageService.deleteMesById(
                id);
        return "Deleted by id Successfully";
    }



    //delete all raws

    @DeleteMapping("/deleteAll")
    public String deleteMessage(Message message)
    {
        iMessageService.deleteMes(message);
        return "Deleted Successfully";
    }
//    @GetMapping("/getByidDis/{idDis}")
//    public List<Message> messageByDisc(@PathVariable Integer idDis){
//        return messageRepository.findByDiscussion_idDicuss(idDis);
//    }
}



