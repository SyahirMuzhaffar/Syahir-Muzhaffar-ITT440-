import java.io.*;
import java.net.*;

public class clientJ {
    public static void main(String[] args) throws IOException 
	{

        String serverH = new String ("127.0.0.1");

        if (args.length > 0)
           serverH = args[0];
        System.out.println ("Wait for Connect Host " +
                serverH + " on port 10007.");

        Socket echoSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            // echoSocket = new Socket("taranis", 7);
            echoSocket = new Socket(serverH, 10007);
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(
                                        echoSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("No Host: " +serverH);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("NO I/O "
                               + "the connection to: " +serverH);
            System.exit(1);
        }

        BufferedReader stdIn = new BufferedReader(
                                   new InputStreamReader(System.in));
        String userInput;

		 System.out.print ("INFO: ");
        while ((userInput = stdIn.readLine()) != null) {


            out.println(userInput);
            System.out.println("OUT: " + in.readLine());


            System.out.print ("INFO: ");

        }

        out.close();
        in.close();
        stdIn.close();
        echoSocket.close();
    }
}
