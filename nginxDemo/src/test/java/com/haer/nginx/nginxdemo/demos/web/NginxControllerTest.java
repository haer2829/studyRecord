package com.haer.nginx.nginxdemo.demos.web;


import cn.hutool.core.lang.Assert;
import com.haer.nginx.nginxdemo.Service1;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = NginxControllerTest.class)
public class NginxControllerTest {
    @MockBean
    private Service1 service1;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void testb(){
        Mockito.when(service1.action1(Mockito.any())).thenReturn(null);
        try {
            //执行被测试的方法
        }catch (Exception e){
            Assert.equals(RuntimeException.class,e.getClass());
        }



    }

}
