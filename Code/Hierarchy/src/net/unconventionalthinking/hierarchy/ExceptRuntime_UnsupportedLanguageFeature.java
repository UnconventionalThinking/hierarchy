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


package net.unconventionalthinking.hierarchy;

import net.unconventionalthinking.hierarchy.*;



/**
 * When metacompiling, if you are metacompiling language feature that's unsupported, this error can be thrown
 *
 * @author peterjoh
 */
public class ExceptRuntime_UnsupportedLanguageFeature extends RuntimeException {

    public enum UnsupportedLanguageFeature { Intefaces, AnnotatedInterfaces }

    private UnsupportedLanguageFeature unsupportedLanguageFeature;

    public ExceptRuntime_UnsupportedLanguageFeature(UnsupportedLanguageFeature unsupportedLanguageFeature, String errorMsg) {
        super(errorMsg);

        this.unsupportedLanguageFeature = unsupportedLanguageFeature;
    }
    public ExceptRuntime_UnsupportedLanguageFeature(UnsupportedLanguageFeature unsupportedLanguageFeature, String errorMsg, Throwable cause) {
        super(errorMsg, cause);
        
        this.unsupportedLanguageFeature = unsupportedLanguageFeature;
    }

    public UnsupportedLanguageFeature getUnsupportedLanguageFeature() {
        return unsupportedLanguageFeature;
    }

    
}
