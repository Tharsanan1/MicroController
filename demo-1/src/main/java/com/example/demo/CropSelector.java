package com.example.demo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

public class CropSelector {
	
	static ArrayList<Double> pointList = new ArrayList<>();
	static ArrayList<String> cropList = new ArrayList<>();
	@Autowired
	static ModelRepository modelRepo;
	public static void addCrop(Double point, String crop) {
		pointList.add(point);
		cropList.add(crop);
	}
	
	public String getCrop(Double point) {
		for(Double d : pointList) {
			if(point == null) continue;
			
			if(point<d) {
				if(cropList.get(pointList.indexOf(d)) == null)continue;
				return cropList.get(pointList.indexOf(d));
			}
		}
		return "no match";
	}
	
	public static void addCrops(ArrayList<CropEntity> crops) {
		for(CropEntity c : crops) {
			pointList.add(c.getPoint());
			cropList.add(c.getCropName());
		}
	}

	public static void delete() {
		// TODO Auto-generated method stub
		pointList.clear();
		cropList.clear();
	}
	
	public static void save(ModelMicro model) {
		modelRepo.save(model);
	}
	
	
}
