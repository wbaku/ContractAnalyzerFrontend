package com.sciamus.contractanalyzerfrontend.views.contractanalyzer;

import com.sciamus.contractanalyzerfrontend.control.checks.ChecksClient;
import com.sciamus.contractanalyzerfrontend.views.main.MainView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
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

    private final ChecksClient checksClient;


    @Autowired
    public ContractAnalyzerView(ChecksClient checksClient) {
        this.checksClient = checksClient;

        addClassName("contract-analyzer-view");


        Label presentationText = new Label("List of checks to run:");

        ListBox<String> listOfChecksToRun = getListBox(checksClient);
//        listOfChecksToRun.addValueChangeListener(event -> Notification.show("Check chosen: " + event.getValue()));
        TextField urlField = getTextField();
        Button runButton = getButton(checksClient, listOfChecksToRun, urlField);
        VerticalLayout verticalLayout = getVerticalLayout(presentationText, listOfChecksToRun, urlField, runButton);
//        verticalLayout.setPadding(true);

        add(verticalLayout);
    }

    private VerticalLayout getVerticalLayout(Label presentationText, ListBox<String> listOfChecksToRun, TextField urlField, Button runButton) {
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.add(presentationText, listOfChecksToRun, urlField, runButton);
        return verticalLayout;
    }

    private Button getButton(ChecksClient checksClient, ListBox<String> listOfChecksToRun, TextField urlField) {
        Button runButton = new Button("Run check");
        runButton.setWidth("150px");
        runButton.addClickListener(event -> checksClient.runCheck(listOfChecksToRun.getValue(), urlField.getValue()));
        return runButton;
    }

    private ListBox<String> getListBox(ChecksClient client) {
        ListBox<String> listOfChecksToRun = new ListBox<>();

        List<String> listOfAvailableChecks = client.getListOfChecks().listOfChecks;

        listOfChecksToRun.setItems(listOfAvailableChecks.stream());

        listOfChecksToRun.setValue(listOfAvailableChecks.get(0));
        return listOfChecksToRun;
    }

    private TextField getTextField() {
        TextField urlField = new TextField();
        urlField.setLabel("Please enter URL: ");
        urlField.setHelperText("This points to the server on which the test will be run");
        urlField.setWidth("500px");
        urlField.setClearButtonVisible(true);
        urlField.setAutoselect(true);
        urlField.setValue("http://localhost:8080");
        return urlField;
    }
}
