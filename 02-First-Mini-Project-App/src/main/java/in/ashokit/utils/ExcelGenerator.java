package in.ashokit.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;

import in.ashokit.entity.CitizenPlan;

@Component
public class ExcelGenerator {

	public void excel(List<CitizenPlan> plans, File f) throws Exception {
		try (Workbook workbook = new HSSFWorkbook()) {
			Sheet sheet = workbook.createSheet("Plan-data");
			Row headerRow = sheet.createRow(0);

			headerRow.createCell(0).setCellValue("ID");
			headerRow.createCell(1).setCellValue("Citizen Name");
			headerRow.createCell(2).setCellValue("Plan Name");
			headerRow.createCell(3).setCellValue("Plan Status");
			headerRow.createCell(4).setCellValue("Plan StartDate");
			headerRow.createCell(5).setCellValue("Plan EndDate");
			headerRow.createCell(6).setCellValue("Benefit Amount");

			int rowSize = 1;

			for (CitizenPlan plan : plans) {

				Row dataRow = sheet.createRow(rowSize);
				dataRow.createCell(0).setCellValue(plan.getCitizenId());
				dataRow.createCell(1).setCellValue(plan.getCitizenName());
				dataRow.createCell(2).setCellValue(plan.getPlanName());
				dataRow.createCell(3).setCellValue(plan.getPlanStatus());
				dataRow.createCell(4).setCellValue(plan.getPlanStartDate()+"");
				dataRow.createCell(5).setCellValue(plan.getPlanEndDate()+"");
				dataRow.createCell(6).setCellValue(plan.getBenefitAmount()+"");

				rowSize++;
			}

			FileOutputStream fos = new FileOutputStream(f);
			workbook.write(fos);
			fos.close();
		}

	}

}
