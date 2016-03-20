import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Element;
import org.w3c.dom.Document;

public class DownloadTest {

	public static void main(String[] args) {
		try{
			DocumentBuilderFactory docfactory = DocumentBuilderFactory.newInstance();
			Document doc = docfactory.newDocumentBuilder().newDocument();
			
			/* Sample XML
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
			Element envelope = doc.createElement("Envelope");
			doc.appendChild(envelope);
			
			//Body
			Element body = doc.createElement("Body");
			envelope.appendChild(body);
			
			//Request
			Element request = doc.createElement("Request");
			body.appendChild(request);
			
			//Base
			Element base = doc.createElement("Base");
			request.appendChild(base);
			
			//AuthCode
			Element authcode = doc.createElement("AuthCode");
			authcode.setTextContent("test");
			base.appendChild(authcode);
			
			//Language
			Element language = doc.createElement("Language");
			language.setTextContent("hu");
			base.appendChild(language);
			
			//Currency
			Element currency = doc.createElement("Currency");
			currency.setTextContent("HUF");
			base.appendChild(currency);
			
			//ProductID
			Element productid = doc.createElement("ProductId");
			productid.setTextContent("123");
			request.appendChild(productid);
			
			//Print result
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			DOMSource source = new DOMSource(doc);
			
			System.out.println("Request: ");
			StreamResult result = new StreamResult(System.out);
			transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.transform(source, result);
			
		}
		catch (Exception e){
			e.printStackTrace();
		}
		

	}

}
