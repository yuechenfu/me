package com.pib.admin.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * 文件上传工具包
 */
public class FileUtils {

    /**
     *
     * @param file 文件
     * @param path 文件存放路径
     * @param fileName 源文件名
     * @return
     */
    public static boolean upload(MultipartFile file, String path, String fileName){
        // 生成新的文件名
    	String name = file.getOriginalFilename();
        String realPath = path + "/" + name; 
        File dest = new File(realPath);
        //判断文件父目录是否存在
        if(!dest.getParentFile().exists())dest.getParentFile().mkdir();
        
        try {
            //保存文件
            file.transferTo(dest);
            return true;
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }
   /**
    * 
    * @param file
    * @return
    */
    public static byte[]  fileStream(MultipartFile file) throws Exception{
    	InputStream ins = file.getInputStream();
        byte[] buffer=new byte[1024];
        int len=0;
        ByteArrayOutputStream bos=new ByteArrayOutputStream();
        while((len=ins.read(buffer))!=-1){
            bos.write(buffer,0,len);
        }
        bos.flush();
        byte data[] = bos.toByteArray();
        
        return data;

    }
    /**
     * 获取文件后缀
     * @param fileName
     * @return
     */
    public static String getSuffix(String fileName){
        return fileName.substring(fileName.lastIndexOf("."));
    }
    /**
     * 生成新的文件名
     * @param fileOriginName 源文件名
     * @return
     */
    public static String getFileName(String fileOriginName){
        return getUUID() + getSuffix(fileOriginName);
    }
    
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }
    
    public static String bytesToHexString(byte[] src){      
        StringBuilder stringBuilder = new StringBuilder();      
        if (src == null || src.length <= 0) {      
            return null;      
        }      
        for (int i = 0; i < src.length; i++) {      
            int v = src[i] & 0xFF;      
            String hv = Integer.toHexString(v);      
            if (hv.length() < 2) {      
                stringBuilder.append(0);      
            }      
            stringBuilder.append(hv);      
        }      
        return stringBuilder.toString();      
    }  
   
    
    public static String getTypeByStream(byte[] fileTypeByte){  
        
        String type = bytesToHexString(fileTypeByte).toUpperCase(); 
        
        if(type.contains("FFD8FF")){  
         return "jpg";  
        }else if(type.contains("89504E47")){  
         return "png";  
        }else if(type.contains("47494638")){  
         return "gif";  
        }else if(type.contains("49492A00")){  
         return "tif";  
        }else if(type.contains("424D")){  
         return "bmp";
        }else {
     	   return "jpg";
        }
    }
   

}
