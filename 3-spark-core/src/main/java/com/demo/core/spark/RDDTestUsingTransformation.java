package com.demo.core.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;

public class RDDTestUsingTransformation {

	public static void main(String[] args) {
		SparkConf conf=new SparkConf();
		conf.setMaster("local[*]");
		conf.setAppName("rdd-create-test");
		JavaSparkContext sc=new JavaSparkContext(conf);
		sc.setLogLevel("WARN");
	
		sc.textFile("c:/test/third.txt").map(String::toUpperCase).filter(s->s.startsWith("I")).collect()
		.forEach(System.out::println);
	}
	
	

}
