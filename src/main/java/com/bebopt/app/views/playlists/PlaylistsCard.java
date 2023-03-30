package com.bebopt.app.views.playlists;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.theme.lumo.LumoUtility.AlignItems;
import com.vaadin.flow.theme.lumo.LumoUtility.Background;
import com.vaadin.flow.theme.lumo.LumoUtility.BorderRadius;
import com.vaadin.flow.theme.lumo.LumoUtility.Display;
import com.vaadin.flow.theme.lumo.LumoUtility.FlexDirection;
import com.vaadin.flow.theme.lumo.LumoUtility.FontSize;
import com.vaadin.flow.theme.lumo.LumoUtility.FontWeight;
import com.vaadin.flow.theme.lumo.LumoUtility.JustifyContent;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;
import com.vaadin.flow.theme.lumo.LumoUtility.Overflow;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;
import com.vaadin.flow.theme.lumo.LumoUtility.Width;

// fix later
// should display ~5/6 playlists on each line
// or could display playlists in list/grid format
public class PlaylistsCard extends ListItem {

    public PlaylistsCard(String text, String url) {
        addClassNames(Background.CONTRAST_5, Display.FLEX, FlexDirection.COLUMN, AlignItems.START, Padding.MEDIUM,
                BorderRadius.LARGE);

        Div div = new Div();
        div.addClassNames(Background.CONTRAST, Display.FLEX, AlignItems.CENTER, JustifyContent.CENTER,
                Margin.Bottom.XSMALL, Overflow.HIDDEN, BorderRadius.MEDIUM, Width.AUTO);
        div.setHeight("100px");
        div.setWidth("100px");

        Image image = new Image();
        image.setWidth("200%");
        image.setSrc(url);
        image.setAlt(text);

        div.add(image);

        // Replace with playlist data later
        Span header = new Span();
        header.addClassNames(FontSize.MEDIUM, FontWeight.SEMIBOLD);
        header.setText("New Playlist");

        add(div, header);
    }
}
