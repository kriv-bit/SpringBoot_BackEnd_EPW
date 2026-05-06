// DashboardServiceImpl.java
package com.epw.activities.service.impl;

import com.epw.activities.dto.DashboardSummaryResponse;
import com.epw.activities.dto.MonthlySale;
import com.epw.activities.dto.TopProduct;
import com.epw.activities.service.DashboardService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DashboardServiceImpl implements DashboardService {

    @Override
    public DashboardSummaryResponse getSummary() {
        // Datos de prueba (más adelante vendrán de JPA, por ejemplo)
        List<MonthlySale> monthlySales = Arrays.asList(
                new MonthlySale("Enero", 1200),
                new MonthlySale("Febrero", 1800),
                new MonthlySale("Marzo", 900),
                new MonthlySale("Abril", 2200),
                new MonthlySale("Mayo", 3100),
                new MonthlySale("Julio", 3200)

        );

        List<TopProduct> topProducts = Arrays.asList(
                new TopProduct("Laptop", 35),
                new TopProduct("Mouse", 80),
                new TopProduct("Teclado", 40),
                new TopProduct("Monitor", 25)
        );

        return new DashboardSummaryResponse(120, 45, 10, monthlySales, topProducts);
    }
}