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
package com.mitbook.common.response;

import io.netty.handler.codec.http.HttpResponseStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author pengzhengfa
 */
@Data
@NoArgsConstructor
public class GeneralResponse<T> {

    public static final transient GeneralResponse NOT_FOUND = new GeneralResponse<>(HttpResponseStatus.NOT_FOUND, HttpResponseStatus.NOT_FOUND.reasonPhrase(), null);

    private static final transient HttpResponseStatus OK = HttpResponseStatus.OK;

    private static final transient HttpResponseStatus SERVER_ERROR = HttpResponseStatus.INTERNAL_SERVER_ERROR;

    private int status;

    private String message = "success";

    private T data;

    private GeneralResponse(final HttpResponseStatus responseStatus, final T data) {
        this.status = responseStatus.code();
        this.data = data;
    }

    private GeneralResponse(final HttpResponseStatus responseStatus, final String message, final T data) {
        this.status = responseStatus.code();
        this.message = message;
        this.data = data;
    }

    public static <T> GeneralResponse<T> success(final T data) {
        return new GeneralResponse<>(OK, data);
    }

    public static GeneralResponse success() {
        return success(null);
    }

    public static <T> GeneralResponse<T> error(final String message) {
        return new GeneralResponse<>(SERVER_ERROR, message, null);
    }
}
