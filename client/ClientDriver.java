
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientDriver 
{
    //the below info would have been gleened from a .torrent file
    private static String TRACKERIP = "localhost";
    private static int TRACKERPORT = 6881;

    public static void main(String[] args) throws Exception
    {
        Socket s = new Socket(TRACKERIP, TRACKERPORT);
        /*
        Scanner textInput = new Scanner(s.getInputStream());
        Scanner localInput = new Scanner(System.in);
        PrintStream textOutput = new PrintStream(s.getOutputStream());
        String question = textInput.nextLine();
        System.out.print(question);
        String answer = localInput.nextLine();
        textOutput.println(answer);
        if(answer.equals("send"))
        {
            try
            {
                String filename = "cambria.jpeg";
                FileInputStream fis = new FileInputStream(filename);
                DataInputStream dis = new DataInputStream(fis);
                DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                while(true)
                {
                    byte b = dis.readByte();
                    dos.writeByte(b);
                }
            }
            catch(EOFException e)
            {
                System.out.println("Finished Sending File");
            }
        }
        else if(answer.equals("receive"))
        {
            //receive the bytes and write to a local file
            FileOutputStream fos = new FileOutputStream("cambriaCopy.jpeg");
            DataOutputStream dos = new DataOutputStream(fos);
            try
            {
                DataInputStream dis_Client = new DataInputStream(s.getInputStream());
                while(true)
                {
                    byte b = dis_Client.readByte();
                    dos.writeByte(b);
                }
            }
            catch (EOFException e)
            {
                System.out.println("File Received");
                fos.close();
                System.exit(0);
            }
            catch(IOException e)
            {
                e.printStackTrace();
                
            }
            
        }
        */
        Socket s = new Socket(TRACKERIP, TRACKERPORT);
        Scanner socketInput = new Scanner(s.getInputStream());
        PrintStream socketOutput = new PrintStream(s.getOutputStream());
        socketOutput.println(Inet4Address.getLocalHost().getHostAddress());
        String listOfConnectedClients = socketInput.nextLine();
        ClientCORE.updateTheConnectedClientIPs(listOfConnectedClients);
        
        //In our main thread here, we want to start the torrent process of sharing bits
        while(true){
            
        }
    }
}
