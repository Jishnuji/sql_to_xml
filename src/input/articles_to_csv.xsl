<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="text" omit-xml-declaration="yes" indent="no"/>
    <xsl:template match="/">ID_ART, NAME, CODE, USERNAME, GUID

        <xsl:for-each select="//article">
            <xsl:value-of select="concat(id_art,',',name,',',code,',',username,',',guid,'&#xA;')"/>
        </xsl:for-each>

    </xsl:template>
</xsl:stylesheet>