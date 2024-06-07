package com.coastalcare.utils;

import com.coastalcare.dto.geocoder.GeocodeLatLgnResponseDTO;
import com.coastalcare.infra.exceptions.AddressInfoNotFoundException;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import io.github.cdimascio.dotenv.Dotenv;
import lombok.NoArgsConstructor;

import java.io.IOException;

@NoArgsConstructor

public class Geocoder {

    private static final Dotenv dotenv = Dotenv.load();
    private static final String API_KEY = dotenv.get("API_KEY_GOOGLE_GEOLOCATION");
    private static final GeoApiContext context = new GeoApiContext.Builder().apiKey(API_KEY).build();

    public static GeocodeLatLgnResponseDTO parseAddressToCoordinate(String address) {
        try {
            GeocodingResult[] results = GeocodingApi.geocode(context, address).await();
            if (results != null && results.length > 0) {
                Double latitude = results[0].geometry.location.lat;
                Double longitude = results[0].geometry.location.lng;
                return new GeocodeLatLgnResponseDTO(latitude, longitude);
            } else {
                throw new AddressInfoNotFoundException("Não foi possível encontrar informações do endereço inserido");
            }
        } catch (ApiException | InterruptedException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
