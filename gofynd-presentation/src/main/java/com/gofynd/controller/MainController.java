/**
 * 
 */
package com.gofynd.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.gofynd.iservice.IReadFile;

/**
 * @author GRO
 *
 */
@Controller
public class MainController extends HttpServlet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3058855474544198047L;
	@Autowired
	private IReadFile readFileImpl;
	
	
	@RequestMapping(value="/UploadFile.htm")
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		 FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload =  new ServletFileUpload(factory);
		File file = null;
		try 
		{  
			List<FileItem> items = upload.parseRequest(request);
			if(isMultipart)
			{
				for(FileItem item : items)
				{
					  if (!item.isFormField())
					  {
		                   String name = new File(item.getName()).getName();
		                    file = new File(request.getRealPath(File.separator) + File.separator + name);
		                   item.write(file);
		              }
				}
				readFileImpl.readCSVFile(file);	
				request.getRequestDispatcher("jsp/display.jsp").forward(request, response);
			}
		}
		catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
