package socketPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		
		Socket s = new Socket("���� IP", 9090);
		BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));  //buffer�� ������ input ��Ʈ���� ��´�.
		String answer = input.readLine();
		System.out.println(answer);
		
	}

}
