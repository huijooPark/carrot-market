package com.cloneproject.carrotmarket.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@Api(value = "TradeController" )
@RequestMapping(value = "/api/trade")
public class TradeController {

    private static final Logger logger = LoggerFactory.getLogger(TradeController.class);


    @ApiOperation(value = "tradeListSearch", notes = "중고거래 List 조회")
    @GetMapping("/tradeList")
    public List<Object> tradeListSearch(Object trade){
        return null;
    }

}
