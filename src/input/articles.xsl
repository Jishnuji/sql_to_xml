<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="xml" indent="yes"/>

    <xsl:template match="articles">
        <articles>
            <xsl:apply-templates/>
        </articles>
    </xsl:template>

    <xsl:template match="article">
        <article>
            <xsl:apply-templates select="@*|*"/>
        </article>
    </xsl:template>

    <xsl:template match="@id_art">
        <id_art>
            <xsl:value-of select="."/>
        </id_art>
    </xsl:template>

    <xsl:template match="@name">
        <name>
            <xsl:value-of select="."/>
        </name>
    </xsl:template>

    <xsl:template match="@code">
        <code>
            <xsl:value-of select="."/>
        </code>
    </xsl:template>

    <xsl:template match="@username">
        <username>
            <xsl:value-of select="."/>
        </username>
    </xsl:template>

    <xsl:template match="@guid">
        <guid>
            <xsl:value-of select="."/>
        </guid>
    </xsl:template>

</xsl:stylesheet>