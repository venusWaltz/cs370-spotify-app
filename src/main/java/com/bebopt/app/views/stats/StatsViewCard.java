package com.bebopt.app.views.stats;

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

public class StatsViewCard extends ListItem {

    public StatsViewCard(String artist, String url) {
        String size = "122px";

        addClassNames(Background.CONTRAST_5, Display.GRID, FlexDirection.COLUMN, AlignItems.START, Padding.SMALL,
                BorderRadius.LARGE);

        Div div = new Div();
        div.addClassNames(Background.CONTRAST, Display.FLEX, AlignItems.CENTER, JustifyContent.CENTER,
                Margin.Bottom.NONE, Overflow.HIDDEN, BorderRadius.MEDIUM, Width.AUTO);
        div.setHeight(size);
        div.setWidth(size);

        Image image = new Image();
        image.setHeight("100%");
        image.setSrc(url);

        div.add(image);

        Span header = new Span();
        header.addClassNames(FontSize.LARGE, FontWeight.SEMIBOLD);
        header.setText(artist);

        add(div, header);
    }
}
