package com.unicom.smartcity;

import org.geotools.data.DataUtilities;
import org.geotools.data.shapefile.ShapefileDataStore;
import org.geotools.data.shapefile.ShapefileDataStoreFactory;
import org.geotools.feature.SchemaException;
import org.geotools.feature.simple.SimpleFeatureBuilder;
import org.geotools.geometry.jts.JTSFactoryFinder;
import org.junit.Test;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Csv2ShapeTest {

    @Test
    public void csv2shp() throws SchemaException, IOException {

        File file = new File("E:\\locations.csv");

        final SimpleFeatureType TYPE =
                DataUtilities.createType(
                        "Location",
                        "111111,"
                                + // <- the geometry attribute: Point type
                                "222222,"
                                + // <- a String attribute
                                "333333333" // a number attribute
                );

        System.out.println("TYPE:" + TYPE);


        List<SimpleFeature> simpleFeatureList = new ArrayList<>();

        SimpleFeatureBuilder featureBuilder = new SimpleFeatureBuilder(TYPE);

        GeometryFactory geometryFactory = JTSFactoryFinder.getGeometryFactory();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            /* First line of the data file is the header */
            String line = reader.readLine();
            System.out.println("Header: " + line);

            for (line = reader.readLine(); line != null; line = reader.readLine()) {
                if (line.trim().length() > 0) { // skip blank lines
                    String tokens[] = line.split("\\,");


                    double latitude = Double.parseDouble(tokens[0]);
                    double longitude = Double.parseDouble(tokens[1]);
                    String name = tokens[2].trim();
                    int number = Integer.parseInt(tokens[3].trim());


                    System.out.println(latitude + " " + longitude + " " + name + " " + number);

                    Point point = geometryFactory.createPoint(new Coordinate(longitude, latitude));


                    featureBuilder.add(point);

                    SimpleFeature simpleFeature = featureBuilder.buildFeature("1");


                    simpleFeatureList.add(simpleFeature);


                }
            }
        }


        for (SimpleFeature simpleFeature : simpleFeatureList) {
            System.out.println(simpleFeature);
        }


        /*
         * Get an output file name and create the new shapefile
         */
        File newFile = new File("E:\\locations.shp");

        ShapefileDataStoreFactory dataStoreFactory = new ShapefileDataStoreFactory();

        Map<String, Serializable> params = new HashMap<>();
        params.put("url", newFile.toURI().toURL());
        params.put("create spatial index", Boolean.TRUE);

        ShapefileDataStore newDataStore = (ShapefileDataStore) dataStoreFactory.createNewDataStore(params);

        /*
         * TYPE is used as a template to describe the file contents
         */
        newDataStore.createSchema(TYPE);


    }

}
