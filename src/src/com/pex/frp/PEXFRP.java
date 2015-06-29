			

/*
 * Code Name: PEXFRP.java
 * Modified By: 'Umar A.Abu Baker.
 * Liscensed under GNU General Public License version 3 (GPLv3).
 *
 * Based on JINT's (Jebr Interpreter) created by 'Umar Ahmad Abu Baker and Fahed Naif Shehab
 * Copyright (c) 2015 'Umar A.Abu Baker and Fahed N.Shehab <umr.baker@gmail.com>, <>
 * Included with this file is the source of the original code (JINT - Jebr Interpreter), if not, 
 * you can check it out from "Project Jebr"'s Github repo.
 * https://www.github.com/geekybedouin/project_jebr
 * 
 * --------------
 * License: 
 * This file is part of PEXFRP.
    PEXFRP is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License.
    Project Jebr is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.
    You should have received a copy of the GNU General Public License
    along with this program. If not, see <http://www.gnu.org/licenses/gpl-3.0.txt>.
 * 
 * --------------
 * Maintainance:
 *   The author of PEXFRP.java will keep maintaining the code and fixing bugs till September 2015.
 *
 *  
 * --------------
 * How to use this file:
 * 
 * This file contains a plain source code with no main class. Thus, this code should be converted to a dll
 * before using it. There's only one public class, which works as a provoker, with three public methods 
 * - parseFile: which parses files containing financial ratios.
 * - getGlobalErrorCount: 
 * - getErrorString: 
 * --------------
 * What is this??
 * 
 * This file contains the source code of Palestine Exchange Financial Ratio Parser.(PEXFRP)
 * PEXFRP is a top-down "recursive descent" power parser. written in Java.
 * The parser checks the compiliance of carodes with the syntax of a non-complex
 * programming language, designed to simulate financial ratios. May/June 2015
 *
 * --------------
 * Significant changes made to the code:
 *
 * 1) Changed the BNF rules.
 * 2) Changed the correct syntax.
 * 3) Better robustness.
 *
 * --------------
 * Wanna edit the code? READ FIRST:
 * 
 * For the brave souls who get this far: You are the chosen ones,
 * the valiant knights of programming who toil away, without rest,
 * fixing our most awful code. To you, true saviors, kings of men,
 * I say this: never gonna give you up, never gonna let you down,
 * never gonna run around and desert you. Never gonna make you cry,
 * never gonna say goodbye. Never gonna tell a lie and hurt you.
 * 
 * Now, take the oath:
 * 
 * Errors gather, and now my maintenance begins. It shall not end until my death.
 * I shall take no wife, hold no lands, father no children. I shall wear no crowns and win no glory.
 * I shall live and die maintaining this code. I am the sword in the darkness. I am the maintainer of the code.
 * I am the fire that burns against the cold, the light that brings the dawn, the horn that wakes the sleepers,
 * the shield that guards the realms of men. I pledge my life and honor to maintain this code,
 * for this night and all the nights to come.
 */


package com.pex.frp;

import java.util.ArrayList;

import static java.lang.Math.abs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.text.html.HTMLEditorKit.Parser;

class Temp
{

String token;
String type;
int count;

public Temp(String val,int c,String t)
{

token=val;
count=c;
type=t;

}


public int getCount()
{

    return count;
}

public String getVal()
{

return token;

}

public String getType()
{

    return type;


}

public void setVal(String s)
{

token=s;

}


}

class SNode
{

    String n;
    SNode next;

   
public  SNode(String m)
{

    n=m;
    next=null;

}
}



class Stack {

    SNode header;
    
    public Stack(String val)
    {
        System.err.println("hello, stack!");
        header=new SNode(val);
    
    }
    
    
    public Stack()
    {
    
    }
    
    
   protected void finalize()
{
       
            System.out.println("hello: im destrecter");
}
   
   public String toString()
{

    return "hello: im linked list";

}
   
   
    public void append(String val)
    {

        SNode temp=header;
    
    if(header==null)
    {
    
    header=new SNode(val);
    return;
    
    }
    
    while(temp.next!=null)
    {
        
    temp=temp.next;
    
    }
    
    temp.next=new SNode(val);
    
    }
    
    
    public String getFront()
    {
    
     SNode temp=header;
     
    if(header==null)
    {
    
    return "null";
    
    }
    
    while(temp.next!=null)
    {
        
    temp=temp.next;
    
    }
    
    return temp.n;
    
    }
    

    
    
        public void setFront(String s)
    {
    
     SNode temp=header;
     
    if(header==null)
    {
    
    return;
    
    }
    
    while(temp.next!=null)
    {
        
    temp=temp.next;
    
    }
    
    temp.n=s;
    
    }
    
    
        
    public void pop()
    {
    SNode N=header;
    SNode C=null;
   
    
    if(header==null)
   {
   
       return;
   }
    
    if(header.next==null)
    {
    
        header=null;
         return;
    
    }
    
    
    while(N.next!=null)
    {
    
        C=N;
        N=N.next;
    
    }
    
    if(N==null)
    {
    
        //System.out.println("this number"+" "+" does not exist in linked list to delete it");
    }
    
    else
    {
    
        C.next=N.next;
        //System.out.println("number"+" "+N.n+" is deleted SUCCESSFULLy from linked list ");
    
    }
    }
    
    public void print()
    {
    
        SNode temp=header;
       //System.out.println("the result of the printing is");
    
       while(temp!=null)
      {
    
          System.out.println(temp.n);
          temp=temp.next;
    }
    }

}

class Node
{

String n;
Node next;
int line;
String type;
String passing_type;
String value;
String kind;
String opType;
int number_of_row;
int number_of_col;
int number_of_parameter;
ArrayList<String>Name_of_the_parameter;
ArrayList<String>Class_declarations_names;
ArrayList<String>Class_functions_names;
boolean isDeclared;
int line_declared,line_referenced;


public  Node(String m,String s,int count)
{
    
kind="null";  
opType="null";
line=count;
type=s;
n=m;
next=null;
isDeclared=false;
line_declared=0;
line_referenced=0;
number_of_row=0;
number_of_col=0;
number_of_parameter=0;
Name_of_the_parameter=new ArrayList<>();
Class_declarations_names=new ArrayList<>();
Class_functions_names=new ArrayList<>();

}
}


 class LinkedList {
     
    Node header;
    int flag=0;
    public LinkedList(){
        System.err.println("hello, linkedlist!");
    }    
    public LinkedList(String val,String s,int count)
    {
    
        header=new Node(val,s,count);
        flag=1;
    
    }
    
    
   protected void finalize()
{
       
            System.out.println("hello: im destrecter");
}
   
   
   public String toString()
{

    return "hello: im linked list";
}
    
   public void append(String val,String s,int count)
            
    {
    Node temp=header;
    while(temp.next!=null)
    {
        
    temp=temp.next;
    
    }
    
    temp.next=new Node(val,s,count);
    }
     
    
    
    public void set_declared(String val)
    {
    
    Node Temp=header;
    
    while(Temp!=null&&Temp.n!=val)
    {
    
        Temp=Temp.next;
    }
    
    if(Temp==null)
    {
    //System.out.println(val+" "+"not exist in LinkedList");
    
    }
    else
    {
    
    Temp.isDeclared=true;
    }
    }
    
    
     public void set_line_declaration(String val,int line)
    {
    
    Node Temp=header;
    
    while(Temp!=null&&!Temp.n.equalsIgnoreCase(val))
    {
    
        Temp=Temp.next;
    }
    
    if(Temp==null)
    {
    //System.out.println(val+" "+"not exist in LinkedList");
    
    }
    else
    {
    
    Temp.line_declared=line;
    }
    }
    
     
     
      public void set_line_referenced(String val,int line)
    {
    
    Node Temp=header;
    
    while(Temp!=null&&!Temp.n.equalsIgnoreCase(val))
    {
    
        Temp=Temp.next;
    }
    
    if(Temp==null)
    {
    //System.out.println(val+" "+"not exist in LinkedList");
    
    }
    else
    {
    
    Temp.line_referenced=line;
    }
    }
     
     
    
    public boolean is_declared(String val)
    {
    Node Temp=header;
    
    while(Temp!=null&&!Temp.n.equalsIgnoreCase(val))
    {
    
        Temp=Temp.next;
    }
    
    if(Temp==null)
    {
    //System.out.println("Bad Search:"+"this value"+" "+val+" "+"not exist in LinkedList");
    return false;
    }
    else
    {
    //System.out.println("Good search:"+"yes it is found in linkedList");
    return Temp.isDeclared;
    }
    
    }
    
    
    
      
    public int line_declared(String val)
    {
    Node Temp=header;
    
    while(Temp!=null&&!Temp.n.equalsIgnoreCase(val))
    {
    
        Temp=Temp.next;
    }
    
    if(Temp==null)
    {
    //System.out.println("Bad Search:"+"this value"+" "+val+" "+"not exist in LinkedList");
    return -1;
    }
    else
    {
    //System.out.println("Good search:"+"yes it is found in linkedList");
    return Temp.line_declared;
    }
    }
    
     
    
    
    public int line_referenced(String val)
    {
    Node Temp=header;
    
    while(Temp!=null&&!Temp.n.equalsIgnoreCase(val))
    {
    
        Temp=Temp.next;
    }
    
    if(Temp==null)
    {
    //System.out.println("Bad Search:"+"this value"+" "+val+" "+"not exist in LinkedList");
    return -1;
    }
    else
    {
    //System.out.println("Good search:"+"yes it is found in linkedList");
    return Temp.line_referenced;
    }
    
    }
    
    
    
    
       int searchAndGetLine(String val)
    {
    Node Temp=header;
    
    while(Temp!=null&&!Temp.n.equalsIgnoreCase(val))
    {
    
        Temp=Temp.next;
    }
    
    if(Temp==null)
    {
    //System.out.println("Bad Search:"+"this value"+" "+val+" "+"not exist in LinkedList");
    return -1;
    }
    else
    {
   // System.out.println("Good search:"+"yes it is found in linkedList");
    return Temp.line;
    }
    }
    
     
       public String searchAndGetType(String val)
    {
    Node Temp=header;
    
    while(Temp!=null&&!Temp.n.equalsIgnoreCase(val))
    {
    
        Temp=Temp.next;
    }
    
    if(Temp==null)
    {
    //System.out.println("Bad Search:"+"this value"+" "+val+" "+"not exist in LinkedList");
    return "null";
    }
    else
    {
    //System.out.println("Good search:"+"yes it is found in linkedList");
    return Temp.type;
    }
    }
        
        
       
       
       public String searchAndGetPassingType(String val)
    {
    Node Temp=header;
    
    while(Temp!=null&&!Temp.n.equalsIgnoreCase(val))
    {
    
        Temp=Temp.next;
    }
    
    if(Temp==null)
    {
    //System.out.println("Bad Search:"+"this value"+" "+val+" "+"not exist in LinkedList");
    return "null";
    }
    else
    {
    //System.out.println("Good search:"+"yes it is found in linkedList");
    return Temp.passing_type;
    }
    }  
       
       
       
        
      public String searchAndGetValue(String val)
    {
    Node Temp=header;
    
    while(Temp!=null&&!Temp.n.equalsIgnoreCase(val))
    {
    
        Temp=Temp.next;
    }
    
    if(Temp==null)
    {
    //System.out.println("Bad Search:"+"this value"+" "+val+" "+"not exist in LinkedList");
    return null;
    }
    else
    {
    //System.out.println("Good search:"+"yes it is found in linkedList");
    return Temp.value;
    }
    }   
        
        
      
      
      public String searchAndGetKind(String val)
    {
    Node Temp=header;
    
    while(Temp!=null&&!Temp.n.equalsIgnoreCase(val))
    {
    
        Temp=Temp.next;
    }
    
    if(Temp==null)
    {
    //System.out.println("Bad Search:"+"this value"+" "+val+" "+"not exist in LinkedList");
    return "null";
    }
    else
    {
    //System.out.println("Good search:"+"yes it is found in linkedList");
    return Temp.kind;
    }
    }  
      
      
      
          
      public String searchAndGetOpType(String val)
    {
    Node Temp=header;
    
    while(Temp!=null&&!Temp.n.equalsIgnoreCase(val))
    {
    
        Temp=Temp.next;
    }
    
    if(Temp==null)
    {
    //System.out.println("Bad Search:"+"this value"+" "+val+" "+"not exist in LinkedList");
    return "null";
    }
    else
    {
    //System.out.println("Good search:"+"yes it is found in linkedList");
    return Temp.opType;
    }
    }   
      
      
      
    public void setTypeToken(String val,String t)
    {
      Node Temp=header;
    
      while(Temp!=null&&!Temp.n.equalsIgnoreCase(val))
    {
    
        Temp=Temp.next;
    }
    
      if(Temp==null)
    {
    //System.out.println("Bad Search:"+"this value"+" "+val+" "+"not exist in LinkedList");
   
    }
    else
    {
    //System.out.println("Good search:"+"yes it is found in linkedList");
    Temp.type=t;
    }
    
    }
    
    
   
     public void setValueToken(String val,String t)
    {
      Node Temp=header;
   
      while(Temp!=null&&!Temp.n.equalsIgnoreCase(val))
    {
    
        Temp=Temp.next;
    }
    
      if(Temp==null)
    {
    //System.out.println("Bad Search:"+"this value"+" "+val+" "+"not exist in LinkedList");
   
    }
    else
    {
    //System.out.println("Good search:"+"yes it is found in linkedList");
    Temp.value=t;
    }
    
    }
    
    
     
     
      public void setKind(String val,String t)
    {
      Node Temp=header;
    
      while(Temp!=null&&!Temp.n.equalsIgnoreCase(val))
    {
    
        Temp=Temp.next;
    }
    
      if(Temp==null)
    {
    //System.out.println("Bad Search:"+"this value"+" "+val+" "+"not exist in LinkedList");
   
    }
    else
    {
    //System.out.println("Good search:"+"yes it is found in linkedList");
    Temp.kind=t;
    }
    
    }
     
     
     
      
          public void setOpType(String val,String t)
    {
      Node Temp=header;
    
      while(Temp!=null&&!Temp.n.equalsIgnoreCase(val))
    {
    
        Temp=Temp.next;
    }
    
      if(Temp==null)
    {
    //System.out.println("Bad Search:"+"this value"+" "+val+" "+"not exist in LinkedList");
   
    }
    else
    {
    //System.out.println("Good search:"+"yes it is found in linkedList");
    Temp.opType=t;
    }
    
    }  
     
          
      
     
     public void setPassingType(String val,String t)
    {
      Node Temp=header;
    
      while(Temp!=null&&!Temp.n.equalsIgnoreCase(val))
    {
    
        Temp=Temp.next;
    }
    
      if(Temp==null)
    {
    //System.out.println("Bad Search:"+"this value"+" "+val+" "+"not exist in LinkedList");
   
    }
    else
    {
    //System.out.println("Good search:"+"yes it is found in linkedList");
    Temp.passing_type=t;
    }
    
    }
     
     
     
     
     public void setNumberOfColumn(String val,int t)
    {
      Node Temp=header;
    
      while(Temp!=null&&!Temp.n.equalsIgnoreCase(val))
    {
    
        Temp=Temp.next;
    }
    
      if(Temp==null)
    {
    //System.out.println("Bad Search:"+"this value"+" "+val+" "+"not exist in LinkedList");
   
    }
    else
    {
    //System.out.println("Good search:"+"yes it is found in linkedList");
    Temp.number_of_col=t;
    }
    
    }
    
     
     
        
     public void setNumberOfRow(String val,int t)
    {
      Node Temp=header;
    
      while(Temp!=null&&!Temp.n.equalsIgnoreCase(val))
    {
    
        Temp=Temp.next;
    }
    
      if(Temp==null)
    {
    //System.out.println("Bad Search:"+"this value"+" "+val+" "+"not exist in LinkedList");
   
    }
    else
    {
    //System.out.println("Good search:"+"yes it is found in linkedList");
    Temp.number_of_row=t;
    }
    
    }
     
     
     
         public void setNumberOfParameter(String val,int t)
    {
      Node Temp=header;
    
      while(Temp!=null&&!Temp.n.equalsIgnoreCase(val))
    {
    
        Temp=Temp.next;
    }
    
      if(Temp==null)
    {
    //System.out.println("Bad Search:"+"this value"+" "+val+" "+"not exist in LinkedList");
   
    }
    else
    {
    //System.out.println("Good search:"+"yes it is found in linkedList");
    Temp.number_of_parameter=t;
    }
    
    }
     
     
         
          public void setTheParametersNames(String val,ArrayList<String> names)
    {
      Node Temp=header;
    
      while(Temp!=null&&!Temp.n.equalsIgnoreCase(val))
    {
    
        Temp=Temp.next;
    }
    
      if(Temp==null)
    {
    //System.out.println("Bad Search:"+"this value"+" "+val+" "+"not exist in LinkedList");
   
    }
    else
    {
    //System.out.println("Good search:"+"yes it is found in linkedList");
    for(int i=0;i<names.size();i++)
    {
   
        Temp.Name_of_the_parameter.add(names.get(i));
    }
    }
    
    }
         
         
     
          
          
     public void setClassDeclarationsNames(String val,ArrayList<String> names)
    {
      Node Temp=header;
    
      while(Temp!=null&&!Temp.n.equalsIgnoreCase(val))
    {
    
        Temp=Temp.next;
    }
    
      if(Temp==null)
    {
    //System.out.println("Bad Search:"+"this value"+" "+val+" "+"not exist in LinkedList");
   
    }
    else
    {
    //System.out.println("Good search:"+"yes it is found in linkedList");
    for(int i=0;i<names.size();i++)
    {
    
        Temp.Class_declarations_names.add(names.get(i));
    }
    }
    
    }     
          
          
          
    
     public void setClassFunctionsNames(String val,ArrayList<String> names)
    {
      Node Temp=header;
    
      while(Temp!=null&&!Temp.n.equalsIgnoreCase(val))
    {
    
        Temp=Temp.next;
    }
    
      if(Temp==null)
    {
    //System.out.println("Bad Search:"+"this value"+" "+val+" "+"not exist in LinkedList");
   
    }
    else
    {
    //System.out.println("Good search:"+"yes it is found in linkedList");
    for(int i=0;i<names.size();i++)
    {
    
        Temp.Class_functions_names.add(names.get(i));
    }
    }
    
    } 
     
     
     
        
    public String searchAndGetToken(String val)
    {
    Node Temp=header;
    
    while(Temp!=null&&!Temp.n.equalsIgnoreCase(val))
    {
    
        Temp=Temp.next;
    }
    
    if(Temp==null)
    {
    //System.out.println("Bad Search:"+"this value"+" "+val+" "+"not exist in LinkedList");
    return null;
    }
    else
    {
    //System.out.println("Good search:"+"yes it is found in linkedList");
    return Temp.n;
    }
    }
    
    
    
    public int searchAndGetNumberOfRow(String val)
    {
    Node Temp=header;
    
    while(Temp!=null&&!Temp.n.equalsIgnoreCase(val))
    {
    
        Temp=Temp.next;
    }
   
    if(Temp==null)
    {
    //System.out.println("Bad Search:"+"this value"+" "+val+" "+"not exist in LinkedList");
    return -1;
    }
    else
    {
    //System.out.println("Good search:"+"yes it is found in linkedList");
    return Temp.number_of_row;
    }
    }
    
    
    
    
        public int searchAndGetNumberOfColumn(String val)
    {
    Node Temp=header;
    
    while(Temp!=null&&!Temp.n.equalsIgnoreCase(val))
    {
    
        Temp=Temp.next;
    }
    
    if(Temp==null)
    {
    //System.out.println("Bad Search:"+"this value"+" "+val+" "+"not exist in LinkedList");
    return -1;
    }
    else
    {
    //System.out.println("Good search:"+"yes it is found in linkedList");
    return Temp.number_of_col;
    }
    }
        
        
        
      public int searchAndGetNumberOfParameter(String val)
    {
    Node Temp=header;
    
    while(Temp!=null&&!Temp.n.equalsIgnoreCase(val))
    {
    
        Temp=Temp.next;
    }
    
    if(Temp==null)
    {
    //System.out.println("Bad Search:"+"this value"+" "+val+" "+"not exist in LinkedList");
    return -1;
    }
    else
    {
    //System.out.println("Good search:"+"yes it is found in linkedList");
    return Temp.number_of_parameter;
    }
    } 
        
    
      
    
        public ArrayList<String> searchAndGetTheParametersNames(String val)
    {
    Node Temp=header;
    
    while(Temp!=null&&!Temp.n.equalsIgnoreCase(val))
    {
    
        Temp=Temp.next;
    }
    
    if(Temp==null)
    {
    //System.out.println("Bad Search:"+"this value"+" "+val+" "+"not exist in LinkedList");
    return null;
    }
    else
    {
    //System.out.println("Good search:"+"yes it is found in linkedList");
    return Temp.Name_of_the_parameter;
    }
    }   
      
      
        
        
     public ArrayList<String> searchAndGetTheClassDeclarationsNames(String val)
    {
    Node Temp=header;
    
    while(Temp!=null&&!Temp.n.equalsIgnoreCase(val))
    {
    
        Temp=Temp.next;
        
    }
    
    if(Temp==null)
    {
    //System.out.println("Bad Search:"+"this value"+" "+val+" "+"not exist in LinkedList");
    return null;
    }
    else
    {
    //System.out.println("Good search:"+"yes it is found in linkedList");
    return Temp.Class_declarations_names;
    }
    }    
        
    
    
     
     public ArrayList<String> searchAndGetTheClassFunctionsNames(String val)
    {
    Node Temp=header;
    
    while(Temp!=null&&!Temp.n.equalsIgnoreCase(val))
    {
    
        Temp=Temp.next;
    }
    
    if(Temp==null)
    {
    //System.out.println("Bad Search:"+"this value"+" "+val+" "+"not exist in LinkedList");
    return null;
    }
    else
    {
    //System.out.println("Good search:"+"yes it is found in linkedList");
    return Temp.Class_functions_names;
    }
    } 
     
     
    
    
    public void delete(String val)
    {
    Node N=header;
    Node C=null;
    
    if(N.n.equalsIgnoreCase(val))
    {
       
    header=header.next;
    //System.out.println("token"+" "+N.n+" is deleted SUCCESSFULLy from linked list ");
    return;
    }
    
    while(N!=null&&!N.n.equalsIgnoreCase(val))
    {
    
    C=N;
    N=N.next;
   
    }
    
    if(N==null)
    {
    //System.out.println("this token"+" "+val+" does not exist in linked list to delete it");
    }
    
    else
    {
    C.next=N.next;
    //System.out.println("token"+" "+N.n+" is deleted SUCCESSFULLy from linked list ");
    }
    }
    
    
    public void print()
    {
    Node temp=header;
    //System.out.println("the result of the printing is");
    while(temp!=null)
    {
    //System.out.println(temp.n+" "+temp.line+"  "+temp.type);
    temp=temp.next;
    }
    }
    
    
}


class Symbol_Table
{
LinkedList []S;
int capacity;
int n;

public Symbol_Table(int cap)
{
   
capacity=cap;
S=new LinkedList[cap];

n=0;

}


protected void finalize()
{
S=null;
}


   public String toString()
{
return "hello: im Symbol Table";
}
   
  boolean empty(){
	if(n<=0)
	{
	return true;
	}
	else{return false;}
	}
  
  int size()
  {
  
  return n;
  }
  
 int hashing(String key)
{
int sum=0;
int i=0;
String p=key;
while(p!=null&&i<p.length())
{
sum=sum+p.charAt(i);
	
i++;
}
 return (abs(sum)%capacity);
}
 
 
 
 
 void set_declared(String key)
 {
 int B=hashing(key);
if(S[B]==null)
{   
//System.out.println("not found to set declared");
return;
}

if(S[B].searchAndGetToken(key)==null)
{
//System.out.println("not found to set declared");
}
if(S[B].searchAndGetToken(key).equalsIgnoreCase(key))
{
S[B].set_declared(key);
}

 }
 
 
 
 
 
    void set_type(String key,String val)
 {
 int B=hashing(key);
if(S[B]==null)
{   
//System.out.println("not found to set declared");
return ;
}

if(S[B].searchAndGetToken(key)==null)
{
//System.out.println("not found to set declared");
}
if(S[B].searchAndGetToken(key).equalsIgnoreCase(key))
{
S[B].setTypeToken(key, val);
}
 }
 
 
    
    
   void set_passing_type(String key,String val)
 {
 int B=hashing(key);
if(S[B]==null)
{   
//System.out.println("not found to set declared");
return ;
}

if(S[B].searchAndGetToken(key)==null)
{
//System.out.println("not found to set passing type");
}
if(S[B].searchAndGetToken(key).equalsIgnoreCase(key))
{
S[B].setPassingType(key, val);
}
 }  
    
    
    
 
 
   void set_value(String key,String val)
 {
 int B=hashing(key);
if(S[B]==null)
{   
//System.out.println("not found to set declared");
return ;
}

if(S[B].searchAndGetToken(key)==null)
{
//System.out.println("not found to set declared");
}
if(S[B].searchAndGetToken(key).equalsIgnoreCase(key))
{
S[B].setValueToken(key, val);
}
 }
 

 
   
     void set_Kind(String key,String val)
 {
 int B=hashing(key);
if(S[B]==null)
{   
//System.out.println("not found to set declared");
return ;
}

if(S[B].searchAndGetToken(key)==null)
{
//System.out.println("not found to set declared");
}
if(S[B].searchAndGetToken(key).equalsIgnoreCase(key))
{
S[B].setKind(key, val);
}
 } 
   
     
     
     
     
     
     void set_op_type(String key,String val)
 {
 int B=hashing(key);
if(S[B]==null)
{   
//System.out.println("not found to set declared");
return ;
}

if(S[B].searchAndGetToken(key)==null)
{
//System.out.println("not found to set declared");
}
if(S[B].searchAndGetToken(key).equalsIgnoreCase(key))
{
S[B].setOpType(key, val);
}
 }
     
     
     
   
 
  void set_line_declared(String key,int line)
 {
 int B=hashing(key);
if(S[B]==null)
{   
//System.out.println("not found to set declared");
return ;
}

if(S[B].searchAndGetToken(key)==null)
{
//System.out.println("not found to set declared");
}
if(S[B].searchAndGetToken(key).equalsIgnoreCase(key))
{
S[B].set_line_declaration(key, line);
}
 }
  
  
  
     void set_number_of_row(String key,int val)
 {
 int B=hashing(key);
if(S[B]==null)
{   
//System.out.println("not found to set row");p
return ;
}

if(S[B].searchAndGetToken(key)==null)
{
//System.out.println("not found to set row");
}
if(S[B].searchAndGetToken(key).equalsIgnoreCase(key))
{
S[B].setNumberOfRow(key, val);
}
 }
  
  
      void set_number_of_col(String key,int val)
 {
 int B=hashing(key);
if(S[B]==null)
{   
//System.out.println("not found to set col");
return ;
}

if(S[B].searchAndGetToken(key)==null)
{
//System.out.println("not found to set col");
}
if(S[B].searchAndGetToken(key).equalsIgnoreCase(key))
{
S[B].setNumberOfColumn(key, val);
}
 }   
     
     
      
       void set_number_of_parameter(String key,int val)
 {
 int B=hashing(key);
if(S[B]==null)
{   
//System.out.println("not found to set col");
return ;
}

if(S[B].searchAndGetToken(key)==null)
{
//System.out.println("not found to set col");
}
if(S[B].searchAndGetToken(key).equalsIgnoreCase(key))
{
S[B].setNumberOfParameter(key, val);
}
 } 
      
 
       
 
  void set_the_parameters_names(String key,ArrayList<String> val)
 {
 int B=hashing(key);
if(S[B]==null)
{   
//System.out.println("not found to set col");
return ;
}

if(S[B].searchAndGetToken(key)==null)
{
//System.out.println("not found to set col");
}
if(S[B].searchAndGetToken(key).equalsIgnoreCase(key))
{
S[B].setTheParametersNames(key, val);
}
 }       
       
       
  
  
   void set_class_declarations_names(String key,ArrayList<String> val)
 {
 int B=hashing(key);
if(S[B]==null)
{   
//System.out.println("not found to set col");
return ;
}

if(S[B].searchAndGetToken(key)==null)
{
//System.out.println("not found to set col");
}
if(S[B].searchAndGetToken(key).equalsIgnoreCase(key))
{
S[B].setClassDeclarationsNames(key, val);
}
 }
  
 
  
   
  void set_class_functions_names(String key,ArrayList<String> val)
 {
 int B=hashing(key);
if(S[B]==null)
{   
//System.out.println("not found to set col");
return ;
}

if(S[B].searchAndGetToken(key)==null)
{
//System.out.println("not found to set col");
}
if(S[B].searchAndGetToken(key).equalsIgnoreCase(key))
{
S[B].setClassFunctionsNames(key, val);
}
 }
   
   
   
  
   void set_line_referenced(String key,int line)
 {
 int B=hashing(key);
if(S[B]==null)
{   
//System.out.println("not found to set declared");
return;
}

if(S[B].searchAndGetToken(key)==null)
{
//System.out.println("not found to set declared");
}
if(S[B].searchAndGetToken(key).equalsIgnoreCase(key))
{
S[B].set_line_referenced(key, line);
}

 }
  
 
 
 boolean is_declared(String key)
 {

  int B=hashing(key);
if(S[B]==null)
{   
//System.out.println("not found to set declared");
return false;
}

if(S[B].searchAndGetToken(key)==null)
{
//System.out.println("not found to set declared");
}
if(S[B].searchAndGetToken(key).equalsIgnoreCase(key))
{
return S[B].is_declared(key);
}
return false; 
 }
 
 
 
 
  int line_declared(String key)
 {

  int B=hashing(key);
if(S[B]==null)
{   
//System.out.println("not found to set declared");

}

if(S[B].searchAndGetToken(key)==null)
{
//System.out.println("not found to set declared");
}
if(S[B].searchAndGetToken(key).equalsIgnoreCase(key))
{
return S[B].line_declared(key);
}
return -1; 
 }
 
 
  
   
  int line_referenced(String key)
 {

  int B=hashing(key);
if(S[B]==null)
{   
//System.out.println("not found to set declared");
}

if(S[B].searchAndGetToken(key)==null)
{
//System.out.println("not found to set declared");
}
if(S[B].searchAndGetToken(key).equalsIgnoreCase(key))
{
return S[B].line_referenced(key);
}
return -1; 
 }
  
  
 
 void insert(String k,String s,int count)
	{
	int B=hashing(k);
        
        if(S[B]==null)
        {
        S[B]=new LinkedList(k,s,count);
        }
        else{S[B].append(k,s,count);}
           
     
         
    
       // S[B].print();
       
	n++;
	}
 
 
 
 int find(String key)
{
int B=hashing(key);
if(S[B]==null)
{   
return -1;
}

if(S[B].searchAndGetToken(key)==null)
{
return -1;
}
if(S[B].searchAndGetToken(key).equalsIgnoreCase(key))
{
return B;
}

return -1;
}
 
 
 
 
 String getValue(String key)
{
int B=hashing(key);
if(S[B]==null)
{   
return null;
}

if(S[B].searchAndGetToken(key)==null)
{
return null;
}
if(S[B].searchAndGetToken(key).equalsIgnoreCase(key))
{
return S[B].searchAndGetValue(key);
}

return null;
}
 
 
 
  String getKind(String key)
{
int B=hashing(key);
if(S[B]==null)
{   
return "null";
}

if(S[B].searchAndGetToken(key)==null)
{
return "null";
}
if(S[B].searchAndGetToken(key).equalsIgnoreCase(key))
{
return S[B].searchAndGetKind(key);
}

return "null";
}
 
 
 
  
  
  String getOpType(String key)
{
int B=hashing(key);
if(S[B]==null)
{   
return "null";
}

if(S[B].searchAndGetToken(key)==null)
{
return "null";
}
if(S[B].searchAndGetToken(key).equalsIgnoreCase(key))
{
return S[B].searchAndGetOpType(key);
}

return "null";
}  
  
  
  
  
 String getToken(String key)
{
int B=hashing(key);
if(S[B]==null)
{   
return null;
}

if(S[B].searchAndGetToken(key)==null)
{
return null;
}
if(S[B].searchAndGetToken(key).equalsIgnoreCase(key))
{
return S[B].searchAndGetToken(key);
}

return null;
}
 
 
 
 

 
  
 
 String getType(String key)
{
int B=hashing(key);
if(S[B]==null)
{   
return "null";
}

if(S[B].searchAndGetToken(key)==null)
{
return "null";
}
if(S[B].searchAndGetToken(key).equalsIgnoreCase(key))
{
return S[B].searchAndGetType(key);
}

return "null";
}
 

 
 
  String getPassingType(String key)
{
int B=hashing(key);
if(S[B]==null)
{   
return null;
}

if(S[B].searchAndGetToken(key)==null)
{
return null;
}
if(S[B].searchAndGetToken(key).equalsIgnoreCase(key))
{
return S[B].searchAndGetPassingType(key);
}

return null;
}
 
 
 
 
 
 int getLine(String key)
{
int B=hashing(key);
if(S[B]==null)
{   
return -1;
}

if(S[B].searchAndGetToken(key)==null)
{
return -1;
}
if(S[B].searchAndGetToken(key).equalsIgnoreCase(key))
{
return S[B].searchAndGetLine(key);
}

return -1;
}
 
 
 
 int get_number_of_row(String key)
{
int B=hashing(key);
if(S[B]==null)
{   
return -1;
}

if(S[B].searchAndGetToken(key)==null)
{
return -1;
}
if(S[B].searchAndGetToken(key).equalsIgnoreCase(key))
{
return S[B].searchAndGetNumberOfRow(key);
}

return -1;
} 
 

 
  int get_number_of_col(String key)
{
int B=hashing(key);
if(S[B]==null)
{   
return -1;
}

if(S[B].searchAndGetToken(key)==null)
{
return -1;
}
if(S[B].searchAndGetToken(key).equalsIgnoreCase(key))
{
return S[B].searchAndGetNumberOfColumn(key);
}

return -1;
}
 
 
  
  
  int get_number_of_parameter(String key)
{
int B=hashing(key);
if(S[B]==null)
{   
return -1;
}

if(S[B].searchAndGetToken(key)==null)
{
return -1;
}
if(S[B].searchAndGetToken(key).equalsIgnoreCase(key))
{
return S[B].searchAndGetNumberOfParameter(key);
}

return -1;
}  
  
  
  
    ArrayList<String> get_the_parameter_names(String key)
{
int B=hashing(key);
if(S[B]==null)
{   
return null;
}

if(S[B].searchAndGetToken(key)==null)
{
return null;
}
if(S[B].searchAndGetToken(key).equalsIgnoreCase(key))
{
return S[B].searchAndGetTheParametersNames(key);
}

return null;
} 
  
  
  
   ArrayList<String> get_class_declarations_names(String key)
{
int B=hashing(key);
if(S[B]==null)
{   
return null;
}

if(S[B].searchAndGetToken(key)==null)
{
return null;
}
if(S[B].searchAndGetToken(key).equalsIgnoreCase(key))
{
return S[B].searchAndGetTheClassDeclarationsNames(key);
}

return null;
} 
    
  

   
  ArrayList<String> get_class_functions_names(String key)
{
int B=hashing(key);
if(S[B]==null)
{   
return null;
}

if(S[B].searchAndGetToken(key)==null)
{
return null;
}
if(S[B].searchAndGetToken(key).equalsIgnoreCase(key))
{
return S[B].searchAndGetTheClassFunctionsNames(key);
}

return null;
}
   
   
   
 
 void Delete(String key)
{
int f=find(key);
if(f==-1)
{
System.out.println("not found");
}
else{S[f].delete(key); n--;}
}
   

}




class PEXParser
{
        String code_input = "";
	 Date datetime = new Date();
	 String error_string = "PEX-FRP Parsing Log: \nFinished parsing at " + datetime.toString()+"\n";
	 int counter_of_op_braces = 0;
     boolean flag_of_string = false;
     boolean flag_of_js = false;
     int global_error_count;
     File input;
     
     File output;
     int mark=0;
     int line=0;
     String my_class;
     String my_func;
    PrintWriter writeOnOutput;
     Scanner readFrominput;
     Scanner readcode;
     Scanner readdata;
     int c=0;
     int u=0;
     int condType=0;
     int isfunc=0;
     PrintWriter test;
      ArrayList<Temp> Buffer= new ArrayList<Temp>();
       ArrayList<Symbol_Table>Sympol_List=new ArrayList<Symbol_Table>();
       ArrayList<String> Parameter_Names= new ArrayList<String>();
       ArrayList<String> functions_Names= new ArrayList<String>();
        Stack op=new  Stack();
        ArrayList<String> passRet=new ArrayList<String>();
         ArrayList<Temp> var= new ArrayList<Temp>();
       Stack stack=new Stack();     
      Temp lookahead;
        Symbol_Table Sympol;
         int count_col;
         int count_row;
         int count_parameter;
         String value="";
    public PEXParser()
    {
        System.err.println("hello, parser!");
    }
    public int getErrorCount()
    {
            return global_error_count;
    }
    public String getErrorString()
    {
            return error_string;
    }
    
          
int Priority(String op)
{
if(op.equalsIgnoreCase("+")||op.equalsIgnoreCase("-"))    
{
return 1;
}
else if(op.equalsIgnoreCase("*")||op.equalsIgnoreCase("/")||op.equalsIgnoreCase("%"))
{
return 2;
}
if(op.equalsIgnoreCase("(")||op.equalsIgnoreCase(")"))    
{
return 3;
}
return -1;
}


    public int [][] transposeMatrix(int [][] m){
        int[][] temp = new int[m[0].length][m.length];
        for (int i = 0; i < m.length; i++)
            for (int j = 0; j < m[0].length; j++)
                temp[j][i] = m[i][j];
        return temp;
    }

    
     public static double[][] invert(double a[][]) 
 {
int n = a.length;
 double x[][] = new double[n][n];
 double b[][] = new double[n][n];
  int index[] = new int[n];
  for (int i=0; i<n; ++i)
      b[i][i] = 1;
  
  
  for (int i=0; i<n-1; ++i)
       for (int j=i+1; j<n; ++j)
            for (int k=0; k<n; ++k)
                 b[index[j]][k]-= a[index[j]][i]*b[index[i]][k];
 
  
  
   for (int i=0; i<n; ++i)
         {
               x[n-1][i] = b[index[n-1]][i]/a[index[n-1]][n-1];
                for (int j=n-2; j>=0; --j)
                {
                     x[j][i] = b[index[j]][i];
                     for (int k=j+1; k<n; ++k)
                     {
                          x[j][i] -= a[index[j]][k]*x[k][i];
                     }
                }
         }
 
 return x;
 }
    
    
         
 public PEXParser(String jin, String jout) throws FileNotFoundException, UnsupportedEncodingException
 {
	 if (jin == null || jin == "" || jout == null || jout == ""){
                error_string += "\nFatal Error: Bad Parameters";
                global_error_count++;
		return;	
	 }
     input = new File(jin);
     output = new File(jout);
     boolean flag_par=false; //this flag decides if we should write the last paranthesis
     count_row=0;
     count_col=0;
     Sympol=new Symbol_Table(10000);
     Sympol_List.add(Sympol);
 
 int counter = 0;
 Scanner readTemp = new Scanner(input);
 while(readTemp.hasNextLine())
 {
     counter++;
     if (counter == 1)
     {
         String tempLine = readTemp.nextLine();
         if (tempLine.equalsIgnoreCase("if ( 1 ) {"))
         {
             code_input +=tempLine;
             flag_par = false;
             continue;
         }
         else
         {
             code_input = "if ( 1 ) {\n" + tempLine;
             flag_par = true;
             continue;
         }
     }
     code_input += "\n"+readTemp.nextLine();
     
 }
 if (counter==0)
 {
     error_string += "\nFatal Error: Empty file..";
     global_error_count++;
     return;
 }
 if (flag_par ==true)
    code_input += "\n }";
 
code_input = code_input.replaceAll("else if", "elseif");

 readTemp.close();
 
 PrintWriter writeInput = new PrintWriter(input);
 writeInput.println(code_input);
 writeInput.close();
 writeOnOutput=new PrintWriter(output);
 readFrominput=new Scanner(input);
 


 
 
 writeOnOutput.println("token"+"     "+"spelling"+"     "+"type"+"      "+"line");
 this.lex();
 
 

 }
 void error_string(String symbol)
 {
	 global_error_count++;error_string += "\n"+"Error: "+symbol+" is not supported.";
	 if(mark!=Buffer.size())
	      lookahead=lexical();
 }
 void MathRandom()
 {
     if (mark != Buffer.size())
        lookahead = lexical();
     if (lookahead.getVal().equalsIgnoreCase("("))
     {
         if (mark != Buffer.size())
             lookahead = lexical();
         if (lookahead.getVal().equalsIgnoreCase(")"))
         {
             
         }
         else
         {
             global_error_count++;error_string += "\n"+"Error: Unexpected token: "+lookahead.getVal()+" after math.random";
         }
     }
     else{
         global_error_count++;error_string += "\n"+"Error: Unexpected token: "+lookahead.getVal()+ " after math.random";
     }
 }
 void MathAbs()
 {
     if (mark != Buffer.size())
        lookahead = lexical();
     if (lookahead.getVal().equalsIgnoreCase("("))
     {
         if (mark != Buffer.size())
             lookahead = lexical();
         if (lookahead.getType().equalsIgnoreCase("identifier")||lookahead.getType().equalsIgnoreCase("number")||lookahead.getType().equalsIgnoreCase("string"))
         {
             if (mark != Buffer.size())
                 lookahead = lexical();
             if (lookahead.getVal().equalsIgnoreCase(")"))
            {

            }
            else
            {
             global_error_count++;error_string += "\n"+"Error: Unexpected token: "+lookahead.getVal()+" after math.abs";
            }
         }
         else
         {
             global_error_count++;error_string += "\n"+"Error: Bad parameter: "+lookahead.getVal()+" for math.abs";
         }
     }
     else{
         global_error_count++;error_string += "\n"+"Error: Unexpected token: "+lookahead.getVal()+ " after math.abs";
     }
 }
 void MathAsin()
 {
     if (mark != Buffer.size())
        lookahead = lexical();
     if (lookahead.getVal().equalsIgnoreCase("("))
     {
         if (mark != Buffer.size())
             lookahead = lexical();
         if (lookahead.getType().equalsIgnoreCase("identifier")||lookahead.getType().equalsIgnoreCase("number")||lookahead.getType().equalsIgnoreCase("string"))
         {
             if (mark != Buffer.size())
                 lookahead = lexical();
             if (lookahead.getVal().equalsIgnoreCase(")"))
            {

            }
            else
            {
             global_error_count++;error_string += "\n"+"Error: Unexpected token: "+lookahead.getVal()+" after math.asin/math.sin";
            }
         }
         else
         {
             global_error_count++;error_string += "\n"+"Error: Bad parameter: "+lookahead.getVal()+" for math.asin/math.sin";
         }
     }
     else{
         global_error_count++;error_string += "\n"+"Error: Unexpected token: "+lookahead.getVal()+ " after math.asin/math.sin";
     }
 }
 void MathAcos()
 {
     if (mark != Buffer.size())
        lookahead = lexical();
     if (lookahead.getVal().equalsIgnoreCase("("))
     {
         if (mark != Buffer.size())
             lookahead = lexical();
         if (lookahead.getType().equalsIgnoreCase("identifier")||lookahead.getType().equalsIgnoreCase("number")||lookahead.getType().equalsIgnoreCase("string"))
         {
             if (mark != Buffer.size())
                 lookahead = lexical();
             if (lookahead.getVal().equalsIgnoreCase(")"))
            {

            }
            else
            {
             global_error_count++;error_string += "\n"+"Error: Unexpected token: "+lookahead.getVal()+" after math.acos/math.cos";
            }
         }
         else
         {
             global_error_count++;error_string += "\n"+"Error: Bad parameter: "+lookahead.getVal()+" for math.acos/math.cos";
         }
     }
     else{
         global_error_count++;error_string += "\n"+"Error: Unexpected token: "+lookahead.getVal()+ " after math.acos/math.cos";
     }
 }
 void MathAtan()
 {
     if (mark != Buffer.size())
        lookahead = lexical();
     if (lookahead.getVal().equalsIgnoreCase("("))
     {
         if (mark != Buffer.size())
             lookahead = lexical();
         if (lookahead.getType().equalsIgnoreCase("identifier")||lookahead.getType().equalsIgnoreCase("number")||lookahead.getType().equalsIgnoreCase("string"))
         {
             if (mark != Buffer.size())
                 lookahead = lexical();
             if (lookahead.getVal().equalsIgnoreCase(")"))
            {

            }
            else
            {
             global_error_count++;error_string += "\n"+"Error: Unexpected token: "+lookahead.getVal()+" after math.atan/math.tan";
            }
         }
         else
         {
             global_error_count++;error_string += "\n"+"Error: Bad parameter: "+lookahead.getVal()+" for math.atan/math.tan";
         }
     }
     else{
         global_error_count++;error_string += "\n"+"Error: Unexpected token: "+lookahead.getVal()+ " after math.atan/math.tan";
     }
 }
 void MathCeil()
 {
     if (mark != Buffer.size())
        lookahead = lexical();
     if (lookahead.getVal().equalsIgnoreCase("("))
     {
         if (mark != Buffer.size())
             lookahead = lexical();
         if (lookahead.getType().equalsIgnoreCase("identifier")||lookahead.getType().equalsIgnoreCase("number")||lookahead.getType().equalsIgnoreCase("string"))
         {
             if (mark != Buffer.size())
                 lookahead = lexical();
             if (lookahead.getVal().equalsIgnoreCase(")"))
            {

            }
            else
            {
             global_error_count++;error_string += "\n"+"Error: Unexpected token: "+lookahead.getVal()+" after math.ceil";
            }
         }
         else
         {
             global_error_count++;error_string += "\n"+"Error: Bad parameter: "+lookahead.getVal()+" for math.ceil";
         }
     }
     else{
         global_error_count++;error_string += "\n"+"Error: Unexpected token: "+lookahead.getVal()+ " after math.ceil";
     }
 }
 void MathExp()
 {
     if (mark != Buffer.size())
        lookahead = lexical();
     if (lookahead.getVal().equalsIgnoreCase("("))
     {
         if (mark != Buffer.size())
             lookahead = lexical();
         if (lookahead.getType().equalsIgnoreCase("identifier")||lookahead.getType().equalsIgnoreCase("number")||lookahead.getType().equalsIgnoreCase("string"))
         {
             if (mark != Buffer.size())
                 lookahead = lexical();
             if (lookahead.getVal().equalsIgnoreCase(")"))
            {

            }
            else
            {
             global_error_count++;error_string += "\n"+"Error: Unexpected token: "+lookahead.getVal()+" after math.exp";
            }
         }
         else
         {
             global_error_count++;error_string += "\n"+"Error: Bad parameter: "+lookahead.getVal()+" for math.exp";
         }
     }
     else{
         global_error_count++;error_string += "\n"+"Error: Unexpected token: "+lookahead.getVal()+ " after math.exp";
     }
 }
 void MathFloor()
 {
     if (mark != Buffer.size())
        lookahead = lexical();
     if (lookahead.getVal().equalsIgnoreCase("("))
     {
         if (mark != Buffer.size())
             lookahead = lexical();
         if (lookahead.getType().equalsIgnoreCase("identifier")||lookahead.getType().equalsIgnoreCase("number")||lookahead.getType().equalsIgnoreCase("string"))
         {
             if (mark != Buffer.size())
                 lookahead = lexical();
             if (lookahead.getVal().equalsIgnoreCase(")"))
            {

            }
            else
            {
             global_error_count++;error_string += "\n"+"Error: Unexpected token: "+lookahead.getVal()+" after math.floor";
            }
         }
         else
         {
             global_error_count++;error_string += "\n"+"Error: Bad parameter: "+lookahead.getVal()+" for math.floor";
         }
     }
     else{
         global_error_count++;error_string += "\n"+"Error: Unexpected token: "+lookahead.getVal()+ " after math.floor";
     }
 }
 void MathLog()
 {
     if (mark != Buffer.size())
        lookahead = lexical();
     if (lookahead.getVal().equalsIgnoreCase("("))
     {
         if (mark != Buffer.size())
             lookahead = lexical();
         if (lookahead.getType().equalsIgnoreCase("identifier")||lookahead.getType().equalsIgnoreCase("number")||lookahead.getType().equalsIgnoreCase("string"))
         {
             if (mark != Buffer.size())
                 lookahead = lexical();
             if (lookahead.getVal().equalsIgnoreCase(")"))
            {

            }
            else
            {
             global_error_count++;error_string += "\n"+"Error: Unexpected token: "+lookahead.getVal()+" after math.log";
            }
         }
         else
         {
             global_error_count++;error_string += "\n"+"Error: Bad parameter: "+lookahead.getVal()+" for math.log";
         }
     }
     else{
         global_error_count++;error_string += "\n"+"Error: Unexpected token: "+lookahead.getVal()+ " after math.log";
     }
 }
 void MathRound()
 {
     if (mark != Buffer.size())
        lookahead = lexical();
     if (lookahead.getVal().equalsIgnoreCase("("))
     {
         if (mark != Buffer.size())
             lookahead = lexical();
         if (lookahead.getType().equalsIgnoreCase("identifier")||lookahead.getType().equalsIgnoreCase("number")||lookahead.getType().equalsIgnoreCase("string"))
         {
             if (mark != Buffer.size())
                 lookahead = lexical();
             if (lookahead.getVal().equalsIgnoreCase(")"))
            {

            }
            else
            {
             global_error_count++;error_string += "\n"+"Error: Unexpected token: "+lookahead.getVal()+" after math.round";
            }
         }
         else
         {
             global_error_count++;error_string += "\n"+"Error: Bad parameter: "+lookahead.getVal()+" for math.round";
         }
     }
     else{
         global_error_count++;error_string += "\n"+"Error: Unexpected token: "+lookahead.getVal()+ " after math.round";
     }
 }
 void MathSqrt()
 {
     if (mark != Buffer.size())
        lookahead = lexical();
     if (lookahead.getVal().equalsIgnoreCase("("))
     {
         if (mark != Buffer.size())
             lookahead = lexical();
         if (lookahead.getType().equalsIgnoreCase("identifier")||lookahead.getType().equalsIgnoreCase("number")||lookahead.getType().equalsIgnoreCase("string"))
         {
             if (mark != Buffer.size())
                 lookahead = lexical();
             if (lookahead.getVal().equalsIgnoreCase(")"))
            {

            }
            else
            {
             global_error_count++;error_string += "\n"+"Error: Unexpected token: "+lookahead.getVal()+" after math.sqrt";
            }
         }
         else
         {
             global_error_count++;error_string += "\n"+"Error: Bad parameter: "+lookahead.getVal()+" for math.sqrt";
         }
     }
     else{
         global_error_count++;error_string += "\n"+"Error: Unexpected token: "+lookahead.getVal()+ " after math.sqrt";
     }
 }
 void MathAtan2()
 {
     if (mark != Buffer.size())
        lookahead = lexical();
     if (lookahead.getVal().equalsIgnoreCase("("))
     {
         if (mark != Buffer.size())
             lookahead = lexical();
         if (lookahead.getType().equalsIgnoreCase("identifier")||lookahead.getType().equalsIgnoreCase("number")||lookahead.getType().equalsIgnoreCase("string"))
         {
             if (mark != Buffer.size())
                 lookahead = lexical();
             if (lookahead.getVal().equalsIgnoreCase(","))
             {
                 if (mark != Buffer.size())
                     lookahead = lexical();
                 if (lookahead.getType().equalsIgnoreCase("identifier")||lookahead.getType().equalsIgnoreCase("number")||lookahead.getType().equalsIgnoreCase("string"))
                 {
                      if (mark != Buffer.size())
                        lookahead = lexical();
                     if (lookahead.getVal().equalsIgnoreCase(")"))
                     {

                     }
                     else
                     {
                        global_error_count++;error_string += "\n"+"Error: Unexpected token: "+lookahead.getVal()+" after math.atan2";
                     }
                 }
             }
             else
             {
                 global_error_count++;error_string += "\n"+"Error: Unexpected token "+lookahead.getVal()+" in math.atan2 call. Expecting ,";
             }
         }
         else
         {
             global_error_count++;error_string += "\n"+"Error: Bad parameter: "+lookahead.getVal()+" for math.atan2";
         }
     }
     else{
         global_error_count++;error_string += "\n"+"Error: Unexpected token: "+lookahead.getVal()+ " after math.atan2";
     }
 }
 void MathPow()
 {
     if (mark != Buffer.size())
        lookahead = lexical();
     if (lookahead.getVal().equalsIgnoreCase("("))
     {
         if (mark != Buffer.size())
             lookahead = lexical();
         if (lookahead.getType().equalsIgnoreCase("identifier")||lookahead.getType().equalsIgnoreCase("number")||lookahead.getType().equalsIgnoreCase("string"))
         {
             if (mark != Buffer.size())
                 lookahead = lexical();
             if (lookahead.getVal().equalsIgnoreCase(","))
             {
                 if (mark != Buffer.size())
                     lookahead = lexical();
                 if (lookahead.getType().equalsIgnoreCase("identifier")||lookahead.getType().equalsIgnoreCase("number")||lookahead.getType().equalsIgnoreCase("string"))
                 {
                      if (mark != Buffer.size())
                        lookahead = lexical();
                     if (lookahead.getVal().equalsIgnoreCase(")"))
                     {

                     }
                     else
                     {
                        global_error_count++;error_string += "\n"+"Error: Unexpected token: "+lookahead.getVal()+" after math.pow";
                     }
                 }
             }
             else
             {
                 global_error_count++;error_string += "\n"+"Error: Unexpected token "+lookahead.getVal()+" in math.pow call. Expecting ,";
             }
         }
         else
         {
             global_error_count++;error_string += "\n"+"Error: Bad parameter: "+lookahead.getVal()+" for math.pow";
         }
     }
     else{
         global_error_count++;error_string += "\n"+"Error: Unexpected token: "+lookahead.getVal()+ " after math.pow";
     }
 }
 void mathArrayPrime()
 {
     if (lookahead.getVal().equalsIgnoreCase(","))
     {
        if (mark != Buffer.size())
            lookahead = lexical();
        if (lookahead.getType().equalsIgnoreCase("number"))
        {
             if (mark != Buffer.size())
                lookahead = lexical();
             mathArrayPrime();
        }
        else
        {
            global_error_count++;error_string += "\n"+"Error: Unexpected token: "+lookahead.getVal()+" after math.min. Expecting a number.  : "+lookahead.getCount();
        }
     }
     else
     {
         
     }
     
 }
 void mathArray()
 {
     if (mark != Buffer.size())
        lookahead = lexical();
     mathArrayPrime();
 }
 void MathMin()
 {
     if (mark != Buffer.size())
        lookahead = lexical();
     if (lookahead.getVal().equalsIgnoreCase("("))
     {
         if (mark != Buffer.size())
             lookahead = lexical();
         if (lookahead.getType().equalsIgnoreCase("identifier")||lookahead.getType().equalsIgnoreCase("number")||lookahead.getVal().equalsIgnoreCase("["))
         {
             if (lookahead.getType().equalsIgnoreCase("identifier"))
             {
                 if (mark != Buffer.size())
                     lookahead = lexical();
                 if (lookahead.getVal().equalsIgnoreCase(")"))
                 {

                 }
                 else
                 {
                    global_error_count++;error_string += "\n"+"Error: Unexpected token: "+lookahead.getVal()+" after math.min   :"+lookahead.getCount();
                 }
             }
             else if (lookahead.getType().equalsIgnoreCase("number"))
             {
                 mathArray();
                 if (lookahead.getVal().equalsIgnoreCase(")"))
                 {

                 }
                 else
                 {
                    global_error_count++;error_string += "\n"+"Error: Unexpected token: "+lookahead.getVal()+" after math.min   :"+lookahead.getCount();
                 }
             }
             else if (lookahead.getVal().equalsIgnoreCase("["))
             {
                  if (mark != Buffer.size())
                     lookahead = lexical();
                  if (lookahead.getType().equalsIgnoreCase("number"))
                  {
                      mathArray();
                    if (lookahead.getVal().equalsIgnoreCase("]"))
                    {
                         if (mark != Buffer.size())
                            lookahead = lexical();
                         if (lookahead.getVal().equalsIgnoreCase(")"))
                         {
                             
                         }
                         else
                         {
                              global_error_count++;error_string += "\n"+"Error: Unexpected token: "+lookahead.getVal()+" after math.min     :"+lookahead.getCount();
                         }
                    }
                    else
                    {
                       global_error_count++;error_string += "\n"+"Error: Unexpected token: "+lookahead.getVal()+" after math.min. Expecting array brackets.     :"+lookahead.getCount();
                    }
                  }
                 
             }
             else
             {
                    global_error_count++;error_string += "\n"+"Error: Unexpected token: "+lookahead.getVal()+" after math.min. Violation of rules.      "+lookahead.getCount();
             }
         }
         else
         {
             global_error_count++;error_string += "\n"+"Error: Bad parameter: "+lookahead.getVal()+" for math.min       :"+lookahead.getCount();
         }
     }
     else{
         global_error_count++;error_string += "\n"+"Error: Unexpected token: "+lookahead.getVal()+ " after math.min     :"+lookahead.getCount();
     }
 }
 void MathMax()
 {
     if (mark != Buffer.size())
        lookahead = lexical();
     if (lookahead.getVal().equalsIgnoreCase("("))
     {
         if (mark != Buffer.size())
             lookahead = lexical();
         if (lookahead.getType().equalsIgnoreCase("identifier")||lookahead.getType().equalsIgnoreCase("number")||lookahead.getVal().equalsIgnoreCase("["))
         {
             if (lookahead.getType().equalsIgnoreCase("identifier"))
             {
                 if (mark != Buffer.size())
                     lookahead = lexical();
                 if (lookahead.getVal().equalsIgnoreCase(")"))
                 {

                 }
                 else
                 {
                    global_error_count++;error_string += "\n"+"Error: Unexpected token: "+lookahead.getVal()+" after math.max   :"+lookahead.getCount();
                 }
             }
             else if (lookahead.getType().equalsIgnoreCase("number"))
             {
                 mathArray();
                 if (lookahead.getVal().equalsIgnoreCase(")"))
                 {

                 }
                 else
                 {
                    global_error_count++;error_string += "\n"+"Error: Unexpected token: "+lookahead.getVal()+" after math.max   :"+lookahead.getCount();
                 }
             }
             else if (lookahead.getVal().equalsIgnoreCase("["))
             {
                  if (mark != Buffer.size())
                     lookahead = lexical();
                  if (lookahead.getType().equalsIgnoreCase("number"))
                  {
                      mathArray();
                    if (lookahead.getVal().equalsIgnoreCase("]"))
                    {
                         if (mark != Buffer.size())
                            lookahead = lexical();
                         if (lookahead.getVal().equalsIgnoreCase(")"))
                         {
                             
                         }
                         else
                         {
                              global_error_count++;error_string += "\n"+"Error: Unexpected token: "+lookahead.getVal()+" after math.max     :"+lookahead.getCount();
                         }
                    }
                    else
                    {
                       global_error_count++;error_string += "\n"+"Error: Unexpected token: "+lookahead.getVal()+" after math.max. Expecting array brackets.     :"+lookahead.getCount();
                    }
                  }
                 
             }
             else
             {
                    global_error_count++;error_string += "\n"+"Error: Unexpected token: "+lookahead.getVal()+" after math.max. Violation of rules.      "+lookahead.getCount();
             }
         }
         else
         {
             global_error_count++;error_string += "\n"+"Error: Bad parameter: "+lookahead.getVal()+" for math.max       :"+lookahead.getCount();
         }
     }
     else{
         global_error_count++;error_string += "\n"+"Error: Unexpected token: "+lookahead.getVal()+ " after math.max     :"+lookahead.getCount();
     }
 }
 void methodHandling()
 {
     if (mark != Buffer.size())
         lookahead = lexical();
     if (lookahead.getVal().equals("."))
     {
         if (mark != Buffer.size())
            lookahead = lexical();
         if (lookahead.getVal().equalsIgnoreCase("Random")||lookahead.getVal().equalsIgnoreCase("andom"))
         {
            MathRandom();
            if (mark != Buffer.size())
             lookahead = lexical();
         }
         else if (lookahead.getVal().equalsIgnoreCase("abs")||lookahead.getVal().equalsIgnoreCase("bs"))
         {
            MathAbs();
            if (mark != Buffer.size())
             lookahead = lexical();
         }
         else if (lookahead.getVal().equalsIgnoreCase("asin"))
         {
            MathAsin();
            if (mark != Buffer.size())
             lookahead = lexical();
         }
         else if (lookahead.getVal().equalsIgnoreCase("acos"))
         {
            MathAcos();
            if (mark != Buffer.size())
             lookahead = lexical();
         }
         else if (lookahead.getVal().equalsIgnoreCase("atan"))
         {
            MathAtan();
            if (mark != Buffer.size())
             lookahead = lexical();
         }
         else if (lookahead.getVal().equalsIgnoreCase("sin")||lookahead.getVal().equalsIgnoreCase("in"))
         {
            MathAsin();
            if (mark != Buffer.size())
             lookahead = lexical();
         }
         else if (lookahead.getVal().equalsIgnoreCase("cos")||lookahead.getVal().equalsIgnoreCase("os"))
         {
            MathAcos();
            if (mark != Buffer.size())
             lookahead = lexical();
         }
         else if (lookahead.getVal().equalsIgnoreCase("tan")||lookahead.getVal().equalsIgnoreCase("an"))
         {
            MathAtan();
            if (mark != Buffer.size())
             lookahead = lexical();
         }
         else if (lookahead.getVal().equalsIgnoreCase("ceil")||lookahead.getVal().equalsIgnoreCase("eil"))
         {
            MathCeil();
            if (mark != Buffer.size())
             lookahead = lexical();
         }
         else if (lookahead.getVal().equalsIgnoreCase("exp")||lookahead.getVal().equalsIgnoreCase("xp"))
         {
            MathExp();
            if (mark != Buffer.size())
             lookahead = lexical();
         }
         else if (lookahead.getVal().equalsIgnoreCase("floor")||lookahead.getVal().equalsIgnoreCase("loor"))
         {
            MathFloor();
            if (mark != Buffer.size())
             lookahead = lexical();
         }
         else if (lookahead.getVal().equalsIgnoreCase("log")||lookahead.getVal().equalsIgnoreCase("og"))
         {
            MathLog();
            if (mark != Buffer.size())
             lookahead = lexical();
         }
         else if (lookahead.getVal().equalsIgnoreCase("Round")||lookahead.getVal().equalsIgnoreCase("ound"))
         {
            MathRound();
            if (mark != Buffer.size())
             lookahead = lexical();
         }
        else if (lookahead.getVal().equalsIgnoreCase("Sqrt")||lookahead.getVal().equalsIgnoreCase("qrt"))
         {
            MathSqrt();
            if (mark != Buffer.size())
             lookahead = lexical();
         }
         else if (lookahead.getVal().equalsIgnoreCase("Atan2")||lookahead.getVal().equalsIgnoreCase("tan2"))
         {
            MathAtan2();
            if (mark != Buffer.size())
             lookahead = lexical();
         }
         else if (lookahead.getVal().equalsIgnoreCase("Pow")||lookahead.getVal().equalsIgnoreCase("ow"))
         {
            MathPow();
            if (mark != Buffer.size())
             lookahead = lexical();
         }
         else if (lookahead.getVal().equalsIgnoreCase("min")||lookahead.getVal().equalsIgnoreCase("in")) //unreachable code
         {
            MathMin();
            if (mark != Buffer.size())
             lookahead = lexical();
         }
         else if (lookahead.getVal().equalsIgnoreCase("max")||lookahead.getVal().equalsIgnoreCase("ax")) //unreachable code
         {
            MathMin();
            if (mark != Buffer.size())
             lookahead = lexical();
         }
         else{
             global_error_count++;error_string += "\n"+"Error: math library has no child with the name of "+lookahead.getVal()+": Access Denied.";
             if (mark != Buffer.size())
              lookahead = lexical();
         }
     }
     else{
         global_error_count++;error_string += "\n"+"Error: Expecting a "+lookahead.getVal()+" after calling the math library.";
         if (mark != Buffer.size())
             lookahead = lexical();
     }
     
 }
 public void program()
 {
   
    
    if (counter_of_op_braces != 0)
    {
    	global_error_count++;error_string += "\n"+"Error : Not an even number of braces";
    	counter_of_op_braces = 0;
    }
    if (lookahead.getVal().equalsIgnoreCase("Math")||lookahead.getVal().equalsIgnoreCase("ath"))
    {
     methodHandling();
     if (lookahead.getVal().equalsIgnoreCase(";")){
         if (mark != Buffer.size()){
             lookahead = lexical();
         }
     }
     else{
         global_error_count++;error_string += "\n"+"Error : Messing ; after a library call.";
         if (mark != Buffer.size()){
             lookahead = lexical();
         }
     }
     
    }
    if(lookahead.getVal().equalsIgnoreCase("if"))
     {
        
     If();
    
     }
    
    /*
    else if(lookahead.getVal().equalsIgnoreCase("@merge"))
    {
    
        merge_List();
    
    }
    
     */
    else if(lookahead.getVal().equalsIgnoreCase("while"))
    {
    
    	global_error_count++;error_string(lookahead.getVal().toLowerCase());
    	program();
        //program(); //continue exec
    }
    
    
     
    else if(lookahead.getVal().equalsIgnoreCase("routine"))
    {
    	global_error_count++;error_string("methods");
    	/*
     if(mark!=Buffer.size())
     lookahead=lexical();
            
    function();
    program();*/
    }
    
     
    else if(lookahead.getVal().equalsIgnoreCase("for"))
    {
   
    	global_error_count++;error_string(lookahead.getVal().toLowerCase());
    }
    
    
    else if(lookahead.getVal().equalsIgnoreCase("class"))
    {
    	global_error_count++;error_string(lookahead.getVal().toLowerCase());
         /* if(mark!=Buffer.size()) 
         
              Class();*/
    }
    
    else if(lookahead.getVal().equalsIgnoreCase("do"))
    {
    	global_error_count++;error_string(lookahead.getVal().toLowerCase());
    //Do();
    }
    else if (lookahead.getVal().equalsIgnoreCase("var"))
    {
    	decleration_js_list();
    }
    else if((!lookahead.getVal().equalsIgnoreCase("Math")&&!lookahead.getVal().equalsIgnoreCase("ath"))&&(lookahead.getType().equalsIgnoreCase("identifier")||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("matrix")||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("float")||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("integer")||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("double")||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equalsIgnoreCase("routine")||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equalsIgnoreCase("class")||Sympol_List.get(Sympol_List.size()-1).getType(Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal())).equalsIgnoreCase("class")||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("vector")))
        
    {
        
		 if(mark!=Buffer.size())        
		    
		     decleration_list();

    }
    
    else
    {
    	if(lookahead.getVal().equalsIgnoreCase("Math")||lookahead.getVal().equalsIgnoreCase("ath"))
        {
            program();
        }
    }
    	
    
     
     
 }
 
 void simple()
 {
     if(lookahead.getType().equalsIgnoreCase("number")||lookahead.getType().equalsIgnoreCase("identifier"))
     {
         
         if(mark!=Buffer.size())
     lookahead=lexical();
     }
     
 
 }
 
 
 void  parameter_list_prime()
 {
      if(lookahead.getType().equalsIgnoreCase("identifier")||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("matrix")||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("float")||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("integer")||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("double"))
     {
 
         parameter_list();
     }
     else{}
 
 }
 
 
 void operation()
 {
	 if (lookahead.getVal().equalsIgnoreCase(";"))
		 return;
 String type=null;
 
  
if(lookahead.getType().equalsIgnoreCase("identifier")||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("matrix")||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("float")||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("integer")||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("double")||lookahead.getType().equalsIgnoreCase("number"))
{
 
var.add(lookahead);
     
  int j=0;
     
  if(!lookahead.getType().equalsIgnoreCase("number"))
     {
     
     for(int i=Sympol_List.size()-1;i>=0;i--)
     {
  
         if(Sympol_List.get(i).is_declared(lookahead.getVal())==true)
     {
     type=Sympol_List.get(i).getType(lookahead.getVal());
         j++;     
        
     }
    else{}
     }
     
     if(j==0){global_error_count++;error_string += "\n"+"Error:"+"   "+lookahead.getVal()+" was not declared  line : "+lookahead.getCount();}j=0;
     }
    
     
   //System.out.println("mm"+lookahead.getType());
    if(!lookahead.getType().equalsIgnoreCase("number"))
    {
     int c=0;
    
     
     for(int i=Sympol_List.size()-1;i>=0;i--)
     {
  
                  
          //System.out.println( "soso"+Sympol_List.get(i).getType(stack.getFront()));
         if(Sympol_List.get(i).getType(stack.getFront()).equalsIgnoreCase("null")||Sympol_List.get(i).getType(stack.getFront()).equalsIgnoreCase("identifier"))
         {
         
         }
         
        
         else if(!Sympol_List.get(i).getType(stack.getFront()).equalsIgnoreCase(type))
         {
            
           // System.out.println( "kokoooooo"+Sympol_List.get(i).getType(stack.getFront()));
             c=2; 
             break;
         }
         else{break;}
         
     }
    
    
     if(c==2){global_error_count++;error_string += "\n"+"Error"+"   "+lookahead.getVal()+"  inconsistance type line :"+lookahead.getCount();}c=0;
    }

    
    

  
    if(mark!=Buffer.size())
 lookahead=lexical();
       
 }
 else{if(lookahead.getVal().equals("*")||lookahead.getVal().equals("(")||lookahead.getVal().equals(")")||lookahead.getVal().equals("+")||lookahead.getVal().equals("-")||lookahead.getVal().equals("/")||lookahead.getVal().equals("%")); else{ global_error_count++;error_string += "\n"+"Error:missing id or number in ops"+"   line:  "+lookahead.getCount();}}
 
 	if (lookahead.getVal().equals("("))
 	{
 		counter_of_op_braces++;
 	}
 	else if (lookahead.getVal().equals(")"))
 	{
 		counter_of_op_braces--;
 	}

    // System.out.println(lookahead.getVal()+"kkk");
  if(lookahead.getVal().equals("*")||lookahead.getVal().equals("(")||lookahead.getVal().equals(")")||lookahead.getVal().equals("+")||lookahead.getVal().equals("-")||lookahead.getVal().equals("/")||lookahead.getVal().equals("%"))
 {
     

    while(Priority(lookahead.getVal())<=Priority(op.getFront())) 
    {
    var.add(new Temp(op.getFront(), 1, "op"));
    op.pop();
    
        
    }
    op.append(lookahead.getVal());
     
     
     
 
  if(mark!=Buffer.size())
 lookahead=lexical();
 
 operation();

 }
 
while(!op.getFront().equalsIgnoreCase("null"))
{
var.add(new Temp(op.getFront(),lookahead.getCount() , "op"));

op.pop();

}


  
     
  
 
 }
 
 
void  instance_decleration_datatype()
 {
     
    
//System.out.println(lookahead.getVal());
     //System.out.println( Sympol_List.get(Sympol_List.size()-1).getKind(stack.getFront())); 
 //System.out.println(lookahead.getVal()+Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()));
  
     
 if(lookahead.getVal().equalsIgnoreCase("^"))
 {
     if(mark!=Buffer.size())  
      lookahead=lexical();

     Sympol_List.get(Sympol_List.size()-1).set_op_type(lookahead.getVal(), "transpose");

     String doOp=Sympol_List.get(Sympol_List.size()-1).getValue(lookahead.getVal());
     String val="";
     int [][]a=new int[Sympol_List.get(Sympol_List.size()-1).get_number_of_row(lookahead.getVal())][Sympol_List.get(Sympol_List.size()-1).get_number_of_col(lookahead.getVal())]; 
     for(int i=0;i<doOp.length();i++)
     {
     if(doOp.charAt(i)!=',')
     {
     val=val+doOp.charAt(i);
     }
     }
    
     for(int i=0;i<Sympol_List.get(Sympol_List.size()-1).get_number_of_row(lookahead.getVal());i++)
     {
        for(int j=0;j<Sympol_List.get(Sympol_List.size()-1).get_number_of_col(lookahead.getVal());j++)
     {
     
     String h=String.valueOf(val.charAt(i*Sympol_List.get(Sympol_List.size()-1).get_number_of_col(lookahead.getVal())+j));
        a[i][j]=Integer.valueOf(h);
         
     }
     }
         a=transposeMatrix(a);

String setval="";
for(int i=0;i<a.length;i++)
{
for(int j=0;j<a[i].length;j++)
{
    if(i!=0||j!=0)
    {
    setval=setval+","+a[i][j];
    }
    else{
    setval=setval+a[i][j];
    }
}    
}




    
Sympol_List.get(Sympol_List.size()-1).set_value(lookahead.getVal(), setval);

    // System.out.println(Sympol_List.get(Sympol_List.size()-1).getValue(lookahead.getVal()));
   int m=Sympol_List.get(Sympol_List.size()-1).get_number_of_row(lookahead.getVal());
   int n=Sympol_List.get(Sympol_List.size()-1).get_number_of_col(lookahead.getVal());
   int c=m*n;
   
    
 }
     
 
 
 else if(lookahead.getVal().equalsIgnoreCase("!"))
   {
       if(mark!=Buffer.size())  
      lookahead=lexical(); 
   
     
       
       
     Sympol_List.get(Sympol_List.size()-1).set_op_type(lookahead.getVal(), "transpose");

     String doOp=Sympol_List.get(Sympol_List.size()-1).getValue(lookahead.getVal());
     String val="";
     double [][]a=new double[Sympol_List.get(Sympol_List.size()-1).get_number_of_row(lookahead.getVal())][Sympol_List.get(Sympol_List.size()-1).get_number_of_col(lookahead.getVal())]; 
     for(int i=0;i<doOp.length();i++)
     {
     if(doOp.charAt(i)!=',')
     {
     val=val+doOp.charAt(i);
     }
     }
     
     
         
     for(int i=0;i<Sympol_List.get(Sympol_List.size()-1).get_number_of_row(lookahead.getVal());i++)
     {
        for(int j=0;j<Sympol_List.get(Sympol_List.size()-1).get_number_of_col(lookahead.getVal());j++)
     {
     
     String h=String.valueOf(val.charAt(i*Sympol_List.get(Sympol_List.size()-1).get_number_of_col(lookahead.getVal())+j));
        a[i][j]=Integer.valueOf(h);
        // System.out.println(a[i][j]);
     }
     }
     
     a=invert(a);
     
     
     String setval="";
for(int i=0;i<a.length;i++)
{
for(int j=0;j<a[i].length;j++)
{
    setval=setval+a[i][j];
}    
}

    
     
       
   }
 
 
 
 //CHECKHERE
 	if (lookahead.getVal().equalsIgnoreCase("("))
 	{
 		counter_of_op_braces++;
 		if (mark!=Buffer.size())
 			lookahead=lexical();
 		instance_decleration_datatype();
 		return;
 	}
 	
     if((!flag_of_js)&&(lookahead.getType().equalsIgnoreCase("identifier")&&!Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equalsIgnoreCase ("class")||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("float")||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("integer")||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("double")||lookahead.getType().equalsIgnoreCase("number")||lookahead.getType().equalsIgnoreCase("string")||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("matrix")||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("vector")))
     {

    
     /*
     if(!Sympol_List.get(Sympol_List.size()-1).getKind(stack.getFront()).equalsIgnoreCase("expr"))
     {
     System.out.println("Error"+"   "+stack.getFront()+"  is assignment because you are using := line :  "+lookahead.getCount());
     
     }*/

     int j=0;
    String type=null;
     for(int i=Sympol_List.size()-1;i>=0;i--)
     {
     
       if(Sympol_List.get(i).is_declared(lookahead.getVal())==true||lookahead.getType().equalsIgnoreCase("number")||lookahead.getType().equalsIgnoreCase("string"))
       {
           
         //  System.out.println(lookahead.getVal()+stack.getFront()+Sympol_List.get(i).getType(lookahead.getVal()));
          type=Sympol_List.get(i).getType(lookahead.getVal());
          j++; 
        break;
       }
   
     }
     
     if(j==0)global_error_count++;error_string += "\n"+"Error:"+"   "+lookahead.getVal()+" was not declared line : "+lookahead.getCount();
     

     
   
    
     if(!lookahead.getType().equalsIgnoreCase("number")&&!lookahead.getType().equalsIgnoreCase("string"))
     {
     
         int c=0;
         

 //System.out.println(lookahead.getVal()+Sympol_List.get(Sympol_List.size()-2).getType(lookahead.getVal()+my_class));
//System.out.println(type);
 for(int i=Sympol_List.size()-1;i>=0;i--)
     {
         
         // System.out.println( "soso"+Sympol_List.get(i).getType(stack.getFront()));
         if(Sympol_List.get(i).getType(stack.getFront()).equalsIgnoreCase("null")||Sympol_List.get(i).getType(stack.getFront()).equalsIgnoreCase("identifier"))
         {
         
         }
         
        
         else if(!Sympol_List.get(i).getType(stack.getFront()).equalsIgnoreCase(type))
         {
            
           // System.out.println( "kokoooooo"+Sympol_List.get(i).getType(stack.getFront()));
             c=2; 
             break;
         }
         else{break;}
     }     
  // System.out.println(c);
	//CHECK AGAIN - if ( c==2 ) {inconsistance} else { elle t77t }
     
     Sympol_List.get(Sympol_List.size()-1).set_value(stack.getFront(), lookahead.getVal());
     
     c=0;
    // System.out.println("value"+Sympol_List.get(Sympol_List.size()-1).getValue(stack.getFront()));
     }
 
     
     Temp temp=new Temp(lookahead.getVal(), lookahead.getCount(), lookahead.getType());
         if(mark!=Buffer.size())
        lookahead=lexical();
         //System.out.println(lookahead.getVal()+"nnnnnnnnnnnn");
         if(!lookahead.getVal().equalsIgnoreCase("*")&&!lookahead.getVal().equalsIgnoreCase("+")&&!lookahead.getVal().equals("-")&&!lookahead.getVal().equals("/"))
         {       
       //   System.out.println(lookahead.getVal());
     if(temp.getType().equalsIgnoreCase("number"))
    {
        if(isfunc==0)
        {
        if(!temp.getVal().contains("."))
        {
    
        }
        else
        {
     
        }
        }
        else
        {
        if(!temp.getVal().contains("."))
                {
     
                }
        else
        {
       
        }
        }
    }
    else
    {
        
        if(isfunc==0)
        {
            if(Sympol_List.get(Sympol_List.size()-1).getType(temp.getVal()).equalsIgnoreCase("integer"))
            {
       
            }
            else
            {
   
            }
            }
        else
        {
        if(Sympol_List.get(Sympol_List.size()-1).getType(temp.getVal()).equalsIgnoreCase("integer"))
        {
     
     
  
        }
        else
        {
      
        }
        }
        
        }
         }
     var.add(temp);
     

     
 if (lookahead.getVal().equals(";")) 
		 return ;
 
 if(lookahead.getVal().equals("*")||lookahead.getVal().equals("(")||lookahead.getVal().equals(")")||lookahead.getVal().equals("+")||lookahead.getVal().equals("-")||lookahead.getVal().equals("/")||lookahead.getVal().equals("%"))
 {
 
    // System.out.println(lookahead.getVal()+"kkkkk");
  op.append(lookahead.getVal());
  
  if(mark!=Buffer.size())
 lookahead=lexical();
  
 operation();
 
 ArrayList<Temp>sol=new ArrayList<>();

if(!Sympol_List.get(Sympol_List.size()-1).getType(stack.getFront()).equalsIgnoreCase("matrix")) 

{  
 
	if (lookahead.getVal().equalsIgnoreCase(";"))
	{
		return;
	}
	
 for(int  i=0;i<var.size();i++)
 {
    // System.out.println("mmm"+var.get(i).getVal());
         
    if(!var.get(i).getType().equalsIgnoreCase("op"))
    {
    
   sol.add(new Temp(var.get(i).getVal(), 1, var.get(i).getType()));
  
    }
    
    else
    {
    
        Temp second=sol.get(sol.size()-1);
        sol.remove(sol.size()-1);
    
        
    Temp first=sol.get(sol.size()-1);
    sol.remove(sol.size()-1);
       // System.out.println(first.getVal()+"first");
        // System.out.println(second.getVal()+"second");
    /*
         if(!Sympol_List.get(Sympol_List.size()-1).getType(stack.getFront()).equalsIgnoreCase("integer")) 
         {
         if(first.getType().equalsIgnoreCase("number"))
         {
            // System.out.println("fahed");
         if(!first.getVal().contains("."))
         {
         
             System.out.println("Error: incompatable type line  :"+lookahead.getCount()+ "  "+first.getVal());
         }
         }
         else{
         
         String a=Sympol_List.get(Sympol_List.size()-1).getValue(first.getVal());
         

         }
         
         
         if(second.getType().equalsIgnoreCase("number"))
         {
            // System.out.println("Umar");
         if(!second.getVal().contains("."))
         {
         
             System.out.println("Error: incompatable type line  :"+lookahead.getCount()+ "  "+second.getVal());
         }
         }
         else{
         
         String a=Sympol_List.get(Sympol_List.size()-1).getValue(second.getVal());
         

         }
         
         
         
         }
         */
    if(second.getVal().equalsIgnoreCase("0"))
    {
        global_error_count++;error_string += "\n"+"Error: arithmetic Error line(): "+lookahead.getCount();
    
    }
    
    if(first.getType().equalsIgnoreCase("number"))
    {
     if(Sympol_List.get(Sympol_List.size()-1).getType(stack.getFront()).equalsIgnoreCase("integer")) 
     {
    if(isfunc==0)
    {
        
    }
    else
    {
    
    }
     }
     else
     {
     
         if(isfunc==0)
    {

        
        
        
    }
    else
    {

        
     
    }
     
     }
    }
    else if(first.getType().equalsIgnoreCase("reg"))
    {
        if(Sympol_List.get(Sympol_List.size()-1).getType(stack.getFront()).equalsIgnoreCase("integer")) 
        {
    if(isfunc==0)
    {
   
    }
    else
    {
   
    }
        }
        else
        {
            if(isfunc==0)
    {
    
    }
    else
    {

  
    }
        
        }
    }
    else{
    
        if(Sympol_List.get(Sympol_List.size()-1).getType(stack.getFront()).equalsIgnoreCase("integer")) 
        {
        if(isfunc==0)
        {
       
        }
        else
        {
       
        }
        }
        else
        {
                if(isfunc==0)
        {
            
   
        
        }
        else
        {
   
            
       
        }
        
        }
    }
    
    
    if(second.getType().equalsIgnoreCase("number"))
    {
    
        if(Sympol_List.get(Sympol_List.size()-1).getType(stack.getFront()).equalsIgnoreCase("integer")) 
        {
        if(isfunc==0)
        {
            
            
        
        }
        else
        {
        
        
        }
        }
        else
        {
                if(isfunc==0)
        {
 
            
        
        }
        else
        {
  
        
        
         
         
        }
        
        }
            
        
    }
    else{
        

        if(isfunc==0)
        {
                if(Sympol_List.get(Sympol_List.size()-1).getType(stack.getFront()).equalsIgnoreCase("integer")) 
         {
          if(second.getType().equalsIgnoreCase("reg")) 
          {
        
          }
        else{   }
         }
              else
              {
                 if(second.getType().equalsIgnoreCase("reg")) 
          {

      
          }
        else{ 

                     }
                     
                 }
         }
        else
        {
         
             if(Sympol_List.get(Sympol_List.size()-1).getType(stack.getFront()).equalsIgnoreCase("integer")) 
             {
            if(second.getType().equalsIgnoreCase("reg")) 
          {
          }
        else{  }
             }
             else
             {
             
            if(second.getType().equalsIgnoreCase("reg")) 
          {
              
     
              
          }
        else{ 
                

                
             }
        }
    
    }
       
   
    if(var.get(i).getVal().equalsIgnoreCase("+"))
    {
       
        if(Sympol_List.get(Sympol_List.size()-1).getType(stack.getFront()).equalsIgnoreCase("integer")) 
        {
        if(isfunc==0)
        {
            
                
        if(i==var.size()-1)  
        {
        
        }
        
        }
        else
        {
             
        
        if(i==var.size()-1)
        {
        }
        
        }
        
      sol.add(new Temp("$t0", 1, "reg"));
        }
        else
        {
        
                    if(isfunc==0)
        {
            

            
        
        if(i==var.size()-1)
        {
        
        }
        }
        else
        {
 
            
        
     
        {if(i==var.size()-1)
        {
        }
        }
        
        }
        
      sol.add(new Temp("$f2", 1, "reg"));
        }
    }
    
  
    else if(var.get(i).getVal().equalsIgnoreCase("*"))
    {
    
         if(Sympol_List.get(Sympol_List.size()-1).getType(stack.getFront()).equalsIgnoreCase("integer")) 
         {
      if(isfunc==0)
      {
    
    if(i==var.size()-1)
    {
    } 
    }
      else
      {
    
    if(i==var.size()-1)
    {
    } 
    }
      
      
    sol.add(new Temp("$t1", 1, "reg"));
         }
         else{
    
      if(isfunc==0)
      {
     
     if(i==var.size()-1)
     {
     }
     
     }
      else
      {
    
    if(i==var.size()-1)
    {
    }
      }
      
      
    sol.add(new Temp("$f3", 1, "reg"));    
    
    }
    }
      else if(var.get(i).getVal().equalsIgnoreCase("/"))
    {
     
         if(Sympol_List.get(Sympol_List.size()-1).getType(stack.getFront()).equalsIgnoreCase("integer")) 
         {
    if(isfunc==0)
    {
    
    if(i==var.size()-1)
    {   
    }
    }
    else
    {
    
    if(i==var.size()-1)
    {
    
    }
    }
    
    sol.add(new Temp("$t2", 1, "reg"));
         }
         else
         {
         
                 if(isfunc==0)
    {
        
    
        
    
    
    if(i==var.size()-1)
    {
    }
    
    }
    else
    {

        
    
    
    
    if(i==var.size()-1)
    {
    }
    
    }
    
    sol.add(new Temp("$f4", 1, "reg"));
         
         
         }
    }
    
    }
   
        
        
    }
      
   
 }
 
}

else
{

for(int  i=0;i<var.size();i++)
 {
     //System.out.println("mmm"+var.get(i).getVal());
         
    if(!var.get(i).getType().equalsIgnoreCase("op"))
    {
    
   sol.add(new Temp(var.get(i).getVal(), 1, var.get(i).getType()));
  
    }
    
    else
    {
    
        Temp second=sol.get(sol.size()-1);
        sol.remove(sol.size()-1);
    
        
    Temp first=sol.get(sol.size()-1);
    sol.remove(sol.size()-1);

    sol.add(new Temp(stack.getFront(), Sympol_List.get(Sympol_List.size()-1).getLine(stack.getFront()), Sympol_List.get(Sympol_List.size()-1).getType(stack.getFront())));
    int crow=Sympol_List.get(Sympol_List.size()-1).get_number_of_row(stack.getFront());
    int ccol=Sympol_List.get(Sympol_List.size()-1).get_number_of_col(stack.getFront());
     int arow=Sympol_List.get(Sympol_List.size()-1).get_number_of_row(first.getVal());
    int acol=Sympol_List.get(Sympol_List.size()-1).get_number_of_col(first.getVal());
    int brow=Sympol_List.get(Sympol_List.size()-1).get_number_of_row(second.getVal());
    int bcol=Sympol_List.get(Sympol_List.size()-1).get_number_of_col(second.getVal());
   
    
 
    
     if(var.get(i).getVal().equalsIgnoreCase("+"))
     {
          if(crow!=arow||crow!=brow||ccol!=acol||ccol!=bcol)
    {
    
    global_error_count++;error_string += "\n"+"Error: inconsistence sizes line :"+lookahead.getCount();
    }
          else
          {
         
      if(isfunc==0)
      {
    
   
    
   
       int m=ccol+crow;
     
     
     
     
     
      }
      else
      {
    
    
   
    
   
       int m=ccol+crow;
     
     
     
     
     
      
      }
      
          }
     }
    
     else if(var.get(i).getVal().equalsIgnoreCase("-"))
     {
         
            if(crow!=arow||crow!=brow||ccol!=acol||ccol!=bcol)
    {
    
    global_error_count++;error_string += "\n"+"Error: inconsistence sizes line :"+lookahead.getCount();
    }
            else
            {
     
           if(isfunc==0)
           {
    
       int m=ccol+crow;
     
     
           }
           else
           {
    
       int m=ccol+crow;
     
           }
           
           }
       
     }
     
     
     else if(var.get(i).getVal().equalsIgnoreCase("*"))
     {
     
       if(crow!=arow||ccol!=bcol||acol!=brow) 
       {
       
       global_error_count++;error_string += "\n"+"Error: inconsistence sizes line :"+lookahead.getCount();
       
       }
       
       else
       {
       
      if(isfunc==0)
      {
       
      }
      else
      {
      
      }
      
           
       
       
       }
         
     
     }
     
 
    
    
    
    
    }
   
        
        
    }
      



}



 } 
  
 if(lookahead.getType().equalsIgnoreCase("identifier")||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("matrix")||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("float")||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("integer")||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("double")||lookahead.getType().equalsIgnoreCase("number"))
 {
 

 global_error_count++;error_string += "\n"+"Error:missing operator  in ops"+"   line:  "+lookahead.getCount();
      
 if(mark!=Buffer.size())
      lookahead=lexical();
       
 }
 }

 
 else if(lookahead.getVal().equals("float")||lookahead.getVal().equals("integer")||lookahead.getVal().equals("matrix")||lookahead.getVal().equals("space")||lookahead.getVal().equals("double")||lookahead.getVal().equals("vector")||lookahead.getVal().equals("character")||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("class")||flag_of_js)
 {
     if(Sympol_List.get(Sympol_List.size()-1).getKind(stack.getFront()).equalsIgnoreCase("expr"))
     {
     
     global_error_count++;error_string += "\n"+"Error: this not assignment because you are using = so "+stack.getFront()+" must be declared before  line :  "+lookahead.getCount();
     
     }
     
    
     
     if(Sympol_List.get(Sympol_List.size()-1).is_declared(stack.getFront())==false||Sympol_List.get(Sympol_List.size()-1).getKind(stack.getFront()).equalsIgnoreCase("parameter"))
     {
         
     Sympol_List.get(Sympol_List.size()-1).set_type(stack.getFront(), "identifier");
     if(!Sympol_List.get(Sympol_List.size()-1).getKind(stack.getFront()).equalsIgnoreCase("expr"))
     {
      
 Sympol_List.get(Sympol_List.size()-1).set_type(stack.getFront(), lookahead.getVal());
  Sympol_List.get(Sympol_List.size()-1).set_declared(stack.getFront()); 
   
     }
     }
     else{
     
     global_error_count++;error_string += "\n"+"Error: multiple declaration "+"   line :  "+lookahead.getCount();
     
     }
     
     
     
    if(lookahead.getVal().equalsIgnoreCase("integer"))
    {
        
    
    }
    else if(lookahead.getVal().equalsIgnoreCase("float"))
    {
    
        
    }
     
     
     
  if(lookahead.getVal().equals("matrix"))
 {
 

     
     
     if(mark!=Buffer.size())
 lookahead=lexical();
     
     
     instance_size();
 
 }
  
  else{ 
  if (flag_of_js) return;
 if(mark!=Buffer.size())
     lookahead=lexical(); 
  
  }
 }

 else if(lookahead.getVal().equals("["))
 {
     if(Sympol_List.get(Sympol_List.size()-1).getKind(stack.getFront()).equalsIgnoreCase("expr"))
     {
     
         
       int j=0;
 
       for(int i=Sympol_List.size()-1;i>=0;i--)
     {
     
         if(Sympol_List.get(i).getType(stack.getFront()).equals("matrix"))
    {
        j++;
 
    }
   else{}
 
     } 
 
       if(j==0){global_error_count++;error_string += "\n"+"Error : "+stack.getFront()+"  not matrix bad type line :"+lookahead.getCount();  matrix_value_zero();}
 
       else{matrix_value_zero();}
         j=0;
     }
     else{
         
         global_error_count++;error_string += "\n"+"Error : "+stack.getFront()+"  this matrix assign values must but = not := line : "+lookahead.getCount();
     
          if(Sympol_List.get(Sympol_List.size()-1).getType(stack.getFront()).equals("matrix"))
    {

        
        matrix_value_zero();
    }
   else{global_error_count++;error_string += "\n"+"Error : "+stack.getFront()+"  not matrix bad type line : "+lookahead.getCount();  matrix_value_zero();}
     
     
     }
 }
 


 
 else{
      if (!lookahead.getVal().equalsIgnoreCase(";"))
    	  global_error_count++;error_string += "\n"+"Error : bad parameter assignment "+"   line:  "+lookahead.getCount();}

 }


void value()
{
  
  if(Sympol_List.get(Sympol_List.size()-1).getType(Sympol_List.get(Sympol_List.size()-1).getType(stack.getFront())).equalsIgnoreCase("class")&&mark!=Buffer.size())
  {
  
      global_error_count++;error_string += "\n"+"Error:this is calss has no value line: "+lookahead.getCount();
  }
    
 if(lookahead.getType().equalsIgnoreCase("identifier")||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("matrix")||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("float")||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("integer")||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("double")||lookahead.getType().equalsIgnoreCase("number")||lookahead.getType().equalsIgnoreCase("string"))
{


  
      if(lookahead.getType().equalsIgnoreCase("identifier")||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("matrix")||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("float")||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("integer")||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("double"))
    {
    
  
      
     if(Sympol_List.get(Sympol_List.size()-1).is_declared(lookahead.getVal())==true||lookahead.getType().equalsIgnoreCase("number")||lookahead.getType().equalsIgnoreCase("string"))
       {
     
         
               
       }
    else{global_error_count++;error_string += "\n"+"Error :"+"   "+lookahead.getVal()+" was not declared line : "+lookahead.getCount();}
     
    
     if(Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equalsIgnoreCase(Sympol_List.get(Sympol_List.size()-1).getType(stack.getFront())))
     {
         if(!Sympol_List.get(Sympol_List.size()-1).getType(Sympol_List.get(Sympol_List.size()-1).getType(stack.getFront())).equalsIgnoreCase("class"))
       Sympol_List.get(Sympol_List.size()-1).set_value(stack.getFront(), lookahead.getVal());
     
     }
     else{
    	 
   // System.out.println("Error :"+"   "+lookahead+"  inconsistance type line : "+lookahead.getCount());
    }
     
    }
      
      else{ 
        
          if(!Sympol_List.get(Sympol_List.size()-1).getType(Sympol_List.get(Sympol_List.size()-1).getType(stack.getFront())).equalsIgnoreCase("class"))
          Sympol_List.get(Sympol_List.size()-1).set_value(stack.getFront(), lookahead.getVal());
     // System.out.println(Sympol_List.get(Sympol_List.size()-1).getValue(stack.getFront()));
      
       }  
    


if(mark!=Buffer.size())
    lookahead=lexical();





}
else{global_error_count++;error_string += "\n"+"Error: bad parameter decleration no assign value"+"   line:  "+lookahead.getCount();}

//System.out.println(lookahead.getVal());
}


void value_zero()
{


      
 if(lookahead.getType().equalsIgnoreCase("identifier")||lookahead.getType().equalsIgnoreCase("string")||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("matrix")||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("float")||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("integer")||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("double")||lookahead.getType().equalsIgnoreCase("number"))
{
   

value();
}
else{}
 


}


void passingtype()
{
    
   
      
if(lookahead.getVal().equals("in")||lookahead.getVal().equals("out")||lookahead.getVal().equals("ino"))    
{
  Sympol_List.get(Sympol_List.size()-1).set_passing_type(stack.getFront(), lookahead.getVal());
    
  
if(mark!=Buffer.size())
    lookahead=lexical();

}
else{ }

}

void passing_with_braces()
{
    
   
    
if(lookahead.getVal().equals("("))
{

    if(mark!=Buffer.size())
    lookahead=lexical();

}
else{global_error_count++;error_string += "\n"+"Error:missing ( for passing parameter"+"   line:  "+lookahead.getCount();}



if(lookahead.getVal().equals("in")||lookahead.getVal().equals("out")||lookahead.getVal().equals("ino"))
{
passingtype();
}
else{
    
      global_error_count++;error_string += "\n"+"Error:bad passing parameter type"+"   line:  "+lookahead.getCount();
    
    if(mark!=Buffer.size())
    lookahead=lexical();
}



if(lookahead.getVal().equals(")"))
{
    
if(mark!=Buffer.size())
    lookahead=lexical();

}
else{global_error_count++;error_string += "\n"+"Error:missing ) for passing parameter"+"   line:  "+lookahead.getCount();}

}
 
 
 void parameter()
 {
  
  String name=stack.getFront();  
 if(lookahead.getType().equalsIgnoreCase("identifier")||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("matrix")||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("float")||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("integer")||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("double"))
 {
   if(Sympol_List.get(Sympol_List.size()-1).find(lookahead.getVal())<0)
   {
   Sympol_List.get(Sympol_List.size()-1).insert(lookahead.getVal(), lookahead.getType(), lookahead.getCount());
   
   }
  
   
   
     stack.append(lookahead.getVal());
    stack.setFront(stack.getFront());
     Sympol_List.get(Sympol_List.size()-1).set_Kind(stack.getFront(),"parameter");
     
// System.out.println( Sympol_List.get(Sympol_List.size()-1).getKind(stack.getFront())+"soso"); 
   //System.out.println(stack.getFront()+"lolo");
     Sympol_List.get(Sympol_List.size()-1).insert(stack.getFront(), "identifier", lookahead.getCount());
     Parameter_Names.add(stack.getFront());
     
  if(mark!=Buffer.size())
      lookahead=lexical();
 
 }
 
 
 
 if(lookahead.getVal().equals(":="))
 {
     
 if(mark!=Buffer.size())
     lookahead=lexical();
 
 }
 else{global_error_count++;error_string += "\n"+"bad parameter decleration missing :="+"   line:  "+lookahead.getCount();}
 
  
      
 if(lookahead.getVal().equals("integer")||lookahead.getVal().equals("float")||lookahead.getType().equalsIgnoreCase("identifier")||lookahead.getVal().equals("vector")||lookahead.getVal().equals("matrix")||lookahead.getVal().equals("character")||lookahead.getVal().equals("double"))
 {
     
   
Sympol_List.get(Sympol_List.size()-1).set_declared(stack.getFront());
Sympol_List.get(Sympol_List.size()-1).set_type(stack.getFront(), lookahead.getVal());
    
   



     instance_decleration_datatype();
      init_value();
      
      
        Sympol_List.get(Sympol_List.size()-1).set_passing_type(stack.getFront(), "in");
       
       if(lookahead.getVal().equalsIgnoreCase("("))
      passing_with_braces();
       
       
       

     
 }
 else{global_error_count++;error_string += "\n"+"Error :bad parameter"+"   line:  "+lookahead.getCount();}
 
 
   //System.out.println(Sympol_List.get(Sympol_List.size()-1).getPassingType(stack.getFront()));
 
 if(Sympol_List.get(Sympol_List.size()-1).getPassingType(stack.getFront()).equalsIgnoreCase("in"))
 {
 if(Sympol_List.get(Sympol_List.size()-1).getType(stack.getFront()).equalsIgnoreCase("integer"))
 {
 
 u++;
 
 } 
 else
 {
 u++;
 
 }
 

 
 }
 
  else if(Sympol_List.get(Sympol_List.size()-1).getPassingType(stack.getFront()).equalsIgnoreCase("out"))
 {
     
  if(Sympol_List.get(Sympol_List.size()-1).getType(stack.getFront()).equalsIgnoreCase("integer"))
 {
 
  passRet.add("lw $v"+u+","+stack.getFront());
 u++;
 
 }   
  else
  {
 
  passRet.add("l.s $f"+c+","+stack.getFront());
 c++; 
  }
     
     
 }
 
 
   else if(Sympol_List.get(Sympol_List.size()-1).getPassingType(stack.getFront()).equalsIgnoreCase("ino"))
 {
     
  if(Sympol_List.get(Sympol_List.size()-1).getType(stack.getFront()).equalsIgnoreCase("integer"))
 {
 
 passRet.add("lw $v"+u+","+stack.getFront());
 u++;
 
 }    
     
     
 }
 
 
 
 
 
 
 
  if(Sympol_List.get(Sympol_List.size()-1).is_declared(stack.getFront())!=true||lookahead.getType().equalsIgnoreCase("number"))
   {
   
   global_error_count++;error_string += "\n"+"Error"+"   "+stack.getFront()+"  was not declared line   "+lookahead.getCount();
   }
 
 if(lookahead.getVal().equals(";"))
 {
     
 if(mark!=Buffer.size())
     lookahead=lexical();
 
 }
 else{global_error_count++;error_string += "\n"+"Error missing ; "+"   line:  "+lookahead.getCount();}
 

stack.pop();

 }
 
 void parameter_list()
 {
     if(lookahead.getType().equalsIgnoreCase("identifier")||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("matrix")||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("float")||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("integer")||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("double"))
     {
 
         parameter();
        count_parameter++;
       parameter_list_prime();
     
     }
     else{}
    
u=0;
 }
 
 
 
 void function()
 {
     
isfunc=1;
 if(lookahead.getType().equalsIgnoreCase("identifier"))
 {
     String temp=stack.getFront();
     my_func=lookahead.getVal();
  stack.append(lookahead.getVal());
  //
 
  if(Sympol_List.get(Sympol_List.size()-1).find(lookahead.getVal())<0)
  {
  Sympol_List.get(Sympol_List.size()-1).insert(stack.getFront(), "routine", lookahead.getCount());
   Sympol_List.get(Sympol_List.size()-1).set_declared(stack.getFront());
  Sympol_List.get(Sympol_List.size()-1).set_type(stack.getFront(), "routine");
  }
  else{global_error_count++;error_string += "\n"+"Error: multiple  declaration of this function line  "+lookahead.getCount();}

  
 //System.out.println("lllll"+stack.getFront()+Sympol_List.get(Sympol_List.size()-1).getType(stack.getFront()));
  
 
  

  
  if(mark!=Buffer.size())
      lookahead=lexical();
 
  
 }
 else{global_error_count++;error_string += "\n"+"Error:missing function name"+"   line:  "+lookahead.getCount();}
 Sympol_List.add(new Symbol_Table(100));
 c=6; 
  parameter_list();
  c=0;
 Sympol_List.get(Sympol_List.size()-2).set_number_of_parameter(stack.getFront(), count_parameter);
//System.out.println("im bbbbbbbbbbbfunc"+stack.getFront()+"   "+Sympol_List.get(Sympol_List.size()-1).get_number_of_parameter(stack.getFront()));
 count_parameter=0;
 
 Sympol_List.get(Sympol_List.size()-2).set_the_parameters_names(stack.getFront(), Parameter_Names);

 
 for(int i=0;i<Parameter_Names.size();i++)
 {
    //System.out.println(Sympol_List.get(Sympol_List.size()-1).getType(Parameter_Names.get(i)));
     functions_Names.add(Sympol_List.get(Sympol_List.size()-1).getType(Parameter_Names.get(i)));
//System.out.println(functions_Names.get(i));
 }
 Sympol_List.get(Sympol_List.size()-2).set_class_functions_names(stack.getFront(),functions_Names);
 


 Parameter_Names.clear();
functions_Names.clear();

 
 
if(stack.getFront()!=null)
stack.pop();
 
 
 
  if(lookahead.getVal().equals("begin"))
 {
     
  if(mark!=Buffer.size())
      lookahead=lexical();
  
  
 }
 else{global_error_count++;error_string += "\n"+"Error:missing begin in routine"+"   line:  "+lookahead.getCount();}
 
  program();
 
  
  
  for(int i=0;i<passRet.size();i++)
  {
      if(isfunc==0)
      {
      }
      else
      {
      }
  }
  
  passRet.clear();
  
   isfunc=0;
  
 
  my_func=null;
   if(lookahead.getVal().equals("end"))
 {
     
  if(mark!=Buffer.size())
      lookahead=lexical();
  
  Sympol_List.remove(Sympol_List.size()-1);
 // program();
  
 }
 else{global_error_count++;error_string += "\n"+"Error:missing end in routine"+"   line:  "+lookahead.getCount();}
 
   
   
                
 
   
 }
 
 void compound()
 {
 
 
 }
 
 void condition()
 {
     ArrayList<String>mips=new ArrayList<>();
    
     
 if(lookahead.getType().equalsIgnoreCase("identifier")||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("float")||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("matrix")||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("integer")||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("double")||lookahead.getType().equalsIgnoreCase("number"))
{
    
    stack.append(lookahead.getVal());
   
 
 
    if(isfunc==0)
    {
    if(lookahead.getType().equalsIgnoreCase("number"))
    {
    
    }
    }
    else
    {
        if(lookahead.getType().equalsIgnoreCase("number"))
    {
    
    }
    
    }
    
    
    int j=0;
      
    if(!lookahead.getType().equalsIgnoreCase("number"))
    {
    for(int i=Sympol_List.size()-1;i>=0;i--)
    {
    
     if(Sympol_List.get(i).is_declared(stack.getFront())==true)
       {
     
         j++;
               
       }
    }
  
    
    if(j==0){global_error_count++;error_string += "\n"+"Error"+"   "+lookahead.getVal()+" was not declared line  "+lookahead.getCount();}j=0;
    }
    
  
    
      if(mark!=Buffer.size())
      lookahead=lexical();
      
      
      if(lookahead.getVal().equalsIgnoreCase("*")||lookahead.getVal().equalsIgnoreCase("-")||lookahead.getVal().equalsIgnoreCase("/")||lookahead.getVal().equalsIgnoreCase("+"))
      {
      
          if(mark!=Buffer.size())
      lookahead=lexical();
       
          
          operation();
          
      }
      
       if(lookahead.getType().equalsIgnoreCase("identifier")||lookahead.getType().equalsIgnoreCase("number"))
 {
   
   
     
   if(mark!=Buffer.size())
      lookahead=lexical();  
 
   global_error_count++;error_string += "\n"+"Error:miising operator in condition"+"   line:  "+lookahead.getCount();
 
 }

}
else{global_error_count++;error_string += "\n"+"Error : missing condition"+"   line:  "+lookahead.getCount();}

   // System.out.println("mmmmmmmmmmmmmmmm"+lookahead.getVal());
if(lookahead.getVal().equals(">")||lookahead.getVal().equals("<")||lookahead.getVal().equals("!")||lookahead.getVal().equals(">=")||lookahead.getVal().equals("<=")||lookahead.getVal().equals("==")||lookahead.getVal().equals("!="))
{		

    mips.add(lookahead.getVal());
    
    if(mark!=Buffer.size())
      lookahead=lexical();
 
 if(lookahead.getType().equalsIgnoreCase("identifier")||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("float")||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("matrix")||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("integer")||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("double")||lookahead.getType().equalsIgnoreCase("number"))
 {
     
  if(isfunc==0)
  {
     if(lookahead.getType().equalsIgnoreCase("number"))
    {
    
    }
  }
  else
  {
  
       if(lookahead.getType().equalsIgnoreCase("number"))
    {
    
    }
  
  }
     
     if(condType==1)
      {
          if(isfunc==0)
          {
          }
          else
          {
          }
      }
   
     
   
     
     if(mips.get(0).equalsIgnoreCase("=="))
     {
    
         if(isfunc==0)
         {
         }
         else
         {
         }
     }
     
     else if(mips.get(0).equalsIgnoreCase(">"))
     {
         if(isfunc==0)
         {
     
         }
     
         else
         {
         
         }
     }
     
     
     else if(mips.get(0).equalsIgnoreCase("<"))
     {
     
      if(isfunc==0)
      {
      }
      else
      {
      
      }
     }
    
     
     else if(mips.get(0).equalsIgnoreCase(">="))
     {
         
     if(isfunc==0)
     {
     }
     else
     {
     
     }
     
     }
    
     
     else if(mips.get(0).equalsIgnoreCase("<="))
     {
         
         
      if(isfunc==0)
      {
      }
      else
      {
      
      }
     
     }
      else if(mips.get(0).equalsIgnoreCase("!="))
     {
     if(isfunc==0)
     {
     }
     else
     {
     
     }
     }
     
      mips.clear();
   
      
      
     if(Sympol_List.get(Sympol_List.size()-1).is_declared(stack.getFront())==true||lookahead.getType().equalsIgnoreCase("number"))
     { 
          
     }
     else{global_error_count++;error_string += "\n"+"Error :"+"   "+lookahead.getVal()+"was not declared line: "+lookahead.getVal();}
     
     
     if(Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equalsIgnoreCase(Sympol_List.get(Sympol_List.size()-1).getType(stack.getFront()))||lookahead.getType().equalsIgnoreCase("number"))
     {
   
     
     }
     else{global_error_count++;error_string += "\n"+"Error"+"   "+lookahead.getType()+"  inconsistance type line :  "+lookahead.getCount();}
     
     
     
 if(mark!=Buffer.size())
      lookahead=lexical();
 
  if(lookahead.getVal().equalsIgnoreCase("*")||lookahead.getVal().equalsIgnoreCase("-")||lookahead.getVal().equalsIgnoreCase("/")||lookahead.getVal().equalsIgnoreCase("+"))
      {
          if(mark!=Buffer.size())
      lookahead=lexical();
       
          
          operation();
          
      }
 
 if(lookahead.getType().equalsIgnoreCase("identifier")||lookahead.getType().equalsIgnoreCase("number"))
 {
   
 
    
     
     
     if(mark!=Buffer.size())
      lookahead=lexical();  
 global_error_count++;error_string += "\n"+"Error:miising operator in condition"+"   line:  "+lookahead.getCount();
 
 }
 
 }
 else{global_error_count++;error_string += "\n"+"Error:bad condition"+"   line:  "+lookahead.getCount();}

}


if(lookahead.getVal().equals("&&")||lookahead.getVal().equals("||"))
{
 
    
    if(mark!=Buffer.size())
      lookahead=lexical();
 
condition();

}
else{}

if(stack.getFront()!=null)
stack.pop();





 }
 
 void elif()
 {
     
 if(lookahead.getVal().equals("elseif"))
 {
     
  if(mark!=Buffer.size())
      lookahead=lexical();
 }
 
  if(lookahead.getVal().equals("("))
 {
     
  
        
 }
 else{global_error_count++;error_string += "\n"+"Error:missing  ( in if "+"   line:  "+lookahead.getCount();}
 
     if(mark!=Buffer.size())
 lookahead=lexical();
  
  condition();
  

 if(lookahead.getVal().equals(")"))
 {
	 
 }
 else{global_error_count++;error_string += "\n"+"Error:missing  left parenthesis"+"   line:  "+lookahead.getCount();}
 
 
  if(mark!=Buffer.size())
    lookahead=lexical();
 
  if(lookahead.getVal().equals("{"))
	 {

	     
	     Sympol_List.add(new Symbol_Table(100));
	 if(mark!=Buffer.size())
	   lookahead=lexical();
	  
	 
	 
	 }
	 else{global_error_count++;error_string += "\n"+"Error:missing  {"+"   line:  "+lookahead.getCount();}
 
  
 Sympol_List.add(new Symbol_Table(100));
 
 program();
 if(lookahead.getVal().equals("}"))
 {

     
     Sympol_List.add(new Symbol_Table(100));
 if(mark!=Buffer.size())
   lookahead=lexical();
  
 
 
 }
 else{global_error_count++;error_string += "\n"+"Error:missing  }"+"   line:  "+lookahead.getCount();}

 if(isfunc==0)
 {
 }
 else
 {
 }
 
 
 
Sympol_List.remove(Sympol_List.size()-1);
 }
 
 void elif_list_prime()
 {
     
 if(lookahead.getVal().equals("elseif"))
 {
     
 elif_list();
 
 }
 else{}
 }
 
 
 
 void elif_list()
 {
     
 elif();
 elif_list_prime();
 
 }
 
 
 
 void else_elif()
 {
     
     if(lookahead.getVal().equals("elseif"))
     {
         
    	 elif_list();
 
     }
     
 if(lookahead.getVal().equals("else"))
 {
     
  if(mark!=Buffer.size())
      lookahead=lexical();
 }
 else{return ;}
 
 Sympol_List.add(new Symbol_Table(100));
 if(lookahead.getVal().equals("{"))
 {

     
     Sympol_List.add(new Symbol_Table(100));
 if(mark!=Buffer.size())
   lookahead=lexical();
  
 
 
 }	
 else{global_error_count++;error_string += "\n"+"Error:missing  {"+"   line:  "+lookahead.getCount();}

 program();
 if(lookahead.getVal().equals("}"))
 {

     
     Sympol_List.add(new Symbol_Table(100));
 if(mark!=Buffer.size())
   lookahead=lexical();
  
 
 
 }
 else{global_error_count++;error_string += "\n"+"Error:missing  }"+"   line:  "+lookahead.getCount();}

 Sympol_List.remove(Sympol_List.size()-1);
 }
 
 
 void For()
 {
 if(lookahead.getVal().equals("for"))
 {
  if(mark!=Buffer.size())
      lookahead=lexical();
  
 }
 else{}
 
 

 
 if(lookahead.getType().equalsIgnoreCase("identifier"))
 {
  if(mark!=Buffer.size())
      lookahead=lexical();
 
 }
 else{global_error_count++;error_string += "\n"+"Error:miising identifier in for"+"   line:  "+lookahead.getCount();}
 
 

 
 if(lookahead.getVal().equals("in"))
 {
  if(mark!=Buffer.size())
      lookahead=lexical();
 
 }
 else{global_error_count++;error_string += "\n"+"Error:missing in in for "+"   line:  "+lookahead.getCount();}
  
 
 

 
  if(lookahead.getType().equalsIgnoreCase("number"))
 {
  
 
 }
 else{global_error_count++;error_string += "\n"+"Error:missing  beginig counter in for "+"   line:  "+lookahead.getCount();} 
 
 if(mark!=Buffer.size())
      lookahead=lexical();
   
  
 if(lookahead.getVal().equals("."))
 {
 
 
 }
 else{global_error_count++;error_string += "\n"+"Error:missing . in for "+"   line:  "+lookahead.getCount();} 
  
 if(mark!=Buffer.size())
      lookahead=lexical();
 

 
 if(lookahead.getVal().equals("."))
 {
 
 
 }
 else{global_error_count++;error_string += "\n"+"Error:missing . in for "+"   line:  "+lookahead.getCount();} 
 
  if(mark!=Buffer.size())
      lookahead=lexical();
 

 
   if(lookahead.getType().equalsIgnoreCase("number"))
 {
  
 
 }
 else{global_error_count++;error_string += "\n"+"Error:missing  extreme counter in for "+"   line:  "+lookahead.getCount();}

if(mark!=Buffer.size())
      lookahead=lexical();
   
     if(lookahead.getVal().equals("beginfor"))
 {
  
 
 }
 else{global_error_count++;error_string += "\n"+"Error:bad begin for "+"   line:  "+lookahead.getCount();}
    
     Sympol_List.add(new Symbol_Table(100));
     
     if(mark!=Buffer.size())
      lookahead=lexical(); 
 
     
     program();
     

      
    if(lookahead.getVal().equals("endfor"))
 {
  
 
 }
 else{global_error_count++;error_string += "\n"+"Error:bad end for "+"   line:  "+lookahead.getCount();}   

    if(mark!=Buffer.size())
      lookahead=lexical(); 
 
 
  Sympol_List.remove(Sympol_List.size()-1);
 }
 
 
 
 void While()
 {
     condType=1;
 if(lookahead.getVal().equals("while"))
 {
 if(mark!=Buffer.size())
      lookahead=lexical();
 
 }
 else{}

 

 if(lookahead.getVal().equals("("))
 {
  if(mark!=Buffer.size())
      lookahead=lexical();
 
 }
 else{global_error_count++;error_string += "\n"+"Error:miising ( in while"+"   line:  "+lookahead.getCount();}
 
 condition();
 
condType=0;
      
 if(lookahead.getVal().equals(")"))
 {
  if(mark!=Buffer.size())
      lookahead=lexical();
 
 
 }
 else{global_error_count++;error_string += "\n"+"Error:miising ) in while"+"   line:  "+lookahead.getCount();}
 
 if(lookahead.getVal().equals("beginwhile"))
 {

 }
 else{global_error_count++;error_string += "\n"+"Error:miising beginwhile in while"+"   line:  "+lookahead.getCount();}
 
 Sympol_List.add(new Symbol_Table(100));
 
  if(mark!=Buffer.size())
      lookahead=lexical();
  
 program();
 
 
 if(isfunc==0)
 {
 }
 else
 {
 
 }
 
 
 
 c=0;
 if(lookahead.getVal().equals("endwhile"))
 {
 if(mark!=Buffer.size())
      lookahead=lexical();
 }
 else{}
 
 
 Sympol_List.remove(Sympol_List.size()-1);
 }
 
 
 
 /*void lambda()
 {
 
 if(lookahead.equals("lambda"))
 {
 
  if(mark!=Buffer.size())
      lookahead=lexical();   
     
 }
 
 
  if(Sympol.getType(lookahead).equals("identifier"))
      {
         if(mark!=Buffer.size())
         lookahead=lexical();     
           
       }
   else{System.out.println("Error:missing identifier for space statment"+"   line:  "+Sympol.getLine(lookahead));}
 
  parameter_list();
  
  
   
  if(lookahead.equals("begin"))
 {
     
  if(mark!=Buffer.size())
      lookahead=lexical();
  
  
 }
 else{System.out.println("Error:missing begin in lambda"+"   line:  "+Sympol.getLine(lookahead));}
 
  program();
  
 
  
   if(lookahead.equals("end"))
 {
     
  if(mark!=Buffer.size())
      lookahead=lexical();
  program();
  
 }
 else{System.out.println("Error:missing end in lambda"+"   line:  "+Sympol.getLine(lookahead));}
  
  
 }
 */
 
 /*void space()
 {
 
   if(lookahead.equals("space"))
   {
    if(mark!=Buffer.size())
 lookahead=lexical();
   }
   
   if(lookahead.equals("("))
   {
   
    if(mark!=Buffer.size())
 lookahead=lexical();
       
   }
   else{System.out.println("Error:missing ( for space statment"+"   line:  "+Sympol.getLine(lookahead));}
   
   //lambda();
   
   
   if(lookahead.equals(","))
   {
   
      if(mark!=Buffer.size())
 lookahead=lexical();    
       
   }
   else{System.out.println("Error:missing , for space statment"+"   line:  "+Sympol.getLine(lookahead));}
     
   
   if(Sympol.getType(lookahead).equals("identifier"))
      {
         if(mark!=Buffer.size())
         lookahead=lexical();     
           
       }
   else{System.out.println("Error:missing identifier for space statment"+"   line:  "+Sympol.getLine(lookahead));}
   
   
     if(lookahead.equals(","))
   {
   
      if(mark!=Buffer.size())
 lookahead=lexical();    
       
   }
   else{System.out.println("Error:missing , for space statment"+"   line:  "+Sympol.getLine(lookahead));}
   
   
        
   if(Sympol.getType(lookahead).equals("identifier"))
      {
         if(mark!=Buffer.size())
         lookahead=lexical();     
           
       }
   else{System.out.println("Error:missing identifier for space statment"+"   line:  "+Sympol.getLine(lookahead));}
     
   
   
   if(lookahead.equals(")"))
   {
   
    if(mark!=Buffer.size())
 lookahead=lexical();
       
   }
   else{System.out.println("Error:missing ) for space statment"+"   line:  "+Sympol.getLine(lookahead));}
   
     
   if(lookahead.equals(";"))
   {
   
    if(mark!=Buffer.size())
 lookahead=lexical();
   
   }
   else{System.out.println("Error:missing ; for space statment"+"   line:  "+Sympol.getLine(lookahead));}
 
 
 }
 
 */
 
 void Do()
 {
     if(mark!=Buffer.size())
 if(lookahead.getVal().equals("do"))
 {
  if(mark!=Buffer.size())
 lookahead=lexical();
  
 }
 else{}
 
 
program();


     
if(lookahead.getVal().equals("while"))
{
 if(mark!=Buffer.size())
 lookahead=lexical();

}
else{global_error_count++;error_string += "\n"+"Error:missing while for do statement"+"   line:  "+lookahead.getCount();}




if(lookahead.getVal().equals("("))
{
 if(mark!=Buffer.size())
 lookahead=lexical();

}
else{global_error_count++;error_string += "\n"+"Error:missing ( in while"+"   line:  "+lookahead.getCount();}
if(mark!=Buffer.size())
    
condition();



if(lookahead.getVal().equals(")"))
{
 if(mark!=Buffer.size())
 lookahead=lexical();

}
else{global_error_count++;error_string += "\n"+"Error:missing ) in while"+"   line:  "+lookahead.getCount();}



 if(lookahead.getVal().equals(";"))
 {
  if(mark!=Buffer.size())
 lookahead=lexical();
  
 }
 else{global_error_count++;error_string += "\n"+"Error:missing ; in while"+"   line:  "+lookahead.getCount();}
 
 }
 
 
 void If()
 {
 
      
 if(lookahead.getVal().equals("if"))
 {
     if(mark!=Buffer.size())
 lookahead=lexical();
      
    
 }
      
 if(lookahead.getVal().equals("("))
 {
     if(mark!=Buffer.size())
 lookahead=lexical();
     
     
    
 }
 else{global_error_count++;error_string += "\n"+"Error:missing  ( in if "+"   line:  "+lookahead.getCount();}
 
  condition();
  
      
 if(lookahead.getVal().equals(")"))
 {
 if(mark!=Buffer.size())
     lookahead=lexical();
 
 }
 else{global_error_count++;error_string += "\n"+"Error:missing  left parenthesis"+"   line:  "+lookahead.getCount();}
 
 
  
 if(lookahead.getVal().equals("{"))
 {

     
     Sympol_List.add(new Symbol_Table(100));
 if(mark!=Buffer.size())
   lookahead=lexical();
  
 
 
 }
 else{global_error_count++;error_string += "\n"+"Error:missing  {"+"   line:  "+lookahead.getCount();}
 
 program();
 
 

 if(isfunc==0)
 {
 }
 else
 {
 
 }
 
 
c++;


if(lookahead.getVal().equals("}"))
 {
 if(mark!=Buffer.size())
     lookahead=lexical();
 
 }

else{global_error_count++;error_string += "\n"+"Error:missing  }"+"   line:  "+lookahead.getCount();}
if(lookahead.getVal().equals("elseif")||lookahead.getVal().equals("else"))
{
else_elif();
}
else
{
	return;
}

if(isfunc==0)
{
}
else
{

}
Sympol_List.remove(Sympol_List.size()-1);
c=0;
 }
 
 
 
 void merge_List()
 {
     if(lookahead.getVal().equals("@merge"))
     {
         if(mark!=Buffer.size())
             
 merge();
 merge_List();
 

     }
     else{ program();}
    
     
     
 
 
 }
 
 void merge()
 {
 if(lookahead.getVal().equals("@merge"))
 {
     if(mark!=Buffer.size())
 lookahead=lexical();
 
 }
 
 
      
 if(lookahead.getVal().equals("'"))
 {
     if(mark!=Buffer.size())
 lookahead=lexical();
 }
 else{global_error_count++;error_string += "\n"+"Error:missing sign qout"+"   lineee:  "+lookahead.getCount();}
 
 

 
 if(lookahead.getType().equalsIgnoreCase("identifier"))
 {
     if(mark!=Buffer.size())
 lookahead=lexical();
 }
 else{global_error_count++;error_string += "\n"+"Error:bad file name"+"   line:  "+lookahead.getCount();}



 if(lookahead.getVal().equals("."))
 {
     if(mark!=Buffer.size())
 lookahead=lexical();
    
 }
 
 else{global_error_count++;error_string += "\n"+"Error:bad file name must put ."+"   line:  "+lookahead.getCount();}

 
 
 if(lookahead.getVal().equals("jpl"))
 {
     if(mark!=Buffer.size())
 lookahead=lexical();
 }
 else{global_error_count++;error_string += "\n"+"Error:bad file name must put jpl"+"   line:" +lookahead.getCount();}

  
 if(lookahead.getVal().equals("'"))
 {
     if(mark!=Buffer.size())
 lookahead=lexical();
 }
 else{global_error_count++;error_string += "\n"+"Error:missing sign qout"+"   line:  "+lookahead.getCount();}
 
 
 }
 
 
 
 void constructor()
 {
 
     
  if(lookahead.getVal().equals("constructor"))
  {
  
       if(mark!=Buffer.size())
      lookahead=lexical();
        
      
  }
 
  
 
  
 if(lookahead.getType().equalsIgnoreCase("identifier"))
 {
     
  if(mark!=Buffer.size())
      lookahead=lexical();
  
parameter_list();
  
 }
 else{global_error_count++;error_string += "\n"+"Error:missing cons name"+"   line:  "+lookahead.getCount();}
 
 
 
 
  if(lookahead.getVal().equals("begincons"))
 {
     
  if(mark!=Buffer.size())
      lookahead=lexical();
 
  
 }
 else{global_error_count++;error_string += "\n"+"Error:missing begincons in cons"+"   line:  "+lookahead.getCount();}
  
   program();
 
  
   
   
   if(lookahead.getVal().equals("endcons"))
 {
     
  if(mark!=Buffer.size())
      lookahead=lexical();
 
  
 }
 else{global_error_count++;error_string += "\n"+"Error:missing endcons in cons"+"   line:  "+lookahead.getCount();}
   
    program();
 
  
  
  
 
 }
 
 
 void function_list_prime()
 {
 
    
     if(lookahead.getVal().equals("routine"))
     {
         
     
      function_list();
      
     }
 
 
 }
 
 
 
 void function_list()
 {
 if(lookahead.getVal().equals("routine"))
 {
      
       if(mark!=Buffer.size())
     lookahead=lexical();
   
       if(Sympol_List.get(Sympol_List.size()-1).is_declared(lookahead.getVal())==true)
       {
       global_error_count++;error_string += "\n"+"Error: this name was used befor  multiple declarations line:"+lookahead.getCount();
       
       }
       
       
   if(lookahead.getType().equalsIgnoreCase("identifier")||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equalsIgnoreCase("routine")) 
   {

       my_func=lookahead.getVal();
       lookahead.setVal(lookahead.getVal()+stack.getFront());
   functions_Names.add(lookahead.getVal());
   
   }
   else{global_error_count++;error_string += "\n"+"Error: bad function name line"+lookahead.getCount();}
    
       
  function();
my_func=null;
  function_list_prime();
 
 
 }
 else{}
 
 }
 
 
 
 void instance_size()
 {
     
     
 if(lookahead.getVal().equals("("))
 {
     
   if(mark!=Buffer.size())
      lookahead=lexical();
 
 }
 else{global_error_count++;error_string += "\n"+"Error :missing ( in matrix declaration "+"   line:  "+lookahead.getCount();}
 
 
 
 if(lookahead.getType().equalsIgnoreCase("number"))
 {
   
   Sympol_List.get(Sympol_List.size()-1).set_number_of_row(stack.getFront(), Integer.valueOf(lookahead.getVal()));
     
 if(mark!=Buffer.size())
      lookahead=lexical();
 
 }
 else{global_error_count++;error_string += "\n"+"Error :missing number in matrix declaration "+"   line:  "+lookahead.getCount();}
 
 
 
 if(lookahead.getVal().equals(","))
 {
 
     if(mark!=Buffer.size())
      lookahead=lexical();
 
 }
 else{global_error_count++;error_string += "\n"+"Error :missing , in matrix declaration "+"   line:  "+lookahead.getCount();}
 
 
 
 if(lookahead.getType().equalsIgnoreCase("number"))
 {
 
    
   Sympol_List.get(Sympol_List.size()-1).set_number_of_col(stack.getFront(), Integer.valueOf(lookahead.getVal()));
    
     if(mark!=Buffer.size())
      lookahead=lexical();
 
 }
 else{global_error_count++;error_string += "\n"+"Error :missing number in matrix declaration "+"   line:  "+lookahead.getCount();}
 
 
 if(lookahead.getVal().equals(")"))
 {
 
     if(mark!=Buffer.size())
      lookahead=lexical();
 
 }
 else{global_error_count++;error_string += "\n"+"Error :missing ) in matrix declaration "+"   line:  "+lookahead.getCount();}
 
 
 if(lookahead.getVal().equals("["))
 {
 matrix_value_zero();
 }
 
 
 }
 
 void rec_init()
 {
     
 if(lookahead.getType().equalsIgnoreCase("number"))
 {
  count_col++;
  value=value+lookahead.getVal(); 
  if(mark!=Buffer.size())
      lookahead=lexical();
 
 }
 else{global_error_count++;error_string += "\n"+"Error:bad initialization of matrix"  +"   line  "+lookahead.getCount();}
 
 
 
 if(lookahead.getVal().equals(","))
 {
 value=value+",";
     
     if(mark!=Buffer.size())
     
         lookahead=lexical();
        rec_init();
 }

 
 }
 
 
 void init_of_matrix()
 {
 
 if(lookahead.getVal().equals("["))
 {

     if(mark!=Buffer.size())
      lookahead=lexical();
 
 }
 else{global_error_count++;error_string += "\n"+"Error:miising ["  +"   line  "+lookahead.getCount();}
 
 rec_init();
 
 
 int j=0;
 for(int i=Sympol_List.size()-1;i>=0;i--)
 {
if(count_col==Sympol_List.get(i).get_number_of_col(stack.getFront()))
{
j++;
    

}
 }
 if(j==0){global_error_count++;error_string += "\n"+"Error: bad number of col row"+count_row+"   line:   "+lookahead.getCount();}j=0;
 
count_col=0;
 

if(lookahead.getVal().equals("]"))
 {
 count_row++;
     if(mark!=Buffer.size())
      lookahead=lexical();
 
 }
 else{global_error_count++;error_string += "\n"+"Error:miising ]"  +"   line  "+lookahead.getCount();}
 

 if(lookahead.getVal().equals(","))
 {
 
     if(mark!=Buffer.size())
     
         lookahead=lexical();
      value=value+",";
       init_of_matrix();
        
 }
 
 

 
 }
 
 
 void matrix_value_zero()
 {
 
 if(lookahead.getVal().equals("["))
 {
 
 if(mark!=Buffer.size())
      lookahead=lexical();
 }
 else{}
 
 init_of_matrix();
 
 int j=0;
 for(int i=Sympol_List.size()-1;i>=0;i--)
 {
 if(count_row==Sympol_List.get(i).get_number_of_row(stack.getFront()))
 {

    j++;
    
 
 }
 }
 if(j==0){ global_error_count++;error_string += "\n"+"Error:  number of  row "+"  is not true line  "+lookahead.getCount();}j=0;
 
 count_row=0;
 Sympol_List.get(Sympol_List.size()-1).set_value(stack.getFront(), value);
 value="";
 
 
 //System.out.println("my value"+Sympol_List.get(Sympol_List.size()-1).getValue(stack.getFront()));
 if(lookahead.getVal().equals("]"))
 {
 
 if(mark!=Buffer.size())
      lookahead=lexical();

 }
 else{global_error_count++;error_string += "\n"+"Error:miising ]"  +"   line  "+lookahead.getCount();}
 
 
 }
 
 
 
 void init_value()
 {
   
     if(lookahead.getType().equalsIgnoreCase("identifier")||lookahead.getType().equalsIgnoreCase("string")||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("matrix")||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("float")||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("integer")||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("double")||lookahead.getType().equalsIgnoreCase("number")||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("class"))
      {
                    
       value_zero();
       }
 
 
 }
 
 
 
 void matrix_index(int index)
 {
 if(lookahead.getType().equalsIgnoreCase("number"))
 {
     
   if(Integer.valueOf(lookahead.getVal())>Sympol_List.get(index).get_number_of_row(stack.getFront())||Integer.valueOf(lookahead.getVal())<0)  
   {
       
   global_error_count++;error_string += "\n"+"Error:" +lookahead.getVal()+"out of bound" +"   line:  "+lookahead.getCount();
   
   }
     
  if(mark!=Buffer.size())
      lookahead=lexical();
 }
 else{global_error_count++;error_string += "\n"+"Error:miising index number"  +"   line  "+lookahead.getCount();}
     
 
  
     
 
      
   if(lookahead.getVal().equalsIgnoreCase("]"))
   {
       
    if(mark!=Buffer.size())
      lookahead=lexical();
   
   }
   else{global_error_count++;error_string += "\n"+"Error:miising ]"  +"   line  "+lookahead.getCount();}
 
   
  
   
    if(lookahead.getVal().equalsIgnoreCase("["))
   {
       
   if(mark!=Buffer.size())
      lookahead=lexical();
  
   }
   else{global_error_count++;error_string += "\n"+"Error:miising ["  +"   line  "+lookahead.getCount();}
 
   
     
     
     
    if(lookahead.getType().equalsIgnoreCase("number"))
 {
     
   if(Integer.valueOf(lookahead.getVal())>Sympol_List.get(index).get_number_of_col(stack.getFront())||Integer.valueOf(lookahead.getVal())<0)  
   {
       
   global_error_count++;error_string += "\n"+"Error:" +lookahead.getVal()+"out of bound" +"   line  "+lookahead.getCount();
   
   }
     
  if(mark!=Buffer.size())
      lookahead=lexical();
 }
 else{global_error_count++;error_string += "\n"+"Error:miising index number"  +"   line  "+lookahead.getCount();}
     
 
  
     
      
      
            
   if(lookahead.getVal().equalsIgnoreCase("]"))
   {
    if(mark!=Buffer.size())
      lookahead=lexical();
   }
   else{global_error_count++;error_string += "\n"+"Error:miising ]"  +"   line  "+lookahead.getCount();}
 
   
  
   
   
   if(!lookahead.getVal().equalsIgnoreCase("="))
   {
   
   global_error_count++;error_string += "\n"+"Error: this expr not assignment so must be =  line : "+lookahead.getCount();
       
   }
      
      
 }
 
 
 void decleration()
 {

if(lookahead.getType().equalsIgnoreCase("identifier")||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("matrix")||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("float")||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("integer")||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("double")||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equalsIgnoreCase("routine")||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equalsIgnoreCase("class")||Sympol_List.get(Sympol_List.size()-1).getType(Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal())).equalsIgnoreCase("class")||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("vector"))
 {
     
     stack.append(lookahead.getVal());
     
     
              
     if(Sympol_List.get(Sympol_List.size()-1).find(stack.getFront())<0)
     {
        
     Sympol_List.get(Sympol_List.size()-1).insert(stack.getFront(), lookahead.getType(), lookahead.getCount());
     }
     
     
  
     
     
     if(mark!=Buffer.size())  
      lookahead=lexical();
     
        int temp=0;
        int u=0;
        for(int i=Sympol_List.size()-1;i>=0;i--)
        {
        
        if(Sympol_List.get(i).getType(stack.getFront()).equalsIgnoreCase("matrix"))
        {
        
        u++;  
        temp=i;
        
        }
        }
        if(u>0){if(lookahead.getVal().equalsIgnoreCase("["))
        {
            
            if(mark!=Buffer.size())  
             lookahead=lexical();
            matrix_index(temp);
          
           }
         
        }
       

     
     
 }
 else{}
 

 
 if(lookahead.getVal().equals(":="))
 {
     

  
  Sympol_List.get(Sympol_List.size()-1).set_Kind(stack.getFront(), "assignment");

   if(mark!=Buffer.size())
      lookahead=lexical();
   
   
     
 instance_decleration_datatype();
 if (counter_of_op_braces != 0)
 {
	 global_error_count++;error_string += "\n"+"Error : Number of braces not correct";
 }
 init_value();
 
 
 int j=0;
 for(int i=Sympol_List.size()-1;i>=0;i--)
 {
  if(Sympol_List.get(i).is_declared(stack.getFront())==true)
   {
   j++;
   
   }
 }
 if(j==0){global_error_count++;error_string += "\n"+"Error"+"   "+stack.getFront()+" was not declared line : "+lookahead.getCount();} j=0;
 
 
if(stack.getFront()!=null)
stack.pop();

   
   
 
 }
 
 
 else if(lookahead.getVal().equalsIgnoreCase("="))
 {
   

     
Sympol_List.get(Sympol_List.size()-1).set_Kind(stack.getFront(), "expr");
  
   

if(mark!=Buffer.size())
      lookahead=lexical();	 
 
 instance_decleration_datatype();
 
 init_value();
 

 
  int j=0;
 for(int i=Sympol_List.size()-1;i>=0;i--)
 {
    
  if(Sympol_List.get(i).is_declared(stack.getFront())==true)
   {
   j++;
   
   }
 

 } if(j==0)global_error_count++;error_string += "\n"+"Error"+"   "+stack.getFront()+" was not declared line : "+lookahead.getCount();
 
if(stack.getFront()!=null)
stack.pop();

   
   
 
 }
 
 
 else if(lookahead.getVal().equalsIgnoreCase("("))
 {
  int j=0;
  
     for(int i=Sympol_List.size()-1;i>=0;i--)
     {
 if(Sympol_List.get(i).is_declared(stack.getFront()+Sympol_List.get(i).getType(stack.getFront()))==true)
 {
 
 j++;
 
 }
     }
     if(j>0){global_error_count++;error_string += "\n"+"Error : this function  "+stack.getFront()+" was not declared   line : "+lookahead.getCount();} j=0;
 
     for(int i=Sympol_List.size()-1;i>=0;i--)
 {
  if(Sympol_List.get(i).getType(stack.getFront()).equalsIgnoreCase("routine"))
 {
 
j++;
 }
 }  
 if(j==0){ global_error_count++;error_string += "\n"+"Error : this not function  "+stack.getFront()+"  line:  "+lookahead.getCount();}j=0;
  
  
func_calling();
 
 }
 
 
 
 else if(lookahead.getVal().equalsIgnoreCase("."))
 {

     int j=0;
     for(int i=Sympol_List.size()-1;i>=0;i--)
     {
     
  if(Sympol_List.get(i).is_declared(stack.getFront())==true)
 {
 j++;
 
 }
     }
 if(j==0){global_error_count++;error_string += "\n"+"Error : this class  "+stack.getFront()+" was not declared line : "+lookahead.getCount();}j++;
     
   
  if(!Sympol_List.get(Sympol_List.size()-1).getType(Sympol_List.get(Sympol_List.size()-1).getType(stack.getFront())).equalsIgnoreCase("class"))
 {
 
 global_error_count++;error_string += "\n"+"Error : this not class  "+stack.getFront()+"  line:  "+lookahead.getCount();
 lookahead=lexical();
 }
     
     
 callingMethod();
  }
 
 
 
 else
 {
       if(mark!=Buffer.size())
      lookahead=lexical();
     global_error_count++;error_string += "\n"+"Error:bad decleration "  +"   line  "+lookahead.getCount();
 
 }

 

 

   
 if(lookahead.getVal().equals(";"))
 {
 
       if(mark!=Buffer.size())
      lookahead=lexical();
 }
 else{
      
     
     global_error_count++;error_string += "\n"+"Error:missing ;"+"   line  "+lookahead.getCount();}
 
 
 
 }
 
 
 void dec_prime()
 {
 
 if(lookahead.getType().equalsIgnoreCase("identifier")&&mark!=Buffer.size()||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("matrix")&&mark!=Buffer.size()||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("float")&&mark!=Buffer.size()||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("integer")&&mark!=Buffer.size()||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("double")&&mark!=Buffer.size()||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equalsIgnoreCase("routine")&&mark!=Buffer.size()||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equalsIgnoreCase("class")&&mark!=Buffer.size()||Sympol_List.get(Sympol_List.size()-1).getType(Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal())).equalsIgnoreCase("class")&&mark!=Buffer.size()||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("vector")&&mark!=Buffer.size())
 {
      
     decleration_list();
     
 }
 else{}
 
 }
 void decleration_js()
 {
	 if(lookahead.getVal().equalsIgnoreCase("var"))
	 {
		 
	 }
	 if(mark!=Buffer.size())  
	      lookahead=lexical();
	 if(lookahead.getType().equalsIgnoreCase("identifier")||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("matrix")||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("float")||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("integer")||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("double")||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equalsIgnoreCase("routine")||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equalsIgnoreCase("class")||Sympol_List.get(Sympol_List.size()-1).getType(Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal())).equalsIgnoreCase("class")||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("vector"))
	 {
	     
	     stack.append(lookahead.getVal());
	     
	     
	              
	     if(Sympol_List.get(Sympol_List.size()-1).find(stack.getFront())<0)
	     {
	        
	     Sympol_List.get(Sympol_List.size()-1).insert(stack.getFront(), "jsinstance", lookahead.getCount());
	     }
	     
	     
	  
	     
	     
	     if(mark!=Buffer.size())  
	      lookahead=lexical();
	     
	        int temp=0;
	        int u=0;
	        for(int i=Sympol_List.size()-1;i>=0;i--)
	        {
	        
	        if(Sympol_List.get(i).getType(stack.getFront()).equalsIgnoreCase("matrix"))
	        {
	        
	        u++;  
	        temp=i;
	        
	        }
	        }
	        if(u>0){if(lookahead.getVal().equalsIgnoreCase("["))
	        {
	            
	            if(mark!=Buffer.size())  
	             lookahead=lexical();
	            matrix_index(temp);
	          
	           }
	         
	        }
	       

	     
	     
	 }
	 else{}
	 

	 
	 if(lookahead.getVal().equals("="))
	 {
	     

	  
	  Sympol_List.get(Sympol_List.size()-1).set_Kind(stack.getFront(), "jsinstance");

	   if(mark!=Buffer.size())
	      lookahead=lexical();
	   
	   
	 flag_of_js = true;
	 instance_decleration_datatype();

	 init_value();
	 flag_of_js = false;
	 
	 int j=0;
	 for(int i=Sympol_List.size()-1;i>=0;i--)
	 {
	  if(Sympol_List.get(i).is_declared(stack.getFront())==true)
	   {
	   j++;
	   
	   }
	 }
	 if(j==0){global_error_count++;error_string += "\n"+"Error"+"   "+stack.getFront()+" was not declared line : "+lookahead.getCount();} j=0;
	 
	 
	if(stack.getFront()!=null)
	stack.pop();

	   
	   
	 
	 }
	 
	 
	 /*else if(lookahead.getVal().equalsIgnoreCase("="))
	 {
	   

	     
	Sympol_List.get(Sympol_List.size()-1).set_Kind(stack.getFront(), "expr");
	  
	   

	if(mark!=Buffer.size())
	      lookahead=lexical();
	  

	 
	    
	 instance_decleration_datatype();
	 
	 init_value();
	  int j=0;
	 for(int i=Sympol_List.size()-1;i>=0;i--)
	 {
	    
	  if(Sympol_List.get(i).is_declared(stack.getFront())==true)
	   {
	   j++;
	   
	   }
	 

	 } if(j==0)System.out.println("Error"+"   "+stack.getFront()+" was not declared line : "+lookahead.getCount());
	 
	if(stack.getFront()!=null)
	stack.pop();

	   
	   
	 
	 }*/
	 
	 
	 else if(lookahead.getVal().equalsIgnoreCase("("))
	 {
	  int j=0;
	  
	     for(int i=Sympol_List.size()-1;i>=0;i--)
	     {
	 if(Sympol_List.get(i).is_declared(stack.getFront()+Sympol_List.get(i).getType(stack.getFront()))==true)
	 {
	 
	 j++;
	 
	 }
	     }
	     if(j>0){global_error_count++;error_string += "\n"+"Error : this function  "+stack.getFront()+" was not declared   line : "+lookahead.getCount();} j=0;
	 
	     for(int i=Sympol_List.size()-1;i>=0;i--)
	 {
	  if(Sympol_List.get(i).getType(stack.getFront()).equalsIgnoreCase("routine"))
	 {
	 
	j++;
	 }
	 }  
	 if(j==0){ global_error_count++;error_string += "\n"+"Error : this not function  "+stack.getFront()+"  line:  "+lookahead.getCount();}j=0;
	  
	  
	func_calling();
	 
	 }
	 
	 
	 
	 else if(lookahead.getVal().equalsIgnoreCase("."))
	 {

	     int j=0;
	     for(int i=Sympol_List.size()-1;i>=0;i--)
	     {
	     
	  if(Sympol_List.get(i).is_declared(stack.getFront())==true)
	 {
	 j++;
	 
	 }
	     }
	 if(j==0){global_error_count++;error_string += "\n"+"Error : this class  "+stack.getFront()+" was not declared line : "+lookahead.getCount();}j++;
	     
	   
	  if(!Sympol_List.get(Sympol_List.size()-1).getType(Sympol_List.get(Sympol_List.size()-1).getType(stack.getFront())).equalsIgnoreCase("class"))
	 {
	 
	 global_error_count++;error_string += "\n"+"Error : this not class  "+stack.getFront()+"  line:  "+lookahead.getCount();
	 lookahead=lexical();
	 }
	     
	     
	 callingMethod();
	  }
	 
	 
	 
	 else
	 {
	       if(mark!=Buffer.size())
	      lookahead=lexical();
	     global_error_count++;error_string += "\n"+"Error:bad decleration "  +"   line  "+lookahead.getCount();
	 
	 }

	 

	 

	   
	 if(lookahead.getVal().equals(";"))
	 {
	 
	       if(mark!=Buffer.size())
	      lookahead=lexical();
	 }
	 else{
	      
	     
	     global_error_count++;error_string += "\n"+"Error:missing ;"+"   line  "+lookahead.getCount();}
	 
	 
	 
	 
 }
 void decleration_js_list()
 {
	 if(lookahead.getVal().equalsIgnoreCase("var"))
			 {
				 decleration_js();
				 decleration_js_list();
			 }
	 else;
	 
	 program();
 }
 
 void decleration_list()
 {
     
   
 if(lookahead.getType().equalsIgnoreCase("identifier")&&mark!=Buffer.size()||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("matrix")&&mark!=Buffer.size()||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("float")&&mark!=Buffer.size()||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("integer")&&mark!=Buffer.size()||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("double")&&mark!=Buffer.size()||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equalsIgnoreCase("routine")&&mark!=Buffer.size()||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equalsIgnoreCase("class")&&mark!=Buffer.size()||Sympol_List.get(Sympol_List.size()-1).getType(Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal())).equalsIgnoreCase("class")&&mark!=Buffer.size()||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("vector")&&mark!=Buffer.size())
 {
  
 decleration();
 dec_prime();
 
 }
 else{}
 
 program();
 
 }
 
 
 
 
 void classDec_prime()
 {
  
 if(lookahead.getType().equalsIgnoreCase("identifier")&&mark!=Buffer.size()||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("matrix")&&mark!=Buffer.size()||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("float")&&mark!=Buffer.size()||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("integer")&&mark!=Buffer.size()||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("double")&&mark!=Buffer.size()||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equalsIgnoreCase("routine")&&mark!=Buffer.size())
 {
    
     classDecleration_list();
     
 }
 else{}
 
 }
 
 
 
  
 void classDecleration_list()
 {
     
   
 if(lookahead.getType().equalsIgnoreCase("identifier")&&mark!=Buffer.size()||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("matrix")&&mark!=Buffer.size()||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("float")&&mark!=Buffer.size()||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("integer")&&mark!=Buffer.size()||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("double")&&mark!=Buffer.size()||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equalsIgnoreCase("routine")&&mark!=Buffer.size())
 {

  Parameter_Names.add(lookahead.getVal());
 
 
 decleration();
 classDec_prime();
 
 }
 else{}
 
 program();
 
 }
 

  
  
 void callingMethod()
 {
 
  if(lookahead.getVal().equalsIgnoreCase("."))
  {
  
  if(mark!=Buffer.size())
      lookahead=lexical();
  
  }
  
 
  if(Sympol_List.get(Sympol_List.size()-1).get_class_functions_names(stack.getFront())!=null&&Sympol_List.get(Sympol_List.size()-1).getType(Sympol_List.get(Sympol_List.size()-1).getType(stack.getFront())).equalsIgnoreCase("class"))
  {
    
  if(!Sympol_List.get(Sympol_List.size()-1).get_class_functions_names(Sympol_List.get(Sympol_List.size()-1).getType(stack.getFront())).contains(lookahead.getVal()+Sympol_List.get(Sympol_List.size()-1).getType(stack.getFront())))
  {
  
 global_error_count++;error_string += "\n"+"Error: this method  "+lookahead.getVal()+"  no matching memper function in this class  line:   "+lookahead.getCount();

 stack.pop();
 stack.append(lookahead.getVal());
 
  if(mark!=Buffer.size())
      lookahead=lexical();
    

 func_calling();
 
  }
   
  
  else{
      
 lookahead.setVal(lookahead.getVal()+Sympol_List.get(Sympol_List.size()-1).getType(stack.getFront()));       
  stack.pop();
  stack.append(lookahead.getVal());
     
   if(mark!=Buffer.size())
      lookahead=lexical();
  
 
   func_calling();
  
  
  }
 
  }
 
 }
  
  
  
 
 void Class()
 {
 
 if(lookahead.getVal().equals("class"))
 {
 
     if(mark!=Buffer.size())
      lookahead=lexical();
 
 }
 


 if(lookahead.getType().equalsIgnoreCase("identifier"))
 {
     my_class=lookahead.getVal();
     stack.append(lookahead.getVal());
     
     stack.append(lookahead.getVal());
     Sympol_List.get(Sympol_List.size()-1).insert(stack.getFront(), "class", lookahead.getCount());
     Sympol_List.get(Sympol_List.size()-1).set_declared(stack.getFront());
     Sympol_List.get(Sympol_List.size()-1).set_type(stack.getFront(), "class");
//System.out.println("mmmmmm"+stack.getFront()+Sympol_List.get(Sympol_List.size()-1).getType(stack.getFront())+"oo");    
  if(mark!=Buffer.size())
      lookahead=lexical();
  
 
 }
 else{global_error_count++;error_string += "\n"+"Error :missing class name "+"   line:  "+lookahead.getCount();}
 
 
 Sympol_List.add(new Symbol_Table(100));
 
 classDecleration_list();
 

Sympol_List.get(Sympol_List.size()-1).set_class_declarations_names(stack.getFront(), Parameter_Names);
Parameter_Names.clear();
      


      
 if(lookahead.getVal().equals("beginclass"))
 {
 
     if(mark!=Buffer.size())
      lookahead=lexical();
 
 }
 else{global_error_count++;error_string += "\n"+"Error :bad begin of class "+"   line:  "+lookahead.getCount();      global_error_count++;
}
 


 if(lookahead.getVal().equals("constructor"))
 {
 
     constructor();
 
 }
 else{}
 

 function_list();
 
Sympol_List.get(Sympol_List.size()-2).set_class_functions_names(stack.getFront(), functions_Names);
functions_Names.clear();
//System.out.println(lookahead.getVal());
 
my_class=null;

 if(lookahead.getVal().equals("endclass"))
 {
  
     if(mark!=Buffer.size())
      lookahead=lexical();
 
stack.pop();
Sympol_List.remove(Sympol_List.size()-1);
  program();
  
 }
 else{global_error_count++;error_string += "\n"+"Error :bad end of class "+"   line:  "+lookahead.getCount();      global_error_count++;
}
 

 
 }
 
 
 
 void   identifier_list()
 {
   
 if(lookahead.getVal().equals(","))
 {
 
     if(mark!=Buffer.size())
      lookahead=lexical();
  

   
if(lookahead.getType().equalsIgnoreCase("identifier")||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("matrix")||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("float")||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("integer")||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("double")||lookahead.getType().equalsIgnoreCase("number"))
 {

   if(Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equalsIgnoreCase("float"))
   {
   }
   else
   {
   }
     c++;
     count_parameter++;
     //System.out.println(lookahead.getVal()+lookahead.getType());
     if(lookahead.getType().equalsIgnoreCase("number"))
     {
      // System.out.println("number"+lookahead.getVal());
     Sympol_List.get(Sympol_List.size()-1).insert(lookahead.getVal(), lookahead.getType(), lookahead.getCount());
     }
     Parameter_Names.add(lookahead.getVal());
     
  if(mark!=Buffer.size())
      lookahead=lexical();
 
  
  identifier_list();
 
 }
  else{global_error_count++;error_string += "\n"+"Error:bad passing parameter in function calling"+"   line:  "+lookahead.getCount();}
 
 }
 else{}
 
 
 
 
 }
 
 
 
 
 void func_calling()
 {

 
 if(lookahead.getVal().equals("("))
 {
     
  if(mark!=Buffer.size())
      lookahead=lexical();
   
 
 }
 
 

 
if(lookahead.getType().equalsIgnoreCase("identifier")||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("matrix")||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("float")||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("integer")||Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equals("double")||lookahead.getType().equalsIgnoreCase("number"))
 {

count_parameter++;

Parameter_Names.add(lookahead.getVal());

   if(lookahead.getType().equalsIgnoreCase("number"))
     {
      // System.out.println("number"+lookahead.getVal());
     Sympol_List.get(Sympol_List.size()-1).insert(lookahead.getVal(), lookahead.getType(), lookahead.getCount());
     }
     
   if(Sympol_List.get(Sympol_List.size()-1).getType(lookahead.getVal()).equalsIgnoreCase("float"))
   {
   }
   else
   {
   }
   
   c++;
  if(mark!=Buffer.size())
      lookahead=lexical();
 
 
  identifier_list();
 
  c=0;
 }
 else{}
 

 
 
 if(lookahead.getVal().equals(")"))
 {
     
  if(mark!=Buffer.size())
      lookahead=lexical();
 
 }
 else{System.out.println("Error:miising ) in function calling"+"   line:  "+lookahead.getCount());}

    // System.out.println("mmmmmm"+stack.getFront()+Sympol_List.get(Sympol_List.size()-1).get_number_of_parameter(stack.getFront()));
  // System.out.println(stack.getFront()+Sympol_List.get(Sympol_List.size()-1).get_number_of_parameter(stack.getFront())+"llll");
 if((count_parameter!=Sympol_List.get(Sympol_List.size()-1).get_number_of_parameter(stack.getFront())))
 {
    
 global_error_count++;error_string += "\n"+"Error:bad number of parameter"+"   line:  "+lookahead.getCount();
 

 }
 else
 {
     
 ArrayList<String>Temp=Sympol_List.get(Sympol_List.size()-1).get_class_functions_names(stack.getFront());

     //System.out.println(Temp.size());
 
 for(int i=0;i<Temp.size();i++)
 {
     
  
 // System.out.println(Temp.get(i)+"jjjjjjjjjjjjjjjjjjjjj"+Sympol_List.get(Sympol_List.size()-1).getType(Parameter_Names.get(i)));
 if(Sympol_List.get(Sympol_List.size()-1).is_declared(Parameter_Names.get(i))!=true&&!Sympol_List.get(Sympol_List.size()-1).getType(Parameter_Names.get(i)).equalsIgnoreCase("number"))
 {
   // System.out.println(lookahead.getVal()+"l");
      
      global_error_count++;error_string +="\n"+"Error:  "+Parameter_Names.get(i)+" was not declared"+"   line :  "+lookahead.getCount();
     

 }
    
 if(Sympol_List.get(Sympol_List.size()-1).getType(Parameter_Names.get(i)).equalsIgnoreCase("number")&&Temp.get(i).equalsIgnoreCase("matrix")||!Sympol_List.get(Sympol_List.size()-1).getType(Parameter_Names.get(i)).equalsIgnoreCase(Temp.get(i))&&!Sympol_List.get(Sympol_List.size()-1).getType(Parameter_Names.get(i)).equalsIgnoreCase("number"))
 {
      global_error_count++;error_string +="\n"+"Error:  "+Parameter_Names.get(i)+" inconsistent  Type"+"   line:  "+lookahead.getCount();
      
 }
  
 
 }
 
 
 Temp.clear();
 }
 

count_parameter=0;
Parameter_Names.clear();


 }
 
 
 
 
 
 public String pars() throws FileNotFoundException
 {
		//PrintStream out = new PrintStream(new FileOutputStream(outres.getAbsolutePath()));
		//System.setOut(System.out);
		
                /**Check**/
                Sympol_List.get(Sympol_List.size()-1).set_type("currentVariables", "identifier");
                Sympol_List.get(Sympol_List.size()-1).set_declared("currentVariables"); 
     
		if(Buffer.size()!=0)
		{
		   
		    if( mark!=Buffer.size());
		    lookahead=lexical();
		    
		 
		    
		    
		    program();
		    System.setOut(System.out);
		    return error_string;
	}
 
	





writeOnOutput.close();
   
return error_string;

     
    
 
 }

 
 public Temp lexical()
 {
  if(mark!=Buffer.size())
        {
           
    return Buffer.get(mark++);
        
        }
        
  
  return null;
 
 
 }
  public void lex() throws FileNotFoundException, UnsupportedEncodingException
    {
        
   
//PrintWriter out = new PrintWriter("out.txt", "UTF-8");
//out.println("token"+"\t\t"+"type"+"\t\t"+"size"+"\t\t"+"spelling"+"\t\t"+""value");

    
          //out.println("token"+"\t"+"\t"+"type"+" \t "+"\t"+"spelling"+"\t "+"\t"+"size"+"\t"+"line number");
    String string="";
    String number="";
    int flag=99;
    int count=1;
   

    while(readFrominput.hasNextLine())
    {
        
       String reader=readFrominput.nextLine();
       
       if(!reader.startsWith("//"))
      for(int i=0;i<reader.length();i++)
      {
      
          if(reader.charAt(i)>='0'&&reader.charAt(i)<='9'||reader.charAt(i)>='a'&&reader.charAt(i)<='z'||reader.charAt(i)=='@'||reader.charAt(i)=='_'||reader.charAt(i)=='.'&&!(reader.charAt(i-1)>'a')||reader.charAt(i)=='.'&&reader.charAt(i-1)=='.'||reader.charAt(i)=='.'&&reader.charAt(i+1)=='.'||reader.charAt(i)=='-'&&reader.charAt(i+1)>'0'&&reader.charAt(i+1)<'9')
         {
          
             string=string+reader.charAt(i);
           
          }
      
      
       else 
      {
      
          
          number=number+reader.charAt(i);
         if(!string.equals(""))
          {
       
        if(string.charAt(0)>='a'&&string.charAt(0)<='z'||reader.charAt(0)=='@'||string.charAt(0)=='#'||string.charAt(0)=='_'||string.charAt(0)=='.') 
       {
       
       if(string.equalsIgnoreCase("integer"))
       {
       
          Buffer.add(new Temp(string,count,"key"));
         
         writeOnOutput.println(string+"   "+"integer"+"    "+"keyword"+"      "+count);
        
         
       }
       else if(string.equalsIgnoreCase("while"))
      {
          
          Buffer.add(new Temp(string,count,"key"));  
       
         writeOnOutput.println(string+"      "+"while"+"     "+"keyword"+"      "+count);
       
      }
       
      
       else if(string.equalsIgnoreCase("lambda"))
      {
       
          Buffer.add(new Temp(string,count,"key"));  
          
         writeOnOutput.println(string+"      "+"lambda"+"     "+"keyword"+"      "+count);
       
      }
       
      
       else if(string.equalsIgnoreCase("float"))
      {
            
         Buffer.add(new Temp(string,count,"key"));  
         
          writeOnOutput.println(string+"      "+"float"+"     "+"keyword"+"      "+count);
         
      }
       
       
       else if(string.equalsIgnoreCase("@merge"))
      {
             
            Buffer.add(new Temp(string,count,"key"));  
              
              writeOnOutput.println(string+"     "+"@merge"+"    "+"keyword"+"      "+count);
             
      }
       
       
       else if(string.equalsIgnoreCase("double"))
      {
          
          Buffer.add(new Temp(string,count,"key"));  
           
            writeOnOutput.println(string+"    "+"double"+"     "+"keyword"+"      "+count);
       }
     
       
       else if(string.equalsIgnoreCase("space"))
      {
          Buffer.add(new Temp(string,count,"key"));  
          
            writeOnOutput.println(string+"      "+"space"+"     "+"keyword"+"      "+count);
       }
            
       
       else if(string.equalsIgnoreCase("vector"))
      {
          
           Buffer.add(new Temp(string,count,"key"));  
            
            writeOnOutput.println(string+"    "+"vector"+"     "+"keyword"+"      "+count);
       }
     
       
       else if(string.equalsIgnoreCase("if"))
      {
          
           Buffer.add(new Temp(string,count,"key"));  
          
           writeOnOutput.println(string+"          "+"if"+"       "+"keyword"+"      "+count);
       }
       
       
       else if(string.equalsIgnoreCase("else"))
      {
            
        Buffer.add(new Temp(string,count,"key"));  
          
           writeOnOutput.println(string+"       "+"else"+"      "+"keyword"+"      "+count);
       }
              
              
                       else if(string.equalsIgnoreCase("jpl"))
      {
            
        Buffer.add(new Temp(string,count,"key"));  
           
           writeOnOutput.println(string+"         "+"jpl"+"      "+"keyword"+"      "+count);
       }
       

             else if(string.equalsIgnoreCase("long"))
      {
            
         Buffer.add(new Temp(string,count,"key"));  
         
          writeOnOutput.println(string+"       "+"long"+"      "+"keyword"+"      "+count);
       }
             
       
             else if(string.equalsIgnoreCase("constant"))
      {
            
        Buffer.add(new Temp(string,count,"key"));  
          
          writeOnOutput.println(string+"   "+"constant"+"  "+"keyword"+"      "+count);
       }
                
                else if(string.equalsIgnoreCase("array"))
                    
      {
            
         Buffer.add(new Temp(string,count,"key"));  
          
          writeOnOutput.println(string+"      "+"array"+"     "+"keyword"+"      "+count);
       
      }
                
      
                else if(string.equalsIgnoreCase("beginif"))
      {
            
         Buffer.add(new Temp(string,count,"key"));  
          
          writeOnOutput.println(string+"    "+"beginif"+"   "+"keyword"+"      "+count);
       }
                       
                
                else if(string.equalsIgnoreCase("end"))
      {
            
          Buffer.add(new Temp(string,count,"key"));  
          
          writeOnOutput.println(string+"        "+"end"+"       "+"keyword"+"      "+count);
       } 
                   
                
                else if(string.equalsIgnoreCase("begin"))
      {
            
         Buffer.add(new Temp(string,count,"key"));  
        
          writeOnOutput.println(string+"      "+"begin"+"     "+"keyword"+"      "+count);
       } 
                       
                
                else if(string.equalsIgnoreCase("endif"))
      {
            
        Buffer.add(new Temp(string,count,"key"));  
        
          writeOnOutput.println(string+"      "+"endif"+"     "+"keyword"+"      "+count);
       
      } 
                 
      
                else if(string.equalsIgnoreCase("beginwhile"))
      {
            
        Buffer.add(new Temp(string,count,"key"));  
          writeOnOutput.println(string+" "+"beginwhile"+""+"keyword"+"      "+count);
          
       }    
                  
              
                else if(string.equalsIgnoreCase("endwhile"))
      {
            
         Buffer.add(new Temp(string,count,"key"));  
           writeOnOutput.println(string+"   "+"endwhile"+"  "+"keyword"+"      "+count);
       }  
              
               
                else if(string.equalsIgnoreCase("beginfor"))
      {
            
      Buffer.add(new Temp(string,count,"key"));  
           writeOnOutput.println(string+"   "+"beginfor"+"  "+"keyword"+"      "+count);
          
       }  
               
                
                else if(string.equalsIgnoreCase("endfor"))
      {
            
    Buffer.add(new Temp(string,count,"key"));  
           writeOnOutput.println(string+"    "+"endfor"+"     "+"keyword"+"      "+count);
          
       }
             
                
                
                else if(string.equalsIgnoreCase("readfile"))
      {
            
        Buffer.add(new Temp(string,count,"key"));  
          writeOnOutput.println(string+"    "+"readfile"+"     "+"keyword"+"      "+count);
       } 
        
               
     
                    
                else if(string.equalsIgnoreCase("openfile"))
      {
          
       Buffer.add(new Temp(string,count,"key"));  
          writeOnOutput.println(string+"  "+"openfile"+"   "+"keyword"+"      "+count);
       
      }    
                
      
                else if(string.equalsIgnoreCase("writefile"))
      {
            
       Buffer.add(new Temp(string,count,"key"));  
          writeOnOutput.println(string+" "+"writefile"+"  "+"keyword"+"      "+count);
       
      }  
                 
      
                else if(string.equalsIgnoreCase("begincons"))
      {
            
        Buffer.add(new Temp(string,count,"key"));  
          writeOnOutput.println(string+" "+"begincons"+"  "+"keyword"+"      "+count);
       
      }
                             
             
       else if(string.equalsIgnoreCase("endcons"))
      {
            
       Buffer.add(new Temp(string,count,"key"));  
          writeOnOutput.println(string+" "+"endcons"+"  "+"keyword"+"      "+count);
       }
                 
                 
      
       else if(string.equalsIgnoreCase("read"))
      {
            
       Buffer.add(new Temp(string,count,"key"));  
          writeOnOutput.println(string+"      "+"read"+"       "+"keyword"+"      "+count);
       
      }  
                    
                    
       else if(string.equalsIgnoreCase("beginclass"))
      {
            
         Buffer.add(new Temp(string,count,"key"));  
          writeOnOutput.println(string+" "+"beginclass"+"  "+"keyword"+"      "+count);
       }
                             
             
       else if(string.equalsIgnoreCase("endclass"))
      {
            
        Buffer.add(new Temp(string,count,"key"));  
          writeOnOutput.println(string+" "+"endclass"+"  "+"keyword"+"      "+count);
      
      }
                    
                    
               else if(string.equalsIgnoreCase("print"))
      {
            
         Buffer.add(new Temp(string,count,"key"));  
          writeOnOutput.println(string+"     "+"print"+"      "+"keyword"+"      "+count);
       }      
             
               
             else if(string.equalsIgnoreCase("closefiles"))
      {
            
         Buffer.add(new Temp(string,count,"key"));  
           writeOnOutput.println(string+" "+"closefiles"+""+"keyword"+"      "+count);
      
      }   
      
             
                   else if(string.equalsIgnoreCase("character"))
      {
           
         Buffer.add(new Temp(string,count,"key"));  
            writeOnOutput.println(string+" "+"character"+"   "+"keyword"+"      "+count);
       
      }
             
               else if(string.equalsIgnoreCase("matrix"))
      {
            
         Buffer.add(new Temp(string,count,"key"));  
           writeOnOutput.println(string+"    "+"matrix"+"     "+"keyword"+"      "+count);
       }
      
    
     
                    else if(string.equalsIgnoreCase("break"))
      {
      Buffer.add(new Temp(string,count,"key"));  
        writeOnOutput.println(string+"     "+"break"+"      "+"keyword"+"      "+count);
       }
                    
                    
           else if(string.equalsIgnoreCase("in"))
      {
       Buffer.add(new Temp(string,count,"key"));  
        writeOnOutput.println(string+"         "+"in"+"        "+"keyword"+"      "+count);
       }
           
           
                 else if(string.equalsIgnoreCase("do"))
      {
        Buffer.add(new Temp(string,count,"key"));  
        writeOnOutput.println(string+"         "+"do"+"        "+"keyword"+"      "+count);
      
      }
           
           
          else if(string.equalsIgnoreCase("out"))
      {
      Buffer.add(new Temp(string,count,"key"));  
        writeOnOutput.println(string+"        "+"out"+"       "+"keyword"+"      "+count);
       }
          
                       else if(string.equalsIgnoreCase("ino"))
      {
      Buffer.add(new Temp(string,count,"key"));  
        writeOnOutput.println(string+"        "+"ino"+"       "+"keyword"+"      "+count);
       }
                                 
                                 
             else if(string.equalsIgnoreCase("continue"))
      {
       Buffer.add(new Temp(string,count,"key"));  
          writeOnOutput.println(string+"  "+"continue"+"   "+"keyword"+"      "+count);  
       }
     
    
                else if(string.equalsIgnoreCase("class"))
      {
           
       Buffer.add(new Temp(string,count,"key"));  
           writeOnOutput.println(string+"      "+"class"+"     "+"keyword"+"      "+count);
          
        
       }
                
                
           else if(string.equalsIgnoreCase("elseif"))
      {
           
        Buffer.add(new Temp(string,count,"key"));  
           writeOnOutput.println(string+"       "+"elseif"+"     "+"keyword"+"      "+count);
          
        
       }
                
                
                 else if(string.equalsIgnoreCase("for"))
      {
            
       Buffer.add(new Temp(string,count,"key"));  
            writeOnOutput.println(string+"        "+"for"+"       "+"keyword"+"      "+count);
       }
                 
      
                 else if(string.equalsIgnoreCase("routine"))
      {
        
        Buffer.add(new Temp(string,count,"key"));  
         writeOnOutput.println(string+" "+"routine"+" "+"keyword"+"      "+count);  
       
      }
      
                 else if(string.equalsIgnoreCase("constructor"))
      {
      
       Buffer.add(new Temp(string,count,"key"));  
         writeOnOutput.println(string+" "+"constructor"+" "+"keyword"+"      "+count);  
       
      }
     
             
     
       else{
           Buffer.add(new Temp(string,count,"identifier"));  
             
     
      
             writeOnOutput.print(string);
                  writeOnOutput.println("           "+string+"      "+"identifier"+"     "+count);
                  string="";
       }
           
       }
      
       else{
         
           for(int k=0;k<string.length();k++)
           {
           
             if(string.charAt(k)>='0'&&string.charAt(k)<='9'||string.charAt(k)=='.'||string.charAt(k)=='-')
           {
           flag=1;
           }
           else{flag=0; break;}
           }
           
           if(flag==0)
           {
             
               if(string.charAt(0)>='0'&&string.charAt(0)<='9')
             {
           
                Buffer.add(new Temp("Error",count,"key"));  
                writeOnOutput.println(string+"         "+"Error"+"     "+"keyword"+"      "+count);
             
             }
             else 
             {
                 //out.println("id"); 
                if(string.equalsIgnoreCase("@merge"))
                {
                Buffer.add(new Temp(string,count,"key"));  
                  writeOnOutput.println(string+"      "+string+"   "+"keyword"+"    "+count);
             
                }
                else{
               Buffer.add(new Temp(string,count,"identifier"));  
    
               
                writeOnOutput.print(string);
                  writeOnOutput.println("           "+string+"      "+"identifier"+"     "+count);
                  string="";
                }
             }
           }
           else if(flag==1){   //out.println(s+"\t"+"\t"+"number"+"\t"+"\t"+s+"\t"+"\t"+"\t"+"--"+"\t"+count); 
                
               Buffer.add(new Temp(string,count,"number"));  
                writeOnOutput.print(string);
                  writeOnOutput.println("           "+string+"          "+"number"+"     "+count);
                  
           
           }
          
           }
     }
     if(number.equals("\""))
     {
    	 	String buff ="\"";
           	 while(reader.charAt(i+1)!='"')
        	 {
        		 buff = buff + reader.charAt(i+1);
        		 i++;
        		 
        	 }
        	 if(reader.charAt(i+1)=='"')
        	 {
        		 buff = buff + reader.charAt(i+1);
        		 i++;
        		 Buffer.add(new Temp(buff, count, "string"));
        		 writeOnOutput.println(buff+"        "+"String"+"  "+"operator"+"     "+count);
        	 }
        	 
        	 
     }
     if(number.equals("="))
       {
           if(reader.charAt(i+1)=='=')
           {
             
           i++;
        
             Buffer.add(new Temp("==",count,"op"));
             
             writeOnOutput.println("=="+"        "+"is equal?"+"  "+"operator"+"     "+count);
           }
           else
           {
                Buffer.add(new Temp("=",count,"op"));
               
              writeOnOutput.println("="+"          "+"equal"+"      "+"operator"+"    "+count);
           }
           }
      
     
        else if(number.equals("+"))
       {
          if(reader.length()!=1&&!reader.endsWith("+"))
          {
          
           if(reader.charAt(i+1)=='=')
           {
               
           i++;
       
             Buffer.add(new Temp("+=",count,"op"));
          
             writeOnOutput.println("+="+"        "+"plus equal"+"  "+"operator"+"    "+count);
           }
           else
           {
           
             Buffer.add(new Temp("+",count,"op"));
            
             writeOnOutput.println("+"+"          "+"plus"+"       "+"operator"+"    "+count);
           }
          }
           else
           {
           
             Buffer.add(new Temp("+",count,"op"));
           
             writeOnOutput.println("+"+"          "+"plus"+"       "+"operator"+"    "+count);
           }
           }
       
       
       else if(number.equals(":"))
       {
          
           if(reader.length()>2)
           {
               
           if(reader.charAt(i+1)=='=')
           {
               
           i++;
       
           Buffer.add(new Temp(":=",count,"op"));
            
             writeOnOutput.println(":="+"  "+"assignment equal"+"  "+"operator"+"    "+count);
           }
           }
           else
           {
           
              Buffer.add(new Temp(":",count,"op"));
          
             writeOnOutput.println(":"+"       "+"punctuation"+"   "+"operator"+"    "+count);
           }
           }
       
       
       else if(number.equals("*"))
       {
          
           if(reader.length()!=1&&!reader.endsWith("*"))
           {
           
               if(reader.charAt(i+1)=='=')
           {
       
           i++;
       
            Buffer.add(new Temp("*=",count,"op"));
          
             writeOnOutput.println("*="+"     "+"multiply equal"+" "+"operator"+"    "+count);
           }
           else
           {
            Buffer.add(new Temp("*",count,"op"));
         
           writeOnOutput.println("*"+"          "+"multiply"+"   "+"operator"+"    "+count);
           }
           }
            else
           {
           Buffer.add(new Temp("*",count,"op"));
         
           writeOnOutput.println("*"+"          "+"multiply"+"   "+"operator"+"    "+count);
           }
           }
       
       
       
       
        else if(number.equals(">"))
       {
          
           if(reader.length()!=1&&!reader.endsWith(">"))
           {
           
               if(reader.charAt(i+1)=='=')
           {
       
           i++;
       
            Buffer.add(new Temp(">=",count,"op"));
          
             writeOnOutput.println(">="+"     "+"greater than or equal"+" "+"operator"+"    "+count);
           }
           else
           {
            Buffer.add(new Temp(">",count,"op"));
         
           writeOnOutput.println(">"+"          "+"greater"+"   "+"operator"+"    "+count);
           }
           }
            else
           {
           Buffer.add(new Temp(">",count,"op"));
         
           writeOnOutput.println(">"+"          "+"greater than or equal"+"   "+"operator"+"    "+count);
           }
           }
        
        
        
        
                else if(number.equals("<"))
       {
          
           if(reader.length()!=1&&!reader.endsWith("<"))
           {
           
               if(reader.charAt(i+1)=='=')
           {
       
           i++;
       
            Buffer.add(new Temp("<=",count,"op"));
          
             writeOnOutput.println("<="+"     "+"less than or equal"+" "+"operator"+"    "+count);
           }
           else
           {
            Buffer.add(new Temp("<",count,"op"));
         
           writeOnOutput.println("<"+"          "+"less than"+"   "+"operator"+"    "+count);
           }
           }
            else
           {
           Buffer.add(new Temp("<",count,"op"));
         
           writeOnOutput.println("<"+"          "+"less than or equal"+"   "+"operator"+"    "+count);
           }
           }
        
       
       
       
       else if(number.equals("/"))
       {
           
        
           if(reader.length()!=1&&!reader.endsWith("/"))  
           {
        
           if(reader.charAt(i+1)=='=')
           {
               i++;
           
             Buffer.add(new Temp("/=",count,"op"));
        
          writeOnOutput.println("/="+"      "+"divide equal"+"  "+"operator"+"    "+count);
           
           
           }
           else
           {
        
                Buffer.add(new Temp("/",count,"op"));
           
                writeOnOutput.println("/"+"          "+"divide"+"     "+"operator"+"    "+count);
           }
           }
           else{
       
               Buffer.add(new Temp("/",count,"op"));
           
                writeOnOutput.println("/"+"          "+"divide"+"     "+"operator"+"    "+count);
           }
           }
      
       else if(number.equals("-"))
       {

           if(reader.length()!=1&&!reader.endsWith("-"))
           {
           
               if(reader.charAt(i+1)=='='||reader.charAt(i+1)=='$')
           {
               i++;
       
               if(reader.charAt(i)=='=')
        {
       
         Buffer.add(new Temp("-=",count,"op"));
      
        writeOnOutput.println("-="+"       "+"minus equal"+" "+"operator"+"     "+count);
        }
        
        else
        {
         Buffer.add(new Temp("-$",count,"op"));
        
        writeOnOutput.println("-$"+"       "+" ref"+"        "+"operator"+"     "+count);
        }
           }
           else
        {
         Buffer.add(new Temp("-",count,"op"));
        
        writeOnOutput.println("-"+"       "+" ref"+"        "+"operator"+"     "+count);
        }
           }
           else
           {
          
                Buffer.add(new Temp("-",count,"op"));
             
                writeOnOutput.println("-"+"          "+"minus"+"      "+"operator"+"    "+count);
               
           }
           }
       
          else if(number.equals("."))
       {
        
          Buffer.add(new Temp(".",count,"op"));
         
           writeOnOutput.println("."+"         "+"dot"+"        "+"operator"+"     "+count);
       }
       
         else if(number.equals(";"))
       {
        
          Buffer.add(new Temp(";",count,"op"));
         
           writeOnOutput.println(";"+"         "+"semicolon"+"   "+"operator"+"    "+count);
       }
         
            else if(number.equals("~"))
       {
        
         Buffer.add(new Temp("~",count,"op"));
          
           writeOnOutput.println("~"+"         "+"tilde"+"      "+"operator"+"     "+count);
       }
            
               else if(number.equals("#"))
       {
        
          Buffer.add(new Temp("#",count,"op"));
         
           writeOnOutput.println("#"+"         "+"hash"+"       "+"operator"+"     "+count);
       }
               
               
                    else if(number.equals("%"))
       {
        
         Buffer.add(new Temp("%",count,"op"));
         
           writeOnOutput.println("%"+"         "+"percent"+"    "+"operator"+"     "+count);
       }
              
                    
               else if(number.equals("$"))
       {
        
          Buffer.add(new Temp("$",count,"op"));
          
           writeOnOutput.println("$"+"         "+"rref"+"       "+"operator"+"     "+count);
       }
         
           else if(number.equals("^"))
       {
        
           Buffer.add(new Temp("^",count,"op"));
        
           writeOnOutput.println("^"+"           "+"hat"+"       "+"operator"+"    "+count);
       }
         
           else if(number.equals(","))
       {
           
        Buffer.add(new Temp(",",count,"op"));
    
        writeOnOutput.println(","+"         "+"comma"+"       "+"operator"+"    "+count);
        
       }
       
           else if(number.equals("'"))
       {
           
        Buffer.add(new Temp("'",count,"op"));
       
        writeOnOutput.println("'"+"         "+"sing_quot"+"  "+"operator"+"     "+count);
        
       }
           
          
           else if(number.equals("("))
       {
           
        Buffer.add(new Temp("(",count,"op"));
      
         writeOnOutput.println("("+"   "+"left parenthesis"+"  "+"operator"+"    "+count);
        
       }
          
      
          
           else if(number.equals(")"))
       {
       
             Buffer.add(new Temp(")",count,"op"));
            
             writeOnOutput.println(")"+"   "+"right parenthesis"+" "+"operator"+"    "+count);
       }
           
           else if(number.equals("{"))
       {
       
           Buffer.add(new Temp("{",count,"op"));
        
         writeOnOutput.println("{"+"     "+"left bracket"+"    "+"operator"+"   "+count);
       
       }
           
               else if(number.equals("["))
       {
       
           Buffer.add(new Temp("[",count,"op"));
        
          writeOnOutput.println("["+" "+"left square bracket"+" "+"operator"+"    "+count);
       
       }
               
                   else if(number.equals("]"))
       {
       
           Buffer.add(new Temp("]",count,"op"));
        
           writeOnOutput.println("]"+" "+"right square bracket"+""+"operator"+"    "+count);
       
       }
                   
           else if(number.equals("}"))
       {
       
           Buffer.add(new Temp("}",count,"op"));
        
         writeOnOutput.println("}"+"     "+"right bracket"+"   "+"operator"+"    "+count);
       
       }
           
         else if(number.equals("<"))
       {
       
           Buffer.add(new Temp("<",count,"op"));
          
          writeOnOutput.println("<"+"        "+"less than"+"    "+"operator"+"    "+count);
       
       }
         
         else if(number.equals(">"))
       {
          Buffer.add(new Temp(">",count,"op"));
       
         writeOnOutput.println("<"+"       "+"greater than"+"  "+"operator"+"    "+count);
       }
         
         
      
       
      else if(number.equals("&"))
       {
           if(reader.charAt(i+1)=='&')
           {
        
       i++;
       
       Buffer.add(new Temp("&&",count,"op"));
      
       writeOnOutput.println("&&"+"       "+"and and"+"      "+"operator"+"    "+count);
           }
           else
           {
          
             Buffer.add(new Temp("&",count,"op"));
            
            writeOnOutput.println("&"+"          "+"and"+"        "+"operator"+"    "+count);
           }
           }
      
       else if(number.equals("!"))
       {
           if(reader.length()!=1&&!reader.endsWith("!"))
           {
           if(reader.charAt(i+1)=='=')
           {
        
       i++;
       
       Buffer.add(new Temp("!=",count,"op"));
      
       writeOnOutput.println("!="+"       "+"anot equal"+"  "+"operator"+"     "+count);
           }
           else
           {
          
            Buffer.add(new Temp("!",count,"op"));
         
            writeOnOutput.println("!"+"          "+"not"+"       "+"operator"+"     "+count);
           }
           }
           else
           {
          
            Buffer.add(new Temp("!",count,"op"));
             
            writeOnOutput.println("!"+"          "+"not"+"       "+"operator"+"     "+count);
           }
           }
      
      
      
      else if(number.equals("|"))
       {
           if(reader.charAt(i+1)=='|')
           {
       
       i++;
        
       Buffer.add(new Temp("||",count,"op"));
       
        writeOnOutput.println("||"+"         "+"or or"+"      "+"operator"+"    "+count);
           }
           else
           {
     
               Buffer.add(new Temp("|",count,"op"));
            
           writeOnOutput.println("|"+"          "+"or"+"         "+"operator"+"    "+count);
           }
           }
     
 
     string="";
     number="";
         
        
          
      }
      }
        if(!string.equals(""))
     {
         
       if(string.charAt(0)>='a'&&string.charAt(0)<='z'||reader.charAt(0)=='@'||string.charAt(0)=='#'||string.charAt(0)=='_') 
       {
           
       if(string.equalsIgnoreCase("integer"))
       {
         Buffer.add(new Temp(string,count,"key"));
         
         writeOnOutput.println(string+"   "+"integer"+"    "+"keyword"+"      "+count);
         
       }
       
        else if(string.equalsIgnoreCase("lambda"))
      {
         Buffer.add(new Temp(string,count,"key"));;
         writeOnOutput.println(string+"      "+"lambda"+"     "+"keyword"+"      "+count);
       }
        
       
       else if(string.equalsIgnoreCase("while"))
      {
         Buffer.add(new Temp(string,count,"key"));
         
         writeOnOutput.println(string+"      "+"while"+"     "+"keyword"+"      "+count);
       }
       
        else if(string.equalsIgnoreCase("float"))
      {
            
        Buffer.add(new Temp(string,count,"key"));
        
          writeOnOutput.println(string+"      "+"float"+"     "+"keyword"+"      "+count);
         
      }
        
        
          else if(string.equalsIgnoreCase("@merge"))
      {
             
             
             Buffer.add(new Temp(string,count,"key"));
             
              writeOnOutput.println(string+"     "+"@merge"+"    "+"keyword"+"      "+count);
             
      }
          
         else if(string.equalsIgnoreCase("double"))
      {
          
           Buffer.add(new Temp(string,count,"key"));
           
            writeOnOutput.println(string+"    "+"double"+"     "+"keyword"+"      "+count);
       }
         
     
            else if(string.equalsIgnoreCase("space"))
      {
          
        Buffer.add(new Temp(string,count,"key"));
        
            writeOnOutput.println(string+"      "+"space"+"     "+"keyword"+"      "+count);
       }
            
            
                else if(string.equalsIgnoreCase("beginclass"))
      {
            
        Buffer.add(new Temp(string,count,"key"));
        
          writeOnOutput.println(string+" "+"beginclass"+"  "+"keyword"+"      "+count);
       }
                             
             
       else if(string.equalsIgnoreCase("endclass"))
      {
            
          Buffer.add(new Temp(string,count,"key"));
          
          writeOnOutput.println(string+" "+"endclass"+"  "+"keyword"+"      "+count);
       }
            
            
            
                               
                   else if(string.equalsIgnoreCase("end"))
      {
            
         Buffer.add(new Temp(string,count,"key"));
         
          writeOnOutput.println(string+"      "+"end"+"       "+"keyword"+"      "+count);
       } 
                   
                             else if(string.equalsIgnoreCase("begin"))
      {
            
          Buffer.add(new Temp(string,count,"key"));
          
          writeOnOutput.println(string+"      "+"begin"+"     "+"keyword"+"      "+count);
       } 
            
               else if(string.equalsIgnoreCase("vector"))
      {
          
          Buffer.add(new Temp(string,count,"key"));
          
            writeOnOutput.println(string+"    "+"vector"+"     "+"keyword"+"      "+count);
       }
     
          else if(string.equalsIgnoreCase("if"))
      {
          
          Buffer.add(new Temp(string,count,"key"));
          
           writeOnOutput.println(string+"          "+"if"+"       "+"keyword"+"      "+count);
       }
              else if(string.equalsIgnoreCase("else"))
      {
            
           Buffer.add(new Temp(string,count,"key"));
           
          
           writeOnOutput.println(string+"       "+"else"+"      "+"keyword"+"      "+count);
       }
              
              
                      else if(string.equalsIgnoreCase("jpl"))
      {
        Buffer.add(new Temp(string,count,"key"));
          
           writeOnOutput.println(string+"         "+"jpl"+"      "+"keyword"+"      "+count);
       }
                               
                               
                               
               else if(string.equalsIgnoreCase("begincons"))
      {
            
          
          Buffer.add(new Temp(string,count,"key"));
          writeOnOutput.println(string+" "+"begincons"+"  "+"keyword"+"      "+count);
       }
                             
             
       else if(string.equalsIgnoreCase("endcons"))
      {
            
           Buffer.add(new Temp(string,count,"key"));
           
          writeOnOutput.println(string+" "+"endcons"+"  "+"keyword"+"      "+count);
       }
                               
       

             else if(string.equalsIgnoreCase("long"))
      {
            
           Buffer.add(new Temp(string,count,"key"));
           
          writeOnOutput.println(string+"       "+"long"+"      "+"keyword"+"      "+count);
       }
             
                else if(string.equalsIgnoreCase("constant"))
      {
            
          Buffer.add(new Temp(string,count,"key"));
          
          writeOnOutput.println(string+"   "+"constant"+"  "+"keyword"+"      "+count);
       }
                
                else if(string.equalsIgnoreCase("array"))
                    
      {
            
        Buffer.add(new Temp(string,count,"key"));
        
          writeOnOutput.println(string+"      "+"array"+"     "+"keyword"+"      "+count);
       }
                
                
                       else if(string.equalsIgnoreCase("beginif"))
      {
            
         Buffer.add(new Temp(string,count,"key"));
         
          writeOnOutput.println(string+"    "+"beginif"+"   "+"keyword"+"      "+count);
       }
                       
                 else if(string.equalsIgnoreCase("endif"))
      {
            
           Buffer.add(new Temp(string,count,"key"));
           
          writeOnOutput.println(string+"      "+"endif"+"     "+"keyword"+"      "+count);
       } 
             
                 
                  else if(string.equalsIgnoreCase("beginwhile"))
      {
            
      Buffer.add(new Temp(string,count,"key"));
      
          writeOnOutput.println(string+" "+"beginwhile"+""+"keyword"+"      "+count);
          
       }    
                  
              else if(string.equalsIgnoreCase("endwhile"))
      {
            
           Buffer.add(new Temp(string,count,"key"));
           
           writeOnOutput.println(string+"   "+"endwhile"+"  "+"keyword"+"      "+count);
       }  
             
              
               else if(string.equalsIgnoreCase("beginfor"))
      {
            
            Buffer.add(new Temp(string,count,"key"));
            
           writeOnOutput.println(string+"   "+"beginfor"+"  "+"keyword"+"      "+count);
          
       }  
               
                else if(string.equalsIgnoreCase("endfor"))
      {
            
          Buffer.add(new Temp(string,count,"key"));
          
           writeOnOutput.println(string+"    "+"endfor"+"     "+"keyword"+"      "+count);
          
       }
              
      
      
                    
                else if(string.equalsIgnoreCase("openfile"))
      {
            
          Buffer.add(new Temp(string,count,"key"));
          
          writeOnOutput.println(string+"  "+"openfile"+"   "+"keyword"+"      "+count);
       }  
                
                           else if(string.equalsIgnoreCase("readfile"))
      {
            
         Buffer.add(new Temp(string,count,"key"));
         
          writeOnOutput.println(string+"  "+"readfile"+"   "+"keyword"+"      "+count);
       } 
                
                
                 else if(string.equalsIgnoreCase("writefile"))
      {
            
          Buffer.add(new Temp(string,count,"key"));
          
          writeOnOutput.println(string+" "+"writefile"+"  "+"keyword"+"      "+count);
       }  
                 
                    else if(string.equalsIgnoreCase("read"))
      {
            
         Buffer.add(new Temp(string,count,"key"));
         
          writeOnOutput.println(string+"      "+"read"+"       "+"keyword"+"      "+count);
       }  
                    
       
               else if(string.equalsIgnoreCase("print"))
      {
            
        Buffer.add(new Temp(string,count,"key"));
        
          writeOnOutput.println(string+"     "+"print"+"      "+"keyword"+"      "+count);
       }      
             
               
             else if(string.equalsIgnoreCase("closefiles"))
      {
            
         Buffer.add(new Temp(string,count,"key"));
         
           writeOnOutput.println(string+" "+"closefiles"+""+"keyword"+"      "+count);
       }    
             
               else if(string.equalsIgnoreCase("matrix"))
      {
           
          Buffer.add(new Temp(string,count,"key"));
           
           writeOnOutput.println(string+"    "+"matrix"+"     "+"keyword"+"      "+count);
       }
      
    
     
                    else if(string.equalsIgnoreCase("break"))
      {
        
          Buffer.add(new Temp(string,count,"key"));
          
        writeOnOutput.println(string+"     "+"break"+"      "+"keyword"+"      "+count);
       }
                    
                   
                        else if(string.equalsIgnoreCase("do"))
      {
        
       Buffer.add(new Temp(string,count,"key"));
       
        writeOnOutput.println(string+"         "+"do"+"        "+"keyword"+"      "+count);
       }
                    
                    
           else if(string.equalsIgnoreCase("in"))
      {
        
        Buffer.add(new Temp(string,count,"key"));
        
        writeOnOutput.println(string+"         "+"in"+"        "+"keyword"+"      "+count);
       }
           
          else if(string.equalsIgnoreCase("out"))
      {
        
         Buffer.add(new Temp(string,count,"key"));
         
        writeOnOutput.println(string+"        "+"out"+"       "+"keyword"+"      "+count);
       }
          
                       else if(string.equalsIgnoreCase("ino"))
      {
        
         Buffer.add(new Temp(string,count,"key"));
         
        writeOnOutput.println(string+"        "+"ino"+"       "+"keyword"+"      "+count);
       }
                                 
                                 
             else if(string.equalsIgnoreCase("continue"))
      {
         
         Buffer.add(new Temp(string,count,"key"));
         
          writeOnOutput.println(string+"  "+"continue"+"   "+"keyword"+"      "+count);  
       }
     
    
                else if(string.equalsIgnoreCase("class"))
      {
           
       Buffer.add(new Temp(string,count,"key"));
       
           writeOnOutput.println(string+"      "+"class"+"     "+"keyword"+"      "+count);
          
        
       }
                
                
                 else if(string.equalsIgnoreCase("elseif"))
      {
           
          Buffer.add(new Temp(string,count,"key"));
          
           writeOnOutput.println(string+"       "+"elseif"+"      "+"keyword"+"      "+count);
          
        
       }
                
                
                 else if(string.equalsIgnoreCase("for"))
      {
            
           Buffer.add(new Temp(string,count,"key"));
           
            writeOnOutput.println(string+"        "+"for"+"       "+"keyword"+"      "+count);
       }
                 
         
             else if(string.equalsIgnoreCase("routine"))
      {
        
          Buffer.add(new Temp(string,count,"key"));
          
         writeOnOutput.println(string+" "+"routine"+" "+"keyword"+"      "+count);  
       }
         
           
         else if(string.equalsIgnoreCase("constructor"))
      {
        
          Buffer.add(new Temp(string,count,"key"));
          
         writeOnOutput.println(string+" "+"constructor"+" "+"keyword"+"      "+count);  
       }
     
      
             else if(string.equalsIgnoreCase("character"))
      {
           
            Buffer.add(new Temp(string,count,"key"));
            
            writeOnOutput.println(string+" "+"character"+"   "+"keyword"+"      "+count);
       }
             
     
       else{
               Buffer.add(new Temp(string,count,"identifier"));
              
            
             
                writeOnOutput.print(string);
                  writeOnOutput.println("           "+string+"      "+"identifier"+"     "+count);
                  string="";
       }
           
       }
      
       else{
         
           for(int k=0;k<string.length();k++)
           {
           
             if(string.charAt(k)>='0'&&string.charAt(k)<='9'||string.charAt(k)=='.')
           {
          
               flag=1;
           }
           else{flag=0; break;}
           }
           
           if(flag==0)
           {
             
               if(string.charAt(0)>='0'&&string.charAt(0)<='9')
             {
                
                 Buffer.add(new Temp("Error",count,"key"));
              
                writeOnOutput.println(string+"         "+"Error"+"     "+"keyword"+"      "+count);
             }
             
               else 
             {
                 //out.println("id"); 
                if(string.equalsIgnoreCase("@merge"))
                {
                
                     Buffer.add(new Temp(string,count,"key"));
            
                  writeOnOutput.println(string+"      "+string+"   "+"keyword"+"    "+count);
                }
                else{
             
                  Buffer.add(new Temp(string,count,"identifier"));
            
            
             
                writeOnOutput.print(string);
                  writeOnOutput.println("           "+string+"      "+"identifier"+"     "+count);
                  string="";
           
                }
             }
           }
    
           else if(flag==1){   //out.println(s+"\t"+"\t"+"number"+"\t"+"\t"+s+"\t"+"\t"+"\t"+"--"+"\t"+count); 
                  Buffer.add(new Temp(string,count,"number"));
                  
                writeOnOutput.print(string);
                  writeOnOutput.println("           "+string+"          "+"number"+"     "+count);
                  
           
           }
          
           }
     }
    
    string="";
    number="";
       count++;
    
    }
   
    }
   
}
class human {
  public human()
    {
        System.out.println("hello, world!");
    }
}

public class PEXFRP {
        
    private int globalErrorCount = 0;
    private String errorString = "";
    
    private void setErrorString(String tempError)
    {
        errorString = tempError;
    }
    public String getErrorString()
    {
        return errorString;
    }
    private void setGlobalErrorCount(int tempCount)
    {
        globalErrorCount = tempCount;
    }
    public int getGlobalErrorCount()
    {
        return globalErrorCount;
    }
    public String parseFile(String in, String out)
    {
        String errorString="Error Occured.. ";
        int errorCount;
            try {
                PEXParser mx = new PEXParser(in, out);
                if (mx.getErrorCount()==0)
                {
                   errorString = mx.pars(); 
                }
                else{
                    
                }
                errorString = mx.getErrorString();
                errorCount = mx.getErrorCount();
                setGlobalErrorCount(errorCount);
                setErrorString(errorString);
                errorString += "\nFinished with "+errorCount+" error/s.";
                return errorString;
            } catch (FileNotFoundException ex) {
                Logger.getLogger(PEXFRP.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(PEXFRP.class.getName()).log(Level.SEVERE, null, ex);
            }
    return errorString;
    }
    public static void main(String[] args)
    {
        PEXFRP mx = new PEXFRP();
        System.out.println(mx.parseFile("/home/minus/jin", "/home/minus/jout"));   
    }
  
}
