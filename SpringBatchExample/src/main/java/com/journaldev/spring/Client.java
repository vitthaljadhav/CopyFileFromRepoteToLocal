package com.journaldev.spring;

import java.util.Scanner;

import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.info.batch.service.BatchService;

public class Client {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);
		 System.out.println("Enter the Batch Name");
		 String batchName=scanner.nextLine();
		 BatchService service = new BatchService();
		 System.out.println("Batch Name Is "+batchName);
		 service.batchName(batchName);
	}
}
