package com.yasith.fileupload.conf;

import com.yasith.fileupload.api.Endpoints;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yasith on 1/18/17.
 */
public class ApplicationInitializer extends Application<ApplicationConfiguration>{

    final static Logger log = LoggerFactory.getLogger(ApplicationInitializer.class);

    public static void main(String[] args) throws Exception {
        new ApplicationInitializer().run(args);
    }

    @Override
    public void run(ApplicationConfiguration applicationConfiguration, Environment environment) throws Exception {
        if(log.isInfoEnabled()){
            log.info("Registering REST resources");
            log.info("Initializing Config");
        }
        ConfigReader.init(applicationConfiguration, environment);
        environment.jersey().register(new Endpoints());
        environment.jersey().register(MultiPartFeature.class);
    }

    @Override
    public void initialize(Bootstrap<ApplicationConfiguration> bootstrap) {

    }

}
