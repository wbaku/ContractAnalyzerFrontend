package com.sciamus.contractanalyzerfrontend.views.suites;

import com.sciamus.contractanalyzerfrontend.control.suites.SuiteReportDTO;
import com.sciamus.contractanalyzerfrontend.control.suites.SuitesClient;
import com.sciamus.contractanalyzerfrontend.views.main.MainView;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;


@Route(value = "suites", layout = MainView.class)
@PageTitle("Suites")
@CssImport("./views/about/about-view.css")


public class SuiteReportsView extends Div {

    SuitesClient suitesClient;

    @Autowired
    public SuiteReportsView(SuitesClient suitesClient) {

        this.suitesClient = suitesClient;
        addClassName("suites-view");

        Grid<SuiteReportDTO> grid = getGrid(suitesClient);

        add(grid);


    }
    private Grid<SuiteReportDTO> getGrid(SuitesClient suitesClient) {
        Grid<SuiteReportDTO> grid = new Grid<>(SuiteReportDTO.class);
        grid.setItems(suitesClient.getAllReports());
        grid.getColumns().forEach(column -> column.setAutoWidth(true));
        grid.setHeightByRows(true);
        return grid;
    }


}
