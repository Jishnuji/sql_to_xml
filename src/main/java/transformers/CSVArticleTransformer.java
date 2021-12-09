package transformers;

import configuration.CSVConfiguration;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

public class CSVArticleTransformer {
    public void createCSVTransformer() {
        CSVConfiguration csvConfig = new CSVConfiguration();
        TransformerFactory factory = new net.sf.saxon.BasicTransformerFactory();
        Source xslt = new StreamSource(new File(csvConfig.getSrcXsl()));
        Source xml = new StreamSource(new File(csvConfig.getSrcXml()));
        Result csv = new StreamResult(new File(csvConfig.getSrcCsv()));

        try {
            Transformer transformer = factory.newTransformer(xslt);
            transformer.transform(xml, csv);
        } catch (
                TransformerException e) {
            e.printStackTrace();
        }
    }
}
