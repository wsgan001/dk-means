package org.tmu.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.math3.stat.clustering.Clusterable;
/**
 * Created with IntelliJ IDEA.
 * User: Saeed
 * Date: 10/9/12
 * Time: 7:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class Point implements Clusterable<Point>{
    public double[] elements=null;

    public Point()
    {
        elements=new double[0];
    }

    public Point(int size)
    {
        elements=new double[size];
        for(int i=0;i<size;i++)
            elements[i]=0.0;
    }

    public Point(double[] point)
    {
        elements=new double[point.length];
        System.arraycopy(point, 0, elements, 0, point.length);
    }

    public Point(Point point)
    {
        this(point.elements);
    }

    public Double getElement(int index) {
        return elements[index];
    }

    public void setElement(int index, double value)
    {
        elements[index]=value;
    }

    public int size()
    {
        return elements.length;
    }

    public String toString()
    {
        StringBuilder builder=new StringBuilder();
        builder.append("(");
        for(int i=0;i<elements.length;i++)
            builder.append(Double.toString(elements[i])).append(",");
        builder.deleteCharAt(builder.length()-1);
        builder.append(")");
        return builder.toString();
    }

    public double distanceFrom(Point point) {
        double distance=0.0;
        if(size()!=point.size())
            throw new IllegalArgumentException("Target point's size is not equal!");

        for(int i=0;i<size();i++)
            distance+=(elements[i]-point.getElement(i))*(elements[i]-point.getElement(i));
        return distance;
    }

    public Point centroidOf(Collection<Point> points) {
        if(points.size()==0)
            throw new IllegalArgumentException("There is no points!");

        Point result=new Point(points.iterator().next().size());

        for( Point p:points)
        {
            if(p.size()!=result.size())
                throw new IllegalArgumentException("There is a point with mismatched size: "+ p.toString());
            for (int i=0;i<p.size();i++)
                result.setElement(i,result.getElement(i)+p.getElement(i));
        }

        for (int i=0;i<result.size();i++)
            result.setElement(i,result.getElement(i)/points.size());

        return result;
    }
}