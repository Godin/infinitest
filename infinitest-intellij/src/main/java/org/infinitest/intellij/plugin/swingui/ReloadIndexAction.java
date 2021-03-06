/*
 * This file is part of Infinitest.
 *
 * Copyright (C) 2010
 * "Ben Rady" <benrady@gmail.com>,
 * "Rod Coffin" <rfciii@gmail.com>,
 * "Ryan Breidenbach" <ryan.breidenbach@gmail.com>, et al.
 *
 * Infinitest is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Infinitest is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Infinitest.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.infinitest.intellij.plugin.swingui;

import java.awt.event.ActionEvent;
import java.net.URL;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import org.infinitest.InfinitestCore;

public class ReloadIndexAction extends AbstractAction
{
    private static final long serialVersionUID = -1L;

    private final InfinitestCore core;

    public ReloadIndexAction(InfinitestCore core)
    {
        Icon icon = new ImageIcon(packageRelativeResource("reload.png", this.getClass()));
        putValue(Action.SMALL_ICON, icon);
        putValue(Action.SHORT_DESCRIPTION, "Force rebuild of dependency graph");
        this.core = core;
    }

    public void actionPerformed(ActionEvent e)
    {
        core.reload();
    }

    private static URL packageRelativeResource(String resourceName, Class<?> clazz)
    {
        String directoryPrefix = '/' + clazz.getPackage().getName().replaceAll("\\.", "/") + '/';
        return clazz.getResource(directoryPrefix + resourceName);
    }
}
