package FirstApiPakage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		do {
		System.out.println("===================================================================");
		System.out.println("=========================1)Read From File============================");
		System.out.println("==2)Search for spcific word And move file from one Dirctory to ather=");
		System.out.println("=========================3)Create Dirctory===========================");
		System.out.println("===================================================================");
		System.out.println("========================= ( plz choose )   ========================");
		System.out.println("===================================================================");

		    Scanner sc=new Scanner(System.in);
			int numberOfOption= sc.nextInt();
		switch (numberOfOption) {
		  case 1:
			  ////	This case for Read file of json
		       // BufferedWriter output = null;

			  System.out.println("========================= ( Read From json file)===================");
			  // File path is passed as parameter
		        File file = new File(
		            "C:\\Users\\Amaal\\Downloads\\StudentsMenuByRawdha-master\\JavaApiProject\\src\\ApiWrite.txt");
		        // Note:  Double backquote is to avoid compiler
		        // interpret words
		        // like \test as \t (ie. as a escape sequence)
		 
		        // Creating an object of BufferedReader class
		        BufferedReader br
		            = new BufferedReader(new FileReader(file));
		 
		        // Declaring a string variable
		        String st;
		        // Condition holds true till
		        // there is character in a string
		        while ((st = br.readLine()) != null) {
		 
		            // Print the string
		            System.out.println(st);
		    }
			System.out.println("===================================================================");

		    break;
		  case 2:
			  System.out.println("========================= ( Search From json file)===================");
			  System.out.println("===================================================================");
			 
			    System.out.println("plz enter name of Dirctory you want to create");
			    Scanner sc11=new Scanner(System.in);
				String CreateDirctory= sc11.next();
				File f = new File("C:\\"+CreateDirctory);
				try{
				    if(f.mkdir()) { 
				        System.out.println("Directory Created");
				    } else {
				        System.out.println("Directory is not created");
				    }
				} catch(Exception e){
				    e.printStackTrace();
				}
			  
			  File directory = new File("C:\\");
			  
		        // store all names with same name
		        // with/without extension
		        String[] flist = directory.list();
		        
		        int flag = 0;
		        if (flist == null) {
		            System.out.println("Empty directory.");
		        }
		        else {
		        	 System.out.println("All File in c that have .txt format");
		        	 for (int i = 0; i < flist.length; i++) {
		        		if(flist[i].endsWith(".txt")) {
		        		 System.out.println(flist[i]);
		        		 System.out.println("===================================================================");
		        		 System.out.println("plz enter word that want to search from file"+flist[i]);
		        		 Scanner sc1=new Scanner(System.in);
     		      	    String SearchForWord2= sc1.next();
     		      	  File f1=new File("C:\\"+flist[i]); //Creation of File Descriptor for input file
			          String[] words=null;  
			          FileReader fr = new FileReader(f1);  //Creation of File Reader object
			          BufferedReader br1 = new BufferedReader(fr); //Creation of BufferedReader object
			          String s;     
			          
			          int count=0;   
			          while((s=br1.readLine())!=null)   //Reading Content from the file
			          {
			             words=s.split(" ");  //Split the word using space
			              for (String word : words) 
			              {
			                     if (word.equals(SearchForWord2))   //Search for the given word
			                     {
			                       
			                       count++;    //If Present increase the count by one
			                       try {
			                    	   File fromFile = new File("C:\\"+flist[i]);
			                    	   File toFile = new File("C:\\"+CreateDirctory+"\\"+flist[i]);
			                          // String toFile = "C:\\"+CreateDirctory+"\\";
			                    	   
			                         
			                            Files.move(fromFile.toPath(), toFile.toPath(),StandardCopyOption.REPLACE_EXISTING);
			                    	    System.out.println("suceffly");
			                    	      
			                       }catch (IOException e) {
			                           e.printStackTrace();
			                       }
			                     }
			              }
			          }
			          if(count!=0)  //Check for count not equal to zero
			          {
			             System.out.println("The given word is present for "+count+ " Times in the file");
			            
			          }
			          else
			          {
			             System.out.println("The given word is not present in the file");
			          }
			          
			             fr.close();
		                	
		                }
     		      	    
		        		}
		        	 }
		            // Linear search in the array
		        	 System.out.println("===================================================================");
//		            for (int i = 0; i < flist.length; i++) {
//		            	
//		                String filename = flist[i];
//		              
		                
//		                Scanner sc1=new Scanner(System.in);
//		                System.out.println("===================================================================");
//			            System.out.println("plz enter word that want to search from file"+flist[i]);
//			      	    String SearchForWord2= sc1.next();
//			      	  File f1=new File("C:\\Users\\Amaal\\OneDrive\\Desktop\\NEW CONCEPTS VER2.txt"); //Creation of File Descriptor for input file
//			          String[] words=null;  
//			          FileReader fr = new FileReader(f1);  //Creation of File Reader object
//			          BufferedReader br1 = new BufferedReader(fr); //Creation of BufferedReader object
//			          String s;     
//			          
//			          int count=0;   
//			          while((s=br1.readLine())!=null)   //Reading Content from the file
//			          {
//			             words=s.split(" ");  //Split the word using space
//			              for (String word : words) 
//			              {
//			                     if (word.equals(SearchForWord2))   //Search for the given word
//			                     {
//			                       
//			                       count++;    //If Present increase the count by one
//			                       Path fileName = Path.of(
//			 			        		  "C:\\Users\\Amaal\\Downloads\\StudentsMenuByRawdha-master\\JavaApiProject\\src\\ApiWriteOut.txt");
//			                    
//			                           // Writing into the file
//			                           Files.writeString(fileName, word);
//			                     }
//			              }
//			          }
//			          if(count!=0)  //Check for count not equal to zero
//			          {
//			             System.out.println("The given word is present for "+count+ " Times in the file");
//			            
//			          }
//			          else
//			          {
//			             System.out.println("The given word is not present in the file");
//			          }
//			          
//			             fr.close();
//		                	
//		                }
//		  
//		        
//		        if (flag == 0) {
//		            System.out.println("File Not Found");
//		        }
		
		        
			  
		    break;
		  case 3:
            System.out.println("Exist From Program");
            System.exit(0);
		    break;
		 //jdfioejo
		}
		}while(true);


       
	}

}
