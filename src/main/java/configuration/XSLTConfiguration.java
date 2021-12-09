package configuration;

public class XSLTConfiguration {
    private static final String SRC_XSL = "src/input/articles.xsl";
    private static final String SRC_XML = "src/output/articles.xml";
    private static final String ARTICLES_OUTPUT = "src/output/articles_output.xml";

    public String getSrcXsl() {
        return SRC_XSL;
    }

    public String getSrcXml() {
        return SRC_XML;
    }

    public String getArticlesOutput() {
        return ARTICLES_OUTPUT;
    }
}
