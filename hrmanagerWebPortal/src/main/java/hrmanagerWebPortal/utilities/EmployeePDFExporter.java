package hrmanagerWebPortal.utilities;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import hrmanagerWebPortal.dto.Employee;

public class EmployeePDFExporter {

	private List<Employee> empList;

	public EmployeePDFExporter(List<Employee> empList) {
		ObjectMapper mapper = new ObjectMapper();
		 List<Employee> empMapping = mapper.convertValue(empList, new TypeReference<List<Employee>>() { });
		this.empList = empMapping;
	}

	private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setPadding(5);
         
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
      
         
        cell.setPhrase(new Phrase("Employee Code", font));
      
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Employee Name", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Location", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Email", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Date-Of-Birth", font));
        table.addCell(cell);       
    }
	  private void writeTableData(PdfPTable table) {
		  
	        for (Employee emp : empList) {
	            table.addCell(Integer.toString(emp.getEmpCode()));
	            table.addCell(emp.getEmpName());
	            table.addCell(emp.getLoc());
	            table.addCell(emp.getEmail());
	            table.addCell(emp.getDob());
	        }
	    }
	  public void export(HttpServletResponse response) throws DocumentException, IOException {
	        Document document = new Document(PageSize.A4);
	        PdfWriter.getInstance(document, response.getOutputStream());
	         
	        document.open();
	        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	        font.setSize(18);
	         
	        Paragraph p = new Paragraph("List of Employees", font);
	        p.setAlignment(Paragraph.ALIGN_CENTER);
	         
	        document.add(p);
	         
	        PdfPTable table = new PdfPTable(5);
	        table.setWidthPercentage(100f);
	        table.setWidths(new float[] {3.0f, 3.0f, 3.0f, 3.0f, 2.5f});
	        table.setSpacingBefore(10);
	        
	         
	        writeTableHeader(table);
	        writeTableData(table);
	         
	        document.add(table);
	         
	        document.close();
	         
	    }
     
}
