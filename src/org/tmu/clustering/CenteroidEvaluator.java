package org.tmu.clustering;

import org.apache.commons.math3.stat.clustering.Cluster;
import org.tmu.util.BinaryFormatReader;
import org.tmu.util.CSVReader;
import org.tmu.util.Point;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Saeed
 * Date: 7/27/13
 * Time: 4:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class CenteroidEvaluator {

    public static double computeSSE(List<Point> points , List<Point> centers) {
        double sse = 0;
        for (Point p : points)
            sse += Math.sqrt(p.distanceFrom(p.findNearest(centers)));
        return sse;
    }

    public static double computeSSEFromCSV(String file_name, List<Point> centers) throws IOException {
        CSVReader csvReader=new CSVReader(file_name);
        double sse = 0;
        Point point;
        while (true) {
            point = csvReader.ReadNextPoint();
            if (point == null)
                break;
            sse += Math.sqrt(point.distanceFrom(point.findNearest(centers)));
        }
        csvReader.close();
        return sse;
    }

    public static double computeSSEFromBinary(String file_name, List<Point> centers) throws IOException {
        BinaryFormatReader binReader=new BinaryFormatReader(file_name);
        double sse = 0;
        Point point;
        while (true) {
            point = binReader.readNextPoint();
            if (point == null)
                break;
            sse += Math.sqrt(point.distanceFrom(point.findNearest(centers)));
        }
        binReader.close();
        return sse;
    }

    public static double computeIntraCenterDistance(List<Point> centers) {
        double icd = 0;
        for (Point p : centers)
            for (int x = 0; x < centers.size(); x++)
                icd += Math.sqrt(p.distanceFrom(centers.get(x)));

        return icd;
    }

}
