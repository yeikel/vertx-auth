/*
 * Copyright 2015 Red Hat, Inc.
 *
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  and Apache License v2.0 which accompanies this distribution.
 *
 *  The Eclipse Public License is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  The Apache License v2.0 is available at
 *  http://www.opensource.org/licenses/apache2.0.php
 *
 *  You may elect to redistribute this code under either of these licenses.
 */
package io.vertx.ext.auth.oauth2.impl.flow;

import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.auth.oauth2.AccessToken;
import io.vertx.ext.auth.oauth2.OAuth2ClientOptions;
import io.vertx.ext.auth.oauth2.impl.AccessTokenImpl;
import io.vertx.ext.auth.oauth2.impl.OAuth2AuthProviderImpl;

import static io.vertx.ext.auth.oauth2.impl.OAuth2API.*;

/**
 * @author Paulo Lopes
 */
public class AuthCodeImpl implements OAuth2Flow {

  private final OAuth2AuthProviderImpl provider;

  public AuthCodeImpl(OAuth2AuthProviderImpl provider) {
    this.provider = provider;
  }

  /**
   * Redirect the user to the authorization page
   * @param params  - redirectURI: A String that represents the registered application URI where the user is redirected after authorization.
   *                  scope:       A String that represents the application privileges.
   *                  state:       A String that represents an optional opaque value used by the client to maintain state between the request and the callback.
   */
  @Override
  public String authorizeURL(JsonObject params) {
    final JsonObject query = params.copy();
    final OAuth2ClientOptions config = provider.getConfig();

    query.put("response_type", "code");
    query.put("client_id", config.getClientID());

    return config.getSite() + config.getAuthorizationPath() + '?' + stringify(query);
  }

  /**
   * Returns the Access Token object.
   *
   * @param params - code:        Authorization code (from previous step).
   *                 redirectURI: A String that represents the callback uri.
   * @param handler - The handler returning the results.
   */
  @Override
  public void getToken(JsonObject params, Handler<AsyncResult<AccessToken>> handler) {
    final JsonObject query = params.copy();
    query.put("grant_type", "authorization_code");

    api(provider, HttpMethod.POST, provider.getConfig().getTokenPath(), query, res -> {
      if (res.succeeded()) {
        handler.handle(Future.succeededFuture(new AccessTokenImpl(provider, res.result())));
      } else {
        handler.handle(Future.failedFuture(res.cause()));
      }
    });
  }
}
