package com.sciamus.contractanalyzerfrontend.views.contractanalyzer;

import com.sciamus.contractanalyzerfrontend.control.GetChecksClient;
import com.sciamus.contractanalyzerfrontend.views.main.MainView;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "start", layout = MainView.class)
@RouteAlias(value = "", layout = MainView.class)
@PageTitle("ContractAnalyzer")
@CssImport("./views/contractanalyzer/contract-analyzer-view.css")


public class ContractAnalyzerView extends Div {

    private  final GetChecksClient client;


    @Autowired
    public ContractAnalyzerView(GetChecksClient client) {
        this.client = client;

        addClassName("contract-analyzer-view");

        add(new Text("List of checks to run:"));
        ListBox<String> listBox = new ListBox<>();

        //trzeba przeanalizować tę metodę setItems, bo
        listBox.setItems(client.getListOfChecks().listOfChecks.stream());

//        listBox.setItems(client.getListOfChecks());

//        Button runButton = new Button("Run check");
//        runButton.addClickListener();

        add(listBox);
    }
}
