package com.busticket.busticket_bookingsystem.service.inter;


import com.busticket.busticket_bookingsystem.dto.response.ReportResponse;

public interface ReportService {

    ReportResponse getTotalRevenue(String startDate, String endDate, String timeOption);

    ReportResponse getCoachUsage(String startDate, String endDate, String timeOption);

    ReportResponse getWeekTotalRevenueOfCurrentDate(String currentDate);

    ReportResponse getTopRoute(String startDate, String endDate, String timeOption);

    ReportResponse getWeeklyPointsReport(String startDate, String endDate);
    ReportResponse getMonthlyPointsReport(String startDate, String endDate);
    ReportResponse getYearlyPointsReport(String startDate, String endDate);
}
