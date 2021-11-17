
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

public class STAXWriteExample {
    private static XMLStreamWriter writer;

    public static void main(String[] args) throws FileNotFoundException, XMLStreamException {
        XMLOutputFactory factory = XMLOutputFactory.newFactory();
        writer = factory.createXMLStreamWriter(new FileOutputStream("src/output/articles.xml"));

        DAOArticles daoArticles = new DAOArticles();
        fromListToXML(daoArticles.getArticlesFromBD());
    }

    public static void fromListToXML(List<Article> articles) throws XMLStreamException {
        writer.writeStartDocument();
        writer.writeDTD(System.lineSeparator());
        writer.writeStartElement("articles");
        writer.writeDTD(System.lineSeparator());

        for (Article article : articles) {
            writer.writeDTD("    ");
            writer.writeStartElement("article");
            writer.writeAttribute("id_art", Long.toString(article.getId()));
            writer.writeAttribute("name", article.getName());
            writer.writeAttribute("code", Long.toString(article.getCode()));
            writer.writeAttribute("username", article.getUserName());
            writer.writeAttribute("guid", article.getGuid());
            writer.writeEndElement();
            writer.writeDTD(System.lineSeparator());
        }

        writer.writeEndDocument();
        if (writer != null) {
            writer.close();
        }
    }
}
