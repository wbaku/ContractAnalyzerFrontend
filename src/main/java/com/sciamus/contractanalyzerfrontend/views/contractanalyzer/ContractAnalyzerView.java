package com.sciamus.contractanalyzerfrontend.views.contractanalyzer;

import com.sciamus.contractanalyzerfrontend.control.GetChecksClient;
import com.sciamus.contractanalyzerfrontend.control.GetReportsClient;
import com.sciamus.contractanalyzerfrontend.control.RunCheckClient;
import com.sciamus.contractanalyzerfrontend.views.main.MainView;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.notification.Notification;
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

        add(new Text("List of checks to run:"));

        ListBox<String> listBox = new ListBox<>();

        List<String> listOfAvailableChecks = client.getListOfChecks().listOfChecks;

        listBox.setItems(listOfAvailableChecks.stream());

        listBox.setValue(listOfAvailableChecks.get(0));


        listBox.addValueChangeListener(event -> Notification.show("Check chosen: " + event.getValue()));

        Button runButton = new Button("Run check");

        TextField urlField = new TextField();
        urlField.setLabel("Please enter URL: ");
        urlField.setHelperText("This points to the server on which the test will be run");


        urlField.setClearButtonVisible(true);
        urlField.setValue("http://localhost:8080");

        runButton.addClickListener(event -> runCheckClient.runCheck(listBox.getValue(), urlField.getValue()));


        add(listBox, runButton, urlField);

    }
}
