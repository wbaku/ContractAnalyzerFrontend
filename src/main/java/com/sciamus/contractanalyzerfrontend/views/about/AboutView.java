package com.sciamus.contractanalyzerfrontend.views.about;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import com.sciamus.contractanalyzerfrontend.views.main.MainView;
import com.vaadin.flow.component.dependency.CssImport;

@Route(value = "about", layout = MainView.class)
@PageTitle("About")
@CssImport("./views/about/about-view.css")
public class AboutView extends Div {

    public AboutView() {
        addClassName("about-view");

        VerticalLayout verticalLayout = new VerticalLayout();

        verticalLayout.add(new Label("REST contract analyzer. From SCIAMUS with love"));

        add(verticalLayout);
    }

}
