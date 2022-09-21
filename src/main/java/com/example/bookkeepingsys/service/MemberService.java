package com.example.bookkeepingsys.service;

import com.example.bookkeepingsys.misc.ApiResponse;
import com.example.bookkeepingsys.pojo.MemberPojo;
import org.springframework.stereotype.Service;

@Service
public interface MemberService {
    ApiResponse insertMember(MemberPojo memberPojo);

    ApiResponse getAllMember();
}
