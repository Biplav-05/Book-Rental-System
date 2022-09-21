package com.example.bookkeepingsys.repository;

import com.example.bookkeepingsys.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Integer> {
}
