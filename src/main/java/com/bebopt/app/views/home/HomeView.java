package com.bebopt.app.views.home;

import com.bebopt.app.views.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;

@PageTitle("Home")
@Route(value = "home", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class HomeView extends VerticalLayout {

    public HomeView() {
        setSpacing(false);

        H2 header = new H2("Welcome!");
        header.addClassNames(Margin.Top.XLARGE, Margin.Bottom.MEDIUM);
        add(header);
        add(new Paragraph("View your Spotify statistics and manage your playlists here."));

        Anchor anchor = new Anchor();
        anchor.setText("Spotify Login");
        Button button = new Button(anchor);

        // fix button url later
        // anchor.setHref("https://accounts.spotify.com/authorize");   

        setSizeFull();
        setJustifyContentMode(JustifyContentMode.START);
        getStyle().set("text-align", "center");

        setMargin(true);
        setHorizontalComponentAlignment(Alignment.START, button);

        add(button);
    }
}
