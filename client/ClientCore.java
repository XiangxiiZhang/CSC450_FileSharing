public class ClientCORE
{
    private static int nextPort = 3000;

    public static int getNextPortNumber(){
        return nextPort++; 
    }
}