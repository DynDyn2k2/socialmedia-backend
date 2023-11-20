package com.socialmedia.service;

import com.socialmedia.model.Report_Pins;

public interface Report_PinService {
    public void changeApprove(int id, boolean currentState);
}
