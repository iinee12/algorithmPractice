package fileIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileIOPractice {

	public static void main(String[] args) {
		
		//Scanner scan = new Scanner(System.in);  //자바 입력받기
		//String message = "";
		//message = scan.nextLine();
		
		File directory = new File("./INPUT");  // 상대경로로 ./이면 프로젝트 기준 최상위다
		
		
		
		//여러개의 파일로 지랄할때
		File[] fList = directory.listFiles(); //해당 경로에 있는 파일을 배열로 가져오기
		
		for( File file : fList ) {
			System.out.println( file.getName() );  //file.getName() 파일 이름을 가져온다.
			System.out.println( file.length() );   //file.length() 파일의 크기를 가져온다. 단위는 byte
			
			if ( file.length() > 2048 ) {  //2MB가 넘는 파일은 OUTPUT 폴더에 복사
				CopyFiles(file.getName());
			}
			
		}
		
		
		//단일파일 하나로 
		FileReader filereader = new FileReader(file);
                //입력 버퍼 생성
                BufferedReader bufReader = new BufferedReader(filereader);
                String line = "";
                while((line = bufReader.readLine()) != null){
                   System.out.println(line);
                }
                //.readLine()은 끝에 개행문자를 읽지 않는다.            
                bufReader.close();


	}
	
	static void CopyFiles( String filename ) {
		
		final int BUFFER_SIZE = 512;
		int readLen;
		try {
			File finalFolder = new File("./OUTPUT");
			
			// 디렉토리가 존재하는지 검사해서 없으면 만들기
			if( !finalFolder.exists() ) {
				finalFolder.mkdir();
			}
			
			InputStream input = new FileInputStream("./INPUT/"+filename);
			OutputStream output = new FileOutputStream("./OUTPUT/"+filename);
			
			byte[] buffer = new byte[BUFFER_SIZE];
			
			while ( (readLen = input.read(buffer)) !=-1 ) {  //readLen에 buffer array만큼 읽어서 넣는다. 더이상 input 스트림이 없으면 -1 반환
				output.write(buffer, 0, readLen);  //buffer에 0부터 시작해서 readLen만큼 output 스트림을 계속 쓴다.
			}
			
			//자원 반환
			input.close();
			output.close();
			
			
		}catch (IOException ex) {
			ex.printStackTrace();
		}
		
		
		
	}
	
	

}
