package jas.javaspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootProducerApplication implements CommandLineRunner {
    @Autowired
    private WikimediaChangesProducer wikimediaChangesProducer;
    public static void main(String[] args) {
        SpringApplication.run(SpringBootProducerApplication.class);
        System.out.println("Producer is up and running...!");
    }

    @Override
    public void run(String... args) throws Exception {
        wikimediaChangesProducer.sendMessage();
    }
}