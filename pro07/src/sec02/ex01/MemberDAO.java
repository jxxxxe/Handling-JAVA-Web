package sec02.ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {

	private PreparedStatement pstmt;
	private Connection con;
	private DataSource dataFactory;
	
	public MemberDAO() {
		try {
			Context ctx=new InitialContext();
			Context envContext=(Context) ctx.lookup("java:/comp/env"); //JNDI에 접근하기 위해 기본 경로를 지정
			dataFactory=(DataSource) envContext.lookup("jdbc/oracle"); //톰캣 context.xml에 설정한 name 값을 이용해 톰캣이 미리 연결한 DataSource를 받아 옴
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public List<MemberVO> listMembers() {
		
		List<MemberVO> list=new ArrayList<MemberVO>();
		try {
			con=dataFactory.getConnection(); //DataSource를 이용해 db에 연결
			String query="select * from t_member";
			System.out.println(query);
			
			pstmt=con.prepareStatement(query); 
			ResultSet rs=pstmt.executeQuery(); 
			while(rs.next()) {
				String id=rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				MemberVO vo = new MemberVO();
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setEmail(email);
				vo.setJoinDate(joinDate);
				list.add(vo);
			}
			rs.close();
			pstmt.close();
			con.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
}
