package com.bebopt.app.views.about;

import com.bebopt.app.views.MainLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;

@PageTitle("About")
@Route(value = "about", layout = MainLayout.class)
public class AboutView extends VerticalLayout {

    public AboutView() {
        setSpacing(false);

        Icon icon = new Icon();
        icon = VaadinIcon.INFO_CIRCLE.create();
        Image img = new Image("images/empty-plant.png", "placeholder plant");
        img.setWidth("100px");
        add(icon);

        H2 header = new H2("About our team");
        header.addClassNames(Margin.Top.LARGE, Margin.Bottom.MEDIUM);
        add(header);
        add(new Paragraph(" "));

        setSizeFull();
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");
    }

}
