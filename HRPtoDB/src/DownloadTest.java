import java.io.FileOutputStream;
import javax.xml.soap.*;

public class DownloadTest {

	public static void main(String[] args) {
		try{
			MessageFactory factory = MessageFactory.newInstance();
			SOAPMessage message = factory.createMessage();
			SOAPPart part = message.getSOAPPart();
			
			SOAPEnvelope envelope = part.getEnvelope();
			SOAPHeader header = envelope.getHeader();
			SOAPBody body = envelope.getBody();
			
			
		}
		catch (Exception e){
			e.printStackTrace();
		}
		

	}

}
