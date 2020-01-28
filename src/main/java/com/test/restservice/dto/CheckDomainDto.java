package com.test.restservice.dto;

import com.test.restservice.model.Tld;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;



@Data
@AllArgsConstructor
public class CheckDomainDto {

    private String domain;

    private String tld;

    private boolean available;

    private double price;


    public static List<CheckDomainDto> of(Set<String> existDomains, List<Tld> tlds, String domainName) {

        List<CheckDomainDto> checkDomainDtos = new ArrayList<>();
        for (Tld tld : tlds) {
            String fullName = domainName + "." + tld.getName();
            boolean isExist = existDomains.contains(fullName);
            boolean available = !isExist;
            CheckDomainDto checkDomainDto = new CheckDomainDto(fullName, tld.getName(), available, tld.getPrice());
            checkDomainDtos.add(checkDomainDto);
        }
        return checkDomainDtos;
    }
}
