package com.seminario;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Control {

    private final static Logger LOG = LoggerFactory.getLogger(FinalSeminarioApplication.class);

    public void call(String mensaje){
        LOG.error(String.valueOf(mensaje));
    }
}
