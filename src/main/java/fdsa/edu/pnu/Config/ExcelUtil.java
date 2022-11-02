package fdsa.edu.pnu.Config;


import org.springframework.stereotype.Service;
@Service
public class ExcelUtil {
//
//    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
//    static String[] HEADERS = {"Id", "Name", "Address", "Contact", "Documents"};
//    static String SHEET = "Students";
//
//    public ByteArrayInputStream exportToExcel(List<Postulant> students) {
//
//        try (Workbook workbook = new XSSFWorkbook();
//             ByteArrayOutputStream out = new ByteArrayOutputStream()) {
//            Sheet sheet = workbook.createSheet(SHEET);
//
//            // Header
//            Row headerRow = sheet.createRow(0);
//
//            for (int col = 0; col < HEADERS.length; col++) {
//                Cell cell = headerRow.createCell(col);
//                cell.setCellValue(HEADERS[col]);
//            }
//
//            int rowIdx = 1;
//            for (Student student : students) {
//                Row row = sheet.createRow(rowIdx++);
//
//                row.createCell(0).setCellValue(student.getStudentId());
//                row.createCell(1).setCellValue(student.getStudentName());
//                row.createCell(2).setCellValue(student.getStudentAddress());
//                row.createCell(3).setCellValue(student.getStudentContact());
//                row.createCell(4).setCellValue(student.getStudentDocumentURL());
//            }
//
//            workbook.write(out);
//            return new ByteArrayInputStream(out.toByteArray());
//        } catch (IOException | IOException e) {
//            throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
//
//        }
//    }
}