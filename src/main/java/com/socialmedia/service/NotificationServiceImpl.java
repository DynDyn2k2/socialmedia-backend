package com.socialmedia.service;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.socialmedia.model.Notifications;
import com.socialmedia.repository.NotificationRepository;

import jakarta.transaction.Transactional;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationRepository repository;

    @Override
    public Notifications saveNotifications(Notifications not) {
        // TODO Auto-generated method stub
        return repository.save(not);
    }

    @Override
    public List<Notifications> getAllNotifications() {
        return repository.findAll();
    }

    @Override
    public List<Notifications> readNotificationsFromCsv(String csvPart) {
        return null;
    }

    @Transactional
    public void uploadCSVdata(String csvFilePath) throws IOException {
        CSVReader reader = new CSVReader(new FileReader(csvFilePath));
        String[] line;
        try {
            while ((line = reader.readNext()) != null) {
                Notifications not = new Notifications();
                not.setNotificationId(Integer.parseInt(line[0]));

            }
        } catch (CsvValidationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}