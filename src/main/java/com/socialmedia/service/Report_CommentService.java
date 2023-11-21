package com.socialmedia.service;


import com.socialmedia.model.Users;

public interface Report_CommentService {

    public long countAll();

    public long countByUserRatify(Users userRatify);

    public long countByApprove(boolean approve);
    
    public void changeApprove(int id, Users userRatify, boolean currentState);

}
