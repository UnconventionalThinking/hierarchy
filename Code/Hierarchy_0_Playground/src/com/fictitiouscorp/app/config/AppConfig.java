/* Copyright 2012, 2013 Unconventional Thinking
 *
 * This file is part of Hierarchy.
 *
 * Hierarchy is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License 
 * as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 *
 * Hierarchy is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied 
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with Hierarchy.  
 * If not, see <http://www.gnu.org/licenses/>.
 */

package com.fictitiouscorp.app.config;

public class AppConfig {
	private final String id;
	private String logFile;
	private PersistenceConfig persistenceConfig;

	public AppConfig(String id, String logFile, PersistenceConfig config) {
		if (id == null || id.trim().equals("") || logFile == null
				|| logFile.trim().equals("") || config == null) {
			throw new IllegalArgumentException("Invalid parameter values.");
		}
		this.id = id;
		this.logFile = logFile;
		this.persistenceConfig = config;
	}

	public String getLogFile() {
		return logFile;
	}

	public void setLogFile(String logFile) {
		this.logFile = logFile;
	}

	public PersistenceConfig getPersistenceConfig() {
		return persistenceConfig;
	}

	public void setPersistenceConfig(PersistenceConfig persistenceConfig) {
		this.persistenceConfig = persistenceConfig;
	}

	public String getId() {
		return id;
	}
}
