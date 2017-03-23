package com.abyssinia.eauction.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.abyssinia.eauction.domain.Member;

	@Repository
	public interface MemberRepository extends  CrudRepository<Member, String> 
	{
		public Member findByMemberNumber(int memberNumber);
 	}

