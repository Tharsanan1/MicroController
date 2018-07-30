package com.example.demo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import antlr.collections.List;

public interface CropRepo extends JpaRepository<CropEntity,Integer>{
	//ArrayList<CropEntity> findAllOrderByPointAsc();
}
