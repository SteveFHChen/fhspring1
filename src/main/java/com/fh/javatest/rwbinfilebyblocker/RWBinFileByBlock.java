package com.fh.javatest.rwbinfilebyblocker;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class RWBinFileByBlock {

	public Map<Integer, String> files = new HashMap<Integer, String>();
	public List<Buffer> buffers = new LinkedList<Buffer>();
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		RWBinFileByBlock f1 = new RWBinFileByBlock();
		f1.files.put(1, "d:/fhtemp/rtest.dat");
		RandomAccessFile rf = new RandomAccessFile(f1.files.get(1), "rw");
		
		int blocks = 8;
		/*
		//test create a binary file
		f1.initFile(rf, 1, blocks);
		//test check the block in the binary file
		f1.checkBadBlock(rf);
		
		//Test : write a List<Map> to a block;
		Buffer buffer0 = new Buffer();
		buffer0.setFileNo(1);
		buffer0.setBlockNo(0);
		buffer0.setBlockType(Constant.BT_BITMAP);
		List records = new ArrayList<>();
		Map r0 = new HashMap();
		r0.put("FILENO", 1);
		r0.put("STARTBLOCKNO", 0);
		r0.put("BLOCKS", blocks);
		r0.put("BITMAP", new byte[blocks/8]);
		records.add(r0);
		buffer0.setData(records);
		byte[] block = f1.decodeBlock(buffer0);
		f1.writeBlock(rf, block);
		
		Buffer buffer1 = new Buffer();
		buffer1.setFileNo(1);
		buffer1.setBlockNo(1);
		buffer0.setBlockType(Constant.BT_DATA);
		records = new ArrayList<>();
		Map r1 = new HashMap();
		r1.put("ID", 1001);
		r1.put("NAME", "Zhang3");
		r1.put("AGE", 18);
		records.add(r1);
		Map r2 = new HashMap();
		r2.put("BOX", "B1");
		r2.put("length", 5);
		r2.put("WIDTH", 4);
		r2.put("HEIGHT", 3);
		records.add(r2);
		buffer1.setData(records);
		
		block = f1.decodeBlock(buffer1);
		f1.writeBlock(rf, block);*/
		
		//Test : read a records from a block;
		byte[] block = f1.getBlock(rf, 0);
		Buffer buffer1 = f1.parseBlock(block);
		System.out.println(buffer1);
		for(Object r : buffer1.getData())
			System.out.println(r);
		
        rf.close();  
	}

	public void initFile(RandomAccessFile rf, int fileNo, long blocks) throws IOException{
		/**
		 * Block design:
		 * Block Header, Block Body
		 * 
		 * Block ID:
		 * 0~3 4byte-int file No, 4~11 8byte-long block No
		 * file No || block No = block ID
		 * 
		 * Block Data Length: int
		 * 
		 * Block Data:
		 * MyObject = MyHeader + MyBody
		 * MyHeader = DataType (1byte) + DataLength(4byte)
		 * DateType: 
		 * 		0x01-byte(1byte), 0x02-short(2byte), 0x03-int(4byte), 0x04-long(8byte) 
		 * 		0x05-float(4byte), 0x06-double(8byte)
		 * 		0x07-boolean(1byte), 0x08-char(2byte)
		 * 		0x10-Object(x byte), 0x11-Map(x byte)
		 * 
		 * BitMap block:
		 * 	fileNo, startBlockNo
		 * 
		 * FileBlock --getBlock--> BufferBlock --parseBlock-->JavaObjects
		 * FileBlock --getBlock--> BufferBlock --decodeBlock--> BufferBlock2 --writeBlock--> FileBlock
		 */
		byte[] initBlock = new byte[Constant.BLOCKSIZE];
        for (int i = 0; i < Constant.BLOCKSIZE; i++) {  
            initBlock[i]=(byte) 0x00;
        }  
        initBlock[Constant.BLOCKSIZE - 1] = (byte) 0xff;
        
        for(long i=0; i<blocks; i++){
        	rf.writeInt(fileNo);
        	rf.writeLong(i);
        	rf.write(initBlock, 12, Constant.BLOCKSIZE - 12);
        }
	}
	
	public void checkBadBlock(RandomAccessFile rf){
		long blocks;
		byte[] blockBackUp = new byte[Constant.BLOCKSIZE];
		byte[] block4Check = new byte[Constant.BLOCKSIZE];
		for (int i = 0; i < Constant.BLOCKSIZE; i++) {  
			block4Check[i]=(byte) 0xff;
        } 
		try {
			blocks = rf.length()/Constant.BLOCKSIZE;
		
			for(long i=0; i< blocks; i++){
				//step 1: backup the exists value
				rf.seek(Constant.BLOCKSIZE * i);
				rf.read(blockBackUp, 0, Constant.BLOCKSIZE);
				
				//step 2: write check value
//				rf.write(block4Check);
				for(int j=0; j<12; j++)
					block4Check[j] = blockBackUp[j];
				writeBlock(rf, block4Check);
				
				//step 3: read the value at last write
				byte[] block = getBlock(rf, i);
				
				//step 4: check the value whether is same as write
				for(int bi=0; bi<Constant.BLOCKSIZE; bi++)
					if(block4Check[bi]!=block[bi])
						System.out.println("A bad byte!");
				//step 5: output check result
				
				//step 6: write back the exists value
				rf.seek(Constant.BLOCKSIZE * i);
				rf.write(blockBackUp);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setBlockBitStatus(int fileNo, long blockNo, boolean isFree){
		
	}
	
	public byte[] findFreeBlock(int fileNo){
		for(Buffer buffer: this.buffers){
			if(buffer.getBlockType()==Constant.BT_BITMAP && buffer.getFileNo()==fileNo){
				for(Map map : buffer.getData()){
					byte[] bitMap = (byte[])map.get("BITMAP");
					for(int i=0; i<bitMap.length; i++){
						byte value = 0x01;
						byte result = 0x11;
						for(int j=0; j<8; j++){
							result = (byte) (bitMap[i] & value<<j);
							if(result==0x00){//find the first free block
								//1. occupy the block first
								bitMap[i]=(byte)(bitMap[i] | value<<j);
								//2. Get block and return
								int blockNo = i*8+j;
								return this.getBlock(fileNo, blockNo);
							}
						}
					}
				}
			}
		}
		System.out.println("Cannot find free block in file ["+fileNo+"]:"+this.files.get(fileNo));
		return null;
	}
	
	public byte[] getBlock(RandomAccessFile rf, long blockNo){
		byte[] block = new byte[Constant.BLOCKSIZE];
		try {
			rf.seek(Constant.BLOCKSIZE * blockNo);
			int len = rf.read(block, 0, Constant.BLOCKSIZE);
			if(len!=Constant.BLOCKSIZE) 
				System.out.println("Get block ["+blockNo+"] failed-1!");
			return block;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Get block ["+blockNo+"] failed-2!");
		return null;
	}
	
	public byte[] getBlock(int fileNo, long blockNo){
		/**
		 * If fileNo or BlockNo is null or 0, then we should find a free block for it.
		 */
		RandomAccessFile rf = null;
		try {
			if(this.files.get(fileNo)!=null){
				rf = new RandomAccessFile(this.files.get(fileNo), "rw");
			}
			return getBlock(rf, blockNo);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(null!=rf)
				try {
					rf.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		return null;
	}
	
	public boolean writeBlock(RandomAccessFile rf, byte[] block){
		try {
			//step 1: get blockNo from block
			long blockNo = BitUtils.bytesToLong2(block, 4);
			System.out.println("Write block ["+blockNo+"] to disk.");
			
			//step 2: seek position
			rf.seek(Constant.BLOCKSIZE * blockNo);
			
			//step 3: write data
			rf.write(block);
			
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public Buffer parseBlock(byte[] block){
		Buffer buffer = new Buffer();
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		int blockPoint=Constant.BLOCKBODY_OFF;
		
		//Step 1: parse header
		buffer.setFileNo(BitUtils.bytesToInt2(block, Constant.DT_INT_SIZE));
		buffer.setBlockNo(BitUtils.bytesToLong2(block, Constant.DT_LONG_SIZE));
		buffer.setBlockType(block[Constant.BLOCKTYPE_OFF]);
		
		//Step 2: parse body
		byte dataType = 0;
		
		int blockDataLength = BitUtils.bytesToInt2(block, Constant.BLOCKDATA_LEN_OFF);
		//Only read data part
		while(blockPoint<Constant.BLOCKBODY_OFF+blockDataLength && 0x00!=(dataType = block[blockPoint])){
			blockPoint+=Constant.SIZE_1BYTE;
			
			int dataLength = BitUtils.bytesToInt2(block, blockPoint);
			blockPoint+=Constant.DT_INT_SIZE;
			
			switch(dataType){
			case Constant.DT_BYTE:
				break;
			case Constant.DT_SHORT:
				break;
			case Constant.DT_INT:
				break;
			case Constant.DT_LONG:
				break;
			case Constant.DT_BOOLEAN:
				break;
			case Constant.DT_CHAR:
				break;
			case Constant.DT_MAP:
				Map m = (Map) ByteObjectUtils.getObjectFromBytes(block, blockPoint, dataLength);
				list.add(m);
				blockPoint+=dataLength;
				break;
			case Constant.DT_OBJECT:
				break;
			default:
				System.out.println("Unknow data type:"+dataType);
				break;
			}
		}
		buffer.setData(list);
		return buffer;
	}
	
	public byte[] decodeBlock(Buffer buffer){
		/**
		 * Suppose one block can contain all data in the buffer.
		 * In future, if one block can not contain, then will find a new free block automatically.
		 */
		try{
			byte[] block=null;
			int blockPoint=Constant.BLOCKBODY_OFF;
			
			//Step 1: Get block first
			/**
			 * If fileNo or BlockNo is null or 0, then we should find a free block for it.
			 */
			if(buffer.getFileNo()==-1 && buffer.getBlockNo()==-1){
				//find a free block for the buffer
				//Step 1: find free block
				//Step 2: fill fileNo and blockNo into buffer property
				block=findFreeBlock(1);//currently, hardcode the fileNo.
			}else{
				block=getBlock(buffer.getFileNo(), buffer.getBlockNo());
			}
			
			//Step 2: decode data
			for(Object obj : buffer.getData()){
				if(obj instanceof Map){
					byte[] obj_byte = ByteObjectUtils.getBytesFromObject(obj);
					
					//Write data type
					block[blockPoint]=Constant.DT_MAP;
					blockPoint+=Constant.SIZE_1BYTE;
					
					//Write data length
					byte[] lengthByte = BitUtils.intToBytes2(obj_byte.length);
					for(int i=0; i<lengthByte.length; i++){
						block[blockPoint+i]=lengthByte[i];
					}
					blockPoint+=Constant.DT_INT_SIZE;
					
					//Write data content
					for(int i=0; i<obj_byte.length; i++){
						block[blockPoint+i]=obj_byte[i];
					}
					blockPoint+=obj_byte.length;
				}
			}
			int blockDataLength = blockPoint - Constant.BLOCKBODY_OFF;
			byte[] blockDataLength_byte = BitUtils.intToBytes2(blockDataLength);
			for(int i=0; i<blockDataLength_byte.length; i++)
				block[Constant.BLOCKDATA_LEN_OFF+i]=blockDataLength_byte[i];
			return block;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	
}
