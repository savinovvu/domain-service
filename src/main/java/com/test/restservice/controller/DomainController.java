package com.test.restservice.controller;

import com.test.restservice.dto.CheckDomainDto;
import com.test.restservice.dto.SearchDto;
import com.test.restservice.service.CheckDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;



@RestController
@RequiredArgsConstructor
public class DomainController {


    @Resource
    private final CheckDomainService checkDomainService;


    @GetMapping("/domains/check")
    public ResponseEntity check(SearchDto search) {
        List<CheckDomainDto> result = checkDomainService.checkDomain(search);
        return ResponseEntity.ok(result);
    }
}
