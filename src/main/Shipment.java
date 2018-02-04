package main;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Created by Win7 on 2/3/2018.
 */
public class Shipment {
    private Double pounds;

    public String convertToKilogram() {
        double lb = 2.2;
        // Calculate weight
        double kg = Math.round(pounds / lb);

        return pounds + "lbs = " + kg + "kg";
    }

    public List<String> calculateOnShipments(
            List<Shipment> shipmentList, Function<Shipment, String> f) {
        List<String> results = new ArrayList<>();
        for(Shipment s : shipmentList) {
            results.add(f.apply(s));
        }
        return results;
    }

    public void setPounds(Double pounds) {
        this.pounds = pounds;
    }
}
