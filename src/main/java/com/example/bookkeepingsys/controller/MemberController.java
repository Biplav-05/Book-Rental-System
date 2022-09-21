package com.example.bookkeepingsys.controller;

import com.example.bookkeepingsys.misc.ApiResponse;
import com.example.bookkeepingsys.pojo.MemberPojo;
import com.example.bookkeepingsys.service.MemberService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("member/")

public class MemberController extends ApiResponse {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("add-member")
    public ApiResponse addMember(@RequestBody @Valid MemberPojo memberPojo)
    {
        return memberService.insertMember(memberPojo);
    }
    @GetMapping("find-all-member")
    public ApiResponse findAllMember()
    {
        return memberService.getAllMember();
    }
}
