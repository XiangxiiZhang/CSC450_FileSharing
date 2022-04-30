import java.io.DataOutputStream;
import java.util.ArrayList;

public class CORE 
{
    private static ArrayList<DataOutputStream> theClientDOSsss= new ArrayList<DataOutputStream>();

    public synchronized static void addDOS(DataOutputStream dos)
    {
        CORE.theClientDOSsss.add(dos);
    }
    
    public static synchronized void removeReceivers()
    {
        for(DataOutputStream dos : CORE.theClientDOSsss)
        {
            for(PrintStream ps : CORE.theClientPrintStreams)
            {
                ps.println(s);
            }
            
        }
    }
    public static String getConnectedClientIPsString()
    {
        String answer = "";
        for(int i = 0; i < CORE.theConnectedClientIPs.size(); i++)
        {
            if(answer.length()==0)
            {
                answer = answer + CORE.theConnectedClientIPs.get(i);
            }
            else
            {
                answer = answer + "," + CORE.theConnectedClientIPs.get(i);
            }
        }
        return answer;
    }
    public synchronized static voidchangeConnectedClientIPs(String ip, boolean shouldAdd)
    {
        //if shouldAdd is true, we are adding the ip, else we are removing the IP
        if(shouldAdd)
        {
            CORE.theConnectedClientIPs.add(ip);
        }
        else
        {
            for(int i = 0; i < CORE.theConnectedClientIPs.size(); i++)
            {
                if(CORE.theConnectedClientIPs.get(i).equals(ip))
                {
                    CORE.theConnectedClientIPs.remove(i);
                    return;
                }
            }
        }
    }
}
