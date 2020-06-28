package com.fh.javatest.rwbinfilebyblocker;

public interface Constant {
	public static final int BLOCKSIZE = 512;
	
	public static final int FILENO_OFF=0;
	public static final int FILENO_SIZE=4;
	public static final int BLOCKNO_OFF=FILENO_OFF + FILENO_SIZE;
	public static final int BLOCKNO_SIZE=8;
	public static final int BLOCKTYPE_OFF=BLOCKNO_OFF+BLOCKNO_SIZE;
	public static final int BLOCKTYPE_SIZE=1;
	public static final int BLOCKDATA_LEN_OFF=BLOCKTYPE_OFF+BLOCKTYPE_SIZE;
	public static final int BLOCKDATA_LEN_SIZE=4;
	public static final int BLOCKHEADER_SIZE=FILENO_SIZE
			+BLOCKNO_SIZE
			+BLOCKTYPE_SIZE
			+BLOCKDATA_LEN_SIZE;
	
	public static final int BLOCKBODY_OFF=BLOCKDATA_LEN_OFF+BLOCKDATA_LEN_SIZE;
	
	public static final byte DT_BYTE=0x01;
	public static final byte DT_SHORT=0x02;
	public static final byte DT_INT=0x03;
	public static final byte DT_LONG=0x04;
	public static final byte DT_FLOAT=0x05;
	public static final byte DT_DOUBLE=0x06;
	public static final byte DT_BOOLEAN=0x07;
	public static final byte DT_CHAR=0x08;
	public static final byte DT_OBJECT=0x10;
	public static final byte DT_MAP=0x11;
//	public static final byte DT_BYTE_ARRAY=0x09;
	
	public static final int SIZE_1BYTE=1;
	public static final int SIZE_2BYTE=2;
	public static final int SIZE_3BYTE=3;
	public static final int SIZE_4BYTE=4;
	public static final int SIZE_8BYTE=8;
	
	public static final int DT_BYTE_SIZE=1;
	public static final int DT_SHORT_SIZE=2;
	public static final int DT_INT_SIZE=4;
	public static final int DT_LONG_SIZE=8;
	public static final int DT_FLOAT_SIZE=4;
	public static final int DT_DOUBLE_SIZE=8;
	public static final int DT_BOOLEAN_SIZE=1;
	public static final int DT_CHAR_SIZE=2;
	
	public static final byte BT_DATA=0x01;
	public static final byte BT_BITMAP=0x02;
	public static final byte BT_FILEHEAD=0x03;
}
