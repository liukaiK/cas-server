/*
 *    GeoTools - The Open Source Java GIS Toolkit
 *    http://geotools.org
 *
 *    (C) 2019, Open Source Geospatial Foundation (OSGeo)
 *
 *    This library is free software; you can redistribute it and/or
 *    modify it under the terms of the GNU Lesser General Public
 *    License as published by the Free Software Foundation;
 *    version 2.1 of the License.
 *
 *    This library is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *    Lesser General Public License for more details.
 *
 */

package org.geotools.tutorial.quickstart;

import org.geotools.data.DataStore;
import org.geotools.data.FeatureSource;
import org.geotools.data.FileDataStoreFinder;
import org.geotools.data.simple.SimpleFeatureCollection;
import org.geotools.data.simple.SimpleFeatureSource;
import org.geotools.feature.FeatureCollection;
import org.geotools.feature.FeatureIterator;
import org.opengis.feature.Feature;
import org.opengis.feature.GeometryAttribute;
import org.opengis.geometry.Geometry;

import java.io.File;

/**
 * Prompts the user for a shapefile and displays the contents on the screen in a map frame.
 *
 * <p>This is the GeoTools Quickstart application used in documentationa and tutorials. *
 */
public class Quickstart2 {

    /**
     * GeoTools Quickstart demo application. Prompts the user for a shapefile and displays its
     * contents on the screen in a map frame
     */
    public static void main(String[] args) throws Exception {
        // display a data store file chooser dialog for shapefiles
//        File file = JFileDataStoreChooser.showOpenFile("shp", null);

        File file = new File("E:\\locations.shp");

        if (file == null) {
            return;
        }

        //连接到Shapefile文件的数据源
        DataStore store = FileDataStoreFinder.getDataStore(file);

        // 从dataStore中获取Shapefile类型名称
        // Shapefile文件名称和Shapefile类型名称通常是一样的。
        // 此处dataStore现在是基于Shapefile创建的, 所以TypeName就是Shapefile文件名称。
        String typeName = store.getTypeNames()[0];

        System.out.println("typeName = " + typeName);

        // 第三步:根据Shapefile类型名称，从dataStore中获取的一个对象

        SimpleFeatureSource featureSource = store.getFeatureSource(typeName);
        SimpleFeatureCollection featureCollection = featureSource.getFeatures();
        // 该FeatureCollection类的实例中存放着0...N个的对象。
        FeatureIterator features = featureCollection.features();


        while (features.hasNext()) {
            // 对Layer核心的操作都是针对的是要素的操作。所以，这里为我们提供了要素。
            Feature feature = features.next();
            // 我们将Gis看成是一组基于数据的服务，而数据的基础是要素(Feature)。
            // 所谓要素简单的说就是一个独立的对象，在地图中可能表现为一个多边形的建筑物，
            // 在数据库中即一个独立的条目。
            // 要素具有两个必要的组成部分，几何信息和属性信息。
            // 我们这里每一要素(Feature)类的对象中存放着
            // 一个几何信息(Geometry)类的对象，和许多属性信息(attributes)。

            System.out.println("feature = " + feature);








        }



    }
}