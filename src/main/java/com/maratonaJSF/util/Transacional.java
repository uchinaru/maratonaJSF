package com.maratonaJSF.util;

import javax.interceptor.InterceptorBinding;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
//import java.lang.annotation.RetentionPolicy;
// import java.lang.annotation.Retention;

@Target({ ElementType.METHOD, ElementType.TYPE })
//@Retention(RetentionPolicy.RUNTIME) REMOVIDO ATE VERIFICAR O ERRO DE IMPORT
@InterceptorBinding
public @interface Transacional {

}