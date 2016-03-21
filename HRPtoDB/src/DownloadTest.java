import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.entity.StringEntity;

public class DownloadTest {

	public static void main(String[] args) {
		try{
			//Creating new Object to handle XML Creation
			HrpXml XmlObject = new HrpXml("{123456}");
						
			//Creating HTTP Client
			String strURL = "http://dev.hrp.hu/CompanyGroup.XmlGateway/CatalogueService/GetCatalogueItem/";
			CloseableHttpClient httpclient = HttpClients.createDefault();
			HttpPost post = new HttpPost(strURL);
			post.setEntity(new StringEntity(XmlObject.TransformDocument(XmlObject.GetCatalogueItem("hu", "HUF"))));
			
			//Post XML to URL
			HttpResponse response = httpclient.execute(post);
		    System.out.println("\nSending 'POST' request to URL : " + strURL);
		    System.out.println("Post parameters : " + post.getEntity());
		    
		    //Get Response
		    System.out.println("Response Code : " + response.getStatusLine().getStatusCode());

		    BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));

		    StringBuffer result = new StringBuffer();
		    String line = "";
		    while ((line = rd.readLine()) != null) {
		        result.append(line);
		        System.out.println(line.toString());
		    }

		    
		    
		    
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}

}
