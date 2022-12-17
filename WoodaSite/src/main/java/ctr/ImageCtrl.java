package ctr;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.catalina.ha.backend.CollectedInfo;

@WebServlet("/Image")
@MultipartConfig(
		fileSizeThreshold = 0,
		location = "/junni802/tomcat/webapps/ROOT/upload"
		)
public class ImageCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ImageCtrl() { super(); }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		Part part = request.getPart("file");
		System.out.println(part);
		String contentDisposition = part.getHeader("content-disposition");
		// 예) form-data; name="file1"; filename="업로드할파일명.확장자"
		System.out.println("contentDisposition : " + contentDisposition);
		
		String uploadFileName = getUploadFileName(contentDisposition);
		
		part.write(uploadFileName);
	}
	private String getUploadFileName(String contentDisposition) {
		String uploadFileName = null;
		String[] contentSplitStr = contentDisposition.split(";");
		
		int fIdx = contentSplitStr[2].indexOf("\"");
		int sIdx = contentSplitStr[2].lastIndexOf("\"");
		
		uploadFileName = contentSplitStr[2].substring(fIdx + 1, sIdx);
		return uploadFileName;
	}

}
