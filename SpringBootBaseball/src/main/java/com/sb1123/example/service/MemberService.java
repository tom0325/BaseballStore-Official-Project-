package com.sb1123.example.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sb1123.example.model.Member;

@Service
public interface MemberService {
 Member saveMember(Member member);
 
 Member updateMember(Member m);
         
 void delMemberByPhone(String phone);
 
 void delAll();
 
 Member findOneByPhone(String phone);
 
 //Member findByName(String name);

 //List<Member> findByNameAndPhone(String name, String phone);

 
 
 List<Member> findAll();
}
