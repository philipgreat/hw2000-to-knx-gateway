package com.chanllenge;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/*Cube 与 手机APP 接口文档

 
固定头:
PHONE_CUBE_PROTOCOL

加密算法(1 Bytes)
(0:不加密，1:chacha加密)
Body length(4 Bytes)
body
Json protocol
*/
public class CubeMessage {
	private static final String FIXED_HEADER = "PHONE_CUBE_PROTOCOL";
	static int encryptFlag = 0;
	private String jsonBody;
	public String getJsonBody() {
		return jsonBody;
	}
	public void setJsonBody(String jsonBody) {
		this.jsonBody = jsonBody;
	}
	protected int getLength(CubeMessageBody body){
		final int encryptFlagLength = 1;
		final int bodyLengthLength = 4;
		return FIXED_HEADER.getBytes().length
				+encryptFlagLength
				+bodyLengthLength
				+body.length();
	}
	public byte[] pack(CubeMessageBody body){
		ByteBuffer buffer = ByteBuffer.allocate(getLength(body));
		buffer.put(FIXED_HEADER.getBytes());
		buffer.put((byte)0);
		buffer.putInt(body.length());
		buffer.put(body.stringBody().getBytes());
		
		return buffer.array();
		
	}
	public CubeMessage unpack(){
		
		return null;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CubeMessage message =new  CubeMessage();
		CubeMessageBody body = new CubeMessageBody();
		
		byte [] data = message.pack(body);
		
		System.out.println(toHex(data));
		/*说明：
1.       协议头24个字节，前19个是字符串常量“PHONE_CUBE_PROTOCOL”
，二进制值是50 48 4F 4E 45 5F 43 55 42 45 5F 50 52 4F 54 4F 43 4F 4C，第20个字节表示是否加密，填0即可。第21~24是body长度，第25个开始是文档中的JSON协议。
例如心跳，{"msgid":"2387r958273894","action":"request","subaction":"heartbeat"}，包含协议头的完整的二进制数据是：
50 48 4F 4E 45 5F 43 55 42 45 5F 50 52 4F 54 4F 43 4F 4C 00 00 00 00 44 7B 22 6D 73 67 69 64 22 3A 22 
32 33 38 37 72 39 35 38 32 37 33 38 39 34 22 2C 22 61 63 74 69 6F 6E 22 3A 22 72 65 71 75 65 73 74 22
 2C 22 73 75 62 61 63 74 69 6F 6E 22 3A 22 68 65 61 72 74 62 65 61 74 22 7D
*/
	}
	
	protected static String toHex(byte[] data) {

		StringBuilder stringBuilder = new StringBuilder();
	    for (byte b : data) {
	        stringBuilder.append(String.format("%02X ", b));
	    }
	    return stringBuilder.toString();
	}
	
	
}
