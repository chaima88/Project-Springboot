package com.GestionEquipe.GestionEquipe.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.GestionEquipe.GestionEquipe.model.Message;
import com.GestionEquipe.GestionEquipe.model.Utilisateur;

@Repository
public interface MessageRepository extends JpaRepository<Message,Integer> {

    //public List<Message> findByDiscussion_idDicuss(Integer idDicuss);
	@Query("SELECT m FROM Message m WHERE (m.recipient = :recipient AND m.sender = :sender) OR (m.recipient = :sender AND m.sender = :recipient)")
	public List<Message> findAll(@Param("recipient")Utilisateur recipient,@Param("sender") Utilisateur sender);
	//public List<Message> findByRecipientIdAndSenderIdOrSenderIdAndRecipientId(Integer RecipientId, Integer senderId, Integer RecipientId1, Integer senderId1);
}
