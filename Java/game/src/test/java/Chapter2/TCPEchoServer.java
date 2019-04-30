import java.net.*;  // for Socket, ServerSocket, and InetAddress
import java.io.*;   // for IOException and Input/OutputStream

public class TCPEchoServer {

  private static final int BUFSIZE = 32;   // Size of receive buffer

  public static void main(String[] args) throws IOException, InterruptedException {

    if (args.length != 1)  // Test for correct # of args
      throw new IllegalArgumentException("Parameter(s): <Port>");

    int servPort = Integer.parseInt(args[0]);

    // Create a server socket to accept client connection requests
    ServerSocket servSock = new ServerSocket(servPort);//nalan_*:socket:*; 一旦建立了server监听，客户端连接就不会被拒绝了，而是进入队列等候

    int recvMsgSize;   // Size of received message
    byte[] receiveBuf = new byte[BUFSIZE];  // Receive buffer

    while (true) { // Run forever, accepting and servicing connections
      //nalan_*:socket:*; 没有客户端连接进来就一直阻塞在这里
      Socket clntSock = servSock.accept();     // Get client connection

//      Thread.sleep(10000);  //nalan

      SocketAddress clientAddress = clntSock.getRemoteSocketAddress();
      System.out.println("Handling client at " + clientAddress);
      
      InputStream in = clntSock.getInputStream();
      OutputStream out = clntSock.getOutputStream();

      // Receive until client closes connection, indicated by -1 return
      while ((recvMsgSize = in.read(receiveBuf)) != -1) { //nalan_*:socket:*; 这里buffer的大小与接收的数据长度没有关系
        out.write(receiveBuf, 0, recvMsgSize);
      }

      clntSock.close();  // Close the socket.  We are done with this client!
    }
    /* NOT REACHED */
  }
}
