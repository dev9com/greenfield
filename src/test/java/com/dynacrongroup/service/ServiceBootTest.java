package com.dynacrongroup.service;

import com.dynacrongroup.data.SimpleData;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.yammer.dropwizard.testing.junit.DropwizardServiceRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.fest.assertions.api.Assertions.assertThat;

public class ServiceBootTest {

    static final Logger LOG = LoggerFactory
            .getLogger(ServiceBootTest.class);

    @Rule
    public DropwizardServiceRule<GreenfieldConfiguration> serviceRule = new DropwizardServiceRule<>(GreenfieldService.class, "target/classes/test-greenfield.yml");

    private String MAIN_PATH;
    private String SERVICE_PATH;

    private Client client = new Client();

    @Before
    public void setPaths() {
        MAIN_PATH = String.format("http://localhost:%d/", serviceRule.getLocalPort());
        SERVICE_PATH = String.format("http://localhost:%d/service/green", serviceRule.getLocalPort());
    }

    @Test
    public void basicTest() {
        ClientResponse response = client.resource(MAIN_PATH)
                .get(ClientResponse.class);
        assertThat(response.getStatus()).isEqualTo(200);

        String text = response.getEntity(String.class);
        assertThat(text).contains("Hello");
        LOG.warn("Absolute minimum smoke test worked.");
    }

    @Test
    public void secondTest() {
        ClientResponse response = client.resource(MAIN_PATH)
                .get(ClientResponse.class);
        assertThat(response.getStatus()).isEqualTo(200);

        String text = response.getEntity(String.class);
        assertThat(text).contains("world");
    }

    @Test
    public void serviceTest() {
        ClientResponse response = client.resource(SERVICE_PATH)
                .get(ClientResponse.class);
        assertThat(response.getStatus()).isEqualTo(200);

        SimpleData responseEntity = response.getEntity(SimpleData.class);
        assertThat(responseEntity).isNotNull();
        assertThat(responseEntity.getHello()).isEqualTo("world");
    }


    @Test
    public void serviceRawTest() {
        ClientResponse response = client.resource(SERVICE_PATH)
                .get(ClientResponse.class);
        assertThat(response.getStatus()).isEqualTo(200);

        String raw = response.getEntity(String.class);

        assertThat(raw).contains("hello\":\"world");
    }

}
