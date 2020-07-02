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
