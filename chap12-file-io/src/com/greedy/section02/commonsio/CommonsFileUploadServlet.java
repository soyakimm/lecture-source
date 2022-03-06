package com.greedy.section02.commonsio;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


@WebServlet("/commons/fileupload")
public class CommonsFileUploadServlet extends HttpServlet {
       
	
	private String rootLocation;
	private int maxFileSize;
	private String encodingType;
	
	@Override
	public void init() {
		ServletContext context = getServletContext();
		
		rootLocation = context.getInitParameter("upload-location");
		maxFileSize = Integer.parseInt(context.getInitParameter("max-file-size"));
		encodingType = context.getInitParameter("encoding-type");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(ServletFileUpload.isMultipartContent(request)) {
			// multipart content로 요청 되었는지 확인한 후 코드를 진행한다.
			System.out.println("파일 저장 root 경로 : " + rootLocation);
			System.out.println("최대 업로드 파일 용량 : " + maxFileSize);
			System.out.println("인코딩 방식 : " + encodingType);
			
			String fileUploadDirectory = rootLocation + "/commons";
			
			File directory = new File(fileUploadDirectory);
			
			/* 파일 저장 경로가 존재하지 않는 경우 디렉토리를 생성한다. */
			if(directory.exists()) { /*true | false 반환*/
				/* 폴더를 한 개만 생성할꺼면 mkdir, 상위 폴더도 존재하지 않으면 한 번에 모든 경로를 생성하기 위해 mkdirs를 이용한다. */
				directory.mkdirs();
			}
			
			/* 최종적으로 request를 parsing하고 파일을 저장 한 뒤 필요한 내용을 담을 리스트와 맵*/
			Map<String, String> parameter = new HashMap<>();
			List<Map<String, String>> fileList = new ArrayList<>();
			
			/* 파일 업로드할 시 최대 크기나 임시 저장할 폴더의 경로 등을 포함하기 위한 인스턴스이다. */
			DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
			fileItemFactory.setRepository(new File(fileUploadDirectory));
			fileItemFactory.setSizeThreshold(maxFileSize);
			
			/* 서블릿에서 기본 제공하는 클래스가 아닌 commons fileupload 라이브러리의 클래스로 임포트 한다. */
			ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory); 
			fileUpload.setHeaderEncoding(encodingType);
			
			try { /*request를 파싱하여 데이터 하나하나를 FileItem 인스턴스로 반환한다. */
				List<FileItem> fileItems = fileUpload.parseRequest(request); //전달받은 request를 List형태로 parsing 해주세요.
				
				for(FileItem item : fileItems) {
					System.out.println(item);
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
				
			} 
		}
	}

}
