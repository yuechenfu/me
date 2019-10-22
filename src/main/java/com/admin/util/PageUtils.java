package com.admin.util;

import org.springframework.web.multipart.MultipartFile;

import com.admin.entity.Pagination;
import com.admin.model.Const;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * 分页工具包
 */
public class PageUtils {

     /**
      * 1.总共8个数
      * 2.当前点击页+3=中间最大
      * @param begRow
      * @param pageRows
      * @param totalRows
      * @return
      */
    public static Pagination createPagination(int currPage, int pageRows, int totalRows){
    	int fristPage = 1;
    	int rangeInitMax = Const.SHOW_PAGE_NUM ;
        int lastPage =  (int)Math.ceil((double)totalRows/(double)pageRows)  ;
        
        int rangeMin = currPage -3 < 2 ? 2 : currPage -3;
        int rangeMax = lastPage ;
    	Pagination p = new Pagination.Builder()
    			.set("fristPage", fristPage)
    			.set("currentPage", currPage)
    			.set("rangeMin", rangeMin)
    			.set("rangeMax", rangeMax)
    			.set("lastPage", lastPage)
    			.build();
    	System.out.println("page ="+p);
    	return p;
    }
    
    public static void main(String[] args) {
    	double a =13;
    	double b = 8;
    	int s =(int) Math.ceil(a/b);
    	System.out.println(s);
    }
}
