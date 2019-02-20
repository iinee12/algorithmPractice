package fileIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileIOPractice {

	public static void main(String[] args) {
		
		String path = FileIOPractice.class.getResource("").getPath();    //�ڹٴ� ����θ� �θ��� ����� ���� Ŭ������ ���� ��θ� �����´�.
		
		File directory = new File(path+"//INPUT");  // ����η� ���� ��ü ����
		
		File[] fList = directory.listFiles(); //�ش� ��ο� �ִ� ������ �迭�� ��������
		
		for( File file : fList ) {
			System.out.println( file.getName() );  //file.getName() ���� �̸��� �����´�.
			System.out.println( file.length() );   //file.length() ������ ũ�⸦ �����´�. ������ byte
			
			if ( file.length() > 2048 ) {  //2MB�� �Ѵ� ������ OUTPUT ������ ����
				CopyFiles(file.getName());
			}
			
		}
		

	}
	
	static void CopyFiles( String filename ) {
		
		final int BUFFER_SIZE = 512;
		int readLen;
		try {
			File finalFolder = new File("./OUTPUT");
			
			// ���丮�� �����ϴ��� �˻��ؼ� ������ �����
			if( !finalFolder.exists() ) {
				finalFolder.mkdir();
			}
			
			InputStream input = new FileInputStream("./INPUT/"+filename);
			OutputStream output = new FileOutputStream("./OUTPUT/"+filename);
			
			byte[] buffer = new byte[BUFFER_SIZE];
			
			while ( (readLen = input.read(buffer)) !=-1 ) {  //readLen�� buffer array��ŭ �о �ִ´�. ���̻� input ��Ʈ���� ������ -1 ��ȯ
				output.write(buffer, 0, readLen);  //buffer�� 0���� �����ؼ� readLen��ŭ output ��Ʈ���� ��� ����.
			}
			
			//�ڿ� ��ȯ
			input.close();
			output.close();
			
			
		}catch (IOException ex) {
			ex.printStackTrace();
		}
		
		
		
	}
	
	

}
