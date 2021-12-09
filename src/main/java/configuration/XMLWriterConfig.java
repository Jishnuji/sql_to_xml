package configuration;

public class XMLWriterConfig {
    private final String SRC = "src/output/articles.xml";
    private final String ARTICLES = "articles";
    private final String ARTICLE = "article";
    private final String ID = "id_art";
    private final String NAME = "name";
    private final String CODE = "code";
    private final String USERNAME = "username";
    private final String GUID = "guid";

    public String getARTICLES() {
        return ARTICLES;
    }

    public String getARTICLE() {
        return ARTICLE;
    }

    public String getID() {
        return ID;
    }

    public String getNAME() {
        return NAME;
    }

    public String getCODE() {
        return CODE;
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public String getGUID() {
        return GUID;
    }

    public String getSRC() {
        return SRC;
    }
}
