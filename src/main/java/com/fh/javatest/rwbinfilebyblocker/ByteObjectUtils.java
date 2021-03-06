package com.fh.javatest.rwbinfilebyblocker;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ByteObjectUtils {
    /**  
     * 文件转化为字节数组  
     * @EditTime 2007-8-13 上午11:45:28  
     */   
    public static byte[] getBytesFromFile(File f) {   
        if (f == null) {   
            return null;   
        }   
        try {   
            FileInputStream stream = new FileInputStream(f);   
            ByteArrayOutputStream out = new ByteArrayOutputStream(1000);   
            byte[] b = new byte[1000];   
            int n;   
            while ((n = stream.read(b)) != -1) {  
                out.write(b, 0, n);   
               }  
            stream.close();   
            out.close();   
            return out.toByteArray();   
        } catch (IOException e) {   
        }   
        return null;   
    }   
  
    /** 
     * 把字节数组保存为一个文件  
     * @EditTime 2007-8-13 上午11:45:56  
     */   
    public static File getFileFromBytes(byte[] b, String outputFile) {   
        BufferedOutputStream stream = null;   
        File file = null;   
        try {   
            file = new File(outputFile);   
            FileOutputStream fstream = new FileOutputStream(file);   
            stream = new BufferedOutputStream(fstream);   
            stream.write(b);   
        } catch (Exception e) {   
            e.printStackTrace();   
        } finally {   
            if (stream != null) {   
                try {   
                    stream.close();   
                } catch (IOException e1) {   
                    e1.printStackTrace();   
                }   
            }   
        }   
        return file;   
    }   
  
    /**  
     * 从字节数组获取对象  
     * @EditTime 2007-8-13 上午11:46:34  
     */   
    public static Object getObjectFromBytes(byte[] objBytes) throws Exception {   
        if (objBytes == null || objBytes.length == 0) {   
            return null;   
        }   
        ByteArrayInputStream bi = new ByteArrayInputStream(objBytes);   
        ObjectInputStream oi = new ObjectInputStream(bi);   
        return oi.readObject();   
    }
    
    public static Object getObjectFromBytes(byte[] src, int offset, int length) {
    	try {
	        if (src == null || src.length == 0) {   
	            return null;   
	        }   
	        ByteArrayInputStream bi = new ByteArrayInputStream(src, offset, length);   
	        ObjectInputStream oi = new ObjectInputStream(bi);   
	        
			return oi.readObject();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    	return null;
    }
  
    /** 
     * 从对象获取一个字节数组  
     * @EditTime 2007-8-13 上午11:46:56  
     */   
    public static byte[] getBytesFromObject(Object obj) {   
    	try {
	        if (obj == null) {   
	            return null;   
	        }else if(!(obj instanceof Serializable)){
	        	System.out.println("Object is not serializable.");
	        	return null;
	        }
	        ByteArrayOutputStream bo = new ByteArrayOutputStream();   
	        ObjectOutputStream oo = new ObjectOutputStream(bo);   
	        
			oo.writeObject(obj);
			return bo.toByteArray();   
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
        
    	return null;
    }   
}
