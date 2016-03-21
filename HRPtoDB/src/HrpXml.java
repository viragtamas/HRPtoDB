import java.io.StringWriter;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Element;
import org.w3c.dom.Document;

public class HrpXml {
	
	//AuthCode az azonosításhoz
	public String AuthCode;
	public String Query;
	
	public HrpXml(String AuthCode){
		this.AuthCode = AuthCode;
	}
	
	public String GetCatalogueList(){
		StringWriter sw = new StringWriter();
		try{
			DocumentBuilderFactory docfactory = DocumentBuilderFactory.newInstance();
			Document doc = docfactory.newDocumentBuilder().newDocument();
			
			/* Sample XML
			 * <Envelope>
         	 *	 <Body>
           	 *		<Request>
             *			<Base>
			 *             <AuthCode>##########</AuthCode>
			 *             <Language>hu</Language>
			 *             <Currency>HUF</Currency>
			 *           </Base>
			 *           <!--DiscountFilter: Szûrés akciós termékre-->
			 *           <DiscountFilter>false</DiscountFilter>
			 *           <!--SecondhandFilter: Szûrés használt termékre-->
			 *           <SecondhandFilter>false</SecondhandFilter>
			 *           <Category1IdList>
			 *	           <Category1Id>B011</Category1Id>
			 *           </Category1IdList>
			 *           <ManufacturerIdList>
			 *              <ManufacturerId>A132</ManufacturerId>
			 *           </ManufacturerIdList>
			 *           <!--NewFilter: Újdonság-->
			 *           <NewFilter>false</NewFilter>
			 *           <!--StockFilter: Készleten-->
			 *           <StockFilter>false</StockFilter>
			 *           <!--TextFilter: Keresés terméknévre vagy cikkszámra-->
			 *           <TextFilter></TextFilter>
			 *           <CurrentPageIndex>1</CurrentPageIndex>
			 *           <ItemsOnPage>30</ItemsOnPage>
			 *            <!--6:ár növekvõ, 7:ár csökkenõ, 2:cikkszám növekvõ, 3:cikkszám csökkenõ, 4:név növekvõ, 5:név csökkenõ, 8:készlet növekvõ, 9:készlet csökkenõ, 12:garancia növekvõ, 13:garancia csökkenõ-->
			 *           <Sequence>6</Sequence>
			 *		</Request>
         	 *	 </Body>
       		 * </Envelope>
			 */
			
		}catch (Exception e){
			e.printStackTrace();
		}
		
		return Query;
	}
		
	public String GetCatalogueItem(String Language, String Currency){
		StringWriter sw = new StringWriter();
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
			authcode.setTextContent(AuthCode);
			base.appendChild(authcode);
			
			//Language
			Element language = doc.createElement("Language");
			language.setTextContent(Language);
			base.appendChild(language);
			
			//Currency
			Element currency = doc.createElement("Currency");
			currency.setTextContent(Currency);
			base.appendChild(currency);
			
			//ProductID
			Element productid = doc.createElement("ProductId");
			productid.setTextContent("123");
			request.appendChild(productid);
			
			//Print result
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			DOMSource source = new DOMSource(doc);
			
			//Transforming request
			System.out.println("Request: ");
			
			transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			transformer.setOutputProperty(OutputKeys.INDENT, "no");
			transformer.transform(source, new StreamResult(sw));
			System.out.println(sw.toString());
		}catch(Exception e){
			e.printStackTrace();
		}
		return sw.toString();
	}
	
	public String GetStructurePta(){
		return Query;
	}
	
	public String GetInvoiceList(){
		return Query;
	}
	
	public String GetInvoiceDetails(){
		return Query;
	}
	
	public String GetStructureList(){
		return Query;
	}
	
	public String GetDeliveryAddresses(){
		return Query;
	}
	
	public String GetOrderInfo(){
		return Query;
	}
	
	public String CreateOrder(){
		return Query;
	}
	
}
