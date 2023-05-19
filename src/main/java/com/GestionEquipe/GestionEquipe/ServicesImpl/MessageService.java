package com.GestionEquipe.GestionEquipe.ServicesImpl;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GestionEquipe.GestionEquipe.Repository.MembreEquipeRepository;
import com.GestionEquipe.GestionEquipe.Repository.MessageRepository;
import com.GestionEquipe.GestionEquipe.Services.IMessageService;
import com.GestionEquipe.GestionEquipe.Services.IUtilisateurService;
import com.GestionEquipe.GestionEquipe.dtos.MessageDto;
import com.GestionEquipe.GestionEquipe.model.Message;
import com.GestionEquipe.GestionEquipe.model.Utilisateur;
import com.GestionEquipe.GestionEquipe.utils.SecurityUtil;

@Service
public class MessageService implements IMessageService {
    @Autowired
    private MessageRepository messageRepository;
    
    @Autowired
    private IUtilisateurService userService;

    @Autowired
    private MembreEquipeRepository  membreEquipeRepository;
    /*@Override
    public Message saveMes(Message message) {
        MembreEquipe membreEquipe =membreEquipeRepository.findById(message.getMembre().getId()).get();
        message.setMembre(membreEquipe);
        Message messageToReturn = messageRepository.save(message);
        return messageToReturn;
    }*/

    /*@Override
    public Message updateMes(Message message, Integer id) {
        Message messageDB
                = messageRepository.findById(id).get();


        if (Objects.nonNull(message.getDestinataire())
                && !"".equalsIgnoreCase(message.getDestinataire())) {
            messageDB.setDestinataire(
                    message.getDestinataire());
        }
        if (Objects.nonNull(message.getDestinateur())
                && !"".equalsIgnoreCase(message.getDestinateur())) {
            messageDB.setDestinateur(
                    message.getDestinateur());
        }
        if (Objects.nonNull(message.getTexteMsg())
                && !"".equalsIgnoreCase(message.getTexteMsg())) {
            messageDB.setTexteMsg(
                    message.getTexteMsg());
        }
        if (Objects.nonNull(message.getDateCreation())
                && !"".equalsIgnoreCase(String.valueOf(message.getDateCreation()))) {
            messageDB.setDateCreation(
                    message.getDateCreation());
        }
        return messageRepository.save(messageDB);
    }*/

    // Read all raws

    @Override public List<Message> fetchMesList(Integer recipientId)
    {
    	Utilisateur currentuser = userService.getCurrentUser();
    	Utilisateur receipt = userService.getUserById(recipientId);
        return 
                messageRepository.findAll(receipt, currentuser);
    }

    //read raw by id
    @Override

    public Message getMesById(Integer id)
    {
        return messageRepository.findById(id).orElse(null);
    }
    // Delete raw by id
    @Override
    public void deleteMesById(Integer id)
    {
        messageRepository.deleteById(id);
    }
    //delete all raws
    @Override
    public void deleteMes(Message message)
    {
        messageRepository.deleteAll();
    }

	@Override
	public Message saveMes(Integer recipientId, MessageDto messageDto) {
		Utilisateur currentuser = userService.getCurrentUser();
		Utilisateur recipient = userService.getUserById(recipientId);
		Message message = Message.builder().createdAt(new Date()).recipient(recipient).sender(currentuser).texteMsg(messageDto.getTexteMsg()).build();
		return messageRepository.save(message);
	}
}