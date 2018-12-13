package com.sensetime.simulator.rpcservice;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LoginController {
    private String account;
    private String password;
    private String device_sn;
    private Long timestamp;
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    public LoginController(String account, String password, String device_sn, Long timestamp) {
        this.account = account;
        this.password = password;
        this.device_sn = device_sn;
        this.timestamp = timestamp;
    }

}
