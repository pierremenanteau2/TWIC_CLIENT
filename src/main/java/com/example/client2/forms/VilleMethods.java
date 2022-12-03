package com.example.client2.forms;

import com.example.client2.beans.Ville;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class VilleMethods {
    public static List<Ville> getAllVilles() {
        List<Ville> villes = null;
        try {
            URL url = new URL("http://localhost:8080/ville");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            if (connection.getResponseCode() == 200) {
                villes = new ArrayList<>();
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(connection.getInputStream()));
                String output;
                String villesString = "";
                ///ville1 = br.readLine();
                while ((output = br.readLine()) != null) {
                    villesString += output;
                }
                String[] villesRaw = villesString.split(",");
                for (int i = 0; i < villesRaw.length - 1; i = i + 7) {
                    Ville villeAdd = new Ville();
                    villeAdd.setCodeCommuneInsee(Integer.parseInt(villesRaw[i]));
                    villeAdd.setNomCommune(villesRaw[i + 1]);
                    villeAdd.setCodePostal(Integer.parseInt(villesRaw[i + 2]));
                    villeAdd.setLibelleAcheminement(villesRaw[i + 3]);
                    villeAdd.setLigne5(villesRaw[i + 4]);
                    villeAdd.setLatitude(Float.parseFloat(villesRaw[i + 5]));
                    villeAdd.setLongitude(Float.parseFloat(villesRaw[i + 6]));
                    villes.add(villeAdd);
                }
            }
            connection.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return villes;
    }

    public static Ville getVilleFromCode(String codeCommune) {
        Ville villeRet = null;
        if (codeCommune != null) {
            List<Ville> villes = VilleMethods.getAllVilles();
            for (Ville ville : villes) {
                if (ville.getCodeCommuneInsee() == Integer.parseInt(codeCommune)) {
                    villeRet = ville;
                }
            }
        }
        return villeRet;
    }

    public static Ville getVilleFromName(String nomCommune) {
        Ville villeRet = null;
        List<Ville> villes = VilleMethods.getAllVilles();
        for (Ville ville : villes) {
            if (ville.getNomCommune().equals(nomCommune)) {
                villeRet = ville;
            }
        }
        return villeRet;
    }

    ///Méthode récupérée
    public static String distance(double lat1, double lng1, double lat2, double lng2) {
        double radTerre = 6371.0;
        double dLat = Math.toRadians(lat2 - lat1);
        double dLng = Math.toRadians(lng2 - lng1);
        double sindLat = Math.sin(dLat / 2);
        double sindLng = Math.sin(dLng / 2);
        double a = Math.pow(sindLat, 2) + Math.pow(sindLng, 2) * Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2));
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double dist = radTerre * c;
        return String.format("%.2f", dist);
    }

    public static List<Ville> getVillesPage(int numPage) {
        List<Ville> villes = VilleMethods.getAllVilles();
        List<Ville> villesPage = new ArrayList<>();
        for (int i = (numPage - 1) * 50; i < (numPage - 1) * 50 + 50; i++) {
            if (villes.size() > i) {
                villesPage.add(villes.get(i));
            }
        }
        return villesPage;
    }

    public static List<String> getAllNameVille() {
        List<Ville> villes = VilleMethods.getAllVilles();
        List<String > newVilles = new ArrayList<String>();
        for (Ville ville : villes) {
            newVilles.add(ville.getNomCommune());
        }
        return newVilles;
    }
}