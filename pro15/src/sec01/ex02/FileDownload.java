package sec01.ex02;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


@WebServlet("/download.do")
public class FileDownload extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		//파일경로 만들기
		File DirPath =new File("C:\\file_repo");
		String fileName=(String)request.getParameter("fileName");
		String downFile=DirPath+"\\"+fileName;
		File f=new File(downFile);
		
		//헤더설정
		response.setHeader("Cache-Control", "no-cache");
		response.addHeader("Content-disposition", "attachment;fileName="+fileName);
		
		//인풋스트림을 통해 파일을 버퍼에 저장-아웃풋 스트림을 통해서 버퍼에 있는걸 브라우저로 출력
		FileInputStream in=new FileInputStream(f);
		OutputStream out=response.getOutputStream();
		byte[] buffer=new byte[1024*8]; //8kb
		
		while(true) {
			int count=in.read(buffer); //buffer크기만큼 inputStream으로 부터 읽어와서 버퍼(바이트배열)에 저장
										// 읽어드린 길이를 반환
			if(count==-1)
				break;
			out.write(buffer,0,count); //아까 버퍼로 넣은 만큼 다시 버퍼에서 꺼내 브라우저에 출력
		}
		
		in.close();
		out.close();
	}

}
