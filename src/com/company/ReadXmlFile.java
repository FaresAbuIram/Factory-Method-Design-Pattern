package com.company;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.*;
import java.io.FileWriter;
import java.io.PrintWriter;

public class ReadXmlFile implements FileParser {
    public void ParseFile(){


        DocumentBuilderFactory factory =  DocumentBuilderFactory.newInstance();
            try {
                PrintWriter pw = new PrintWriter("result.txt");
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document doc = builder.parse("Test.xml");
                NodeList personlist=doc.getElementsByTagName("note");
                FileWriter fw=new FileWriter("result.txt",true);
                fw.write("Type: Note \n------------------\n");
                for (int i=0;i<personlist.getLength();i++){
                    Node p=personlist.item(i);
                    if (p.getNodeType()==Node.ELEMENT_NODE) {
                        Element note = (Element) p;
                        NodeList nameList = note.getChildNodes();
                        for (int j = 0; j < nameList.getLength(); j++) {
                            Node n = nameList.item(j);
                            if (n.getNodeType()==Node.ELEMENT_NODE) {
                            Element name=(Element) n;
                                fw.write(name.getTagName()+": "+name.getTextContent()+'\n');

                            }

                        }
                    }
                }
             fw.close();
            } catch (Exception e){
                System.out.println(e);
            }

    }
}
