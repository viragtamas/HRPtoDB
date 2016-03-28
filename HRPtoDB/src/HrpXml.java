import java.io.File;
import java.io.StringWriter;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Element;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

public class HrpXml {
	
	//AuthCode az azonosításhoz
	public String AuthCode;
	public String Query = "";
	
	public HrpXml(String AuthCode){
		this.AuthCode = AuthCode;
	}
	
	//A paraméterlista nem teljes, át kell nézni.
	public Document GetCatalogueList(String Language,
									 String Currency,
									 boolean DiscountFilter,
									 boolean SecondHandFilter,
									 boolean NewFilter,
									 boolean StockFilter,
									 String[] ManufacturerIdList,
									 String[] Category1IdList,
									 String[] Category2IdList,
									 String[] Category3IdList,
									 String TextFilter,
									 int CurrentPage,
									 int ItemsOnPage,
									 int Sequence) throws Exception{
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
				      <!--DiscountFilter: Szûrés akciós termékre-->
				      <DiscountFilter>false</DiscountFilter>
				      <!--SecondhandFilter: Szûrés használt termékre-->
				      <SecondhandFilter>false</SecondhandFilter>
				      <!--NewFilter: Szûrés újdonságokra-->
				      <NewFilter>false</NewFilter>
				      <!--StockFilter: Szûrés készleten lévõ termékekre-->
				      <StockFilter>false</StockFilter>
				      <!--ManufacturerIdList: Gyártók azonosítói-->
				      <ManufacturerIdList>
				        <ManufacturerId></ManufacturerId>
				      </ManufacturerIdList>
				      <!--Category1IdList: Elsõdleges termékjellemzõk azonosítói-->
				      <Category1IdList>
				        <Category1Id></Category1Id>
				      </Category1IdList>
				      <!--Category2IdList: Másodlagos termékjellemzõk azonosítói-->
				      <Category2IdList>
				        <Category2Id></Category2Id>
				      </Category2IdList>
				      <!--Category3IdList: Harmadlagos termékjellemzõk azonosítói-->
				      <Category3IdList>
				        <Category3Id></Category3Id>
				      </Category3IdList>
				      <!--TextFilter: Keresés terméknévre vagy cikkszámra-->
				      <TextFilter></TextFilter>
				      <!--CurrentPageIndex: Aktuális oldalszám-->
				      <CurrentPageIndex>1</CurrentPageIndex>
				      <!--ItemsOnPage: Egy oldalon megjeleníthetõ termékek száma-->
				      <ItemsOnPage>10</ItemsOnPage>
				      <!--Sequence: Sorrend (0:alapértelmezett, 6:ár növekvõ, 7:ár csökkenõ, 2:cikkszám növekvõ, 3:cikkszám csökkenõ, 4:név növekvõ, 5:név csökkenõ, 8:készlet növekvõ, 9:készlet csökkenõ, 12:garancia növekvõ, 13:garancia csökkenõ)-->
				      <Sequence>0</Sequence>
				      <!--PtaProductDetails: Szûrés termék technikai jellemzõkre-->
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
			
			//ManufacturerIdList
			if(ManufacturerIdList!=null){
				Element manufactureridlist = doc.createElement("ManufacturerIdList");
				request.appendChild(manufactureridlist);
				
				//Element list
				for (String id : ManufacturerIdList){
					Element manufacturerid = doc.createElement("ManufacturerId");
					manufacturerid.setTextContent(id);
					manufactureridlist.appendChild(manufacturerid);
				}
			}
			
			//Category1IdList
			if(Category1IdList!=null){
				Element category1idlist = doc.createElement("Category1IdList");
				request.appendChild(category1idlist);
				
				//Element list
				for (String id : Category1IdList){
					Element category1id = doc.createElement("Category1Id");
					category1id.setTextContent(id);
					category1idlist.appendChild(category1id);
				}
			}
			
			//Category2IdList
			if(Category2IdList!=null){
				Element category2idlist = doc.createElement("Category2IdList");
				request.appendChild(category2idlist);
				
				//Element list
				for (String id : Category2IdList){
					Element category2id = doc.createElement("Category2Id");
					category2id.setTextContent(id);
					category2idlist.appendChild(category2id);
				}
			}
			
			//Category1IdList
			if(Category3IdList!=null){
				Element category3idlist = doc.createElement("Category3IdList");
				request.appendChild(category3idlist);
				
				//Element list
				for (String id : Category3IdList){
					Element category3id = doc.createElement("Category3Id");
					category3id.setTextContent(id);
					category3idlist.appendChild(category3id);
				}
			}
			
			//TextFilter
			Element textfilter = doc.createElement("TextFilter");
			textfilter.setTextContent(TextFilter);
			request.appendChild(textfilter);
			
			//CurrentPageIndex
			Element currentpage = doc.createElement("CurrentPageIndex");
			currentpage.setTextContent(""+CurrentPage);
			request.appendChild(currentpage);
			
			//ItemsOnPage
			Element itemsonpage = doc.createElement("ItemsOnPage");
			itemsonpage.setTextContent(""+ItemsOnPage);
			request.appendChild(itemsonpage);
			
			//Sequence
			Element sequence = doc.createElement("Sequence");
			sequence.setTextContent(""+Sequence);
			request.appendChild(sequence);
			
		return doc;
	}
	
	public String ParseCatalogueItems(String filename) throws Exception{
		
		File fXmlFile = new File(filename);
		DocumentBuilderFactory docfactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = docfactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);
		
		//Node length = doc.getElementById("ListCount");
		NodeList nList = doc.getElementsByTagName("CatalogueItem");
		
		for (int i=0; i<nList.getLength(); i++){
			Node nNode = nList.item(i);
			Element eElement = (Element) nNode;
			Query = Query+eElement.getElementsByTagName("ProductId").item(0).getTextContent()+"; ";
		}
		
		return Query;
	}
		
	public Document GetCatalogueItem(String Language, String Currency, String ProductId) throws Exception{
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
			productid.setTextContent(ProductId);
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
