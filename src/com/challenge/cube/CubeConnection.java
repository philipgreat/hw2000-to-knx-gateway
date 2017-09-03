/**
 * 
 */
package com.challenge.cube;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;

import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * @author Philip
 *
 */
public class CubeConnection{
	
	
	
	
	
	private String ipAddress;
	private int port;
	private Socket sock;
	private int timeOutInSeconds;
	private OutputStream outputStream;
	private InputStream inputStream;
	public int getTimeOutInSeconds() {
		return timeOutInSeconds;
	}

	public void setTimeOutInSeconds(int timeOutInSeconds) {
		this.timeOutInSeconds = timeOutInSeconds;
	}

	public OutputStream getOutputStream() {
		return outputStream;
	}

	public void setOutputStream(OutputStream outputStream) {
		this.outputStream = outputStream;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	private void close() {
		// TODO Auto-generated method stub
		
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public Socket getSock() {
		return sock;
	}

	public void setSock(Socket sock) {
		this.sock = sock;
	}

	public String auth(String cudeId, String password) throws IOException {
		
		//CubeMessage message = new CubeMessage();
		CubeMessageBody body = new CubeMessageBody().buildLogin(cudeId, password);
		
		return execute(body);
		
		
	}
	public String getConfig() throws IOException {
		
		//CubeMessage message = new CubeMessage();
		CubeMessageBody body = new CubeMessageBody().buildGetConfig();
		
		return execute(body);
		
		
	}
	
	protected String execute(CubeMessageBody body) throws IOException{
		this.getOutputStream().write(CubeMessage.pack(body));
		//byte [] result = this.getInputStream().read(b)
		//read the header first
		byte messageheader[] = new byte[CubeMessage.getHeaderLength()];
		this.getInputStream().read(messageheader);

		CubeMessageHeader header = CubeMessageHeader.parseHeader(messageheader);
		
		
		
		
		ByteBuffer bodyBuffer = ByteBuffer.allocate(header.getMessageLength());
		byte [] bodyData = new byte[1424];
		int readLength = 0;
		int remain = header.getMessageLength();
		while(remain > 0){
			readLength = this.getInputStream().read(bodyData);
			
			bodyBuffer.put(bodyData, 0, readLength);
			
			remain -= readLength;
		}
		

		
		String jsonBody = new String(bodyBuffer.array());
		System.out.println(jsonBody);
		return jsonBody;
	}
	
	public void connect() throws IOException {
		// TODO Auto-generated method stub
		InetAddress addr = InetAddress.getByName(this.getIpAddress());
        SocketAddress sockaddr = new InetSocketAddress(addr, port);
        sock = new Socket();
        timeOutInSeconds= 2;   // 2 seconds
        sock.connect(sockaddr, timeOutInSeconds * 1000);
        this.outputStream = sock.getOutputStream();
        this.inputStream = sock.getInputStream();
        
	}
	public CubeConnection(String ipAddress, int port) {
		// TODO Auto-generated constructor stub
		this.ipAddress = ipAddress;
		this.port = port;
		
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String ipAddress = "192.168.0.104";
		int port = 9000;
		CubeConnection conn = new CubeConnection(ipAddress, port);
		conn.connect();
		String cudeId="001F552A0562";
		String password="12345";
		conn.auth(cudeId,password);
		conn.getConfig();
		conn.getConfig();
		
		conn.close();
		
	}


	
}
