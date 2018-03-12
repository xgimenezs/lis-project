package com.lis.sample;

import com.lis.core.TestManager;
import com.lis.core.TestManagerConfig;
import com.lis.core.model.Order;
import com.lis.core.model.Patient;
import com.lis.core.model.Sample;
import com.lis.core.model.tests.impl.GlucoseTest;
import com.lis.core.model.tests.impl.HemoglobinTest;
import com.lis.sample.operation.IConsoleOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by xgimenez on 8/3/18.
 */
@SpringBootApplication
public class ConsoleApp implements CommandLineRunner {

    @Autowired
    private TestManager testManager;

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(ConsoleApp.class, TestManagerConfig.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }
    @Override
    public void run(String... args) throws Exception {
        Order order = new Order.OrderBuilder()
                .setSample(new Sample("Blood", new Patient("Xavier")))
                .setEntryDate(new Date())
                .setTests(Arrays.asList(new GlucoseTest(), new HemoglobinTest()))
                .createOrder();
        testManager.executeOperation(order, IConsoleOperation.class);
        System.exit(0);
    }
}
