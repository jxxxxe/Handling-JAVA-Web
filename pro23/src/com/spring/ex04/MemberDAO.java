package com.spring.ex04;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.spring.ex01.MemberVO;

public class MemberDAO {
	
	private static SqlSessionFactory sqlMapper=null;
	
	public static SqlSessionFactory getInstance() {
		if(sqlMapper==null) {
			try {
				String resource="mybatis/SqlMapConfig.xml";
				Reader reader=Resources.getResourceAsReader(resource);
				sqlMapper=new SqlSessionFactoryBuilder().build(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sqlMapper;
	}

	public List selectAllMemberList() {
		sqlMapper=getInstance();
		SqlSession session=sqlMapper.openSession();
		
		List<HashMap<String,String>> memList=null;
		memList=session.selectList("mapper.member.selectAllMemberList");
		
		return memList;
	}
	
	public String selectName() {
		sqlMapper=getInstance();
		SqlSession session=sqlMapper.openSession();
		
		String name=session.selectOne("mapper.member.selectName");
		
		return name;
	}
	
	public int selectPwd() {
		sqlMapper=getInstance();
		SqlSession session=sqlMapper.openSession();
		
		return session.selectOne("mapper.member.selectPwd");
	}
	
	public MemberVO selectMemberById(String id) {
		sqlMapper=getInstance();
		SqlSession session=sqlMapper.openSession();
		
		return session.selectOne("mapper.member.selectMemberById",id);
		
	}
	
	public List selectMemberByPwd(String pwd) {
		sqlMapper=getInstance();
		SqlSession session=sqlMapper.openSession();
		
		List<MemberVO> membersList=session.selectList("mapper.member.selectMemberByPwd",pwd);
		
		return membersList;
	}
	
	public int insertMember(MemberVO memberVO) {
		sqlMapper=getInstance();
		SqlSession session=sqlMapper.openSession();
		
		int result=0;
		result=session.insert("mapper.member.insertMember",memberVO);
		session.commit();
		
		return result;
	}

	public int insertMember2(Map<String,String> memberMap) {
		sqlMapper=getInstance();
		SqlSession session=sqlMapper.openSession();
		
		int result=0;
		result=session.insert("mapper.member.insertMember2",memberMap);
		session.commit();
		
		return result;
		
	}

	public int updateMember(MemberVO memberVO) {
		sqlMapper=getInstance();
		SqlSession session=sqlMapper.openSession();
		
		int result=0;
		result=session.update("mapper.member.updateMember",memberVO);
		session.commit();
		
		return result;
	}

	public int deleteMember(String id) {
		sqlMapper=getInstance();
		SqlSession session=sqlMapper.openSession();
		
		int result=0;
		result =session.delete("mapper.member.deleteMember",id);
		session.commit();
		
		return result;
	}

	public List<MemberVO> selectMember(MemberVO memberVO) {
		sqlMapper=getInstance();
		SqlSession session=sqlMapper.openSession();
		
		List<MemberVO> list=session.selectList("mapper.member.searchMember", memberVO);
		
		return list;
	}

	public List<MemberVO> foreachSelect(List<String> nameList) {
		sqlMapper=getInstance();
		SqlSession session=sqlMapper.openSession();
		
		return session.selectList("mapper.member.foreachSelect",nameList);
	}

	public int foreachInsert(List<MemberVO> memList) {
		sqlMapper=getInstance();
		SqlSession session=sqlMapper.openSession();
		
		int result=session.insert("mapper.member.foreachInsert",memList);
		session.commit();
		
		return result;
	}

	public List<MemberVO> selectLike(String name) {
		sqlMapper=getInstance();
		SqlSession session=sqlMapper.openSession();
		
		return session.selectList("mapper.member.selectLike",name);
	}

}
