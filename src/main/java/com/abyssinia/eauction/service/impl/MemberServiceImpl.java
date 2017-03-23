package com.abyssinia.eauction.service.impl;

import java.util.List;

import com.abyssinia.eauction.repository.MemberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abyssinia.eauction.domain.Member;
import com.abyssinia.eauction.service.CredentialsService;
import com.abyssinia.eauction.service.MemberService;

@Service
@Transactional 
public class MemberServiceImpl implements MemberService {
	
 	@Autowired
	private MemberRepository memberRepository;

 	@Autowired
 	CredentialsService credentialsService;

  	@PreAuthorize("hasRole('ROLE_ADMIN')")
  	public void saveFull( Member member) {  		
  		credentialsService.save(member.getCredentials());
  		memberRepository.save(member);
	}
  	
  	@PreAuthorize("hasRole('ROLE_ADMIN')")
  	public void save( Member member) {  		
  		memberRepository.save(member);
 	}
  	
  	
	public List<Member> findAll() {
		return (List< Member>)memberRepository.findAll();
	}

	public Member findByMemberNumber(int memberId) {
		return memberRepository.findByMemberNumber(memberId);
	}
 

}
