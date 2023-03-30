package com.bebopt.app.authorization;

import java.net.URI;

import com.bebopt.app.domain.Client;

import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.SpotifyHttpManager;

// fix later
public class Authorize{
    private static String clientId = Client.getClientID();

    private static String clientSecret = Client.getClientSecret();

    private static final URI redirectUri = SpotifyHttpManager.makeUri("https://example.com/spotify-redirect");
    
    public SpotifyApi getSpotifyApi() {
        return new SpotifyApi.Builder()
            .setClientId(clientId)
            .setClientSecret(clientSecret)
            .setRedirectUri(redirectUri)
            .build();
    }
}
