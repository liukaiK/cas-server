package com.unicom.smartcity.util;

import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author liukai
 */
public class ResponseUtil {

    private ResponseUtil() {
    }


    public static void response(HttpServletResponse response, String content) throws IOException {
        response.setContentType(MediaType.APPLICATION_JSON.toString());
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        writer.write(content);
        writer.close();


    }

}
