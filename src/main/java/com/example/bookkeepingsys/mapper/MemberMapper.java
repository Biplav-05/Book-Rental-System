package com.example.bookkeepingsys.mapper;

import java.util.*;
import com.example.bookkeepingsys.pojo.MemberPojo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
@Mapper
public interface MemberMapper {

    @Select("select id,name,email,address,phone_number as phoneNumber from  tbl_member")
    public List<MemberPojo> getTotalData();
}
