package com.epw.activities.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DashboardSummaryResponse {
    private int completed;
    private int pending;
    private int cancelled;
    private List<MonthlySale> monthlySales;
    private List<TopProduct> topProducts;
}