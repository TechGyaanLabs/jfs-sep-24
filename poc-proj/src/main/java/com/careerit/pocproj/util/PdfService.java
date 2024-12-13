package com.careerit.pocproj.util;

import com.careerit.pocproj.pdf.Invoice;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;
import org.json.JSONObject;
import org.json.XML;

import javax.xml.transform.*;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PdfService {

    private String xsltFilePath = "";
    private Map<String, Object> data;
    private String rootElement = "root";
    private String fileName = "demo.pdf";


    public File generateInvoicePdf() {
        File pdfFile = null;
        try {
            File xsltFile = new File(xsltFilePath);
            FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());
            FOUserAgent foUserAgent = fopFactory.newFOUserAgent();
            String tempDir = System.getProperty("java.io.tmpdir");
            pdfFile = new File(tempDir, fileName);
            try (OutputStream out = new FileOutputStream(pdfFile)) {
                Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, out);
                TransformerFactory factory = TransformerFactory.newInstance();
                Transformer transformer = factory.newTransformer(new StreamSource(xsltFile));
                String xmlString = convertToXml(data, rootElement);
                Source src = new StreamSource(new ByteArrayInputStream(xmlString.getBytes()));
                Result res = new SAXResult(fop.getDefaultHandler());

                transformer.transform(src, res);
            } catch (TransformerException e) {
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return pdfFile;

    }

    private String convertToXml(Map<String, Object> map, String root) {
        JSONObject jsonObject = new JSONObject(map);
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?><" + root + ">" + XML.toString(jsonObject) + "</" + root + ">";
    }
}
