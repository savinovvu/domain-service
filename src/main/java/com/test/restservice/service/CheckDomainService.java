package com.test.restservice.service;

import com.test.restservice.dto.CheckDomainDto;
import com.test.restservice.dto.SearchDto;
import com.test.restservice.model.Tld;
import com.test.restservice.repository.DomainRepository;
import com.test.restservice.repository.TldRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;



@Service
@RequiredArgsConstructor
public class CheckDomainService {

    private static final String DOMAIN_QUERY_END = ".%";

    private static final Sort TLD_SORT = new Sort(Sort.Direction.ASC, "price");

    @Resource
    private final DomainRepository domainRepository;

    @Resource
    private final TldRepository tldRepository;


    @Transactional(readOnly = true)
    public List<CheckDomainDto> checkDomain(SearchDto searchDto) {
        String domainName = searchDto.getSearch();
        String condition = domainName + DOMAIN_QUERY_END;
        Set<String> existDomains = domainRepository.existsByName(condition);
        List<Tld> tlds = tldRepository.findAll(TLD_SORT);
        List<CheckDomainDto> result = CheckDomainDto.of(existDomains, tlds, domainName);
        return result;
    }
}
