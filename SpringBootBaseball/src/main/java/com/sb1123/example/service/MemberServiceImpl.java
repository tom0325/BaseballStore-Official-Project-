package com.sb1123.example.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.sb1123.example.model.*;

@Service
public class MemberServiceImpl implements MemberService{
    
	public static void main(String[] args)
	{
		Member m = new Member("0955", "tpe", "@","22","tom","Y");
		new MemberServiceImpl().updateMember(m);
	}
	@Autowired
    private MemberRepo memberRepo;
	
	@Override
	public Member saveMember(Member member) {
		
        return memberRepo.save(member);
	}

	@Override
	public void delMemberByPhone(String phone) {
		memberRepo.deleteById(phone);
		
	}

	@Override
	public void delAll() {
		memberRepo.deleteAll();
		
	}

	@Override
	public Member findOneByPhone(String phone) {
		return memberRepo.findById(phone).orElse(null);
	}

	/*@Override
	public Member findByName(String name) {
		return memberRepo.findByName(name);
	}

	@Override
	public List<Member> findByNameAndPhone(String name, String phone) {
		return  memberRepo.findByNameAndAge(name, phone);
	}*/

	

	@Override
	public List<Member> findAll() {
		// TODO Auto-generated method stub
		return (List<Member>) memberRepo.findAll();
	}

	@Override
	public Member updateMember(Member m) {
		// TODO Auto-generated method stub

			      return memberRepo.save(m);

		
	}

	
	

}
