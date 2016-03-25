
public class XmlTester {

	public static void main(String[] args) throws Exception {
		HrpXml XmlObject = new HrpXml("B35B2464-9678-41CE-BA7F-792133AD5211");
		String[] ManIDList = new String[] {"A","B"};
		String[] Cat1IdList = new String[] {"A", "B"};
		String[] Cat2IdList = new String[] {"A", "B"};
		String[] Cat3IdList = new String[] {"A", "B"};
		XmlObject.TransformDocument(XmlObject.GetCatalogueList("hu", "HUF", true, true, true, true, ManIDList, Cat1IdList, Cat2IdList, Cat3IdList, "Dell"));
	}

}
