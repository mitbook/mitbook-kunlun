package com.mitbook.common.utils;

import com.google.common.collect.Maps;
import com.mitbook.common.Constant;
import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.QueryStringDecoder;
import io.netty.util.CharsetUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * @author pengzhengfa
 */
public class RequestUtil {

    private RequestUtil() {
    }

    public static Map<String, List<String>> getParameterMap(final FullHttpRequest request) {
        final String uri = request.uri();
        if (StringUtils.isNotBlank(uri)) {
            if (uri.contains(Constant.QUESTION)) {
                return new QueryStringDecoder(uri).parameters();
            }
        }
        return Maps.newTreeMap();
    }

    public static List<String> getParameterValue(final FullHttpRequest request, final String name) {
        return getParameterMap(request).get(name);
    }

    public static String getParameterFirstValue(final FullHttpRequest request, final String name) {
        return getParameterValue(request, name).iterator().next();
    }

    public static <T> T postEntity(final FullHttpRequest request, final Class<T> clazz) {
        final ByteBuf jsonBuf = request.content();
        final String json = jsonBuf.toString(CharsetUtil.UTF_8);
        return JsonUtil.fromJson(json, clazz);
    }
}
