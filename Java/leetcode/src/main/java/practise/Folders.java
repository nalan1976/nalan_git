package practise;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class Folders {
    public static Collection<String> folderNames(String xml, char startingLetter) throws Exception {
//        throw new UnsupportedOperationException("Waiting to be implemented.");

        //simple implementation, there are bugs in it
/*        String[] str = xml.split("folder name=\"");
        Collection<String> ret = new ArrayList<>();
        for (int i = 1; i < str.length; i++){
            if (str[i].charAt(0) == startingLetter){
                ret.add(str[i].substring(0, str[i].indexOf("\"")));
            }
        }
        return ret;*/
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(xml));
        Document doc = builder.parse(is);
        NodeList node = doc.getElementsByTagName("folder");
        Collection<String> result = new ArrayList<String>();
        for (int i =0; i< node.getLength();i ++) {
            String nodeName = node.item(i).getAttributes().getNamedItem("name").getNodeValue();
            if(nodeName.toCharArray()[0] == startingLetter) {
                result.add(nodeName);
            }
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        String xml =
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                        "<folder name=\"c\">" +
                        "<folder name=\"program files\">" +
                        "<folder name=\"uninstall information\" />" +
                        "</folder>" +
                        "<folder name=\"users\" />" +
                        "</folder>";

        Collection<String> names = folderNames(xml, 'u');
        for(String name: names)
            System.out.println(name);

    }
}
