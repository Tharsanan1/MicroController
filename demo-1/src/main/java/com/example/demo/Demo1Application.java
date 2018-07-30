package com.example.demo;

import java.util.Date;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Demo1Application {

	
	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
		CropSelector.addCrop(1.213, "banana");
		CropSelector.addCrop(2.213, "banana");
		CropSelector.addCrop(3.213, "banana");
		CropSelector.addCrop(4.213, "banana");
		CropSelector.addCrop(5.213, "banana");
		CropSelector.addCrop(6.213, "banana");
		CropSelector.addCrop(7.213, "banana");
		CropSelector.addCrop(8.213, "banana");
		CropSelector.addCrop(9.213, "banana");
		CropSelector.addCrop(10.213, "banana");
		CropSelector.addCrop(11.213, "banana");
		CropSelector.addCrop(12.213, "banana");
		Timer timer = new Timer();
		
		/**timer.schedule(new TimerTask() {
		  @Override
		  public void run() {
			  Random r = new Random();
			  int Low = 72;
			  int High = 79;
			  int humidity = r.nextInt(High-Low) + Low;
			  int moisure = r.nextInt(5) + 4;
			  ModelMicro modelMicro = new ModelMicro();
			  modelMicro.setId(1);
			  modelMicro.setDate(new Date().toString());
			  modelMicro.setPlace("Jaffna");
			  modelMicro.setHumidity(Integer.toString(humidity));
			  modelMicro.setMoisure(Integer.toString(moisure));
			  CropSelector.save(modelMicro);
			  
		  }
		}, 30*1000);**/
		
	}
}
