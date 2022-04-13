package com.avbravo.jmoordbcore.logger;

import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.Produces;
import jakarta.enterprise.inject.spi.InjectionPoint;

import java.util.logging.Logger;

/**
 *
 * @author hantsy
 */
@Dependent
public class LoggerResources {

    @Produces
    public Logger getLogger(InjectionPoint p) {
        return Logger.getLogger(p.getMember().getDeclaringClass().getName());
    }

}
