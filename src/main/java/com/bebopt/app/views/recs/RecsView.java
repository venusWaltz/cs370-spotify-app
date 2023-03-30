package com.bebopt.app.views.recs;

import com.bebopt.app.domain.Track;
import com.bebopt.app.views.MainLayout;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;
import com.vaadin.flow.theme.lumo.LumoUtility.MaxWidth;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;

@PageTitle("Recommendations")
@Route(value = "recs", layout = MainLayout.class)
public class RecsView extends Main {

    Grid<Track> grid = new Grid<>();    // empty

    private TextField searchField;
    private Button searchButton;
    
    public RecsView() {
        addClassName("recs-view");
        addClassNames(MaxWidth.SCREEN_XLARGE, Margin.Horizontal.AUTO, Padding.Bottom.LARGE);
        setSizeFull();
        VerticalLayout verticalLayout = new VerticalLayout();
        HorizontalLayout horizontalLayout = new HorizontalLayout();

        searchField = new TextField();
        searchButton = new Button("Search for songs");

        // search for songs when search button is clicked
        searchButton.addClickListener(e -> {
                Notification.show("Searching for \"" + searchField.getValue() + "\"");
                // Add Spotify search here

        });
        searchButton.addClickShortcut(Key.ENTER);

        grid.setHeight("100%");
        grid.addThemeVariants(GridVariant.LUMO_NO_BORDER, GridVariant.LUMO_NO_ROW_BORDERS);
        grid.addComponentColumn(track -> createCard(track));
        
        // add components to view
        horizontalLayout.add(searchField, searchButton);
        horizontalLayout.setSizeFull();
        horizontalLayout.setFlexGrow(1,searchField); // allow searchField to fill available space
        verticalLayout.add(horizontalLayout);
        add(verticalLayout);
    }

    private HorizontalLayout createCard(Track track) {
        HorizontalLayout card = new HorizontalLayout();
        card.addClassName("card");
        card.setSpacing(false);
        card.getThemeList().add("spacing-s");

        Image image = new Image();
        image.setSrc(track.getImage());
        VerticalLayout description = new VerticalLayout();
        description.addClassName("description");
        description.setSpacing(false);
        description.setPadding(false);

        HorizontalLayout header = new HorizontalLayout();
        header.addClassName("header");
        header.setSpacing(false);
        header.getThemeList().add("spacing-s");

        HorizontalLayout actions = new HorizontalLayout();
        actions.addClassName("actions");
        actions.setSpacing(false);
        actions.getThemeList().add("spacing-s");

        description.add(header, actions);
        card.add(image, description);
        return card;
    }

}
