package org.tmu;

import com.google.common.base.Stopwatch;
import org.apache.commons.math3.stat.clustering.Cluster;
import org.apache.commons.math3.stat.clustering.KMeansPlusPlusClusterer;
import org.tmu.clustering.DKMeansClusterer;
import org.tmu.clustering.ImprovedStreamClusterer;
import org.tmu.clustering.SimpleKMeansClusterer;
import org.tmu.clustering.StreamClusterer;
import org.tmu.util.*;


import java.io.IOException;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Saeed
 * Date: 10/9/12
 * Time: 5:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        String file_name=args[0];
        Stopwatch watch=new Stopwatch().start();
        DKMeansClusterer dkMeansClusterer=new DKMeansClusterer();
        dkMeansClusterer.cluster(file_name,3,6);
        System.out.println(watch.elapsedMillis());
//        TestCSV test=new TestCSV();
//        test.ReadLines(file_name,1000*1000*10);
//        test.SerialParse();
//        test.ParallelParse();
//
//        System.exit(0);
//        FileWriter writer=new FileWriter(file_name);
//        RandomPointGenerator.GenerateDisjointClustersToFile(writer,new Point(new double[]{0,0,0}),5,1000*1000*10,new Random(1234));
//        writer.close();
//        System.out.println(watch.elapsedMillis());
//        watch.reset().start();
//
//        CSVReader reader= new CSVReader(file_name);
//        List<Point> points=new ArrayList<Point>();
//
//        int count=1000*1000*10;
//
//        Point p1=null;
//        for(int i=0;i<count;i++)
//        {
//            p1=reader.ReadNextPoint();
//            if(p1!=null)
//                points.add(p1);
//        }
//        System.out.println(points.size() +" took  "+ watch.elapsedMillis());
//
//
//        watch.reset().start();
//        points.clear();
//        reader= new CSVReader(file_name);
//
//        System.in.read();
//        System.exit(0);

//        Collection<Point> p;
//        //while ((p=reader.ReadSomePointInParallel(500*1000,4))!=null&&points.size()<1000*500)
//        int chunk_size=500*1000;
////        for(int i=0;i<count/chunk_size;i++){
////            p=reader.ReadSomePointInParallel(chunk_size,4);
////            points.addAll(p);
////        }
//        System.out.println(points.size() +" took  "+ watch.elapsedMillis());
//
        //System.out.println(watch.elapsedMillis());
        //System.exit(0);

//        int count=1000*1000*10;
//        int num_clusters=5;
//        int max_iter=7;
//        Stopwatch watch=new Stopwatch().start();
//        List<Point> points=null;
//
//        for(count=1000*1000*40;count<=50*1000*1000;count=count*2){
//            points= RandomPointGenerator.GenerateDisjointClusters(new Point(new double[]{10,10,10}),num_clusters,count,new Random(123));
//            System.out.println("Random Generation took: "+watch);
//            for(int y=0;y<1;y++)
//        {
//           watch.reset().start();
//
//            KMeansPlusPlusClusterer<Point> kmpp=new KMeansPlusPlusClusterer<Point>(new Random(123));
//            kmpp.cluster(points,num_clusters,max_iter);
//            System.out.println("Serial kmeans++ took: "+watch);
//            System.out.println("Points: "+points.size());
//            points=null;
//            Runtime.getRuntime().gc();
//            watch.reset().start();
//
//            int num_points=0;
//            ImprovedStreamClusterer<Point> smeans=new ImprovedStreamClusterer<Point>(num_clusters);
//            //StreamClusterer<Point> smeans=new StreamClusterer<Point>(num_clusters,new Random());
//            smeans.Start();
//
//            int chunk_size=10000;
//            points= RandomPointGenerator.GenerateDisjointClusters(new Point(new double[]{10,10,10}),num_clusters,chunk_size,new Random(123));
//            for(int i=0;i<count/chunk_size;i++)
//            {
//                smeans.AddChunk(points);
//                num_points+=points.size();
//            }
//            smeans.InputIsDone();
//            //smeans.AddChunk(new ArrayList<Point>());
//
//            smeans.WaitTillDone();
//            //smeans.getIntermediateCenters();
//            //smeans.GetIntermediateCenters();
//            System.out.println("Parallel kmeans++ took: "+watch);
//            System.out.println("Points: "+num_points);
//            System.out.println("==========================================");
//        }
//        }
    }
}
