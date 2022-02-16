package sec03.brd01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAO {

	private Connection con;
	private DataSource dataFactory;
	private PreparedStatement pstmt;
	
	public BoardDAO() {
		try {
			Context ctx=new InitialContext();
			Context envContext=(Context) ctx.lookup("java:/comp/env");
			dataFactory=(DataSource) envContext.lookup("jdbc/oracle");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public List<ArticleVO> selectAllArticles() {

		List<ArticleVO> articlesList=new ArrayList();
		try {
			con=dataFactory.getConnection();
			String query="SELECT LEVEL, articleNO, parentNO, title, content, writeDate, id " + 
					"FROM t_board " + 
					"START WITH parentNO=0 " + 
					"CONNECT BY PRIOR articleNO=parentNO " + 
					"ORDER SIBLINGS BY articleNO DESC";
			System.out.println(query);
			pstmt=con.prepareStatement(query);
			ResultSet rs=pstmt.executeQuery();
			
			while(rs.next()) {
				int level=rs.getInt("level");
				int articleNO=rs.getInt("articleNO");
				int parentNO=rs.getInt("parentNO");
				String title=rs.getString("title");
				String content=rs.getString("content");
				Date writeDate=rs.getDate("writeDate");
				String id=rs.getString("id");
				
				ArticleVO articleVO=new ArticleVO(level,articleNO,parentNO,title,content,null,id);
				articleVO.setWriteDate(writeDate);
				
				articlesList.add(articleVO);
			}
			con.close();
			pstmt.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return articlesList;
	}
	
}
