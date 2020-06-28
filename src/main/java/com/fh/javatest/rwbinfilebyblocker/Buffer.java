package com.fh.javatest.rwbinfilebyblocker;

import java.util.List;
import java.util.Map;

public class Buffer {

	private int fileNo=-1;
	private long blockNo=-1;
	private byte blockType;
	private List<Map<String, Object>> data;
	
	public int getFileNo() {
		return fileNo;
	}
	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}
	public long getBlockNo() {
		return blockNo;
	}
	public void setBlockNo(long blockNo) {
		this.blockNo = blockNo;
	}
	public byte getBlockType() {
		return blockType;
	}
	public void setBlockType(byte blockType) {
		this.blockType = blockType;
	}
	public List<Map<String, Object>> getData() {
		return data;
	}
	public void setData(List<Map<String, Object>> data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "Buffer [fileNo=" + fileNo + ", blockNo=" + blockNo
				+ ", blockType=" + blockType + "]";
	}
}
