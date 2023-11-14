package com.socialmedia.repository;

import com.socialmedia.model.DetailNotification;
import com.socialmedia.model.Pins;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailNotificationRepository extends JpaRepository<DetailNotification, Integer> {

    public List<DetailNotification> findAllByPin(Pins pin);

}
