package com.info.batch.listener;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.core.ItemWriteListener;

import com.info.batch.constant.Constant;
import com.journaldev.spring.model.Settlement;

public class CustomItemWriterListener implements ItemWriteListener<Settlement> {


	@Override
	public void beforeWrite(List<? extends Settlement> items) {
		System.out.println("beforeWrite--------> " + items);

	}

	// @Override
	public void afterWriteOld(List<? extends Settlement> items) {
		List<Settlement> list = new ArrayList<Settlement>();
		list.addAll(items);

		FileWriter fileWriter = null;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddhhmmss");
		LocalDateTime now = LocalDateTime.now();
		String format = dtf.format(now);
		// System.out.println(dtf.format(now));

		try {
			// fileWriter = new FileWriter("D:/Vitthal Jadhav/BatchFile/SuccessFile" +
			// format + ".txt");
			fileWriter = new FileWriter("D:/Vitthal Jadhav/BatchFile/" );
			if (items != null) {
				fileWriter.write(items.toString()+"\n");
			}
			System.out.println("File Successfully created");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fileWriter != null) {
					fileWriter.flush();
					fileWriter.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// System.out.println("afterWrite ------>" + items);
	}

	@Override
	public void afterWrite(List<? extends Settlement> items) {

		File file = new File(Constant.SUCCESSFILE_PATH);
		FileWriter fr;
		try {
			fr = new FileWriter(file, true);
			BufferedWriter br = new BufferedWriter(fr);
			if(items.size()!=0) {	
				String str=items.toString();
				br.write(items.toString()+"\n");
				br.write("\n");
			}
			br.close();
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void onWriteError(Exception exception, List<? extends Settlement> items) {
		// System.out.println("onWriteError---------" + items);
	}

}
