package com.socialmedia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.socialmedia.model.Likes;
import com.socialmedia.model.Pins;
import com.socialmedia.repository.LikeRepository;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;

@Service
public class LikeServiceImpl implements LikeService {

    @Autowired
    private LikeRepository repository;

    @Override
    public List<Likes> findAllByPin(Pins pin) {
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

    @Override
    public long countAll() {
        return repository.count();
    }

    @Override
    public long countByCreatedAtBefore(Date date) {
        return repository.countByCreatedAtBefore(date);
    }

    @Override
    public long countByCreatedAt(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = dateFormat.format(date);
        return repository.countByCreatedAt(formattedDate);
    }

    @Override
    public long countByCreatedAt(Date date1, Date date2) {
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate1 = dateFormat1.format(date1);

        SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate2 = dateFormat2.format(date2);
        return repository.countByCreatedAt(formattedDate1, formattedDate2);
    }

}
