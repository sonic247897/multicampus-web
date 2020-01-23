package openapi;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
// w3c�� import�ؾ���!
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
//xml���� �Ľ��ϱ�
public class DomParserTest01 {
	public static void main(String[] args) throws Exception {
		// domParser(W3C ����)
		// �ļ��� ������ factory Ŭ����(Parser ������)
		DocumentBuilderFactory factory = 
				DocumentBuilderFactory.newInstance(); //static�޼ҵ�
		// DOM Parser
		DocumentBuilder domparser = factory.newDocumentBuilder();
		// Parser�� parse�޼ҵ带 ȣ���ϸ� xml�� �м��ؼ� Dom��ü(document)�� ���� ��ȯ
		Document document = domparser.parse("src/openapi/dept.xml");
		
		// javascript�� ���� �޼ҵ�
		// root������Ʈ(=���, �±�)
		Element root = document.getDocumentElement();
		System.out.println(root.getNodeName());
		
		// dept������Ʈ ���� - ��� ��Ʈ �ؿ� �ֱ� ������ ��Ʈ�κ��� ���Ѵ�.
		// @ NodeList = ArrayList
		// �ε� ���� ��ü ���屸��(NodeList)�� �̸� �����ϰ� �ִ�. -spring�� map
		NodeList nodelist = root.getElementsByTagName("dept");
		System.out.println(nodelist.getLength());
		// dept�� �����Ҷ����� 'getElementsBy-��øfor��' �߰�
		for(int i=0; i<nodelist.getLength(); ++i) {
			Node node = nodelist.item(i);
			System.out.println("����: "+node.getNodeName());
		}
	}
}
