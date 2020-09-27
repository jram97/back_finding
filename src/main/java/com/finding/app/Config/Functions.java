package com.finding.app.Config;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

public class Functions {

	public static File convert(MultipartFile file) throws IOException {
		File convFile = new File(file.getOriginalFilename());
		FileOutputStream fos = new FileOutputStream(convFile);
		fos.write(file.getBytes());
		fos.close();
		return convFile;
	}
	
	@SuppressWarnings("rawtypes")
	public static Map upload(MultipartFile cover){
		Cloudinary cloudinary = CloudinaryConfig.getInstace();
		Map uploadResult = null;
		try {
			uploadResult = cloudinary.uploader().upload(cover.getBytes(), ObjectUtils.asMap("folder","finding"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return uploadResult;
	}
	
	public static void delete(String public_id){
		Cloudinary cloudinary = CloudinaryConfig.getInstace();
		try {
			cloudinary.uploader().destroy(public_id, ObjectUtils.asMap("folder","finding"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}	
	
}
