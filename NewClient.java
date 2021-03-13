

	
	// A Java program for a Client 
	import java.net.*; 
	import java.io.*; 
	  
	public class NewClient 
	{ 
	    // initialize socket and input output streams 
	    private Socket socket            = null; 
	    private DataInputStream  input   = null; 
	    private DataOutputStream out     = null; 
	    private DataInputStream  inp   = null; 
	  
	    // constructor to put ip address and port 
	    public NewClient(String address, int port) 
	    { 
	        // establish a connection 
	        try
	        { 
	            socket = new Socket(address, port); 
	            System.out.println("Connected"); 
	  
	            // takes input from terminal 
	            input  = new DataInputStream(System.in); 
	            
	            inp = new DataInputStream(new BufferedInputStream(socket.getInputStream())); 
	  
	            // sends output to the socket 
	            out    = new DataOutputStream(socket.getOutputStream()); 
	        } 
	        catch(UnknownHostException u) 
	        { 
	            System.out.println(u); 
	        } 
	        catch(IOException i) 
	        { 
	            System.out.println(i); 
	        } 
	  
	        // string to read message from input 
	        String line = ""; 
	        
	        String line2 = "";
	  
	        // keep reading until "Over" is input 
	        while (!line.equals("Over")) 
	        { 
	            try
	            { System.out.println("Enter the word to be found");
	            	line = input.readLine(); 
	            	if (line.isEmpty()==false) {
	                
	                out.writeUTF(line); 
	            	}
	             line2 =inp.readUTF();
	            if (line2.isEmpty()==false) {
	                System.out.println("I am client here");
                    System.out.println(line2); 
	            }
	            } 
	            catch(IOException i) 
	            { 
	                System.out.println(i); 
	            } 
	        } 
	  
	        // close the connection 
	        try
	        { 
	            input.close(); 
	            out.close(); 
	            socket.close(); 
	        } 
	        catch(IOException i) 
	        { 
	            System.out.println(i); 
	        } 
	    } 
	  
	    public static void main(String args[]) 
	    { 
	        NewClient client = new NewClient("127.0.0.1", 5000); 
	    } 
	} 


