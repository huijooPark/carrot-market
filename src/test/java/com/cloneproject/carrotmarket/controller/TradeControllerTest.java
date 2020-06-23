package com.cloneproject.carrotmarket.controller;

import com.cloneproject.carrotmarket.controller.UserController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/* 컨트롤러에 service나 Repository 가 있는 경우는 테스트 할수 없음 수순 controller만 테스트 가능*/
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = TradeController.class)
public class TradeControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void Trade_연결확인() throws Exception{

        String hello = "trade";

        mvc.perform(get("/api/trade/tradeList"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }
}
