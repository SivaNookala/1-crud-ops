package com.demo.core.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.util.List;

public class RDDTestToReadFile {

    public static void main(String[] args) {
        SparkConf conf=new SparkConf();
        conf.setMaster("local[*]");
        conf.setAppName("rdd-create-test");
        JavaSparkContext sc=new JavaSparkContext(conf);
        sc.setLogLevel("WARN");
        /*
          To read a speciffic file
         */
        JavaRDD<String> rdd1=sc.textFile("/Users/sivanookala/Documents/Work/spark/test-files/test.txt");
        /*
          To Read all files from a directory
         */
        //JavaRDD<String> rdd1=sc.textFile("/Users/sivanookala/Documents/Work/spark/test-files");
        /*
          Reading multiple files
         */
        //JavaRDD<String> rdd1=sc.textFile("/Users/sivanookala/Documents/Work/spark/test-files/test.txt,/Users/sivanookala/Documents/Work/spark/test-files/test2.txt");
        List<String> list=rdd1.collect();
        long count=rdd1.count();

        list.forEach(System.out::println);
        List<String> array=rdd1.take(3);
        array.forEach(System.out::println);
        JavaRDD<String> rdd2=rdd1.map(String::toUpperCase);
        rdd2.collect().forEach(System.out::println);

        //rdd2.saveAsTextFile("/Users/sivanookala/Documents/Work/spark/test-files/testout");
        rdd2.repartition(1).saveAsTextFile("/Users/sivanookala/Documents/Work/spark/test-files/testout");

    }

}
