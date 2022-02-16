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
		
		//���ϰ�� �����
		File DirPath =new File("C:\\file_repo");
		String fileName=(String)request.getParameter("fileName");
		String downFile=DirPath+"\\"+fileName;
		File f=new File(downFile);
		
		//�������
		response.setHeader("Cache-Control", "no-cache");
		response.addHeader("Content-disposition", "attachment;fileName="+fileName);
		
		//��ǲ��Ʈ���� ���� ������ ���ۿ� ����-�ƿ�ǲ ��Ʈ���� ���ؼ� ���ۿ� �ִ°� �������� ���
		FileInputStream in=new FileInputStream(f);
		OutputStream out=response.getOutputStream();
		byte[] buffer=new byte[1024*8]; //8kb
		
		while(true) {
			int count=in.read(buffer); //bufferũ�⸸ŭ inputStream���� ���� �о�ͼ� ����(����Ʈ�迭)�� ����
										// �о�帰 ���̸� ��ȯ
			if(count==-1)
				break;
			out.write(buffer,0,count); //�Ʊ� ���۷� ���� ��ŭ �ٽ� ���ۿ��� ���� �������� ���
		}
		
		in.close();
		out.close();
	}

}
