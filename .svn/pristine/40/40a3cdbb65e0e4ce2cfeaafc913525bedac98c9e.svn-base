package com.zszd.ai.controller;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.zszd.ai.pojo.Employee;
import com.zszd.ai.pojo.Resources;
import com.zszd.ai.service.resource.ResourceService;
import com.zszd.ai.service.resource.ResourceServiceImpl;
import com.zszd.ai.tools.Constants;

@Controller
@RequestMapping("/sys/resource")
public class ResourceController {
	private Logger logger = Logger.getLogger(ResourceController.class);

	@Resource
	ResourceService resourceService = new ResourceServiceImpl();
	
	
	@RequestMapping(value = "view.html")
	public String view(HttpServletRequest request,HttpSession session) {
		List<Resources> list = null;		
		int type = Integer.parseInt(request.getParameter("type"));
		int roleId = ((Employee) session
				.getAttribute(Constants.EMPlOYEE_SESSION)).getRoleId();
		if(roleId == Constants.NORMALSTAFF){
			list = resourceService.queryPassedResourceInfoByType(type);
		}else{
			list = resourceService.queryAllResourceInfoByType(type);
		}
		request.setAttribute("list", list);
		switch (type) {
		case 0:
			return "resource/photo_list";
		case 1:
			return "resource/video_list";
		case 2:
			return "resource/file_list";
		}
		return "resource/resource_upload";
	}
	
	
	@RequestMapping(value = "review.html")
	public String review(HttpServletRequest request,HttpSession session) {
		int type = Integer.parseInt(request.getParameter("type"));
		String id = request.getParameter("id");
		Resources resource = resourceService.getResourceById(id);
		request.setAttribute("resource", resource);
		switch (type) {
		case 0:
			return "resource/photo_modify";
		case 1:
			return "resource/video_modify";
		case 2:
			return "resource/file_modify";
		}
		return "resource/resource_upload";
	}
	
	@RequestMapping(value = "toreview.html")
	public String toreview(HttpServletRequest request,HttpSession session) {
		String loginname = ((Employee) session
				.getAttribute(Constants.EMPlOYEE_SESSION)).getName();
		String type = request.getParameter("type");
		String name = request.getParameter("name");
		String state = request.getParameter("state");
		String showType = request.getParameter("showType");
		String id = request.getParameter("id");
		Date date = new Date();			
		Resources resource = new Resources();
		resource.setId(Integer.valueOf(id));
		resource.setName(name);
		resource.setState(Integer.valueOf(state));
		resource.setShowType(showType);
		resource.setReviewBy(loginname);
		resource.setReviewTime(date);
		int row = resourceService.updateResourceInfo(resource);
		if (row > 0) {
			return "redirect:view.html?type="+type;		
		}else{
			return "redirect:view.html?type="+type;	
		}
	}
	
	
	@RequestMapping(value = "upload.html")
	public String upload() {
		return "resource/resource_upload";
	}

	@RequestMapping(value = "toupload.html",method=RequestMethod.POST)
	public String toupload(HttpSession session,HttpServletRequest request,
			 @RequestParam(value ="uploadfile", required = false) MultipartFile attach) {
		String loginname = ((Employee) session
				.getAttribute(Constants.EMPlOYEE_SESSION)).getName();
		String idPath = null;
		String message = "";
		//判断文件是否为空
		if(!attach.isEmpty()){
			String path = request.getSession().getServletContext().getRealPath("statics"+File.separator+"uploadfiles"); 
			logger.info("uploadFile path ============== > "+path);
			String oldFileName = attach.getOriginalFilename();//原文件名
			logger.info("uploadFile oldFileName ============== > "+oldFileName);
			String prefix=FilenameUtils.getExtension(oldFileName);//原文件后缀     
	        logger.debug("uploadFile prefix============> " + prefix);
			int filesize = 50000000;
			logger.debug("uploadFile size============> " + attach.getSize());
			
			int type = 0;// 类型：0 图片 1 视频 2 文件
	        if(attach.getSize() >  filesize){//上传大小不得超过 50000k
            	request.setAttribute("uploadFileError", " * 上传大小不得超过 50000k");
            	message = "上传大小不得超过 50000k";
	        	return "redirect:/resource/upload.html";
            }else if(prefix.equalsIgnoreCase("jpg") || prefix.equalsIgnoreCase("png") 
            		|| prefix.equalsIgnoreCase("jpeg") || prefix.equalsIgnoreCase("pneg")){//上传图片格式
            	type = 0 ;
            	String fileName = System.currentTimeMillis()+RandomUtils.nextInt(1000000)+"_PHOTO." + prefix;  
                logger.debug("new fileName======== " + attach.getName());
                File targetFile = new File(path, fileName);  
                if(!targetFile.exists()){  
                    targetFile.mkdirs();  
                }  
                //保存  
                try {  
                	attach.transferTo(targetFile);  
                } catch (Exception e) {  
                    e.printStackTrace();  
                    request.setAttribute("uploadFileError", " * 上传失败！");
                    message = "上传失败！";
                    request.setAttribute("message", message);
                    return "redirect:upload.html";
                }  
                idPath = "statics\\uploadfiles"+File.separator+fileName;
            }else if(prefix.equalsIgnoreCase("mp4") || prefix.equalsIgnoreCase("avi") 
            		|| prefix.equalsIgnoreCase("wmv") ){//上传视频格式
            	type = 1 ;
            	String fileName = System.currentTimeMillis()+RandomUtils.nextInt(1000000)+"_VIDEO." + prefix;  
                logger.debug("new fileName======== " + attach.getName());
                File targetFile = new File(path, fileName);  
                if(!targetFile.exists()){  
                    targetFile.mkdirs();  
                }  
                //保存  
                try {  
                	attach.transferTo(targetFile);  
                } catch (Exception e) {  
                    e.printStackTrace();  
                    request.setAttribute("uploadFileError", " * 上传失败！");
                    message = "上传失败！";
                    request.setAttribute("message", message);
                    return "redirect:upload.html";
                }  
                idPath = "statics\\uploadfiles"+File.separator+fileName;
            }else{
            	type = 2 ;
            	String fileName = System.currentTimeMillis()+RandomUtils.nextInt(1000000)+"_FILE." + prefix;  
                logger.debug("new fileName======== " + attach.getName());
                File targetFile = new File(path, fileName);  
                if(!targetFile.exists()){  
                    targetFile.mkdirs();  
                }  
                //保存  
                try {  
                	attach.transferTo(targetFile);  
                } catch (Exception e) {  
                    e.printStackTrace();  
                    request.setAttribute("uploadFileError", " * 上传失败！");
                    message = "上传失败！";
                    request.setAttribute("message", message);
                    return "redirect:upload.html";
                }  
                idPath = "statics\\uploadfiles"+File.separator+fileName;
            }
	        
	        //写入表里
			Resources resource = new Resources();
			resource.setName(oldFileName);
			resource.setPath(idPath);
			resource.setCreateBy(loginname);
			resource.setType(type);
			int row = resourceService.insertResourceRecord(resource);
			if(row>0){
				message = "文件上传成功";
				request.setAttribute("message", message);
				return "resource/resource_list";
			}
			
		}
		request.setAttribute("message", message);
		return "redirect:upload.html";
	}

}
