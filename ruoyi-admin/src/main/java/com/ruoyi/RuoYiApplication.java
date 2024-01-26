package com.ruoyi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 始めるプログラム
 * 
 * @author ruoyi
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class RuoYiApplication
{
    public static void main(String[] args)
    {
        // System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(RuoYiApplication.class, args);
        System.out.println("始めるされました \n" +
                " ________  ____  ____________  \r\n" + //
                "\\______ \\ \\   \\/  /\\_   ___ \\ \r\n" + //
                " |    |  \\ \\     / /    \\  \\/ \r\n" + //
                " |    `   \\/     \\ \\     \\____\r\n" + //
                "/_______  /___/\\  \\ \\______  /\r\n" + //
                "        \\/      \\_/        \\/ \n"
                );
    }
}











