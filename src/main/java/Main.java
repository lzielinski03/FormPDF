import org.apache.pdfbox.PDFBox;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lzielinski on 11/03/2016.
 */
public class Main {

    public static void main(String[] args) {

        String formPath = "FCAHO023.pdf";

        try {
            // load template
            File file = new File(formPath);
            PDDocument template = PDDocument.load(file);
            PDDocumentCatalog catalog = template.getDocumentCatalog();
            PDAcroForm acroForm = catalog.getAcroForm();
            List<PDField> fields = acroForm.getFields();

            for(PDField field : fields) {
                System.out.println(field.getFullyQualifiedName());
                //field.getAlternateFieldName()
            }
            System.out.println(acroForm.getFields());
            /*
            List<PDPage> pages = catalog.getAllPages();

            for(PDPage page : pages) {
                for(PDAnnotation anotation : page.getAnnotations()) {
                    anotation.getDictionary().
                    System.out.println(anotation.getAnnotationName());
                }
            }*/
            //System.out.println(pages.size());




            //System.out.println(pages.get(1).getAnnotations().get(1).getAnnotationName());

                    /*
            PDAcroForm acroForm = catalog.getAcroForm();



            List<PDField> fieldList = acroForm.getFields();

            for (PDField x : fieldList) {
                System.out.println(x.getFullyQualifiedName());
            }

*/

            template.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    /*  Write a new pdf

    PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);

        try {

            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            PDFont font = PDType1Font.HELVETICA;

            contentStream.beginText();
            contentStream.setFont(font, 12);
            contentStream.moveTextPositionByAmount(10, 1);
            contentStream.drawString("test123");
            contentStream.endText();
            contentStream.close();


            document.save("test.pdf");
            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (COSVisitorException e) {
            e.printStackTrace();
        }
     */
}
