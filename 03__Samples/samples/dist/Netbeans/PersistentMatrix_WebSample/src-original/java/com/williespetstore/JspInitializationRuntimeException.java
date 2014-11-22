package com.williespetstore;

/**
 *
 * @author Peter Joh
 */
public class JspInitializationRuntimeException extends RuntimeException {
    public JspInitializationRuntimeException(String errorMsg) {
        super(errorMsg);
    }
    public JspInitializationRuntimeException(String errorMsg, Throwable cause) {
        super(errorMsg, cause);
    }

}
