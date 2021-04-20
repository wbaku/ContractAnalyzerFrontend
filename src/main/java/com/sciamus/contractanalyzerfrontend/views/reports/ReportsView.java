package com.sciamus.contractanalyzerfrontend.views.reports;

import com.sciamus.contractanalyzerfrontend.control.GetReportsClient;
import com.sciamus.contractanalyzerfrontend.control.RunCheckClientResponseDTO;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import com.sciamus.contractanalyzerfrontend.views.main.MainView;
import com.vaadin.flow.component.dependency.CssImport;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "reports", layout = MainView.class)
@PageTitle("Reports")
@CssImport("./views/about/about-view.css")
public class ReportsView extends Div {

    GetReportsClient getReportsClient;

    @Autowired
    public ReportsView(GetReportsClient getReportsClient) {
        this.getReportsClient = getReportsClient;
        addClassName("reports-view");


        Grid<RunCheckClientResponseDTO> grid = new Grid<>(RunCheckClientResponseDTO.class);

        System.out.println(getReportsClient.getAllReports());

        grid.setItems(getReportsClient.getAllReports().stream());

        add(grid);




    }

}
