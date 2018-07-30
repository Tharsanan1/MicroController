package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpEntity;
import org.springframework.ui.Model;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import antlr.collections.List;

import java.text.SimpleDateFormat;
import java.time.Clock;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@Controller
@RequestMapping(path = "/micro")
public class MicroController {
	
	@Autowired
	ModelRepository modelRepo;
	
	@Autowired
	CropRepo cropRepo;
	
	
	@GetMapping(path = "/getAll")
	public String getAllModel(Model model){
	    model.addAttribute("models",new ArrayList(modelRepo.findAll()));
	    return "cropDetail";
	}
	
	/**@GetMapping(path = "/add")
	public ResponseEntity  addCrop(@PathVariable Double point, @PathVariable String crop ){
		CropSelector.addCrop(point, crop);
		return ResponseEntity.ok(HttpStatus.ACCEPTED);
	}**/
	
	
	@PostMapping(path = "/create")
    public @ResponseBody ModelMicro createNewEmployee(@RequestBody ModelMicro model){
		ModelMicro model1 = modelRepo.save(model);
        return model1;
    }
	@GetMapping(path = "/getLast")
	public @ResponseBody ModelMicro getLastModel(){
		ArrayList models =  new ArrayList(modelRepo.findAll());	
		ModelMicro model = (ModelMicro)models.get(models.size()-1);
		return model;
	}
	
	@GetMapping(path = "/getPreferredCrop")
	public @ResponseBody String getPreferredModel(){
		ArrayList<ModelMicro> models =  new ArrayList(modelRepo.findAll());	
		ModelMicro model = (ModelMicro)models.get(models.size()-1);
		Double moisureAvg = (double) 0;
		Double humidityAvg = (double) 0;
		Double tempAvg = (double) 0;
		for(ModelMicro m : models) {
			try {
				moisureAvg+=Double.parseDouble(m.getMoisure());
			}
			catch(Exception e) {}
			try {
				humidityAvg+=Double.parseDouble(m.getHumidity());
			}
			catch(Exception e) {}
			try {
				tempAvg+=Double.parseDouble(m.getTemperature());
			}
			catch(Exception e) {}
			
		}
		Integer modelSize = models.size();
		moisureAvg = moisureAvg/modelSize;
		tempAvg = tempAvg/modelSize;
		humidityAvg = humidityAvg/modelSize;
		
		Double point  = (moisureAvg*moisureAvg)+(tempAvg*tempAvg)+(humidityAvg*humidityAvg);
		CropSelector cropSel = new CropSelector();
		ArrayList<CropEntity> crops = (ArrayList<CropEntity>) cropRepo.findAll();
		CropSelector.delete();
		CropSelector.addCrops(crops);
		String crop = cropSel.getCrop(point);
		return crop;
	}
	
	@PostMapping(path = "/createCrop")
    public @ResponseBody CropEntity createCrop(@RequestBody CropEntity crop){
		CropEntity model1 = cropRepo.save(crop);
        return model1;
    }
	
	
	
	
	
	
	
	
	
}
