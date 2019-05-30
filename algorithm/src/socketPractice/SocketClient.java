package socketPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		
		Socket s = new Socket("나의 IP", 9090);
		BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));  //buffer에 소켓의 input 스트림을 담는다.
		String answer = input.readLine();
		System.out.println(answer);
		
		
		
		//파일 보내기
		
		java.io.OutputStream out = s.getOutputStream()
		byte[] buffer = new byte[4096];
		int readLen;
		FileInputStream inputStream = new FileInputStream(파일경로);
		
		while( (readLen=inputStream.read(buffer)) !=-1 ){
			out.write(buffer,0,readLen);
		}
		inputStream.close();
		
		
		
		
	}

}
