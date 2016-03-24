
public class XmlTester {

	public static void main(String[] args) throws Exception {
		HrpXml XmlObject = new HrpXml("B35B2464-9678-41CE-BA7F-792133AD5211");
		XmlObject.TransformDocument(XmlObject.GetCatalogueList("hu", "HUF", true, true, true, true));
	}

}
