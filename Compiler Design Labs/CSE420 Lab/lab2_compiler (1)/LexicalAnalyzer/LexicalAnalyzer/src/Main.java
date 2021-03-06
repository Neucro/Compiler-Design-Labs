
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class Main {

 public static void main(String[] args) {

  File file = new File("input.txt");
  
  try{

   Scanner input = new Scanner(file);
   
   ArrayList keyword = new ArrayList();
   ArrayList mathOperater = new ArrayList();
   ArrayList logicalOperater = new ArrayList();
   ArrayList other = new ArrayList();
   
   keyword.add("int");
   keyword.add("float");
   keyword.add("if");
   keyword.add("else");
   
   mathOperater.add("+");
   mathOperater.add("-");
   mathOperater.add("=");

   logicalOperater.add(">");

   other.add("(");
   other.add(")");
   other.add("{");
   other.add("}");
   other.add(",");
   other.add(";");
   
   Set<String> keywords = new HashSet<String>();
   Set<String> mathOperators = new HashSet<String>();
   Set<String> logicalOperators = new HashSet<String>();
   Set<String> identifiers = new HashSet<String>();
   Set<String> numericalValues = new HashSet<String>();
   Set<String> others = new HashSet<String>();

   while(input.hasNext()){

    String str = input.next();
    
    if(str.indexOf(';')!=-1){
     others.add(";");
     string = string.replace(";","");
    }

    boolean intCheck =  checkInt(str);
    boolean floatCheck =  checkFloat(str);

    if(intCheck == true || floatCheck == true){
     
     numericalValues.add(str);
    }
    
    else if(keyword.contains(str)){
     
     keywords.add(str); 
    }

    else if(mathOperater.contains(str)){

     mathOperators.add(str); 
    }

    else if(logicalOperater.contains(str)){

     logicalOperators.add(str);
    }

    else if(str.equals("(")||str.equals(")")||str.equals("{")||str.equals("}")||str.equals("[")||str.equals("]")){

     others.add(str);
    }

    else {
     
     if(str.indexOf(',')!= -1)
      others.add(",");
     String[] parts = str.split(",");
     for(int i=0; i<parts.length; i++){
      identifiers.add(parts[i]);
     }
     
    }
   }

   System.out.print("Keywords: ");
   for(String str: keywords){

    System.out.print(str.toString()+" ");
   }

   System.out.println();
   System.out.print("Math Operators: ");

   for(String str: mathOperators){

    System.out.print(str.toString()+" ");
   }


   System.out.println();
   System.out.print("Logical Operators: ");

   for(String str: logicalOperators){

    System.out.print(str.toString()+" ");
   }

   System.out.println();
   System.out.print("Identifiers: ");

   for(String str: identifiers){

    System.out.print(str.toString()+" ");
   }

   System.out.println();
   System.out.print("Numerical values: ");

   for(String str: numericalValues){

    System.out.print(str.toString()+" ");
   }

   System.out.println();
   System.out.print("Others: ");

   for(String str: others){

    System.out.print(str.toString()+" ");
   }

  } catch(Exception e){
   System.out.println(e.toString());
  }
 }

 
 
 public static boolean checkInt(String string){
  try{
   Integer.parseInt(string);
   return true;
   
  } catch (Exception e){
   return false;
  }
 }


 public static boolean checkFloat(String string){
  try{
   Double.parseDouble(string);
   return true;

  } catch (Exception e){
   return false;
  }
 }

}
