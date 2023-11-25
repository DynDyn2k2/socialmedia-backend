package com.socialmedia.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.socialmedia.model.DetailNotification;
import com.socialmedia.model.Notifications;
import com.socialmedia.model.Pins;
import com.socialmedia.repository.DetailNotificationRepository;
import com.socialmedia.repository.NotificationRepository;
import com.socialmedia.repository.PinRepository;

@Service
public class DetailNotificationServiceImpl implements DetailNotificationService {

    @Autowired
    private DetailNotificationRepository repository;

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private PinRepository pinRepository;

    @Override
    public List<DetailNotification> findAllByPin(Pins pin) {
        return repository.findAllByPin(pin);
    }

    @Override
    public List<Pins> getRelatedPins(int notificationId) {
        List<Pins> result = new ArrayList<>();
        Notifications notifications = notificationRepository.findById(notificationId).get();
        repository.findAllByNotification(notifications).forEach(e -> {
            result.add(e.getPin());
        });
        return result;
    }

    @Override
    public void initDetailNotifications(int notificationId, List<Pins> pins) {
        Set<Pins> result = new HashSet<>();
        pins.forEach(e -> {
            // if (e.getType() != null) {
            result.addAll(pinRepository.findPinsByTypeId((long) e.getType().getId()));
            // }
        });
        result.forEach(e -> {
            DetailNotification detailNotification = new DetailNotification();
            detailNotification.setNotification(notificationRepository.findById(notificationId).get());
            detailNotification.setPin(e);
            repository.save(detailNotification);
        });
    }

    @Override
    public boolean delete(int id) {
        try {
            repository.deleteById(id);
            return true;
        } catch (EmptyResultDataAccessException ex) {
            System.out.println("Không tìm thấy thực thể để xóa");
            return false;
        } catch (DataIntegrityViolationException ex) {
            System.out.println("Lỗi liên quan đến tính toàn vẹn dữ liệu hoặc ràng buộc khóa ngoại");
            return false;
        }
    }
}
