package com.socialmedia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.socialmedia.model.Friendships;
import com.socialmedia.model.Pins;
import com.socialmedia.repository.FriendshipRepository;
import java.util.List;
import com.socialmedia.model.Users;
import java.util.Optional;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;

@Service
public class FriendshipServiceImpl implements FriendshipService {

    @Autowired
    private FriendshipRepository repository;

    @Override
    public List<Friendships> getAllByUser1AndStatus(Users user, Friendships.FriendshipStatus status) {
        return repository.findAllByUser1AndStatus(user, status);

    }

    @Override
    public List<Friendships> getAllByUser2AndStatus(Users user, Friendships.FriendshipStatus status) {
        return repository.findAllByUser2AndStatus(user, status);
    }

    @Override
    public List<Friendships> getAllByUser1(Users user) {
        return repository.findAllByUser1(user);
    }

    @Override
    public List<Friendships> getAllByUser2(Users user) {
        return repository.findAllByUser2(user);
    }

    @Override
    public Optional<Friendships> getById(int id) {
        return repository.findById(id);
    }

    @Override
    public Friendships save(Friendships friendship) {
        return repository.save(friendship);
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
    public Friendships getOneByUser1AndUser2(Users user1, Users user2) {
        return repository.findOneByUser1AndUser2(user1, user2);
    }
    
}
