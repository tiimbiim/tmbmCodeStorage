package frc.Vision;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.concurrent.ConcurrentHashMap;

import frc.Vision.SensorObject;
import frc.Vision.SensorObjContainer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class UDPServerThread extends Thread {
    static DatagramSocket socket = null;

    private static final int PORT_NUMBER = 5005;

    private String threadName = "UDPServer";

    public static char val;

    public static InetAddress IPAddress;
    public static int port;



    public UDPServerThread() 
    {
        this.setName(threadName);
        System.out.println("Starting UDP Server");
    }

    public void run()
    {
        try
        {
            socket = new DatagramSocket(PORT_NUMBER);

            byte[] incomingData;

            while (true)
            {
                incomingData = new byte[256];
                ConcurrentHashMap<String, SensorObject> chm;
                DatagramPacket incomingPacket = new DatagramPacket(incomingData, incomingData.length);

                socket.receive(incomingPacket);

                byte[] data = incomingPacket.getData();

                try
                {
                    //constructing a string using a byte array will cause the constructed
                    //string to have the exact length of the byte array which means a lot
                    //of trailing whitespace.
                    String json = new String(data).trim();

                    Gson gson   = new GsonBuilder().create();

                    Type map    = new TypeToken<ConcurrentHashMap<String, SensorObject>>(){}.getType();

                    chm = gson.fromJson(json, map);
                    SensorObjContainer.overwriteMap(chm);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }

                IPAddress = incomingPacket.getAddress();
                port      = incomingPacket.getPort();

               /* String reply = "ack";
                byte[] replyBytes = reply.getBytes();

                DatagramPacket replyPacket = new DatagramPacket(replyBytes, 
                                                                replyBytes.length, 
                                                                IPAddress, 
                                                                port);
                
                socket.send(replyPacket);
                */
                
                val = 'L';

                String str     = String.format("%c", val); 
                byte[] strByte = str.getBytes();

                if(IPAddress != null)
                {
                    DatagramPacket target = new DatagramPacket(strByte, strByte.length, IPAddress, port);
                    socket.send(target);
                }

                Thread.sleep(10);
            }
        }
        catch (SocketException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

    }

    public static void targetRight() throws IOException
    {
        val = 'R';
    }
}