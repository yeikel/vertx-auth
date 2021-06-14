/*
 * Copyright (c) 2021 Dmitry Novikov
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0, or the Apache License, Version 2.0
 * which is available at https://www.apache.org/licenses/LICENSE-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0 OR Apache-2.0
 */

package io.vertx.ext.auth.otp.utils;

import org.apache.commons.codec.binary.Base32;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

public class OtpKey implements SecretKey {

  private Key key;

  private final String encoded;

  public OtpKey(byte[] key, String algorithm) {
    this(new SecretKeySpec(key, algorithm));
  }

  public OtpKey(Key key) {
    this.key = key;
    encoded = new Base32(false).encodeToString(key.getEncoded());
  }

  @Override
  public String getAlgorithm() {
    return key.getAlgorithm();
  }

  @Override
  public String getFormat() {
    return key.getFormat();
  }

  @Override
  public byte[] getEncoded() {
    return key.getEncoded();
  }

  public String getBase32() {
    return encoded;
  }
}
