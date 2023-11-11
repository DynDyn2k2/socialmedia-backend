package com.socialmedia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.socialmedia.model.Users;
import com.socialmedia.repository.UserRepository;
import java.util.Date;
import java.util.Optional;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public Users saveUser(Users user) {
        return repository.save(user);
    }

    @Override
    public List<Users> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public Users getUserByUsername(String username) {
        return repository.findOneByUsername(username);
    }

    @Override
    public Optional<Users> getUserById(int id) {
        return repository.findById(id);
    }


    @Override
    public Users getUserByPassword(String password) {
        return repository.findOneByPassword(password);
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
