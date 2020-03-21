package com.unicom.smartcity.web;

import com.unicom.smartcity.config.RootConfig;
import com.unicom.smartcity.config.ServletConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class, ServletConfig.class})
public class IndexControllerTest {

    @Test
    public void index() {
        IndexController indexController = new IndexController();
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();
//        mockMvc.perform()

    }
}