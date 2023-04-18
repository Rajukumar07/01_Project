package in.ashokit.services;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import in.ashokit.dto.SearchRequest;
import in.ashokit.entity.CitizenPlan;

public interface ReportService {

	public List<String> getByPlanName();

	public List<String> getByPlanStatus();

	public List<CitizenPlan> handleSearchBtn(SearchRequest searchRequest);

	public void exportPDF(HttpServletResponse response) throws Exception;

	public void getReportInExcel(HttpServletResponse response) throws Exception;

}
