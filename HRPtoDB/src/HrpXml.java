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
	
	//AuthCode az azonos�t�shoz
	public String AuthCode;
	public String Query;
	
	public HrpXml(String AuthCode){
		this.AuthCode = AuthCode;
	}
	
	//A param�terlista nem teljes, �t kell n�zni.
	public Document GetCatalogueList(String Language,
									 String Currency,
									 boolean DiscountFilter,
									 boolean SecondHandFilter,
									 boolean NewFilter,
									 boolean StockFilter) throws Exception{
			DocumentBuilderFactory docfactory = DocumentBuilderFactory.newInstance();
			Document doc = docfactory.newDocumentBuilder().newDocument();
			
			/* Sample XML
			   <Envelope>
				  <Body>
				    <Request>
				      <Base>
				        <AuthCode>________-____-____-____-____________</AuthCode>
				        <Language>hu</Language>
				        <Currency>HUF</Currency>
				      </Base>
				      <!--DiscountFilter: Sz�r�s akci�s term�kre-->
				      <DiscountFilter>false</DiscountFilter>
				      <!--SecondhandFilter: Sz�r�s haszn�lt term�kre-->
				      <SecondhandFilter>false</SecondhandFilter>
				      <!--NewFilter: Sz�r�s �jdons�gokra-->
				      <NewFilter>false</NewFilter>
				      <!--StockFilter: Sz�r�s k�szleten l�v� term�kekre-->
				      <StockFilter>false</StockFilter>
				      <!--ManufacturerIdList: Gy�rt�k azonos�t�i-->
				      <ManufacturerIdList>
				        <ManufacturerId></ManufacturerId>
				      </ManufacturerIdList>
				      <!--Category1IdList: Els�dleges term�kjellemz�k azonos�t�i-->
				      <Category1IdList>
				        <Category1Id></Category1Id>
				      </Category1IdList>
				      <!--Category2IdList: M�sodlagos term�kjellemz�k azonos�t�i-->
				      <Category2IdList>
				        <Category2Id></Category2Id>
				      </Category2IdList>
				      <!--Category3IdList: Harmadlagos term�kjellemz�k azonos�t�i-->
				      <Category3IdList>
				        <Category3Id></Category3Id>
				      </Category3IdList>
				      <!--TextFilter: Keres�s term�kn�vre vagy cikksz�mra-->
				      <TextFilter></TextFilter>
				      <!--CurrentPageIndex: Aktu�lis oldalsz�m-->
				      <CurrentPageIndex>1</CurrentPageIndex>
				      <!--ItemsOnPage: Egy oldalon megjelen�thet� term�kek sz�ma-->
				      <ItemsOnPage>10</ItemsOnPage>
				      <!--Sequence: Sorrend (0:alap�rtelmezett, 6:�r n�vekv�, 7:�r cs�kken�, 2:cikksz�m n�vekv�, 3:cikksz�m cs�kken�, 4:n�v n�vekv�, 5:n�v cs�kken�, 8:k�szlet n�vekv�, 9:k�szlet cs�kken�, 12:garancia n�vekv�, 13:garancia cs�kken�)-->
				      <Sequence>0</Sequence>
				      <!--PtaProductDetails: Sz�r�s term�k technikai jellemz�kre-->
				      <PtaProductDetails>
				        <PtaProductDetail>
				          <TulajdonsagListaId></TulajdonsagListaId>
				          <TulajdonsagId></TulajdonsagId>
				          <TulajdonsagTipus></TulajdonsagTipus>
				          <ProdValueFrom></ProdValueFrom>
				          <ProdValueTo></ProdValueTo>
				        </PtaProductDetail>
				      </PtaProductDetails>
				    </Request>
				  </Body>
				</Envelope>
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
			
			//DiscountFilter
			Element discountfilter = doc.createElement("DiscountFilter");
			discountfilter.setTextContent(DiscountFilter ? "true" : "false");
			request.appendChild(discountfilter);
			
			//SecondhandFilter
			Element secondhandfilter = doc.createElement("SecondhandFilter");
			secondhandfilter.setTextContent(SecondHandFilter ? "true" : "false");
			request.appendChild(secondhandfilter);
			
			//NewFilter
			Element newfilter = doc.createElement("NewFilter");
			newfilter.setTextContent(NewFilter ? "true" : "false");
			request.appendChild(newfilter);
			
			//StockFilter
			Element stockfilter = doc.createElement("StockFilter");
			stockfilter.setTextContent(StockFilter?"true":"false");
			request.appendChild(stockfilter);
			
			//Category1IdList
			
			//Category1Id - array
			
			//ManufacturerIdList
			
			//ManufacturerId - array
			
			
			//TextFilter
			
			//CurrentPageIndex
			
			//ItemsOnPage
			
			//Sequence
			
		return doc;
	}
		
	public Document GetCatalogueItem(String Language, String Currency) throws Exception{
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
		
			return doc;
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
	
	public String TransformDocument(Document doc){
		StringWriter sw = new StringWriter();
		try{
		//Print result
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		DOMSource source = new DOMSource(doc);
		
		//Transforming request
		System.out.println("Request: ");
		
		transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.transform(source, new StreamResult(sw));
		System.out.println(sw.toString());
		}catch(Exception e){
			e.printStackTrace();
		}
		return sw.toString();
	}
	
}
