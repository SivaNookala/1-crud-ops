package com.demo.core.spark;

import java.util.Arrays;
import java.util.List;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.rdd.RDD;

public class RDDTestUsingParallelize {

	public static void main(String[] args) {
		SparkConf conf=new SparkConf();
		conf.setMaster("local[*]");
		conf.setAppName("rdd-create-test");
		JavaSparkContext sc=new JavaSparkContext(conf);
		sc.setLogLevel("WARN");
		List<Integer> numbers=Arrays.asList(12,5,6,10);
		JavaRDD<Integer> rdd1=sc.parallelize(numbers);
		
		rdd1.filter(n->n<=10).map(n->n*2).collect().forEach(System.out::println);
		
	/*	RDD<Integer> rdd2=rdd1.map(n->n*2);
		RDD<Integer> rdd3=rdd2.filter(n->n<=20);
		List<Integer> list=rdd3.collect();
		list.foreach(System.out::println);
		*/
	
	}
	
	

}
