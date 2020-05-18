package com.unicom.smartcity;

import org.geotools.data.FileDataStore;
import org.geotools.data.FileDataStoreFinder;
import org.geotools.data.simple.SimpleFeatureIterator;
import org.geotools.data.simple.SimpleFeatureSource;
import org.geotools.map.FeatureLayer;
import org.geotools.map.Layer;
import org.geotools.map.MapContent;
import org.geotools.styling.SLD;
import org.geotools.styling.Style;
import org.geotools.swing.JMapFrame;
import org.junit.Test;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class GeotoolsTest {

    @Test
    public void quickStart() throws IOException, ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {

        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());


        File file = new File("E:\\ne_50m_admin_0_countries\\ne_50m_admin_0_countries.shp");


        FileDataStore store = FileDataStoreFinder.getDataStore(file);


        SimpleFeatureSource featureSource = store.getFeatureSource();


        SimpleFeatureIterator features = featureSource.getFeatures().features();


        while (features.hasNext()) {
            System.out.println(features.next());
        }


        // Create a map content and add our shapefile to it
        MapContent map = new MapContent();
        map.setTitle("Quickstart");

        Style style = SLD.createSimpleStyle(featureSource.getSchema());
        Layer layer = new FeatureLayer(featureSource, style);
        map.addLayer(layer);

        // Now display the map
        JMapFrame.showMap(map);
    }


}
