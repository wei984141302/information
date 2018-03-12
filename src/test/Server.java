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
		// 通过5432端口建立连接

		ServerSocket ss = new ServerSocket(5432);
		// 循环运行监听程序，以监视连接请求

		// 监听端口请求，等待连接
		System.out.println("waiting connection!!! ");
		s = ss.accept();
		// 得到与socket相连接的数据流对象
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