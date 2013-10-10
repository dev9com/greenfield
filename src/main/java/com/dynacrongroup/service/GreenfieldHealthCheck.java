package com.dynacrongroup.service;

import com.yammer.metrics.core.HealthCheck;

public class GreenfieldHealthCheck extends HealthCheck {
    private final String template;

    public GreenfieldHealthCheck(String template) {
        super("template");
        this.template = template;
    }

    @Override
    protected Result check() throws Exception {
        String saying = String.format(template, "TEST");
        if (!saying.contains("TEST")) {
            return Result.unhealthy("template doesn't include a name");
        }
        return Result.healthy();
    }
}
