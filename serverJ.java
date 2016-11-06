import java.net.*;
import java.io.IOException;
import java.io.*;
import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;


public class serverJ
{
 public static void main(String[] args) throws IOException,InterruptedException 
   {
    ServerSocket serverSocket = null;

    try {
         serverSocket = new ServerSocket(10007);
        }
    catch (IOException e)
        {
         System.err.println("No I/O From: 10007.");
         System.exit(1);
        }

    Socket clientSocket = null;
System.out.println ("Wait For Respond.....");

    try {
         clientSocket = serverSocket.accept();
        }
    catch (IOException e)
        {
         System.err.println("FAILED.");
         System.exit(1);
        }

    System.out.println ("SUCCESS");

// create gpio controller
        final GpioController gpio = GpioFactory.getInstance();

        // provision gpio pin #01 as an output pin and turn on
        final GpioPinDigitalOutput pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "MyLED", PinState.HIGH);

        // set shutdown state for this pin
        pin.setShutdownOptions(true, PinState.LOW);

        System.out.println("--> GPIO state should be: ON");

      // Thread.sleep(5000);  

        // turn off gpio pin #01
       // pin.low();



    System.out.println ("WAIT FOR RESPOND.....");

    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),
                                      true);
    BufferedReader in = new BufferedReader(
            new InputStreamReader( clientSocket.getInputStream()));
			
			
			
			String inputLine;

    while ((inputLine = in.readLine()) != null)
        {


         if( inputLine != null) {
         System.out.println ("CLIENT'S MESSAGE: " + inputLine);
         out.println(inputLine); }


         if (inputLine.equals("OUT."))
             break;
        }

    out.close();
    in.close();
    clientSocket.close();
    pin.low();
   System.out.println("LED OFF");
    serverSocket.close();
   }
   }

