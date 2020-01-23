package openapi;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
// w3c를 import해야함!
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
//xml문서 파싱하기
public class DomParserTest01 {
	public static void main(String[] args) throws Exception {
		// domParser(W3C 제공)
		// 파서를 만들어내는 factory 클래스(Parser 생성기)
		DocumentBuilderFactory factory = 
				DocumentBuilderFactory.newInstance(); //static메소드
		// DOM Parser
		DocumentBuilder domparser = factory.newDocumentBuilder();
		// Parser의 parse메소드를 호출하면 xml을 분석해서 Dom객체(document)를 만들어서 반환
		Document document = domparser.parse("src/openapi/dept.xml");
		
		// javascript와 같은 메소드
		// root엘리먼트(=노드, 태그)
		Element root = document.getDocumentElement();
		System.out.println(root.getNodeName());
		
		// dept엘리먼트 추출 - 모두 루트 밑에 있기 때문에 루트로부터 구한다.
		// @ NodeList = ArrayList
		// 로딩 전에 자체 저장구조(NodeList)에 미리 저장하고 있다. -spring은 map
		NodeList nodelist = root.getElementsByTagName("dept");
		System.out.println(nodelist.getLength());
		// dept가 증가할때마다 'getElementsBy-중첩for문' 추가
		for(int i=0; i<nodelist.getLength(); ++i) {
			Node node = nodelist.item(i);
			System.out.println("노드명: "+node.getNodeName());
		}
	}
}
