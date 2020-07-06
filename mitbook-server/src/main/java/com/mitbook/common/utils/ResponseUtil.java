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

import com.mitbook.common.response.GeneralResponse;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.*;

/**
 * @author pengzhengfa
 */
public class ResponseUtil {

    public ResponseUtil() {

    }

    public static void notFound(ChannelHandlerContext ctx, FullHttpRequest request) {
        response(ctx, request, GeneralResponse.NOT_FOUND);
    }

    public static void response(ChannelHandlerContext ctx, FullHttpRequest request, GeneralResponse generalResponse) {
        final byte[] jsonBytes = JsonUtil.toJson(generalResponse).getBytes();
        final FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, Unpooled.wrappedBuffer(jsonBytes));
        final HttpHeaders headers = response.headers();
        headers.set(HttpHeaderNames.CONTENT_TYPE, HttpHeaderValues.APPLICATION_JSON);
        headers.setInt(HttpHeaderNames.CONTENT_LENGTH, response.content().readableBytes());
        final boolean keepAlive = HttpUtil.isKeepAlive(request);
        if (!keepAlive) {
            ctx.write(response).addListener(ChannelFutureListener.CLOSE);
        } else {
            headers.set(HttpHeaderNames.CONNECTION, HttpHeaderValues.KEEP_ALIVE);
            ctx.write(response);
        }
        ctx.flush();
    }
}
