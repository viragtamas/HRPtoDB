import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Element;
import org.w3c.dom.Document;

public class HrpXml {

	public HrpXml(){
		
	}
	
	public StreamResult getCatalogueItem(){
		try{
			DocumentBuilderFactory docfactory = DocumentBuilderFactory.newInstance();
			Document doc = docfactory.newDocumentBuilder().newDocument();
			
			
		}catch (Exception e){
			e.printStackTrace(System.out);
		}
		StreamResult CatalogueItem = new StreamResult();
		return CatalogueItem;
		
	}
	
	
}
