import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.entity.StringEntity;

public class DownloadTest {

	public static void main(String[] args) {
		try{
			//Today
			Date today = Calendar.getInstance().getTime();
			DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
			
			//Creating new Object to handle XML Creation
			HrpXml XmlObject = new HrpXml("B35B2464-9678-41CE-BA7F-792133AD5211");
						
			//Creating HTTP Client
			String strURL = "http://dev.hrp.hu/CompanyGroup.XmlGateway/CatalogueService/GetCatalogueList/";
			CloseableHttpClient httpclient = HttpClients.createDefault();
			HttpPost post = new HttpPost(strURL);
			//post.setEntity(new StringEntity(XmlObject.TransformDocument(XmlObject.GetCatalogueItem("hu", "HUF", "M2800-6"))));
			post.setEntity(new StringEntity(XmlObject.TransformDocument(XmlObject.GetCatalogueList("hu", "HUF", false, false, false, true, null, null, null, null, "", 1, 1701, 7))));
			
			//Post XML to URL
			HttpResponse response = httpclient.execute(post);
		    System.out.println("\nSending 'POST' request to URL : " + strURL);
		    System.out.println("Post parameters : " + post.getEntity());
		    
		    //Get Response
		    System.out.println("Response Code : " + response.getStatusLine().getStatusCode());

		    BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));

		    PrintWriter file = new PrintWriter("test"+df.format(today).toString()+".xml");
		    String line = "";
		    while ((line = rd.readLine()) != null) {
		        file.println(line.toString());
		    }
		    file.close();
		    System.out.println("Created: test"+df.format(today).toString()+".xml");
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
}
