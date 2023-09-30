package com.socialmedia.repository;

import com.socialmedia.model.Participants;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantRepository extends JpaRepository<Participants,Integer> {


}