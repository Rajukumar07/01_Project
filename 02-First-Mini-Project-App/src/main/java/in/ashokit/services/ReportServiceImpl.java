package in.ashokit.services;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import in.ashokit.dto.SearchRequest;
import in.ashokit.entity.CitizenPlan;
import in.ashokit.repositories.CitizenPlanRepo;
import in.ashokit.utils.EmailUtils;
import in.ashokit.utils.ExcelGenerator;
import in.ashokit.utils.PDFGenerator;

@Service
public class ReportServiceImpl implements ReportService {

	@Autowired
	private CitizenPlanRepo repo;

	@Autowired
	private ExcelGenerator generator;
	@Autowired
	private EmailUtils email;
	@Autowired
	private PDFGenerator pdf;

	@Override
	public List<String> getByPlanName() {
		List<String> name = repo.getPlanName();
		return name;
	}

	@Override
	public List<String> getByPlanStatus() {
		List<String> status = repo.getPlanStatus();
		return status;
	}

	@Override
	public List<CitizenPlan> handleSearchBtn(SearchRequest request) {

		System.out.println(request);

		CitizenPlan entity = new CitizenPlan();

		if (null != request.getPlanName() && "" != request.getPlanName()) {
			entity.setPlanName(request.getPlanName());
		}

		if (!"".equals(request.getPlanStatus()) && null != request.getPlanStatus()) {
			entity.setPlanStatus(request.getPlanStatus());
		}
		if (!"".equals(request.getGender()) && null != request.getGender()) {
			entity.setGender(request.getGender());
		}

		if (!"".equals(request.getStartDate()) && null != request.getStartDate()) {
			String startDate = request.getStartDate();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate date = LocalDate.parse(startDate, formatter);
			entity.setPlanStartDate(date);
		}

		if (!"".equals(request.getEndDate()) && null != request.getEndDate()) {
			String endDate = request.getEndDate();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate date = LocalDate.parse(endDate, formatter);
			entity.setPlanEndDate(date);
		}

		List<CitizenPlan> findAll = repo.findAll(Example.of(entity));
		System.out.println(findAll);

		return findAll;
	}

	@Override
	public void exportPDF(HttpServletResponse response) throws Exception {

		List<CitizenPlan> findAll = repo.findAll();
		File file = new File("plan.pdf");
		pdf.getReportInPDF(findAll,response, file);
		String to = "rajukumar59210@gmail.com";
		String sub = "Test Email";
		String body = "<h1>Test Mail</h1>";
		email.sendEmail(to, sub, body, file);
		file.delete();

	}

	@Override
	public void getReportInExcel(HttpServletResponse response) throws Exception {

		List<CitizenPlan> findAll = repo.findAll();
		File file = new File("plan.xls");
		generator.excel(findAll, file);
		String to = "rajukumar59210@gmail.com";
		String sub = "Test Email";
		String body = "<h1>Test Mail</h1>";
		email.sendEmail(to, sub, body, file);
		file.delete();
	}

}
