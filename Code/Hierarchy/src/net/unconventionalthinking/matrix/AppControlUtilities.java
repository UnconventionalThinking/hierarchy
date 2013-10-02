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

package net.unconventionalthinking.matrix;

import net.unconventionalthinking.lang.Boolean_Mutable;
import net.unconventionalthinking.reflection.DynamicClassUtilities;
import net.unconventionalthinking.reflection.MethodInvoker;
import java.net.URL;
import java.util.List;

/**
 *
 * @author peterjoh
 */
public class AppControlUtilities {


    /**
     * The purpose of this method is to load a jar's or project's appControl through the matrix or schema class. One of the main
     * reasons you'd want to do this is if a project uses a matrix/schema from another jar file, then the project should load the app control for that
     * matrix/schema. It does this through the "initialize_AppControl()" method found on the matrix/schema. NOTE: this should all happen automatically,
     * the developer shouldn't need to do this himself.<p>
     *
     * This version does not take an existing, parent appControl (the version of this method taht does take the appControl is the one that should normally
     * be used).
     *
     * @param matrixName_Full
     * @param running_AppControl_forMetacompilation   indicates if this appControl is being loaded for metacompilation (as opposed to actual, application runtime).
     */
    public static void loadAppControl_throughMatrixOrSchema(String matrixName_Full, List<URL> classPath,
            boolean running_AppControl_forMetacompilation) {


        try {
            //  Initialize the app control for the jar (will not init if it's already initialized)
            //  The initialization of the jar's app control should create the schema
            Class matrixClass = DynamicClassUtilities.classPath__dynLoadClass(classPath, matrixName_Full);

            MatrixContainer matrixContainer = (MatrixContainer)matrixClass.newInstance();
            matrixContainer.initialize_AppControl(running_AppControl_forMetacompilation);

        } catch (Exception e) {
            throw new ExceptRuntime_Matrix_GeneralError("While trying to initialize the schema named, " + matrixName_Full + ", had an error while " +
                    "trying to dynamically initialize the appControl.");
        }


    }
    

    /**
     * The purpose of this method is to load a jar's or project's appControl through the matrix or schema class. One of the main
     * reasons you'd want to do this is if a project uses a matrix/schema from another jar file, then the project should load the app control for that
     * matrix/schema. It does this through the "initialize_AppControl()" method found on the matrix/schema. NOTE: this should all happen automatically,
     * the developer shouldn't need to do this himself.
     *
     * @param matrixName_Full
     * @param existing_AppControl   The parent application context's appControl.
     * @param running_AppControl_forMetacompilation   indicates if this appControl is being loaded for metacompilation (as opposed to actual, application runtime).
     */
    public static void loadAppControl_throughMatrixOrSchema(String matrixName_Full, AppControl_Base existing_AppControl, List<URL> classPath,
            boolean running_AppControl_forMetacompilation)  {



        try {
            //  Initialize the app control for the jar (will not init if it's already initialized)
            //  The initialization of the jar's app control should create the schema
            Class matrixClass = DynamicClassUtilities.classPath__dynLoadClass(classPath, matrixName_Full);
            
            MatrixContainer matrixContainer = (MatrixContainer)matrixClass.newInstance();
            matrixContainer.initialize_AppControl(existing_AppControl, running_AppControl_forMetacompilation);

        } catch (Exception e) {
            throw new ExceptRuntime_Matrix_GeneralError("While trying to initialize the schema named, " + matrixName_Full + ", had an error while " +
                    "trying to dynamically initialize the appControl.", e);
        }


    }

}
