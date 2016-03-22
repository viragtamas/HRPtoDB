
public class XmlTester {

	public static void main(String[] args) throws Exception {
		HrpXml XmlObject = new HrpXml("12345678");
		XmlObject.TransformDocument(XmlObject.GetCatalogueList("hu"));
	}

}
