package com.sciamus.contractanalyzerfrontend.views.reports;

import com.sciamus.contractanalyzerfrontend.control.checks.CheckReportDTO;
import com.sciamus.contractanalyzerfrontend.control.checks.ChecksClient;
import com.sciamus.contractanalyzerfrontend.views.main.MainView;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "reports", layout = MainView.class)
@PageTitle("Reports")
@CssImport("./views/about/about-view.css")
public class ReportsView extends Div {

    ChecksClient checksClient;

    @Autowired
    public ReportsView(ChecksClient checksClient) {
        this.checksClient = checksClient;
        addClassName("reports-view");

        Grid<CheckReportDTO> grid = getGrid(checksClient);
        add(grid);
    }

    private Grid<CheckReportDTO> getGrid(ChecksClient checksClient) {
        Grid<CheckReportDTO> grid = new Grid<>(CheckReportDTO.class);

        grid.setItems(checksClient.getAllReports());
        grid.getColumns().forEach(column -> column.setAutoWidth(true));
        grid.setHeightByRows(true);
        return grid;
    }

}
