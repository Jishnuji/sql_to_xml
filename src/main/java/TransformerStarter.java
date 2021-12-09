import transformers.CSVArticleTransformer;
import transformers.STAXWriterArticle;
import transformers.XSLTArticleTransformer;

public class TransformerStarter {
    public static void main(String[] args) {
        STAXWriterArticle staxWriterArticle = new STAXWriterArticle();
        staxWriterArticle.createXMLWriter();

        XSLTArticleTransformer xsltArticleTransformer = new XSLTArticleTransformer();
        xsltArticleTransformer.createXSLTArticleTransformer();

        CSVArticleTransformer csvArticleTransformer = new CSVArticleTransformer();
        csvArticleTransformer.createCSVTransformer();
    }
}
