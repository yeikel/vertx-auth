/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package io.vertx.ext.auth.authorization.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * The following code has been adapted from the class WildcardPermission from
 * Apache Shiro
 *
 * A <code>WildcardPermission</code> is a very flexible permission construct
 * supporting multiple levels of permission matching. However, most people will
 * probably follow some standard conventions as explained below.
 * <p/>
 * <h3>Simple Usage</h3>
 * <p/>
 * In the simplest form, <code>WildcardPermission</code> can be used as a simple
 * permission string. You could grant a user an &quot;editNewsletter&quot;
 * permission and then check to see if the user has the editNewsletter
 * permission by calling
 * <p/>
 * <code>subject.isPermitted(&quot;editNewsletter&quot;)</code>
 * <p/>
 * This is (mostly) equivalent to
 * <p/>
 * <code>subject.isPermitted( new WildcardPermission(&quot;editNewsletter&quot;) )</code>
 * <p/>
 * but more on that later.
 * <p/>
 * The simple permission string may work for simple applications, but it
 * requires you to have permissions like
 * <code>&quot;viewNewsletter&quot;</code>,
 * <code>&quot;deleteNewsletter&quot;</code>,
 * <code>&quot;createNewsletter&quot;</code>, etc. You can also grant a user
 * <code>&quot;*&quot;</code> permissions using the wildcard character (giving
 * this class its name), which means they have <em>all</em> permissions. But
 * using this approach there's no way to just say a user has &quot;all
 * newsletter permissions&quot;.
 * <p/>
 * For this reason, <code>WildcardPermission</code> supports multiple
 * <em>levels</em> of permissioning.
 * <p/>
 * <h3>Multiple Levels</h3>
 * <p/>
 * WildcardPermission</code> also supports the concept of multiple
 * <em>levels</em>. For example, you could restructure the previous simple
 * example by granting a user the permission
 * <code>&quot;newsletter:edit&quot;</code>. The colon in this example is a
 * special character used by the <code>WildcardPermission</code> that delimits
 * the next token in the permission.
 * <p/>
 * In this example, the first token is the <em>domain</em> that is being
 * operated on and the second token is the <em>action</em> being performed. Each
 * level can contain multiple values. So you could simply grant a user the
 * permission <code>&quot;newsletter:view,edit,create&quot;</code> which gives
 * them access to perform <code>view</code>, <code>edit</code>, and
 * <code>create</code> actions in the <code>newsletter</code> <em>domain</em>.
 * Then you could check to see if the user has the
 * <code>&quot;newsletter:create&quot;</code> permission by calling
 * <p/>
 * <code>subject.isPermitted(&quot;newsletter:create&quot;)</code>
 * <p/>
 * (which would return true).
 * <p/>
 * In addition to granting multiple permissions via a single string, you can
 * grant all permission for a particular level. So if you wanted to grant a user
 * all actions in the <code>newsletter</code> domain, you could simply give them
 * <code>&quot;newsletter:*&quot;</code>. Now, any permission check for
 * <code>&quot;newsletter:XXX&quot;</code> will return <code>true</code>. It is
 * also possible to use the wildcard token at the domain level (or both): so you
 * could grant a user the <code>&quot;view&quot;</code> action across all
 * domains <code>&quot;*:view&quot;</code>.
 * <p/>
 * <h3>Instance-level Access Control</h3>
 * <p/>
 * Another common usage of the <code>WildcardPermission</code> is to model
 * instance-level Access Control Lists. In this scenario you use three tokens -
 * the first is the <em>domain</em>, the second is the <em>action</em>, and the
 * third is the <em>instance</em> you are acting on.
 * <p/>
 * So for example you could grant a user
 * <code>&quot;newsletter:edit:12,13,18&quot;</code>. In this example, assume
 * that the third token is the system's ID of the newsletter. That would allow
 * the user to edit newsletters <code>12</code>, <code>13</code>, and
 * <code>18</code>. This is an extremely powerful way to express permissions,
 * since you can now say things like <code>&quot;newsletter:*:13&quot;</code>
 * (grant a user all actions for newsletter <code>13</code>),
 * <code>&quot;newsletter:view,create,edit:*&quot;</code> (allow the user to
 * <code>view</code>, <code>create</code>, or <code>edit</code> <em>any</em>
 * newsletter), or <code>&quot;newsletter:*:*</code> (allow the user to perform
 * <em>any</em> action on <em>any</em> newsletter).
 * <p/>
 * To perform checks against these instance-level permissions, the application
 * should include the instance ID in the permission check like so:
 * <p/>
 * <code>subject.isPermitted( &quot;newsletter:edit:13&quot; )</code>
 * <p/>
 * There is no limit to the number of tokens that can be used, so it is up to
 * your imagination in terms of ways that this could be used in your
 * application. However, the Shiro team likes to standardize some common usages
 * shown above to help people get started and provide consistency in the Shiro
 * community.
 *
 */
class WildcardExpression {

  protected static final String PART_DIVIDER_TOKEN = ":";
  protected static final String SUBPART_DIVIDER_TOKEN = ",";
  protected static final String WILDCARD_TOKEN = "*";

  /*--------------------------------------------
  |    I N S T A N C E   V A R I A B L E S    |
  ============================================*/
  private List<Set<String>> parts;
  private final String value;

  /*--------------------------------------------
  |         C O N S T R U C T O R S           |
  ============================================*/
  public WildcardExpression(String value) {
    Objects.requireNonNull(value);

    this.value = value.trim();
    if (value.isEmpty()) {
      throw new IllegalArgumentException("Wildcard value cannot be empty");
    }
    setParts(value);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (!(obj instanceof WildcardExpression))
      return false;
    WildcardExpression other = (WildcardExpression) obj;
    return Objects.equals(parts, other.parts);
  }

  /*--------------------------------------------
  |  A C C E S S O R S / M O D I F I E R S    |
  ============================================*/

  @Override
  public int hashCode() {
    return Objects.hash(parts);
  }

  /*--------------------------------------------
  |               M E T H O D S               |
  ============================================*/

  public boolean implies(String p) {
    if (p == null) {
      return false;
    }
    // fast path by simply testing string equality
    if (value.equals(p)) {
      return true;
    }
    // slightly slower path where we've got to convert 'p' to a wildcard
    return implies(new WildcardExpression(p));
  }

  public boolean implies(WildcardExpression p) {
    if (p == null) {
      return false;
    }

    // By default only supports comparisons with other WildcardPermissions
    List<Set<String>> otherParts = p.parts;

    int i = 0;
    for (Set<String> otherPart : otherParts) {
      // If this permission has less parts than the other permission, everything after
      // the number of parts contained
      // in this permission is automatically implied, so return true
      if (parts.size() - 1 < i) {
        return true;
      } else {
        Set<String> part = parts.get(i);
        if (!part.contains(WILDCARD_TOKEN) && !part.containsAll(otherPart)) {
          return false;
        }
        i++;
      }
    }

    // If this permission has more parts than the other parts, only imply it if all
    // of the other parts are wildcards
    for (; i < parts.size(); i++) {
      Set<String> part = parts.get(i);
      if (!part.contains(WILDCARD_TOKEN)) {
        return false;
      }
    }
    return true;
  }

  protected void setParts(String wildcardString) {
    wildcardString = wildcardString.trim();

    if (wildcardString.isEmpty()) {
      throw new IllegalArgumentException("Wildcard string cannot be empty");
    }

    this.parts = new ArrayList<>();
    for (String part : wildcardString.split(PART_DIVIDER_TOKEN)) {
      Set<String> subparts = new LinkedHashSet<>(Arrays.asList(part.split(SUBPART_DIVIDER_TOKEN)));
      if (subparts.isEmpty()) {
        throw new IllegalArgumentException(
            "Wildcard string cannot contain parts with only dividers. Make sure permission strings are properly formatted.");
      }
      this.parts.add(subparts);
    }

    if (this.parts.isEmpty()) {
      throw new IllegalArgumentException(
          "Wildcard string cannot contain only dividers. Make sure permission strings are properly formatted.");
    }
  }

  public String toString() {
    return value;
  }

}
