package com.GestionEquipe.GestionEquipe.Services;

import java.util.List;

import com.GestionEquipe.GestionEquipe.dtos.MessageDto;
import com.GestionEquipe.GestionEquipe.model.Message;

public interface IMessageService {
	// public Message saveMes(Message message);
	//public Message updateMes(Message message, Integer id);

	public void deleteMesById(Integer id);

	public Message getMesById(Integer id);

	public void deleteMes(Message message);

	public List<Message> fetchMesList(Integer recipientId);

	public Message saveMes(Integer recipientId, MessageDto message);

}
