package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface ModelRepository extends JpaRepository<ModelMicro,Integer>{//},ClockInOutRepositoryCustom{
    
}
