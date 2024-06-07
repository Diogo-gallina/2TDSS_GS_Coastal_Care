package com.coastalcare.utils;

import com.coastalcare.dto.geocoder.GeocodeLatLgnResponseDTO;
import com.coastalcare.infra.exceptions.AddressInfoNotFoundException;
import com.coastalcare.models.Beach;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;
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

    public static String parseCoordinateToAddress(Double latitude, Double longitude) {
        try {
            LatLng location = new LatLng(latitude, longitude);
            GeocodingResult[] results = GeocodingApi.reverseGeocode(context, location).await();
            if (results != null && results.length > 0)
                return results[0].formattedAddress;
            throw new AddressInfoNotFoundException("Não foi possível encontrar informações do endereço com as cordenadas inseridas");
        } catch (ApiException | InterruptedException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {

    }

}
