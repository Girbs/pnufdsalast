package fdsa.edu.pnu.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
public class ExportService {

//    @Autowired
//    private ExcelUtil excelUtil;

    @Autowired
    private ExportPDFUtil exportPDFUtil;

//    public ByteArrayInputStream exportStudentData(List<Postulant> s) {
//        return excelUtil.exportToExcel(s);
//    }

    public void exportPDF(HttpServletResponse httpServletResponse, Integer id) throws IOException {
        exportPDFUtil.export(httpServletResponse, id);
    }
}