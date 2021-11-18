
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

public class XSLTExample {
    public static void main(String[] args) throws TransformerException {
        TransformerFactory factory = new net.sf.saxon.BasicTransformerFactory();
        Source xslt = new StreamSource(new File("src/input/articles.xsl"));
        Transformer transformer = factory.newTransformer(xslt);
        Source xml = new StreamSource(new File("src/output/articles.xml"));
        transformer.transform(xml, new StreamResult(new File("src/output/articles_output.xml")));
    }
}
