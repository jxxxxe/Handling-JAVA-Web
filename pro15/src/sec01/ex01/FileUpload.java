package sec01.ex01;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


@WebServlet("/upload.do")
public class FileUpload extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		
		String encoding="utf-8";
		
		File currentDirPath =new File("C:\\file_repo"); //파일 업로드 될 위치(폴더 생성 필요)
		
		DiskFileItemFactory factory=new DiskFileItemFactory(); //라이브러리에서 제공하는 클래스1
		factory.setRepository(currentDirPath); //파일 업로드 위치 설정
		factory.setSizeThreshold(1024*1024); //업로드 가능한 파일 최대 크기 설정
		
		ServletFileUpload upload =new ServletFileUpload(factory); //라이브러리에서 제공하는 클래스2
		try {
			List items=upload.parseRequest(request); //요청 매개변수를 리스트로 파싱
			for(int i=0;i<items.size();i++) {
				FileItem fileItem=(FileItem)items.get(i);
				
				if(fileItem.isFormField()) { //매개변수가 폼필드(text,,)이면 매개변수이름=값(encoding해서 가져옴)을 출력
					System.out.println(fileItem.getFieldName() + "=" + fileItem.getString(encoding));
				}else { //폼 필드가 아니면(file) 파일 업로드 기능 수행
					System.out.println("파라미터명:" + fileItem.getFieldName()); //매개변수 이름
					System.out.println("파일명:" + fileItem.getName()); //파일이름
					System.out.println("파일크기:" + fileItem.getSize() + "bytes"); //파일크기
					
					if (fileItem.getSize() > 0) {
						int idx = fileItem.getName().lastIndexOf("\\"); // 파일 이름 중에서 \\의 끝 인덱스
						if (idx == -1) {
							idx = fileItem.getName().lastIndexOf("/"); // 파일 이름 중에서 \\가 없으면 /의 인덱스
						}
						String fileName = fileItem.getName().substring(idx + 1); // \\나 / 뒤에 있는 파일 이름을 가져옴
						File uploadFile = new File(currentDirPath + "\\" + fileName); // 저장소위치\\파일이름이 경로임
						fileItem.write(uploadFile); //저장소에 파일 업로드
					}
				}
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}

}
