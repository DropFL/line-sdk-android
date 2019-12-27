package com.linecorp.linesdk.api;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;

import com.linecorp.linesdk.api.internal.OpenChatApiClientImpl;
import com.linecorp.linesdk.internal.AccessTokenCache;
import com.linecorp.linesdktest.BuildConfig;

/**
 * Class to create {@link LineApiClient} for test.
 */
public final class LineApiTestClientFactory {
    private LineApiTestClientFactory() {
        // To prevent instantiation
    }

    @NonNull
    public static LineApiClient createLineApiClient(
            @NonNull final Context context,
            @NonNull final String channelId) {
        return new LineApiClientBuilder(context, channelId)
                .apiBaseUri(Uri.parse(BuildConfig.API_SERVER_BASE_URI))
                .build();
    }

    @NonNull
    public static OpenChatApiClient createOpenchatApiClient(
            @NonNull final Context context,
            @NonNull final String channelId) {
        return new OpenChatApiClientImpl(
                context,
                Uri.parse(BuildConfig.API_SERVER_BASE_URI),
                new AccessTokenCache(context, channelId));
    }
}
