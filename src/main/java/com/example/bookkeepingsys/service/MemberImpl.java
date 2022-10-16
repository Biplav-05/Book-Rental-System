package com.example.bookkeepingsys.service;

import com.example.bookkeepingsys.converter.MemberConverter;
import com.example.bookkeepingsys.mapper.MemberMapper;
import com.example.bookkeepingsys.misc.ApiResponse;
import com.example.bookkeepingsys.model.Member;
import com.example.bookkeepingsys.pojo.MemberPojo;
import com.example.bookkeepingsys.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberImpl extends ApiResponse implements MemberService{

    private final MemberRepository memberRepository;
    private MemberConverter memberConverter;
    private MemberMapper memberMapper;

    public MemberImpl(MemberRepository memberRepository, MemberConverter memberConverter, MemberMapper memberMapper) {
        this.memberRepository = memberRepository;
        this.memberConverter = memberConverter;
        this.memberMapper = memberMapper;
    }

    @Override
    public ApiResponse insertMember(MemberPojo memberPojo) {
        Member member = memberConverter.pojoToEntity(memberPojo);
        member=memberRepository.save(member);
        Optional<MemberPojo> memberEmail = memberMapper.checkEmail(memberPojo.getEmail());
        if(!memberEmail.isPresent()){
            return success(member.getName()+" is  added as library member",null);
        }
        return error(memberPojo.getEmail()+" email is already exists",null);

    }

    @Override
    public ApiResponse getAllMember() {
        return success("All member data",memberMapper.getTotalData());
    }
}
