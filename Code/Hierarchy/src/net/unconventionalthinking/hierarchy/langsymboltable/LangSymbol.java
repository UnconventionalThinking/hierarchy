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

package net.unconventionalthinking.hierarchy.langsymboltable;

import net.unconventionalthinking.matrix.ExceptRuntime_DescriptorAccess;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author peterjoh
 */
public class LangSymbol {

    public enum SymbolType {
        Variable_Local, Variable_Class, Variable_MethodParameter, Class, Interface, Enum, Method,
        PackageName, Import_Package, Import_Type,
        //  Matrix Symbol-Types
        Matrix_MatrixAccess, Matrix_AnnotationHandler;
    }

    public enum SymbolModifier {
        Static("static"), Final("final"), Abstract("abstract"), Access_Public("public"), Access_Private("private"),
        Access_Protected("protected"), Access_Package("package"),
        Synchronized("synchronized"), Native("native"), Strictfp("strictfp"), Transient("transient"), Volatile("volatile"),
        JavaAnnotation("JavaAnnotation");

        private String value;

        private SymbolModifier(String value) { this.value = value; }

        public String getAsJavaKeyword() { return value; }

        public static SymbolModifier getEnumForStringValue(String value) {

            switch(value.charAt(0)) {
                case '@':
                    return JavaAnnotation;
                case 'a':
                    return Abstract;
                case 'f':
                    return Final;
                case 'n':
                    return Native;
                case 'p':
                    switch(value.charAt(1)) {
                        case 'a':
                            return Access_Package;
                        case 'r':
                            switch(value.charAt(2)) {
                                case 'i':
                                    return Access_Private;
                                case 'o':
                                    return Access_Protected;
                            }
                        case 'u':
                            return Access_Public;
                    }
                case 's':
                    switch(value.charAt(1)) {
                        case 't':
                            switch(value.charAt(2)) {
                                case 'a':
                                    return Static;
                                case 'r':
                                    return Strictfp;
                            }
                        case 'y':
                            return Synchronized;
                    }

                case 't':
                    return Transient;
                case 'v':
                    return Volatile;
            }

            throw new ExceptRuntime_LangSymbolTable("Could not find a modifer keyword for this token: " + value);
        }
    }


    public enum PrimitiveType  {
        Byte("byte"), Short("short"), Int("int"), Long("long"), Float("float"), Double("double"), Char("char"), Boolean("boolean");


        private String value;

        private PrimitiveType(String value) { this.value = value; }

        public String getAsJavaKeyword() { return value; }

        public static PrimitiveType getEnumForStringValue(String value) {

            switch(value.charAt(0)) {
                case 'b':
                    switch(value.charAt(1)) {
                        case 'o':
                            return Boolean;
                        case 'y':
                            return Byte;
                    }
                case 'c':
                    return Char;
                case 'd':
                    return Double;
                case 'f':
                    return Float;
                case 'i':
                    return Int;
                case 'l':
                    return Long;
                case 's':
                    return Short;

            }

            throw new ExceptRuntime_LangSymbolTable("Could not find a primitive type keyword for this token: " + value);
        }

    }






    

    
    public String               name;


    public SymbolType           symbolType;
    public Set<SymbolModifier>  modifiers;
    public int                  scopeID;

    public Object               otherInfo;


    LangSymbol(String name, SymbolType symbolType, int scopeID, Object otherInfo, SymbolModifier... modifiers) {
        
        this.name = name;
        this.symbolType = symbolType;
        this.scopeID = scopeID;
        this.otherInfo = otherInfo;

        this.modifiers = new HashSet<SymbolModifier>();
        for (SymbolModifier modifier : modifiers)
            this.modifiers.add(modifier);
        
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LangSymbol other = (LangSymbol) obj;
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        if (this.symbolType != other.symbolType && (this.symbolType == null || !this.symbolType.equals(other.symbolType))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 53 * hash + this.scopeID;
        return hash;
    }


    @Override
    public String toString() {
        return toString(0);
    }

	public String toString(int indentLevel) {
		StringBuilder indent_Builder = new StringBuilder();
		for(int i = 0; i < indentLevel; ++i)
			indent_Builder.append("\t");
		String indent = indent_Builder.toString();
		
		
		String out = indent + "Lang Symbol: " + name + "\n" +
				     indent + "\tsymbol type: " + symbolType +"\n" +
				     indent + "\tscopeID: " + scopeID + "\n";
		return out;
	}


}
