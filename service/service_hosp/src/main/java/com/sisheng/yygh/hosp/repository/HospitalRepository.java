package com.sisheng.yygh.hosp.repository;

import com.sisheng.yygh.model.hosp.Hospital;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospitalRepository extends MongoRepository<Hospital,String> {
    Hospital getHospitalByHoscode(String hoscode);

    //根据医院名称模糊查询
    List<Hospital> findHospitalByHosnameLike(String hosname);
}
