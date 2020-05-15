<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="xml" indent="yes"/>

    <xsl:template match="site">
        <website>
                <xsl:attribute name="id">
                    <xsl:value-of select="@id"/>
                </xsl:attribute>
                <xsl:attribute name="name">
                    <xsl:value-of select="@name"/>
                </xsl:attribute>
            <description>
                <xsl:value-of select="@description"/>
            </description>
            <xsl:apply-templates select="views"/>
        </website>
    </xsl:template>

    <xsl:template match="views">
        <xsl:apply-templates select="view"/>
    </xsl:template>

    <xsl:template match="view">
    <page>
        <xsl:attribute name="id">
            <xsl:value-of select="@id"/>
        </xsl:attribute>
        <xsl:attribute name="name">
            <xsl:value-of select="@name"/>
        </xsl:attribute>
        <description><xsl:value-of select="description"/></description>
        <xsl:apply-templates select="component"/>
    </page>
    </xsl:template>

    <xsl:template match="component">
        <xsl:apply-templates select="/site/components/component[@id=current()/@ref]"/>
    </xsl:template>

    <xsl:template match = "/site/components/component">
        <widget>
            <xsl:copy-of select="@*"/>
            <xsl:copy-of select="*"/>
        </widget>
    </xsl:template>

</xsl:stylesheet>
