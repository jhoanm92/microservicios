package com.user.config;

import com.user.exception.ModeloNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.ErrorResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class Interceptor implements HandlerInterceptor {

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // Este método se ejecuta después de que la vista haya sido renderizada
        System.out.println("entrooooooooooo");
        System.out.println(response.getStatus());
        if (ex != null) {
            // Manejar la excepción globalmente y construir una respuesta personalizada
            ModeloNotFoundException errorResponse = new ModeloNotFoundException("Error en la aplicación: " + ex.getMessage());
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write(errorResponse.toString());

        }
    }
}
