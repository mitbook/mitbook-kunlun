/*
 * Copyright 1999-2020 Mitbook Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
