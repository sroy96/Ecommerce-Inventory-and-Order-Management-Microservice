package com.vedantu.vedantu.controller;

import com.vedantu.vedantu.constants.ApiMapper;
import com.vedantu.vedantu.constants.AppConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoreController {

    @GetMapping(ApiMapper.GET_HEALTH)
    public ResponseEntity getHealth() {
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping(ApiMapper.POST_ORDER)
    public ResponseEntity createOrder(@RequestHeader(AppConstants.ACCESS_TOKEN) String accessToken) {

        return new ResponseEntity(HttpStatus.OK);
    }

}
