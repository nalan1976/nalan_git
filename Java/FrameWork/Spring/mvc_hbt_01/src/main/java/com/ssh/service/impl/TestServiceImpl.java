package com.ssh.service.impl;

import com.ssh.service.TestService;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {
    public String test() {
        return "test";
    }
}