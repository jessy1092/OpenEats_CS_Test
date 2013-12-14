package controllers;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import play.db.jpa.*;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Http.MultipartFormData;
import play.mvc.Http.MultipartFormData.FilePart;
import play.*;

import securesocial.core.Identity;
import securesocial.core.java.SecureSocial;
import views.html.*;

import models.CSRecord;

public class CrdSrcController extends Controller {

    public static Result uploadForm() {
        return ok(upload.render()); 
    }

    @play.db.jpa.Transactional
    public static Result upload() {
		MultipartFormData body = request().body().asMultipartFormData();
		String playPath = Play.application().path().toString();
		String[] picsName = new String[3];
	
		// deal with the picture file
		FilePart[] pics = new FilePart[3];
		for(int i=0 ; i<pics.length ; i++) {
		    pics[i] = body.getFile("pic"+i);
		}
	
		//FilePart picture = body.getFile("pic1").getFilename();
		//String fileName = picture.getFilename();
		//String contentType = picture.getContentType();
		//File file = picture.getFile();
	
		// get the data
		Map<String, String[]> values = body.asFormUrlEncoded();
		String barcode = values.get("barcode")[0];
	
		// create the CSRecord
		CSRecord r = new CSRecord();
		r.barcode = barcode;
	
		// create the directory
		File dir = new File(playPath+"/public/csimg/"+r.id);
		try {
		    FileUtils.forceMkdir(dir);
		} catch (Exception e){
		    return ok("Failed to create directory");
		}
	
		// Move the images
		try {
			for(int i=0 ; i<pics.length ; i++) 
			{
			    File srcFile = pics[i].getFile();
			    File dstFile = new File(dir.toString() + "/" + pics[i].getFilename()); // directory path + / + file name
			    picsName[i] = pics[i].getFilename();
			    //Check the same file name, and rename
			    if(dstFile.exists())
			    {
			    	//split the pic name and type ex. name.png  
			    	int index = pics[i].getFilename().indexOf(".");
			    	String picType;
			    	String picName = pics[i].getFilename().substring(0, index);
			    	if(index < 0)
			    	{
			    		picType = "";
			    	}
			    	else
			    	{
			    		picType = pics[i].getFilename().substring(index);
			    	}
			    	dstFile = new File(dir.toString() + "/" + picName + "_1" + picType);
			    	picsName[i] = new String(picName + "_1" + picType);
			    }
			    FileUtils.moveFile(srcFile, dstFile);
			}
		} catch (Exception e) 
		{
		    return ok("Failed to move files " + e.toString());
		}
	
		// save the CSRecord
		r.picOneName = picsName[0];
		r.picTwoName = picsName[1];
		r.picThreeName = picsName[2];
		r.save();
		
		//return ok(Play.application().path()+":"+barcode+":"+fileName+":"+contentType);
		return ok("success");
    }

    @play.db.jpa.Transactional
    public static Result inputForm() {
	Query query = JPA.em().createQuery("SELECT r FROM CSRecord r");
	List<CSRecord> rList = query.getResultList();
	return ok(CSInputForm.render(rList.get(rList.size()-1))); 
    }

}
