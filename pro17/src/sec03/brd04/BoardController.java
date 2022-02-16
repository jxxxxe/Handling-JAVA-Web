package sec03.brd04;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;


/**
 * Servlet implementation class MemberController
 */
//@WebServlet("/board/*")
public class BoardController extends HttpServlet {
	private static String ARTICLE_IMAGE_REPO="C:\\javaWeb\\article_image";
	BoardService boardService;
	ArticleVO articleVO;

	public void init() throws ServletException {
		boardService = new BoardService();
		articleVO=new ArticleVO();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		doHandle(request, response);
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		String nextPage = null;
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String action = request.getPathInfo();
		
		
		if (action == null || action.equals("/listArticles.do")) {
			List<ArticleVO> articlesList = boardService.listArticles();
			request.setAttribute("articlesList", articlesList);
			nextPage = "/board02/listArticles.jsp";
		} 
		else if(action.equals("/articleForm.do")) {
			nextPage="/board02/articleForm.jsp";
		}
		else if(action.equals("/addArticle.do")) {
			Map<String, String> articleMap=upload(request,response);
			String title=articleMap.get("title");
			String content=articleMap.get("content");
			String imageFileName=articleMap.get("imageFileName");
			
			articleVO.setParentNO(0);
			articleVO.setId("an");
			articleVO.setTitle(title);
			articleVO.setContent(content);
			articleVO.setImageFileName(imageFileName);
			
			int articleNO=boardService.addArticle(articleVO);
			
			File srcFile=new File(ARTICLE_IMAGE_REPO+"\\temp\\"+imageFileName);
			
			File destDir=new File(ARTICLE_IMAGE_REPO+"\\"+articleNO);
			destDir.mkdir();
			FileUtils.moveFileToDirectory(srcFile, destDir,true);
			
			PrintWriter pw=response.getWriter();
			pw.print("<script> alert('새 글을 추가하였습니다');   location.href='"+request.getContextPath()+"/board/listArticles.do'; </script>");
			
			return; //알림창에서 확인 누르면 바로 이동하게 하기 위해선 location.href만 써야 한다..ㅎ
			
//			nextPage="/board/listArticles.do";
		}
		else if(action.equals("/viewArticle.do")){
			String articleNO=request.getParameter("articleNO");
			articleVO=boardService.viewArticle(Integer.parseInt(articleNO));
			request.setAttribute("article", articleVO);
			
			nextPage="/board03/viewArticle.jsp";
		}
		else {
			nextPage = "/board02/listArticles.jsp";
		}
		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
		dispatch.forward(request, response);
	}


	private Map<String, String> upload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Map<String,String> articleMap=new HashMap<String,String>();
		String encoding="utf-8";
		
		File currentDirPath=new File(ARTICLE_IMAGE_REPO); //저장 폴더에 대한 파일 객체 생성
		DiskFileItemFactory factory=new DiskFileItemFactory();
		factory.setRepository(currentDirPath);
		factory.setSizeThreshold(1024*1024);
		
		ServletFileUpload upload=new ServletFileUpload(factory);
		
		try {
			List items=upload.parseRequest(request);
			for(int i=0;i<items.size();i++) {
				FileItem fileItem=(FileItem)items.get(i);
				
				if(fileItem.isFormField()) {
					articleMap.put(fileItem.getFieldName(),fileItem.getString(encoding));
				}
				else {
					if(fileItem.getSize()>0) {
						int idx=fileItem.getName().lastIndexOf("\\");
						
						String fileName=fileItem.getName().substring(idx+1);
						articleMap.put("imageFileName", fileName);
						
						File uploadFile=new File(currentDirPath+"\\temp\\"+fileName);
						fileItem.write(uploadFile);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return articleMap;
	}

}