package org.infinitest.eclipse;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

/**
 * Controls the plug-in life cycle.
 */
public class InfinitestPlugin extends AbstractUIPlugin
{
    public static final String PLUGIN_ID = "org.infinitest.eclipse";
    private static InfinitestPlugin sharedInstance;
    private static Bundle pluginBundle;

    @Override
    // CHECKSTYLE:OFF
    // Idiomatic OSGI and checkstyle don't like each other
    public void start(BundleContext context) throws Exception
    // CHECKSTYLE:ON
    {
        super.start(context);
        sharedInstance = this;
    }

    @Override
    // CHECKSTYLE:OFF
    // Idiomatic OSGI and checkstyle don't like each other
    public void stop(BundleContext context) throws Exception
    // CHECKSTYLE:ON
    {
        sharedInstance = null;
        super.stop(context);
    }

    // Idiomatic OSGI
    public static InfinitestPlugin getInstance()
    {
        return sharedInstance;
    }

}
