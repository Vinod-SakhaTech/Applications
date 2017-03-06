package Demo;

import java.util.ArrayList;
import java.util.Arrays;

public class Simple {
	
	 public static void main(String[] args) {
		
          ArrayList<String> al=new ArrayList<>();
          al.add("coke");
          al.add("pepsi");
          al.add("marinda");
          
          System.out.println("Array:" +al);
          System.out.println(al.size());
          String[] s1=new String[al.size()];
          String[] s2=al.toArray(s1);
          
          System.out.println("s1==s2: " +(s1==s2));
          System.out.println("s1: " +Arrays.toString(s1));
          System.out.println("s2: " +Arrays.toString(s2));
          
          
	
	} 	 
	 }


	