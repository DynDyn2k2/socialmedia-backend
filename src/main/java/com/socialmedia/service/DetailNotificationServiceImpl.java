package com.socialmedia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.socialmedia.model.DetailNotification;
import com.socialmedia.model.Pins;
import com.socialmedia.repository.DetailNotificationRepository;
import java.util.List;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;

@Service
public class DetailNotificationServiceImpl implements DetailNotificationService {

    @Autowired
    private DetailNotificationRepository repository;

    @Override
    public List<DetailNotification> findAllByPin(Pins pin) {
        return repository.findAllByPin(pin);
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
