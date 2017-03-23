package com.abyssinia.eauction.service;

import java.util.List;

import com.abyssinia.eauction.domain.Member;
 
public interface MemberService {

	public void save(Member member);
	public List<Member> findAll();
	public Member findByMemberNumber(int memberId);
  	public void saveFull( Member member);  		
}
