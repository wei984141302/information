package test;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {
	static Socket s;

	// read info from client
	public static void main(String args[]) throws IOException {
		// ͨ��5432�˿ڽ�������

		ServerSocket ss = new ServerSocket(5432);
		// ѭ�����м��������Լ�����������

		// �����˿����󣬵ȴ�����
		System.out.println("waiting connection!!! ");
		s = ss.accept();
		// �õ���socket�����ӵ�����������
		Server server = new Server();
		server.start();
		
		InputStream is = s.getInputStream();
		int len = 0;
		byte[] str = new byte[100];

		while (true) {
			while ((len = is.read(str)) != -1) {
				String sr = new String(str);
				System.out.println(sr);
			}
		}
	}

	// write info to client
	public void run() {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		OutputStream os;
		
		try {
			os= s.getOutputStream();
			String strOut = new String();
			
			while(true){
				strOut = in.readLine();
				os.write(strOut.getBytes());
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}