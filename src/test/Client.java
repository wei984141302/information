package test;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class Client extends Thread{
	static Socket s;

	public static void main(String args[]) throws IOException {

		// 在端口5432打开连接
		s = new Socket("127.0.0.1", 5432);
		// 获得socket端口的输入句柄，并从中读取数据
		if (s.isConnected()) {
			System.out.println("client connected!!!");
		}

		Client client = new Client();
		client.start();
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		OutputStream os;

		try {
			os = s.getOutputStream();
			String strOut = new String();

			while (true) {
				strOut = in.readLine();
				os.write(strOut.getBytes());
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void run(){
		// 得到与socket相连接的数据流对象
		InputStream is = null;
		try {
			is = s.getInputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int len = 0;
		byte[] str = new byte[100];

		while (true) {
			try {
				while ((len = is.read(str)) != -1) {
					String sr = new String(str);
					System.out.println(sr);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}