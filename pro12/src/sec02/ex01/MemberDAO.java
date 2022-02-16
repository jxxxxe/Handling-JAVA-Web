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

	private DataSource dataFactory;
	private PreparedStatement pstmt;
	private Connection con;
	
	public MemberDAO() {
		try {
			Context ctx=new InitialContext();
			Context envContext=(Context)ctx.lookup("java:/comp/env");
			dataFactory=(DataSource)envContext.lookup("jdbc/oracle");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	

	public List listMembers(MemberVO memberVO) {
		List memberList=new ArrayList();
		String name=memberVO.getName();
		try {
			con=dataFactory.getConnection();
			String query="select * from t_member";
			if(name!=null &&name.length()!=0) {
				query+=" where name=?";
				pstmt=con.prepareStatement(query);
				pstmt.setString(1, name);
			}else {
				pstmt=con.prepareStatement(query);
			}
			ResultSet rs=pstmt.executeQuery();
			
			while(rs.next()) {
				MemberVO vo=new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setPwd(rs.getString("pwd"));
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
				vo.setJoinDate(rs.getDate("joinDate"));
				memberList.add(vo);
			}
			rs.close();
			pstmt.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return memberList;
	}
}
