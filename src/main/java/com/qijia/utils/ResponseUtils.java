package com.qijia.utils;

import com.qijia.domain.Result;
import com.qijia.utils.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * 响应工具类
 *
 * @author CaoChenLei
 */
public class ResponseUtils {
    private static final Logger logger = LoggerFactory.getLogger(ResponseUtils.class);

    /**
     * 向浏览器响应一个json字符串
     *
     * @param response 响应对象
     * @param status   状态码
     * @param message  响应信息
     */
    public static void write(HttpServletResponse response, boolean status, String message) {
        try {
            if (response.getHeader("Authorization") == null) {
                response.reset();
            }
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Request-Headers", "*");
            response.setHeader("Access-Control-Request-Method", "*");
            response.setHeader("Cache-Control", "no-cache");
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            response.setStatus(200);
            PrintWriter out = response.getWriter();
            out.write(JsonUtils.toString(new Result(status, null, message)));
            out.flush();
            out.close();
        } catch (Exception e) {
            logger.error("响应出错：" + message, e);
        }
    }

    /**
     * 向浏览器响应一个json字符串
     *
     * @param response 响应对象
     * @param status   状态码
     * @param message  响应信息
     * @param data     响应数据
     */
    public static void write(HttpServletResponse response, boolean status, String message, Object data) {
        try {
            if (response.getHeader("Authorization") == null) {
                response.reset();
            }
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Request-Headers", "*");
            response.setHeader("Access-Control-Request-Method", "*");
            response.setHeader("Cache-Control", "no-cache");
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            response.setStatus(200);
            PrintWriter out = response.getWriter();
            out.write(JsonUtils.toString(new Result(status, data, message)));
            out.flush();
            out.close();
        } catch (Exception e) {
            logger.error("响应出错：" + message, e);
        }
    }
}