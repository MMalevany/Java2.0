import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RunnerDOM {
    static List<TopBook> bookList = new ArrayList<>();

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File("src\\book.xml"));
        NodeList elements = doc.getDocumentElement().getElementsByTagName("book");
        for (int j = 0; j < elements.getLength(); j++) {
            List<String> values = new ArrayList<>();
            NodeList nodeList = elements.item(j).getChildNodes();
            for (int i = 0; i < nodeList.getLength(); i++) {
                if (nodeList.item(i) instanceof Element) {
                    values.add(nodeList.item(i).getTextContent());
                    System.out.println(nodeList.item(i).getNodeName() +
                            " " + nodeList.item(i).getTextContent());
                }
            }
            bookList.add(new TopBook(Integer.parseInt(values.get(0)),
                    values.get(1), values.get(2), values.get(3),
                    Integer.parseInt(values.get(4)), Integer.parseInt(values.get(5))));
        }

        for (var s : bookList) {
            System.out.println(s.toString());
        }
    }
}
