package com.evoltech.linecommand.components;

import com.evoltech.linecommand.service.DownloadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class ApplicationRunner implements CommandLineRunner {
    Logger log = LoggerFactory.getLogger(ApplicationRunner.class);
    @Autowired
    DownloadService downloadService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Dentro de Application runner");
        var ret = downloadService.getStringFromService();
        log.info("String de regreso del servicio " + ret);
        downloadService.downloadFromRemoteServer();
        log.info("download from remote server regreso del servicio " + ret);
    }
}
