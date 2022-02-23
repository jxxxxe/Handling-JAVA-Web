package com.spring.member.dao;

import java.util.List;

import com.spring.member.vo.MemberVO;

public interface MemberDAO {

	List selectAllMembers();
	int addMember(MemberVO memberVO);

}
