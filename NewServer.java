

	// A Java program for a Server 
	import java.net.*;
import java.util.Scanner;
import java.io.*; 
	  
	public class NewServer 
	{ 
	    //initialize socket and input stream 
	    private Socket          socket   = null; 
	    private ServerSocket    server   = null; 
	    private DataInputStream in       =  null; 
	    private DataOutputStream outp       =  null; 
	    private DataInputStream  input   = null; 
	  
	    // constructor with port 
	    public NewServer(int port) 
	    { 
	        // starts server and waits for a connection 
	        try
	        { 
	            server = new ServerSocket(port); 
	            System.out.println("Server started"); 
	  
	            System.out.println("Waiting for a client ..."); 
	  
	            socket = server.accept(); 
	            System.out.println("Client accepted"); 
	  
	            // takes input from the client socket 
	            in = new DataInputStream( 
	                new BufferedInputStream(socket.getInputStream())); 
	            
	            input  = new DataInputStream(System.in); 
	            
	            outp    = new DataOutputStream(socket.getOutputStream()); 
	  
	            String line = ""; 
	            
	            String line2 = "" ;
	            
	            String line3 = "" ;
	  
	            // reads message from client until "Over" is sent 
	            while (!line.equals("Over")) 
	            { 
	                try
	                { 
	                	line = in.readUTF();
	                	if(line.isEmpty()==false) {
	                		
	                		
	                		System.out.println(line); 
	                		boolean flag = false;
		            	      
		            	      //Reading the contents of the file
		            	      Scanner sc2 = new Scanner(new FileInputStream("/Users/anshu/Downloads/Dictionary.txt"));
		            	      while(sc2.hasNextLine()) {
		            	    	
		            	    	 System.out.println("" ); 
		            	         line3 = sc2.nextLine();
		            	         
		            	        // System.out.println(line);
		            	         if(line3.indexOf(line)!=-1) {
		            	            flag = true;
		            	            System.out.println(line3);
		            	            break;
		            	           
		            	         }
		            	      //System.out.println(word.lines());
		            	     // }
		            	         
		            	      
		            	   }
		            	      if(flag) {
		            	          System.out.println("File contains the specified word");
		            	          
		            	         
		            	       } else {
		            	          System.out.println("File does not contain the specified word");
		            	       }
				               
		            	//System.out.println("I am server here");

		            	      outp.writeUTF(line3); 
	                	}
						/*
						 * line2 = input.readLine(); if (line2.isEmpty()==false) {
						 * 
						 * boolean flag = false;
						 * 
						 * //Reading the contents of the file Scanner sc2 = new Scanner(new
						 * FileInputStream("/Users/anshu/Downloads/Dictionary.txt"));
						 * while(sc2.hasNextLine()) {
						 * 
						 * System.out.println("" ); line3 = sc2.nextLine();
						 * 
						 * // System.out.println(line); if(line3.indexOf(line2)!=-1) { flag = true;
						 * System.out.println(line3); break;
						 * 
						 * } //System.out.println(word.lines()); // }
						 * 
						 * 
						 * } if(flag) { System.out.println("File contains the specified word");
						 * 
						 * 
						 * } else { System.out.println("File does not contain the specified word"); }
						 * 
						 * //System.out.println("I am server here");
						 * 
						 * outp.writeUTF(line3); }
						 */
	                   
	  
	                } 
	                
	                
	                catch(IOException i) 
	                { 
	                    System.out.println(i); 
	                } 
	            } 
	            System.out.println("Closing connection"); 
	  
	            // close connection 
	            socket.close(); 
	            in.close(); 
	        } 
	        catch(IOException i) 
	        { 
	            System.out.println(i); 
	        } 
	    } 
	  
	    public static void main(String args[]) 
	    { 
	        NewServer server = new NewServer(5000); 
	    } 

	}

