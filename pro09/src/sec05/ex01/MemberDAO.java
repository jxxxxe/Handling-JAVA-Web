package sec05.ex01;

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

	

	public boolean isExisted(MemberVO memberVO) {
		boolean result=false;
		try {
			con=dataFactory.getConnection();
			String query="select decode(count(*),1,'true','false') as result from t_member where id=? and pwd=?";
			//오라클의 decode함수로 조건에 맞는 레코드가 있으면 true, 없으면 false반환
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, memberVO.getId());
			pstmt.setString(2, memberVO.getPwd());
			
			ResultSet rs=pstmt.executeQuery();
			rs.next(); //커서를 첫번째 레코드로

			result=Boolean.parseBoolean(rs.getString("result")); //result필드 값 얻기
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
