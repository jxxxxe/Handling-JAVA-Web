package com.spring.member.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.member.vo.MemberVO;

public interface MemberDAO {

	List selectAllMembers();
	int insertMember(MemberVO memberVO) throws DataAccessException;
	int deleteMember(String id) throws DataAccessException;

}
