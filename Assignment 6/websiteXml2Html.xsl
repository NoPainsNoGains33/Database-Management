<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:output method="html"/>

    <xsl:key name="distinct" match="/website/page/widget" use="@id"></xsl:key>

    <xsl:template match="website">
        <html>
            <body>
                <h1>Website(h1)</h1>
                <h2>Page(h2)</h2>
                <xsl:apply-templates select="page"/>
                <h2>Widgets(h2)</h2>
                <table style="border:1px solid black;border-collapse:collapse;">
                    <tr>
                        <th style="border:1px solid black;">id</th>
                        <th style="border:1px solid black;">type</th>
                        <th style="border:1px solid black;">text</th>
                        <th style="border:1px solid black;">src</th>
                        <th style="border:1px solid black;">url</th>
                        <th style="border:1px solid black;">label</th>
                    </tr>
                    <xsl:for-each select="/website/page/widget[generate-id() = generate-id(key('distinct', ./@id))]">
                        <tr>
                            <td style="border:1px solid black;"><xsl:value-of select="@id"/></td>
                            <td style="border:1px solid black;"><xsl:value-of select="@type"/></td>
                            <td style="border:1px solid black;"><xsl:value-of select="text"/></td>
                            <td style="border:1px solid black;"><xsl:value-of select="@src"/></td>
                            <td style="border:1px solid black;"><xsl:value-of select="@url"/></td>
                            <td style="border:1px solid black;"><xsl:value-of select="@label"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>

    <xsl:template match="page">
        <xsl:number/>.
        <xsl:value-of select="@name"/>,
        <xsl:value-of select="description"/>
        <br/>
    </xsl:template>

</xsl:stylesheet>