package com.fh.javatest.rwbinfilebyblocker;

public class BitUtils {
	
	/**  
	    * 将int数值转换为占四个字节的byte数组，本方法适用于(低位在前，高位在后)的顺序。 和bytesToInt（）配套使用 
	    * @param value  
	    *            要转换的int值 
	    * @return byte数组 
	    */    
	public static byte[] intToBytes( int value )   
	{   
	    byte[] src = new byte[4];  
	    src[3] =  (byte) ((value>>24) & 0xFF);  
	    src[2] =  (byte) ((value>>16) & 0xFF);  
	    src[1] =  (byte) ((value>>8) & 0xFF);    
	    src[0] =  (byte) (value & 0xFF);                  
	    return src;   
	}  
	 /**  
	    * 将int数值转换为占四个字节的byte数组，本方法适用于(高位在前，低位在后)的顺序。  和bytesToInt2（）配套使用 
	    */    
	public static byte[] intToBytes2(int value)   
	{   
	    byte[] src = new byte[4];  
	    src[0] = (byte) ((value>>24) & 0xFF);  
	    src[1] = (byte) ((value>>16)& 0xFF);  
	    src[2] = (byte) ((value>>8)&0xFF);    
	    src[3] = (byte) (value & 0xFF);       
	    return src;  
	}  
	
	/**  
	    * byte数组中取int数值，本方法适用于(低位在前，高位在后)的顺序，和和intToBytes（）配套使用 
	    *   
	    * @param src  
	    *            byte数组  
	    * @param offset  
	    *            从数组的第offset位开始  
	    * @return int数值  
	    */    
	public static int bytesToInt(byte[] src, int offset) {  
	    int value;    
	    value = (int) ((src[offset] & 0xFF)   
	            | ((src[offset+1] & 0xFF)<<8)   
	            | ((src[offset+2] & 0xFF)<<16)   
	            | ((src[offset+3] & 0xFF)<<24));  
	    return value;  
	}  
	  
	 /**  
	    * byte数组中取int数值，本方法适用于(低位在后，高位在前)的顺序。和intToBytes2（）配套使用 
	    */  
	public static int bytesToInt2(byte[] src, int offset) {  
	    int value;    
	    value = (int) ( ((src[offset] & 0xFF)<<24)  
	            |((src[offset+1] & 0xFF)<<16)  
	            |((src[offset+2] & 0xFF)<<8)  
	            |(src[offset+3] & 0xFF));  
	    return value;  
	}  
	
	/**  
	    * byte数组中取long数值，本方法适用于(低位在前，高位在后)的顺序，和和longToBytes（）配套使用 
	    *   
	    * @param src  
	    *            byte数组  
	    * @param offset  
	    *            从数组的第offset位开始  
	    * @return int数值  
	    */    
	public static long bytesToLong(byte[] src, int offset) {  
	    long value;    
	    value = (long) ((src[offset] & 0xFF)   
	            | ((src[offset+1] & 0xFF)<<8)   
	            | ((src[offset+2] & 0xFF)<<16)
	            | ((src[offset+3] & 0xFF)<<24) 
	            | ((src[offset+4] & 0xFF)<<32) 
	            | ((src[offset+5] & 0xFF)<<40) 
	            | ((src[offset+6] & 0xFF)<<48) 
	            | ((src[offset+7] & 0xFF)<<56));  
	    return value;  
	}  
	  
	 /**  
	    * byte数组中取long数值，本方法适用于(低位在后，高位在前)的顺序。和longToBytes2（）配套使用 
	    */  
	public static long bytesToLong2(byte[] src, int offset) {  
	    long value;    
	    value = (long) ( ((src[offset] & 0xFF)<<56)  
	    		|((src[offset+1] & 0xFF)<<48)
	    		|((src[offset+2] & 0xFF)<<40)
	    		|((src[offset+3] & 0xFF)<<32)
	    		|((src[offset+4] & 0xFF)<<24)
	            |((src[offset+5] & 0xFF)<<16)  
	            |((src[offset+6] & 0xFF)<<8)  
	            |(src[offset+7] & 0xFF));  
	    return value;  
	}  
}
