package com.socialmedia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.socialmedia.model.Comments;
import com.socialmedia.model.Pins;
import com.socialmedia.repository.CommentRepository;
import java.util.Date;
import java.util.List;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository repository;

    @Override
    public List<Comments> getAll() {
        return repository.findAll();
    }
    
    @Override
    public Comments saveComment(Comments comment) {
        return repository.save(comment);
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
        return repository.countByCommentAtBefore(date);
    }

    @Override
    public List<Comments> findAllByPin(Pins pin) {
        return repository.findAllByPin(pin);
    }
}
