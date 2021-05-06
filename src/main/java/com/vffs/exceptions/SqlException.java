
package com.vffs.exceptions;

/**
 *
 * @author valeria
 */
public class SqlException extends RuntimeException{
    
    protected Throwable excecao;
    
    public SqlException(Throwable exception){
        this.excecao = exception;
    }
    
    public String getMensagem() {
       return this.excecao.toString();
    }
}
