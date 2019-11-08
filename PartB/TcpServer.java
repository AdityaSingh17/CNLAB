/* Using TCP/IP sockets, write a client-server program to make the client send the file name and to make the server send back the
   contents of the requested file if present.
   Note: Run the server before the client. If an error occurs, change the port number (From both server and client) and re run the server.
*/
import java.io.*;
import java.net.*;
public class TcpServer
{
    public static void main(String[] args) throws Exception 
    {
        ServerSocket sersock = new ServerSocket(4000);
        System.out.println("Server ready for connection");

        Socket sock = sersock.accept();
        System.out.println("Connection is successful");

        //  Get file name from client
        InputStream istream = sock.getInputStream();
        BufferedReader nameRead = new BufferedReader(new InputStreamReader(istream));
        String fname = nameRead.readLine();

        //  Send file contents to client.
        BufferedReader contentRead = new BufferedReader(new FileReader(fname));
        OutputStream ostream = sock.getOutputStream();
        PrintWriter pwrite = new PrintWriter(ostream, true);

        String str;

        while((str = contentRead.readLine()) != null)
        {
            pwrite.println(str);
        }

        sersock.close();
        sock.close();

        nameRead.close();
        contentRead.close();
        pwrite.close();
    }
}
