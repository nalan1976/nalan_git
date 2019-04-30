import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DelimFramer implements Framer {

  private InputStream in;        // data source
  private static final byte DELIMITER = '\n'; // message delimiter

  public DelimFramer(InputStream in) {
    this.in = in;
  }

  public void frameMsg(byte[] message, OutputStream out) throws IOException {
    // ensure that the message does not contain the delimiter
    for (byte b : message) {
      if (b == DELIMITER) {
        throw new IOException("Message contains delimiter");
      }
    }
    out.write(message);
    out.write(DELIMITER); //运行时绑定public abstract void write(int b) throws IOException，将指定的字节写入此输出流。write 的常规协定是：向输出流写入一个字节。要写入的字节是参数 b 的八个低位。b 的 24 个高位将被忽略。
    out.flush();
  }

  public byte[] nextMsg() throws IOException {
    ByteArrayOutputStream messageBuffer = new ByteArrayOutputStream();
    int nextByte;

    // fetch bytes until find delimiter
    while ((nextByte = in.read()) != DELIMITER) {
      if (nextByte == -1) { // end of stream?
        if (messageBuffer.size() == 0) { // if no byte read
          return null;  //表示全部消息已接收完?
        } else { // if bytes followed by end of stream: framing error
          throw new EOFException("Non-empty message without delimiter");
        }
      }
      messageBuffer.write(nextByte); // write byte to buffer
    }

    return messageBuffer.toByteArray();
  }
}
