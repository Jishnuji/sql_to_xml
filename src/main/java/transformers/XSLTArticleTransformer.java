package transformers;

import configuration.XSLTConfiguration;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

public class XSLTArticleTransformer {
    public void createXSLTArticleTransformer() {
        XSLTConfiguration xsltConfig = new XSLTConfiguration();
        TransformerFactory factory = new net.sf.saxon.BasicTransformerFactory();
        Source xslt = new StreamSource(new File(xsltConfig.getSrcXsl()));
        Source xml = new StreamSource(new File(xsltConfig.getSrcXml()));
        Result out = new StreamResult(new File(xsltConfig.getArticlesOutput()));

        try {
            Transformer transformer = factory.newTransformer(xslt);
            transformer.transform(xml, out);
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
