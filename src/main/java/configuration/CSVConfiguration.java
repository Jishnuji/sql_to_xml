package configuration;

public class CSVConfiguration {
    private static final String SRC_XSL = "src/input/articles_to_csv.xsl";
    private static final String SRC_XML = "src/output/articles_output.xml";
    private static final String SRC_CSV = "src/output/articles_output.xml";

    public String getSrcXsl() {
        return SRC_XSL;
    }

    public String getSrcXml() {
        return SRC_XML;
    }

    public String getSrcCsv() {
        return SRC_CSV;
    }

}
