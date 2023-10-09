package com.popularsafi.service;

public class RiesgoResponseRest extends ResponseRest{

    private RiesgoResponse riesgoResponse = new RiesgoResponse();

    public RiesgoResponse getRiesgoResponse() {
        return riesgoResponse;
    }

    public void setRiesgoResponse(RiesgoResponse riesgoResponse) {
        this.riesgoResponse = riesgoResponse;
    }
}
