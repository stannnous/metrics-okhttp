/*
 * Copyright 2015 Ras Kasa Williams
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.raskasa.metrics.okhttp;

import com.codahale.metrics.MetricRegistry;
import com.squareup.okhttp.Authenticator;
import com.squareup.okhttp.Cache;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.CertificatePinner;
import com.squareup.okhttp.ConnectionPool;
import com.squareup.okhttp.ConnectionSpec;
import com.squareup.okhttp.Dispatcher;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.Request;
import java.net.CookieHandler;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

public final class InstrumentedOkHttpClient extends OkHttpClient {
  private final MetricRegistry registry;
  private final OkHttpClient client;

  public InstrumentedOkHttpClient(MetricRegistry registry, OkHttpClient client) {
    this.registry = registry;
    this.client = client;
  }

  @Override public void setConnectTimeout(long timeout, TimeUnit unit) {
    client.setConnectTimeout(timeout, unit);
  }

  @Override public int getConnectTimeout() {
    return client.getConnectTimeout();
  }

  @Override public void setReadTimeout(long timeout, TimeUnit unit) {
    client.setReadTimeout(timeout, unit);
  }

  @Override public int getReadTimeout() {
    return client.getReadTimeout();
  }

  @Override public void setWriteTimeout(long timeout, TimeUnit unit) {
    client.setWriteTimeout(timeout, unit);
  }

  @Override public int getWriteTimeout() {
    return client.getWriteTimeout();
  }

  @Override public OkHttpClient setProxy(Proxy proxy) {
    return client.setProxy(proxy);
  }

  @Override public Proxy getProxy() {
    return client.getProxy();
  }

  @Override public OkHttpClient setProxySelector(ProxySelector proxySelector) {
    return client.setProxySelector(proxySelector);
  }

  @Override public ProxySelector getProxySelector() {
    return client.getProxySelector();
  }

  @Override public OkHttpClient setCookieHandler(CookieHandler cookieHandler) {
    return client.setCookieHandler(cookieHandler);
  }

  @Override public CookieHandler getCookieHandler() {
    return client.getCookieHandler();
  }

  @Override public OkHttpClient setCache(Cache cache) {
    return client.setCache(cache);
  }

  @Override public Cache getCache() {
    return client.getCache();
  }

  @Override public OkHttpClient setSocketFactory(SocketFactory socketFactory) {
    return client.setSocketFactory(socketFactory);
  }

  @Override public SocketFactory getSocketFactory() {
    return client.getSocketFactory();
  }

  @Override public OkHttpClient setSslSocketFactory(SSLSocketFactory sslSocketFactory) {
    return client.setSslSocketFactory(sslSocketFactory);
  }

  @Override public SSLSocketFactory getSslSocketFactory() {
    return client.getSslSocketFactory();
  }

  @Override public OkHttpClient setHostnameVerifier(HostnameVerifier hostnameVerifier) {
    return client.setHostnameVerifier(hostnameVerifier);
  }

  @Override public HostnameVerifier getHostnameVerifier() {
    return client.getHostnameVerifier();
  }

  @Override public OkHttpClient setCertificatePinner(CertificatePinner certificatePinner) {
    return client.setCertificatePinner(certificatePinner);
  }

  @Override public CertificatePinner getCertificatePinner() {
    return client.getCertificatePinner();
  }

  @Override public OkHttpClient setAuthenticator(Authenticator authenticator) {
    return client.setAuthenticator(authenticator);
  }

  @Override public Authenticator getAuthenticator() {
    return client.getAuthenticator();
  }

  @Override public OkHttpClient setConnectionPool(ConnectionPool connectionPool) {
    return client.setConnectionPool(connectionPool);
  }

  @Override public ConnectionPool getConnectionPool() {
    return client.getConnectionPool();
  }

  @Override public OkHttpClient setFollowSslRedirects(boolean followProtocolRedirects) {
    return client.setFollowSslRedirects(followProtocolRedirects);
  }

  @Override public boolean getFollowSslRedirects() {
    return client.getFollowSslRedirects();
  }

  @Override public void setFollowRedirects(boolean followRedirects) {
    client.setFollowRedirects(followRedirects);
  }

  @Override public boolean getFollowRedirects() {
    return client.getFollowRedirects();
  }

  @Override public void setRetryOnConnectionFailure(boolean retryOnConnectionFailure) {
    client.setRetryOnConnectionFailure(retryOnConnectionFailure);
  }

  @Override public boolean getRetryOnConnectionFailure() {
    return client.getRetryOnConnectionFailure();
  }

  @Override public OkHttpClient setDispatcher(Dispatcher dispatcher) {
    return client.setDispatcher(dispatcher);
  }

  @Override public Dispatcher getDispatcher() {
    return client.getDispatcher();
  }

  @Override public OkHttpClient setProtocols(List<Protocol> protocols) {
    return client.setProtocols(protocols);
  }

  @Override public List<Protocol> getProtocols() {
    return client.getProtocols();
  }

  @Override public OkHttpClient setConnectionSpecs(List<ConnectionSpec> connectionSpecs) {
    return client.setConnectionSpecs(connectionSpecs);
  }

  @Override public List<ConnectionSpec> getConnectionSpecs() {
    return client.getConnectionSpecs();
  }

  @Override public List<Interceptor> interceptors() {
    return client.interceptors();
  }

  @Override public List<Interceptor> networkInterceptors() {
    return client.networkInterceptors();
  }

  @Override public Call newCall(Request request) {
    return client.newCall(request);
  }

  @Override public OkHttpClient cancel(Object tag) {
    return client.cancel(tag);
  }

  @Override public OkHttpClient clone() {
    return client.clone();
  }

  @Override public boolean equals(Object obj) {
    return
        obj instanceof InstrumentedOkHttpClient
        && client.equals(((InstrumentedOkHttpClient) obj).client);
  }

  @Override public String toString() {
    return client.toString();
  }
}
