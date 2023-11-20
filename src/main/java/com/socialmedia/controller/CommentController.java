package com.socialmedia.controller;

import com.socialmedia.model.Comments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.socialmedia.service.CommentService;
import com.socialmedia.service.PinService;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/comments")
@CrossOrigin

public class CommentController {
    @Autowired
    private CommentService commentService;
    @Autowired
    private PinService pinService;

    @GetMapping("/getAll")
    public List<Comments> getAll() {
        return commentService.getAll();
    }
    
    @GetMapping("/pin_id/{pin_id}")
    public List<Comments> getByPinId(@PathVariable("pin_id") int pin_id) {
        return commentService.findAllByPin(pinService.getPinById(pin_id).get());
    }

    @PostMapping("/add")
    public Comments add(@RequestBody Comments comments){
        return commentService.saveComment(comments);
//        return "New student is added";
    }
    
    @GetMapping("/delete/cmt_id/{cmt_id}")
    public boolean delete(@PathVariable("cmt_id") int cmt_id) {
        return commentService.delete(cmt_id);
    }
    
    @GetMapping("/countAll")
    public long countAll() {
        return commentService.countAll();
    }
    
    @GetMapping("/percent7days")
    public double percent7days() {
        Date currentDate = new Date();
        // Tạo một đối tượng Calendar và thiết lập nó với ngày hiện tại
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        // Trừ đi 7 ngày
        calendar.add(Calendar.DAY_OF_MONTH, -7);

        // Lấy ngày mới sau khi đã trừ đi 7 ngày
        Date newDate = calendar.getTime();

        long countAll = commentService.countAll();
        long count7DayAgo = commentService.countByCreatedAtBefore(newDate);

        double ratio = (double) count7DayAgo / countAll;
        double percent = Math.round(ratio * 100.0) / 100.0;

        return percent;
    }
}
