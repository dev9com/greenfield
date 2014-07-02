package com.dev9.service;

import com.dev9.data.SimpleData;
import com.google.common.base.Optional;
import com.yammer.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;

@Path("/green")
@Produces(MediaType.APPLICATION_JSON)
public class GreenfieldResource {

    private final String template;
    private final String defaultName;
    private final AtomicLong counter;

    public GreenfieldResource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

     @GET
     @Timed
     public SimpleData sayHello() {
         return new SimpleData();
     }
}
