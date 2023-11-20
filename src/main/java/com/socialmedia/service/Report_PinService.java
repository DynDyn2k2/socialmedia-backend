package com.socialmedia.service;

import com.socialmedia.model.Report_Pins;
import com.socialmedia.model.Users;

public interface Report_PinService {

    public long countAll();

    public long countByUserRatify(Users userRatify);

    public long countByApprove(boolean approve);
}
