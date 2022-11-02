package fdsa.edu.pnu.Config;

import com.lowagie.text.Font;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import fdsa.edu.pnu.Model.Postulant;
import fdsa.edu.pnu.Repository.PostulantDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;

@Service
public class ExportPDFUtil {

    @Autowired
    private PostulantDAO postulantDAO;

    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.BLACK);

        cell.setPhrase(new Phrase("Id", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("PP", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Name", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Address", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Contact", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Doc Url", font));
        table.addCell(cell);
    }

    private void writeTableData(PdfPTable table, Postulant postulant) throws IOException {
//        for (Postulant postulant : studentList) {
            //Image image = Image.getInstance(postulant.getPhotoProfil());
           // table.addCell(String.valueOf(postulant.getId()));
           // table.addCell(image);
            table.addCell(postulant.getNom());
            table.addCell(postulant.getPrenom());
            table.addCell(postulant.getEmail());
            //table.addCell(postulant.getLienFichier());
//            break;
//        }
    }

    public void export(HttpServletResponse response, Integer id) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.ORANGE);

        Paragraph p = new Paragraph("Here's the exported data", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);

        document.add(p);

        PdfPTable table = new PdfPTable(6);
        table.setWidthPercentage(100f);
        table.setWidths(new float[]{0.5f, 1.0f, 3.5f, 3.0f, 3.0f, 1.5f});
        table.setSpacingBefore(10);

        writeTableHeader(table);

       Postulant postulant = postulantDAO.findById(id).get();
      //  writeTableData(table, postulant);
//        List<Postulant> postulants = postulantDAO.findAll();
//        writeTableData(table, postulants);
        table.addCell("TEXT");

        document.add(table);

        document.close();

    }
}