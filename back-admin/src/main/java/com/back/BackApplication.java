package com.back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动程序
 * 
 * @author back
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class BackApplication
{
    public static void main(String[] args)
    {
        // System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(BackApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  布达启动！！   ლ(´ڡ`ლ)ﾞ");
    }
}