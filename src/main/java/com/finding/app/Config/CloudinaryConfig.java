package com.finding.app.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;

public class CloudinaryConfig {

	@Autowired
	private static Environment env;
	
	private static Cloudinary cloudinary;
	protected static String cloudName = env.getProperty("finding.app.cloudinary.cloud_name");
	protected static String apiKey = env.getProperty("finding.app.cloudinary.api_key");
	protected static String apiSecret = env.getProperty("finding.app.cloudinary.api_secret");

	
    public static Cloudinary getInstace(){
        if(cloudinary==null){
            cloudinary = new Cloudinary(ObjectUtils.asMap(
                    "cloud_name", cloudName,
                    "api_key", apiKey,
                    "api_secret", apiSecret
            ));
        }
        return cloudinary;
    }
	
}
