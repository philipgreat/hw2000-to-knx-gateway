package com.challenge.cube;

import java.nio.ByteBuffer;
import java.util.Arrays;

public class CubeMessageHeader {
	private static final String FIXED_HEADER = "PHONE_CUBE_PROTOCOL";
	private static final byte[] FIXED_HEADER_DATA = FIXED_HEADER.getBytes();
	
	private int encryptFlag = 0;
	//private String jsonBody;
	private int messageLength;
	
	public int getEncryptFlag() {
		return encryptFlag;
	}
	public void setEncryptFlag(int encryptFlag) {
		this.encryptFlag = encryptFlag;
	}
	public int getMessageLength() {
		return messageLength;
	}
	public void setMessageLength(int messageLength) {
		this.messageLength = messageLength;
	}
	protected static int getLength(CubeMessageBody body){
		
		return getHeaderLength()
				+body.length();
	}
	protected static int getHeaderLength(){
		final int encryptFlagLength = 1;
		final int bodyLengthLength = 4;
		return FIXED_HEADER_DATA.length
				+encryptFlagLength
				+bodyLengthLength;
				
	}
	public static CubeMessageHeader parseHeader(byte []headerData){
		//
		
		if(headerData.length != getHeaderLength()){
			throw new IllegalArgumentException("The header length of the message"
					+ " ("+headerData.length+") is not equal to expected length("+getHeaderLength()+") ");
		}
		ByteBuffer buffer = ByteBuffer.wrap(headerData);
		
		byte [] fixedHeaderData = new byte[FIXED_HEADER_DATA.length];
		buffer.get(fixedHeaderData);
		//check the header if equals the dest byte
		
		if(!Arrays.equals(FIXED_HEADER_DATA, fixedHeaderData)){
			throw new IllegalArgumentException("The fixed header("+new String(fixedHeaderData)+") is not equal to expected value("+FIXED_HEADER+") ");
		}
		CubeMessageHeader header = new CubeMessageHeader();
		
		header.setEncryptFlag((int)buffer.get()); ;
		header.setMessageLength(buffer.getInt());
		
		
		return header;
		
		
		
	}
	
	
}
