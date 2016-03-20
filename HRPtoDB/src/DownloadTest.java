import java.io.FileOutputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.Document;

public class DownloadTest {

	public static void main(String[] args) {
		try{
			DocumentBuilderFactory docfactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docbuilder = docfactory.newDocumentBuilder();
			
			/*
			 * <Envelope>
         	 *	 <Body>
           	 *		<Request>
             *			<Base>
             * 				<AuthCode>##########</AuthCode>
             *				<Language>hu</Language>
             *				<Currency>HUF</Currency>
             *			</Base>
             *			<ProductId>...</ProductId>
			 *		</Request>
         	 *	 </Body>
       		 * </Envelope>
			 */
			
			//Envelope
			Document doc = docbuilder.newDocument();
			Element envelope = doc.createElement("Envelope");
			doc.appendChild(envelope);
			
			//Body
			
			
			//Request
			
			
			//Base
			
			
			//AuthCode
			
			
			//Language
			
			
			//Currency
			
			
			//ProductID
			
			
			
		}
		catch (Exception e){
			e.printStackTrace();
		}
		

	}

}
