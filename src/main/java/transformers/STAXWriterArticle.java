package transformers;

import configuration.XMLWriterConfig;
import dao.DAOArticles;
import dao.DAOArticlesJDBCImpl;
import model.Article;
import service.ServiceArticles;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class STAXWriterArticle {
    private static XMLStreamWriter writer;
    private static XMLWriterConfig xmlWriterConfig;

    public void createXMLWriter() {
        XMLOutputFactory factory = XMLOutputFactory.newFactory();
        xmlWriterConfig = new XMLWriterConfig();
        ServiceArticles serviceArticles = new ServiceArticles();

        try(FileOutputStream fileOutputStream = new FileOutputStream(xmlWriterConfig.getSRC())) {
            writer = factory.createXMLStreamWriter(fileOutputStream);
            writeToXML(serviceArticles.getArticlesFromResultSet());

        } catch (IOException | XMLStreamException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (XMLStreamException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void writeToXML(List<Article> articles) {
        try {
            writer.writeStartDocument();
            writer.writeDTD(System.lineSeparator());
            writer.writeStartElement(xmlWriterConfig.getARTICLES());
            writer.writeDTD(System.lineSeparator());

            for (Article article : articles) {
                writer.writeDTD("    ");
                writer.writeStartElement(xmlWriterConfig.getARTICLE());
                writer.writeAttribute(xmlWriterConfig.getID(), Long.toString(article.getId()));
                writer.writeAttribute(xmlWriterConfig.getNAME(), article.getName());
                writer.writeAttribute(xmlWriterConfig.getCODE(), Long.toString(article.getCode()));
                writer.writeAttribute(xmlWriterConfig.getUSERNAME(), article.getUserName());
                writer.writeAttribute(xmlWriterConfig.getGUID(), article.getGuid());
                writer.writeEndElement();
                writer.writeDTD(System.lineSeparator());
            }

            writer.writeEndDocument();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }
}
