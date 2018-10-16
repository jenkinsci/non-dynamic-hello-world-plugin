package org.jenkinsci.plugins.sample.compat;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import hudson.Extension;
import jenkins.model.GlobalConfiguration;

import java.util.logging.Level;
import java.util.logging.Logger;

@Extension
public class DummyConfiguration extends GlobalConfiguration {
    private static final String ENVVAR_NAME = "NDHW_BOOLEAN";
    private boolean someField;

    private static final Logger LOGGER = Logger.getLogger(DummyConfiguration.class.getName());

    @SuppressFBWarnings("UR_UNINIT_READ")
    public DummyConfiguration() {
        final boolean newValue = Boolean.getBoolean(ENVVAR_NAME);

        LOGGER.log(Level.WARNING, "Saving value for field, previous={0}, new={1}", new Boolean[]{someField, newValue});
        this.someField = newValue;
        save();
    }
}
