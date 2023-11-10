package com.socialmedia.service;

import com.socialmedia.model.Boards;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.socialmedia.model.Pins;
import com.socialmedia.model.Users;
import com.socialmedia.repository.PinRepository;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;

@Service
public class PinServiceImpl implements PinService {

    @Autowired
    private PinRepository repository;

    @Override
    public List<Pins> findByUserOrderByIdAsc(Users user) {
        return repository.findByUserOrderByIdAsc(user);
    }

    @Override
    public List<Pins> getPinsByTypeId(Long typeId) {
        return repository.findPinsByTypeId(typeId);
    }

    @Override
    public List<Pins> getAllPins() {
        return repository.findAll();
    }

    @Override
    public List<Pins> getPinsByUser(Optional<Users> user) {
        return repository.findByUser(user);
    }

    @Override
    public Optional<Pins> getPinById(int id) {
        return repository.findById(id);
    }

    @Override
    public Pins save(Pins pin) {
        return repository.save(pin);
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

    @Override
    public long countAll() {
        return repository.count();
    }

    @Override
    public long countByCreatedAtBefore(Date date) {
        return repository.countByCreatedAtBefore(date);
    }

}
