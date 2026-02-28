import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ex49_server {
  public static void main(String[] args) {
    try {
      ServerSocket serverSocket = new ServerSocket();
      serverSocket.bind(new InetSocketAddress("localhost", 5001));
      while (true) { //무한루프
        System.out.println("서버가 연결을 기다리는 중...");
        Socket socket = serverSocket.accept();  //동기(Sync), 무한대기중...
        InetSocketAddress isa =
            (InetSocketAddress)socket.getRemoteSocketAddress();
        System.out.println("서버가 연결을 수락함:"+isa.getHostName());

        //클라이언트의 데이터를 수신한다.
        byte[] bytes = null;
        String message = null;
        InputStream is = socket.getInputStream();
        bytes = new byte[1024]; //1024바이트만큼 버퍼 생성
        int readByteCount = is.read(bytes);
        message = new String(bytes, 0, readByteCount, "UTF-8");
        System.out.println("서버가 데이터받기 성공함.");
        System.out.println("서버가 받은 데이터:" + message);

        //서버가 클라이언트에 데이터 보내기
        OutputStream os = socket.getOutputStream();
        message = "Hi~ This is Server~";
        bytes = message.getBytes("UTF-8");
        os.write( bytes );
        os.flush();
        System.out.println("서버가 클라에게 데이터보내기 성공!");

        is.close();
        os.close();
        socket.close();
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}
