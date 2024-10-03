package languagetables;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;

import java.awt.*;
import java.io.File;
import java.nio.file.Path;

public class BaseDocumentGenerator implements DocumentGenerator {

    @Override
    public void generateDoc(Word[] words, Path docPath) throws GeneratorException {
        try {
            createPdf(words, docPath);
        } catch (Exception e) {
            throw new GeneratorException(e);
        }
    }

    private static void createPdf(Word[] words, Path docPath) throws Exception {
        PDDocument helloPdf = new PDDocument();
        PDPage page = new PDPage(new PDRectangle(PDRectangle.A4.getHeight(), PDRectangle.A4.getWidth()));
        helloPdf.addPage(page);

        PDRectangle pageRect = page.getMediaBox();
        float d = 10;
        float x = pageRect.getLowerLeftX();
        float y = pageRect.getLowerLeftX();
        float width = pageRect.getWidth();
        float height = pageRect.getHeight();

        PDPageContentStream content = new PDPageContentStream(helloPdf, page);

        content.addRect(d + x, d + y, width - 2 * d, height - 2 * d);
        content.setStrokingColor(Color.BLACK);
        content.stroke();

        float dx = width / words.length;
        for (int i = 0; i < words.length; i++) {
            float lx = d + x + i * dx;
            content.beginText();
            content.setFont(new PDType1Font(Standard14Fonts.FontName.COURIER_BOLD), 30);
            content.newLineAtOffset(lx, width / 2);
            content.showText(words[i].getMain());
            content.endText();

            content.moveTo(lx, d);
            content.lineTo(lx, height - d);
            content.stroke();
        }

        content.close();

        helloPdf.save(docPath.toFile());
        helloPdf.close();
    }
}
