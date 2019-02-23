package socketPractice;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SocketServer {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		ServerSocket listener = new ServerSocket();
		try {
			Socket socket = listener.accept();   //client ������ ���� ��ٸ���.
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			
			Date time = new Date();
			String time2 = format.format(time);
			
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);  //���� ����� �ƿ�ǲ ��Ʈ���� ��������.
			out.print(time2);
			socket.close();  //�ڿ� �ݳ�
		}finally{
			listener.close();  // �ڿ� �ݳ�
		}	
	}
}
