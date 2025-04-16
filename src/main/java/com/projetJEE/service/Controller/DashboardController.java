package com.projetJEE.Controller;

import com.projetJEE.ServicesImpl.DashboardService;
import com.projetJEE.model.DashboardModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;
    @GetMapping("/generate")
    public DashboardModel genrateDashboard(){
        return dashboardService.genrateDashboard();
    }
}
