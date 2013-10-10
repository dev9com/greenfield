package com.dynacrongroup.service;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.assets.AssetsBundle;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

public class GreenfieldService extends Service<GreenfieldConfiguration> {

    public static void main(String[] args) throws Exception {
        new GreenfieldService().run(args);
    }

    @Override
    public void initialize(Bootstrap<GreenfieldConfiguration> bootstrap) {
        bootstrap.setName("green");
        bootstrap.addBundle(new AssetsBundle("/static/", "/"));
    }

    @Override
    public void run(GreenfieldConfiguration configuration,
                    Environment environment) {
        String template = configuration.getTemplate();
        String defaultName = configuration.getDefaultName();
        environment.addResource(new GreenfieldResource(template, defaultName));
        environment.addHealthCheck(new GreenfieldHealthCheck(template));
    }
}
