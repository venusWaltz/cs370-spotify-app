package com.bebopt.app.views.stats;

import java.util.Arrays;
import java.util.List;

import com.bebopt.app.domain.Artist;
import com.bebopt.app.domain.Track;
import com.bebopt.app.views.MainLayout;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.html.OrderedList;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.tabs.TabSheet;
import com.vaadin.flow.component.tabs.TabSheetVariant;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.AlignItems;
import com.vaadin.flow.theme.lumo.LumoUtility.Background;
import com.vaadin.flow.theme.lumo.LumoUtility.BorderRadius;
import com.vaadin.flow.theme.lumo.LumoUtility.Display;
import com.vaadin.flow.theme.lumo.LumoUtility.FontSize;
import com.vaadin.flow.theme.lumo.LumoUtility.FontWeight;
import com.vaadin.flow.theme.lumo.LumoUtility.JustifyContent;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;
import com.vaadin.flow.theme.lumo.LumoUtility.MaxWidth;
import com.vaadin.flow.theme.lumo.LumoUtility.Overflow;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;
import com.vaadin.flow.theme.lumo.LumoUtility.TextColor;
import com.vaadin.flow.theme.lumo.LumoUtility.Width;

@PageTitle("Statistics")
@Route(value = "stats", layout = MainLayout.class)
public class StatsView extends Main {

    private Div trackTab;
    private Div artistTab;
    private Div genreTab;
    private TabSheet tabsheet;

    public StatsView() {
        tabsheet = new TabSheet();

        // create tab page layouts
        trackTab = createTopTracks();
        artistTab = createTopArtists();
        genreTab = createTopGenres();
 
        // add tabs to tabsheet
        tabsheet.add("Top Tracks", trackTab);
        tabsheet.add("Top Artists", artistTab);
        tabsheet.add("Top Genres", genreTab);
        add(tabsheet);
        
        // distribute tabs evenly
        tabsheet.addThemeVariants(TabSheetVariant.LUMO_TABS_EQUAL_WIDTH_TABS);
    }

    // top tracks tab view
    private Div createTopTracks() {
        Div div = new Div();
        div.addClassNames("stats-view");
        div.addClassNames(MaxWidth.SCREEN_MEDIUM, Margin.Horizontal.AUTO, Padding.Bottom.LARGE, Padding.Horizontal.LARGE);

        HorizontalLayout container = new HorizontalLayout();
        container.addClassNames(AlignItems.CENTER, JustifyContent.BETWEEN);

        VerticalLayout headerContainer = new VerticalLayout();
        H2 header = new H2("Top Tracks");
        header.addClassNames(Margin.Bottom.NONE, Margin.Top.LARGE, FontSize.XXXLARGE);
        headerContainer.add(header);

        // sort select
        Select<String> sortBy = new Select<>();
        sortBy.setItems("Recent", "Last four weeks", "Last six months", "All data");
        sortBy.setValue("Recent");

        // temporary dummy list of tracks
        List<Track> tracks = Arrays.asList(
            new Track("Heat of the Moment", "Asia", "https://i.scdn.co/image/ab67616d0000b2732323f86e757c3436b3cc38af"), 
            new Track("Mr. Blue Sky", "Electric Light Orchestra", "https://i.scdn.co/image/ab67616d0000b2738c4e95986c803791125e8991"),
            new Track("Time in a Bottle", "Jim Croce", "https://i.scdn.co/image/ab67616d0000b27397e92e26bae020503bdff4fb"),
            new Track("(Sittin' On) the Dock of the Bay", "Otis Redding", "https://i.scdn.co/image/ab67616d0000b273b050a4bba4ad96ea639d75b3"),
            new Track("Heat of the Moment", "Asia", "https://i.scdn.co/image/ab67616d0000b2732323f86e757c3436b3cc38af"), 
            new Track("Mr. Blue Sky", "Electric Light Orchestra", "https://i.scdn.co/image/ab67616d0000b2738c4e95986c803791125e8991"),
            new Track("Time in a Bottle", "Jim Croce", "https://i.scdn.co/image/ab67616d0000b27397e92e26bae020503bdff4fb"),
            new Track("(Sittin' On) the Dock of the Bay", "Otis Redding", "https://i.scdn.co/image/ab67616d0000b273b050a4bba4ad96ea639d75b3"),
            new Track("Heat of the Moment", "Asia", "https://i.scdn.co/image/ab67616d0000b2732323f86e757c3436b3cc38af"), 
            new Track("Mr.Blue Sky", "Electric Light Orchestra", "https://i.scdn.co/image/ab67616d0000b2738c4e95986c803791125e8991"),
            new Track("Time in a Bottle", "Jim Croce", "https://i.scdn.co/image/ab67616d0000b27397e92e26bae020503bdff4fb"),
            new Track("(Sittin' On) the Dock of the Bay", "Otis Redding", "https://i.scdn.co/image/ab67616d0000b273b050a4bba4ad96ea639d75b3"),
            new Track("Heat of the Moment", "Asia", "https://i.scdn.co/image/ab67616d0000b2732323f86e757c3436b3cc38af"), 
            new Track("Mr. Blue Sky", "Electric Light Orchestra", "https://i.scdn.co/image/ab67616d0000b2738c4e95986c803791125e8991")
        );
        
        // add tracks to container
        OrderedList trackContainer = new OrderedList();
        for(int i = 0; i < tracks.size(); i++) {
        trackContainer.add(createCard(tracks.get(i), i));
        }

        // add components to layout
        container.add(headerContainer, sortBy);
        div.add(container, trackContainer);

        return div;
    }

    // create a new track card
    private HorizontalLayout createCard(Track track, int index) {
        String height = "50px";

        HorizontalLayout layout = new HorizontalLayout();
        Span num = new Span(String.valueOf(index + 1));
        layout.add(num);
        num.setWidth("15px");
        layout.addClassNames(AlignItems.CENTER);
        
        Div div = new Div();
        div.addClassNames(Background.CONTRAST_5, Display.GRID, AlignItems.CENTER, JustifyContent.START,
                Margin.Top.SMALL, Margin.Bottom.SMALL, Overflow.HIDDEN, BorderRadius.MEDIUM, Width.AUTO);
        div.setSizeFull();

        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.addClassName("header");
        horizontalLayout.setSpacing(false);
        horizontalLayout.setWidth(100f, Unit.PERCENTAGE);

        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.addClassName("card");
        verticalLayout.setSpacing(false);
        verticalLayout.setHeight(height);
        verticalLayout.setJustifyContentMode(JustifyContentMode.CENTER);
     
        Image image = new Image();
        image.setWidth(height);
        image.setHeight(height);
        image.setSrc(track.getImage());

        Span title = new Span(track.getTrack());
        title.addClassNames(FontSize.SMALL, FontWeight.SEMIBOLD);
        title.addClassName("title");
        Span artist = new Span(track.getArtist());
        artist.addClassNames(FontSize.XSMALL, TextColor.SECONDARY);
        artist.addClassName("artist");
        
        // add components to layout
        verticalLayout.add(title, artist);
        horizontalLayout.add(image, verticalLayout);
        div.add(horizontalLayout);
        layout.add(div);

        return layout;
    }

    // top artists tab view
    private Div createTopArtists() {
        Div div = new Div();
        div.addClassNames("stats-view");
        div.addClassNames(MaxWidth.SCREEN_MEDIUM, Margin.Horizontal.AUTO, Padding.Bottom.LARGE, Padding.Horizontal.LARGE);

        HorizontalLayout container = new HorizontalLayout();
        container.addClassNames(AlignItems.CENTER, JustifyContent.BETWEEN);

        VerticalLayout headerContainer = new VerticalLayout();
        H2 header = new H2("Top Artists");
        header.addClassNames(Margin.Bottom.NONE, Margin.Top.LARGE, FontSize.XXXLARGE);
        headerContainer.add(header);

        // sort select
        Select<String> sortBy = new Select<>();
        sortBy.setItems("Recent", "Last four weeks", "Last six months", "All data");
        sortBy.setValue("Recent");

        // imageContainer = new OrderedList();
        // imageContainer.addClassNames(Gap.SMALL, Display.FLEX, ListStyleType.NONE, Margin.NONE, Padding.NONE);

        // imageContainer.add(new StatsViewCard("Queen",
        //         "https://i.scdn.co/image/af2b8e57f6d7b5d43a616bd1e27ba552cd8bfd42"));
        // imageContainer.add(new StatsViewCard("The Jam",
        //         "https://i.scdn.co/image/443c4fb3b00e2205618c74b243612e36fd21d378"));
        // imageContainer.add(new StatsViewCard("Depeche Mode",
        //         "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSzoyuHKcahWoOestQspfnMX1D4ZBQgn3nqA6A6AN0RcQ&s"));
        // imageContainer.add(new StatsViewCard("Donna Summer",
        //         "https://i.scdn.co/image/ab6761610000e5eb739ffc27b8655e4ae4f12a66"));
        // imageContainer.add(new StatsViewCard("Boney M.",
        //         "https://i.scdn.co/image/524d6cfd6530ec5ed5a543b86840f99e631c5478"));
        // imageContainer.add(new StatsViewCard("The Beatles",
        //         "https://i.scdn.co/image/ab6761610000e5ebe9348cc01ff5d55971b22433"));
        
        // temporary list of artists
        List<Artist> artists = Arrays.asList(
            new Artist("Queen", "https://i.scdn.co/image/af2b8e57f6d7b5d43a616bd1e27ba552cd8bfd42"),
            new Artist("The Jam", "https://i.scdn.co/image/443c4fb3b00e2205618c74b243612e36fd21d378"),
            new Artist("Pink Floyd", "https://i.scdn.co/image/d011c95081cd9a329e506abd7ded47535d524a07"),
            new Artist("Jimi Hendrix", "https://i.scdn.co/image/ab6761610000e5eb31f6ab67e6025de876475814"),
            new Artist("Boney M.", "https://i.scdn.co/image/524d6cfd6530ec5ed5a543b86840f99e631c5478"),
            new Artist("The Beatles", "https://i.scdn.co/image/ab6761610000e5ebe9348cc01ff5d55971b22433"),
            new Artist("Queen", "https://i.scdn.co/image/af2b8e57f6d7b5d43a616bd1e27ba552cd8bfd42"),
            new Artist("The Jam", "https://i.scdn.co/image/443c4fb3b00e2205618c74b243612e36fd21d378"),
            new Artist("Pink Floyd", "https://i.scdn.co/image/d011c95081cd9a329e506abd7ded47535d524a07"),
            new Artist("Jimi Hendrix", "https://i.scdn.co/image/ab6761610000e5eb31f6ab67e6025de876475814"),
            new Artist("Boney M.", "https://i.scdn.co/image/524d6cfd6530ec5ed5a543b86840f99e631c5478"),
            new Artist("The Beatles", "https://i.scdn.co/image/ab6761610000e5ebe9348cc01ff5d55971b22433")
        );

        // add artists to layout in rows of 5 
        int k = 0;
        VerticalLayout v = new VerticalLayout();
        for (int i = 0; i < 2; i++) {
            HorizontalLayout h = new HorizontalLayout();
            for (int j = 0; j < 5; j++, k++){
                h.add(new StatsViewCard(artists.get(k).getArtist(), artists.get(k).getArtistImage()));
            }
            h.setWidth(100f, Unit.PERCENTAGE);
            h.setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN);
            v.add(h);
        }

        v.setWidth(100f, Unit.PERCENTAGE);

        // add components to layout
        container.add(headerContainer, sortBy);
        div.add(container, v);
        
        return div;
    }

    // top genres tab view
    private Div createTopGenres() {
        Div div = new Div();
        div.addClassNames("stats-view");
        div.addClassNames(MaxWidth.SCREEN_MEDIUM, Margin.Horizontal.AUTO, Padding.Bottom.LARGE, Padding.Horizontal.LARGE);

        HorizontalLayout container = new HorizontalLayout();
        container.addClassNames(AlignItems.CENTER, JustifyContent.BETWEEN);

        VerticalLayout headerContainer = new VerticalLayout();
        H2 header = new H2("Top Genres");
        header.addClassNames(Margin.Bottom.NONE, Margin.Top.LARGE, FontSize.XXXLARGE);
        headerContainer.add(header);

        // sort select
        Select<String> sortBy = new Select<>();
        sortBy.setItems("Recent", "Last four weeks", "Last six months", "All data");
        sortBy.setValue("Recent");

        // [add genre display here later]

        // add components to layout
        container.add(headerContainer, sortBy);
        div.add(container);

        return div;
    }
}
