package com.socialmedia.service;

import com.socialmedia.model.Report_Comments;
import com.socialmedia.model.Users;

public interface Report_CommentService {

    public long countAll();

    public long countByUserRatify(Users userRatify);

    public long countByApprove(boolean approve);

}
