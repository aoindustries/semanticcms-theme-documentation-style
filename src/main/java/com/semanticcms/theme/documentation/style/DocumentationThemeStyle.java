/*
 * semanticcms-theme-documentation-style - Default style for SemanticCMS theme tailored for technical documentation.
 * Copyright (C) 2020  AO Industries, Inc.
 *     support@aoindustries.com
 *     7262 Bull Pen Cir
 *     Mobile, AL 36695
 *
 * This file is part of semanticcms-theme-documentation-style.
 *
 * semanticcms-theme-documentation-style is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * semanticcms-theme-documentation-style is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with semanticcms-theme-documentation-style.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.semanticcms.theme.documentation.style;

import com.aoindustries.web.resources.registry.Group;
import com.aoindustries.web.resources.registry.Style;
import com.aoindustries.web.resources.registry.Styles;
import com.aoindustries.web.resources.servlet.RegistryEE;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener("Registers the style in RegistryEE.")
public class DocumentationThemeStyle implements ServletContextListener {

	/**
	 * The name of the {@linkplain com.aoindustries.web.resources.servlet.RegistryEE.Application application-scope}
	 * group that will be used for the documentation theme.
	 */
	public static final Group.Name RESOURCE_GROUP = new Group.Name("semanticcms-theme-documentation-style");

	public static final Style THEME_CSS = new Style("/semanticcms-theme-documentation/styles/semanticcms-theme-documentation.css");
	public static final Style THEME_PRINT_CSS = Style.builder().uri("/semanticcms-theme-documentation/styles/semanticcms-theme-documentation-print.css").media("print").build();

	@Override
	public void contextInitialized(ServletContextEvent event) {
		// Add our CSS files
		Styles styles = RegistryEE.Application.get(event.getServletContext())
			.getGroup(RESOURCE_GROUP)
			.styles;
		styles.add(THEME_CSS);
		styles.add(THEME_PRINT_CSS);
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		// Do nothing
	}
}
