<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:fo="http://www.w3.org/1999/XSL/Format">

    <!-- Root template -->
    <xsl:template match="/players">
        <fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
            <fo:layout-master-set>
                <fo:simple-page-master master-name="simple" page-height="29.7cm" page-width="21cm" margin="2cm">
                    <fo:region-body/>
                    <fo:region-after extent="1cm"/>
                </fo:simple-page-master>
            </fo:layout-master-set>

            <fo:page-sequence master-reference="simple" id="last-page">
                <fo:static-content flow-name="xsl-region-after">
                    <fo:block text-align="center" font-size="10pt">
                        Page <fo:page-number/> of <fo:page-number-citation-last ref-id="last-page"/>
                    </fo:block>
                </fo:static-content>

                <fo:flow flow-name="xsl-region-body">
                    <fo:table table-layout="fixed" width="100%" border="1pt solid black">
                        <!-- Table header -->
                        <fo:table-header>
                            <fo:table-row border="1pt solid black">
                                <fo:table-cell border="1pt solid black">
                                    <fo:block font-weight="bold">Name</fo:block>
                                </fo:table-cell>
                                <fo:table-cell border="1pt solid black">
                                    <fo:block font-weight="bold">Country</fo:block>
                                </fo:table-cell>
                                <fo:table-cell border="1pt solid black">
                                    <fo:block font-weight="bold">Role</fo:block>
                                </fo:table-cell>
                                <fo:table-cell border="1pt solid black">
                                    <fo:block font-weight="bold">Price</fo:block>
                                </fo:table-cell>
                            </fo:table-row>
                        </fo:table-header>

                        <!-- Table body -->
                        <fo:table-body>
                            <xsl:for-each select="player">
                                <fo:table-row border="1pt solid black">
                                    <fo:table-cell border="1pt solid black">
                                        <fo:block>
                                            <xsl:value-of select="name"/>
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border="1pt solid black">
                                        <fo:block>
                                            <xsl:value-of select="country"/>
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border="1pt solid black">
                                        <fo:block>
                                            <xsl:value-of select="role"/>
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell border="1pt solid black">
                                        <fo:block>
                                            <xsl:value-of select="price"/>
                                        </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                            </xsl:for-each>
                        </fo:table-body>
                    </fo:table>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>

    </xsl:template>

</xsl:stylesheet>