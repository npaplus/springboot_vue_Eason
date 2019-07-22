package com.qf.eason.controller;

import com.qf.eason.dao.SymptomMapper;
import com.qf.eason.pojo.Symptom;
import com.qf.eason.service.SymptomService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Component
@RequestMapping(value ="/symptom")
@ResponseBody
public class SymptomController {

    @Autowired(required = false)
    private SymptomService symptomService;

    @RequestMapping(value = "/findByBadyParts",method = RequestMethod.GET)
    @ApiOperation(value = "人体图中'全身症状'等查症状（id,症状）")
    public List<Symptom> findByBadyParts(String badyParts) {
        return symptomService.findByBadyParts(badyParts);
    }

    @RequestMapping(value = "/findById",method = RequestMethod.GET)
    @ApiOperation(value = "根据症状Id查 '以下症状'")
    public List<Symptom> findById(Integer id) {
        return symptomService.findById(id);
    }
}
