package com.example.bookkeepingsys.converter;

import com.example.bookkeepingsys.model.Member;
import com.example.bookkeepingsys.pojo.MemberPojo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class MemberConverter {
    private ModelMapper modelMapper;

    public MemberConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Member pojoToEntity(MemberPojo memberPojo) {
        Member member = this.modelMapper.map(memberPojo, Member.class);
        return member;
    }




}
