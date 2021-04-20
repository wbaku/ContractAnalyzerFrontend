package com.sciamus.contractanalyzerfrontend.views.contractanalyzer;

import com.sciamus.contractanalyzerfrontend.control.GetChecksClient;
import com.sciamus.contractanalyzerfrontend.control.RunCheckClient;
import com.sciamus.contractanalyzerfrontend.views.main.MainView;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Route(value = "start", layout = MainView.class)
@RouteAlias(value = "", layout = MainView.class)
@PageTitle("ContractAnalyzer")
@CssImport("./views/contractanalyzer/contract-analyzer-view.css")


public class ContractAnalyzerView extends Div {

    //    private final GetChecksClient client;
    private final RunCheckClient runCheckClient;
    private final GetChecksClient getChecksClient;


    @Autowired
    public ContractAnalyzerView(GetChecksClient client, RunCheckClient runCheckClient) {
        this.getChecksClient = client;
        this.runCheckClient = runCheckClient;

        addClassName("contract-analyzer-view");

        ListBox<String> listOfChecksToRun = new ListBox<>();

        List<String> listOfAvailableChecks = client.getListOfChecks().listOfChecks;

        listOfChecksToRun.setItems(listOfAvailableChecks.stream());

        listOfChecksToRun.setValue(listOfAvailableChecks.get(0));

//        listOfChecksToRun.addValueChangeListener(event -> Notification.show("Check chosen: " + event.getValue()));

        TextField urlField = new TextField();
        urlField.setLabel("Please enter URL: ");
        urlField.setHelperText("This points to the server on which the test will be run");
        urlField.setWidth("500px");
        urlField.setClearButtonVisible(true);
        urlField.setValue("http://localhost:8080");


        Button runButton = new Button("Run check");
        runButton.setWidth("150px");
        runButton.addClickListener(event -> runCheckClient.runCheck(listOfChecksToRun.getValue(), urlField.getValue()));


        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.add(new Text("List of checks to run:"), listOfChecksToRun, urlField, runButton);

        add(verticalLayout);

    }
}
