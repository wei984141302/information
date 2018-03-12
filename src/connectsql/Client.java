package connectsql;
import java.io.*;
import java.net.Socket;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Client extends Thread{
    static Socket s;
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式

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

    //从server端得到数据读取并输出
    public void run(){
        sqlinterface dbclient=new sqlinterface();
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
                    String timeclient=df.format(new Date());
                    String sqlstatement = "INSERT INTO log (name, time,content) VALUES ('server', '" +timeclient +"','" + sr + "')";
                    //System.out.println(sqlstatement);
                    dbclient.add(sqlstatement);
                }

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
