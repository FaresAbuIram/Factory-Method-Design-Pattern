package com.company;



import java.util.Scanner;
interface FileParser {
    void ParseFile();
}
public class Main{

    public static void main(String[] args) {

    Scanner s=new Scanner(System.in);
        String yourFile;
        System.out.print("Enter your file extensions : ");
        yourFile=s.nextLine();
        if(yourFile.equals("json")) {
            ReadJsonFile R=  new ReadJsonFile();
            R.ParseFile();
        }
        else if(yourFile.equals("xml")){
            ReadXmlFile R=new ReadXmlFile();
            R.ParseFile();
        }
        else
            System.out.println("Not required extensions !");

            }

        }

