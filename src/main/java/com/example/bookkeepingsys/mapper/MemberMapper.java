package com.example.bookkeepingsys.mapper;

import com.example.bookkeepingsys.pojo.MemberPojo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MemberMapper {
    @Select("select id,name,email,address,phone_number as phoneNumber from  tbl_member")
    public List<MemberPojo> getTotalData();

    @Select("select * from tbl_member where  email=#{email}")
    Optional<MemberPojo> checkEmail(String email);


}
