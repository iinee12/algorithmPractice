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
			Socket socket = listener.accept();   //client 응답이 오길 기다린다.
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			
			Date time = new Date();
			String time2 = format.format(time);
			
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);  //소켓 통신의 아웃풋 스트림을 내보낸다.
			out.print(time2);
			socket.close();  //자원 반납
		}finally{
			listener.close();  // 자원 반납
		}	
	}
}
