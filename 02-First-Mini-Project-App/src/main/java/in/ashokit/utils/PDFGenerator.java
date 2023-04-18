package in.ashokit.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import in.ashokit.entity.CitizenPlan;

@Component
public class PDFGenerator {

	public boolean getReportInPDF(List<CitizenPlan> citizenPlan, HttpServletResponse response, File f)
			throws Exception {

		Document document = new Document(PageSize.A4);

		PdfWriter.getInstance(document, response.getOutputStream());
		PdfWriter.getInstance(document, new FileOutputStream(f));
		document.open();

		Font font = FontFactory.getFont("Arial", 12, BaseColor.BLACK);

		Paragraph paragraph = new Paragraph("All Citizen", font);
		paragraph.setAlignment(Element.ALIGN_CENTER);
		paragraph.setIndentationLeft(50);
		paragraph.setIndentationRight(50);
		paragraph.setSpacingAfter(10);
		document.add(paragraph);

		PdfPTable table = new PdfPTable(8);
		table.setWidthPercentage(100);
		table.setSpacingBefore(10f);
		table.setSpacingAfter(10);
		table.setWidths(new float[] { 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f });
		table.setWidthPercentage(100f);

		PdfPCell CitizenId = new PdfPCell(new Paragraph("ID", font));
		CitizenId.setBorderColor(BaseColor.BLACK);
		CitizenId.setPaddingLeft(10f);
		CitizenId.setHorizontalAlignment(Element.ALIGN_CENTER);
		CitizenId.setVerticalAlignment(Element.ALIGN_CENTER);
		CitizenId.setExtraParagraphSpace(5f);
		CitizenId.setBackgroundColor(BaseColor.GRAY);
		table.addCell(CitizenId);

		PdfPCell holderValue = new PdfPCell(new Paragraph("Holder", font));
		holderValue.setBorderColor(BaseColor.BLACK);
		holderValue.setPaddingLeft(10f);
		holderValue.setHorizontalAlignment(Element.ALIGN_CENTER);
		holderValue.setVerticalAlignment(Element.ALIGN_CENTER);
		holderValue.setExtraParagraphSpace(5f);
		holderValue.setBackgroundColor(BaseColor.GRAY);
		table.addCell(holderValue);

		PdfPCell genderValue = new PdfPCell(new Paragraph("Gender", font));
		genderValue.setBorderColor(BaseColor.BLACK);
		genderValue.setPaddingLeft(10f);
		genderValue.setHorizontalAlignment(Element.ALIGN_CENTER);
		genderValue.setVerticalAlignment(Element.ALIGN_CENTER);
		genderValue.setExtraParagraphSpace(5f);
		genderValue.setBackgroundColor(BaseColor.GRAY);
		table.addCell(genderValue);

		PdfPCell PlanValue = new PdfPCell(new Paragraph("Plan Name", font));
		PlanValue.setBorderColor(BaseColor.BLACK);
		PlanValue.setPaddingLeft(10f);
		PlanValue.setHorizontalAlignment(Element.ALIGN_CENTER);
		PlanValue.setVerticalAlignment(Element.ALIGN_CENTER);
		PlanValue.setExtraParagraphSpace(5f);
		PlanValue.setBackgroundColor(BaseColor.GRAY);
		table.addCell(PlanValue);

		PdfPCell statusValue = new PdfPCell(new Paragraph("Plan Status", font));
		statusValue.setBorderColor(BaseColor.BLACK);
		statusValue.setPaddingLeft(10f);
		statusValue.setHorizontalAlignment(Element.ALIGN_CENTER);
		statusValue.setVerticalAlignment(Element.ALIGN_CENTER);
		statusValue.setExtraParagraphSpace(5f);
		statusValue.setBackgroundColor(BaseColor.GRAY);
		table.addCell(statusValue);
		
		PdfPCell startDate = new PdfPCell(new Paragraph("Start Date", font));
		startDate.setBorderColor(BaseColor.BLACK);
		startDate.setPaddingLeft(10f);
		startDate.setHorizontalAlignment(Element.ALIGN_CENTER);
		startDate.setVerticalAlignment(Element.ALIGN_CENTER);
		startDate.setExtraParagraphSpace(5f);
		startDate.setBackgroundColor(BaseColor.GRAY);
		table.addCell(startDate);
		
		PdfPCell endDate = new PdfPCell(new Paragraph("End Date", font));
		endDate.setBorderColor(BaseColor.BLACK);
		endDate.setPaddingLeft(10f);
		endDate.setHorizontalAlignment(Element.ALIGN_CENTER);
		endDate.setVerticalAlignment(Element.ALIGN_CENTER);
		endDate.setExtraParagraphSpace(5f);
		endDate.setBackgroundColor(BaseColor.GRAY);
		table.addCell(endDate);
		
		PdfPCell benifitAmt = new PdfPCell(new Paragraph("Benifit Amount", font));
		benifitAmt.setBorderColor(BaseColor.BLACK);
		benifitAmt.setPaddingLeft(10f);
		benifitAmt.setHorizontalAlignment(Element.ALIGN_CENTER);
		benifitAmt.setVerticalAlignment(Element.ALIGN_CENTER);
		benifitAmt.setExtraParagraphSpace(5f);
		benifitAmt.setBackgroundColor(BaseColor.GRAY);
		table.addCell(benifitAmt);

		for (CitizenPlan c : citizenPlan) {

			PdfPCell id = new PdfPCell(new Paragraph(c.getCitizenId().toString(), font));
			id.setBorderColor(BaseColor.BLACK);
			id.setPaddingLeft(10f);
			id.setHorizontalAlignment(Element.ALIGN_CENTER);
			id.setVerticalAlignment(Element.ALIGN_CENTER);
			id.setExtraParagraphSpace(5f);
			table.addCell(id);

			PdfPCell holder = new PdfPCell(new Paragraph(c.getCitizenName(), font));
			holderValue.setBorderColor(BaseColor.BLACK);
			holder.setPaddingLeft(10f);
			holder.setHorizontalAlignment(Element.ALIGN_CENTER);
			holder.setVerticalAlignment(Element.ALIGN_CENTER);
			holder.setExtraParagraphSpace(5f);
			table.addCell(holder);

			PdfPCell gender = new PdfPCell(new Paragraph(c.getGender(), font));
			gender.setBorderColor(BaseColor.BLACK);
			gender.setPaddingLeft(10f);
			gender.setHorizontalAlignment(Element.ALIGN_CENTER);
			gender.setVerticalAlignment(Element.ALIGN_CENTER);
			gender.setExtraParagraphSpace(5f);
			table.addCell(gender);

			PdfPCell Plan = new PdfPCell(new Paragraph(c.getPlanName(), font));
			Plan.setBorderColor(BaseColor.BLACK);
			Plan.setPaddingLeft(10f);
			Plan.setHorizontalAlignment(Element.ALIGN_CENTER);
			Plan.setVerticalAlignment(Element.ALIGN_CENTER);
			Plan.setExtraParagraphSpace(5f);
			table.addCell(Plan);

			PdfPCell status = new PdfPCell(new Paragraph(c.getPlanStatus(), font));
			status.setBorderColor(BaseColor.BLACK);
			status.setPaddingLeft(10f);
			status.setHorizontalAlignment(Element.ALIGN_CENTER);
			status.setVerticalAlignment(Element.ALIGN_CENTER);
			status.setExtraParagraphSpace(5f);
			table.addCell(status);

			String sDate = null;
			if (c.getPlanStartDate() != null) {
				sDate = c.getPlanStartDate() + "";

			} else {
				sDate = "N/A";
			}
			PdfPCell start = new PdfPCell(new Paragraph(sDate, font));
			start.setBorderColor(BaseColor.BLACK);
			start.setPaddingLeft(10f);
			start.setHorizontalAlignment(Element.ALIGN_CENTER);
			start.setVerticalAlignment(Element.ALIGN_CENTER);
			start.setExtraParagraphSpace(5f);
			table.addCell(start);

			String eDate = null;
			if (c.getPlanStartDate() != null) {
				eDate = c.getPlanStartDate() + "";

			} else {
				eDate = "N/A";
			}
			PdfPCell end = new PdfPCell(new Paragraph(eDate, font));
			end.setBorderColor(BaseColor.BLACK);
			end.setPaddingLeft(10f);
			end.setHorizontalAlignment(Element.ALIGN_CENTER);
			end.setVerticalAlignment(Element.ALIGN_CENTER);
			end.setExtraParagraphSpace(5f);
			table.addCell(end);

			String bAmt = null;
			if (c.getBenefitAmount()!= null) {
				bAmt = c.getBenefitAmount() + "";

			} else {
				bAmt = "N/A";
			}
			PdfPCell amt = new PdfPCell(new Paragraph(bAmt, font));
			amt.setBorderColor(BaseColor.BLACK);
			amt.setPaddingLeft(10f);
			amt.setHorizontalAlignment(Element.ALIGN_CENTER);
			amt.setVerticalAlignment(Element.ALIGN_CENTER);
			amt.setExtraParagraphSpace(5f);
			table.addCell(amt);

		}
		document.add(table);
		document.close();

		return true;

	}

}
