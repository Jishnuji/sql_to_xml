
import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

public class CSVExample {
    public static void main(String[] args) throws TransformerException {
        TransformerFactory factory = new net.sf.saxon.BasicTransformerFactory();
        Source xslt = new StreamSource(new File("src/input/articles_to_csv.xsl"));
        Transformer transformer = factory.newTransformer(xslt);
        Source xml = new StreamSource(new File("src/output/articles_output.xml"));
        transformer.transform(xml, new StreamResult(new File("src/output/articles_output_csv.csv")));
    }
}
