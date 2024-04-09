package com.projectdc.service;

import com.projectdc.request.PostAddressRequest;
import com.projectdc.utilities.StatusHandler;

public interface PostAddressProcessIF {

    StatusHandler postAddressProcess(PostAddressRequest request);
}
