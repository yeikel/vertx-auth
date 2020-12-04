package io.vertx.ext.jwt;

import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import org.junit.Ignore;
import org.junit.Test;

import java.security.cert.CertificateExpiredException;

import static org.junit.Assert.*;

public class JWKTest {

  @Test
  public void publicRSA() {
    JsonObject jwk = new JsonObject()
      .put("kty", "RSA")
      .put("n", "0vx7agoebGcQSuuPiLJXZptN9nndrQmbXEps2aiAFbWhM78LhWx4cbbfAAtVT86zwu1RK7aPFFxuhDR1L6tSoc_BJECPebWKRXjBZCiFV4n3oknjhMstn64tZ_2W-5JsGY4Hc5n9yBXArwl93lqt7_RN5w6Cf0h4QyQ5v-65YGjQR0_FDW2QvzqY368QQMicAtaSqzs8KJZgnYb9c7d0zgdAZHzu6qMQvRL5hajrn1n91CbOpbISD08qNLyrdkt-bFTWhAI4vMQFh6WeZu0fM4lFd2NcRwr3XPksINHaQ-G_xBniIqbw0Ls1jF44-csFCur-kEgU8awapJzKnqDKgw")
      .put("e", "AQAB")
      .put("alg", "RS256")
      .put("kid", "2011-04-29");

    new JWK(jwk);
  }

  @Test
  public void publicEC() {
    JsonObject jwk = new JsonObject()
      .put("kty", "EC")
      .put("crv", "P-256")
      .put("x", "MKBCTNIcKUSDii11ySs3526iDZ8AiTo7Tu6KPAqv7D4")
      .put("y", "4Etl6SRW2YiLUrN5vfvVHuhp7x8PxltmWWlbbM4IFyM")
//      .put("use", "enc")
      .put("kid", "1");

    new JWK(jwk);
  }

  @Test
  public void privateEC() {
    JsonObject jwk = new JsonObject()
      .put("kty", "EC")
      .put("crv", "P-256")
      .put("x", "MKBCTNIcKUSDii11ySs3526iDZ8AiTo7Tu6KPAqv7D4")
      .put("y", "4Etl6SRW2YiLUrN5vfvVHuhp7x8PxltmWWlbbM4IFyM")
      .put("d", "870MB6gfuTJ4HtUnUvYMyJpr5eUZNP4Bk43bVdj3eAE")
//      .put("use", "enc")
      .put("kid", "1");

    new JWK(jwk);
  }

  @Test
  public void privateRSA() {
    JsonObject jwk = new JsonObject()
      .put("kty", "RSA")
      .put("n", "0vx7agoebGcQSuuPiLJXZptN9nndrQmbXEps2aiAFbWhM78LhWx4cbbfAAtVT86zwu1RK7aPFFxuhDR1L6tSoc_BJECPebWKRXjBZCiFV4n3oknjhMstn64tZ_2W-5JsGY4Hc5n9yBXArwl93lqt7_RN5w6Cf0h4QyQ5v-65YGjQR0_FDW2QvzqY368QQMicAtaSqzs8KJZgnYb9c7d0zgdAZHzu6qMQvRL5hajrn1n91CbOpbISD08qNLyrdkt-bFTWhAI4vMQFh6WeZu0fM4lFd2NcRwr3XPksINHaQ-G_xBniIqbw0Ls1jF44-csFCur-kEgU8awapJzKnqDKgw")
      .put("e", "AQAB")
      .put("d", "X4cTteJY_gn4FYPsXB8rdXix5vwsg1FLN5E3EaG6RJoVH-HLLKD9M7dx5oo7GURknchnrRweUkC7hT5fJLM0WbFAKNLWY2vv7B6NqXSzUvxT0_YSfqijwp3RTzlBaCxWp4doFk5N2o8Gy_nHNKroADIkJ46pRUohsXywbReAdYaMwFs9tv8d_cPVY3i07a3t8MN6TNwm0dSawm9v47UiCl3Sk5ZiG7xojPLu4sbg1U2jx4IBTNBznbJSzFHK66jT8bgkuqsk0GjskDJk19Z4qwjwbsnn4j2WBii3RL-Us2lGVkY8fkFzme1z0HbIkfz0Y6mqnOYtqc0X4jfcKoAC8Q")
      .put("p", "83i-7IvMGXoMXCskv73TKr8637FiO7Z27zv8oj6pbWUQyLPQBQxtPVnwD20R-60eTDmD2ujnMt5PoqMrm8RfmNhVWDtjjMmCMjOpSXicFHj7XOuVIYQyqVWlWEh6dN36GVZYk93N8Bc9vY41xy8B9RzzOGVQzXvNEvn7O0nVbfs")
      .put("q", "3dfOR9cuYq-0S-mkFLzgItgMEfFzB2q3hWehMuG0oCuqnb3vobLyumqjVZQO1dIrdwgTnCdpYzBcOfW5r370AFXjiWft_NGEiovonizhKpo9VVS78TzFgxkIdrecRezsZ-1kYd_s1qDbxtkDEgfAITAG9LUnADun4vIcb6yelxk")
      .put("dp", "G4sPXkc6Ya9y8oJW9_ILj4xuppu0lzi_H7VTkS8xj5SdX3coE0oimYwxIi2emTAue0UOa5dpgFGyBJ4c8tQ2VF402XRugKDTP8akYhFo5tAA77Qe_NmtuYZc3C3m3I24G2GvR5sSDxUyAN2zq8Lfn9EUms6rY3Ob8YeiKkTiBj0")
      .put("dq", "s9lAH9fggBsoFR8Oac2R_E2gw282rT2kGOAhvIllETE1efrA6huUUvMfBcMpn8lqeW6vzznYY5SSQF7pMdC_agI3nG8Ibp1BUb0JUiraRNqUfLhcQb_d9GF4Dh7e74WbRsobRonujTYN1xCaP6TO61jvWrX-L18txXw494Q_cgk")
      .put("qi", "GyM_p6JrXySiz1toFgKbWV-JdI3jQ4ypu9rbMWx3rQJBfmt0FoYzgUIZEVFEcOqwemRN81zoDAaa-Bk0KWNGDjJHZDdDmFhW3AN7lI-puxk_mHZGJ11rxyR8O55XLSe3SPmRfKwZI6yU24ZxvQKFYItdldUKGzO6Ia6zTKhAVRU")
      .put("alg", "RS256")
      .put("kid", "2011-04-29");

    new JWK(jwk);
  }

  @Test
  public void keycloakRSA() {
    JsonObject jwk = new JsonObject()
      .put("kty", "RSA")
      .put("n", "m8fbXeoEBu1eRE1Tsgq_L414mbiNPOhFNT20jKM-rd6nspp-7xoCsuYfuqUwEgAYAB_kRnTwcZj_SZXiQvauvM4-Howa6VpwPriZc3BRpzT4LBiskYBqoXslmRq7KMrNi0X-NKw4U1GIVfbYSSeoODpVj2IvC8hYUvzRF8w989DNHlduFyHweXcsOmGlHb9KZNyYy5N2zGNy5WHdtRuwGie7J5yKsJ4y0-YsJQG2GrkgDCa1ulS961KIrqLCEdLkoTsvJvnGPEXbajOQ2tIuh3iiIXY3QfMF05908Mhr0vzdApeHSdYrvv6WTyu66xj6prm_TaWcyfCqubYb53MIqQ")
      .put("alg", "RS256")
      .put("e", "AQAB")
      .put("use", "sig")
      .put("kid", "-s66_hGKPJ6ISSKeQyxslRl-cjQaqvcxoUlqIWj4CxM");

    JWK key = new JWK(jwk);
  }

  @Test
  public void x509CertChain() {

    JWT jwt = new JWT();

    assertThrows(CertificateExpiredException.class, () -> {
      try {
        jwt.addJWK(new JWK(new JsonObject()
          .put("kty", "RSA")
          .put("alg", "RS256")
          .put("x5c", new JsonArray().add(
            "MIIDJjCCAg6gAwIBAgIIZtJv8PyRUgowDQYJKoZIhvcNAQEFBQAwNjE0MDIGA1UEAxMrZmVkZXJhdGVkLXNpZ25vbi5zeXN0ZW0uZ3NlcnZpY2VhY2NvdW50LmNvbTAeFw0xNzEwMDgxMTQzMzRaFw0xNzEwMTExMjEzMzRaMDYxNDAyBgNVBAMTK2ZlZGVyYXRlZC1zaWdub24uc3lzdGVtLmdzZXJ2aWNlYWNjb3VudC5jb20wggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQC6fNn5kfLZQ43Z+ZTqFMUF+dN2L2BphQKzgaWCsyzyJYwEySgMxbO8cQgTlgZzcC1Rt6phWHMBkFQQNykSk/K0A8xaaNqFNNVzeszR+XJ3IvCQGo8rS2K/LrNofGZrph00k6DZ7XJsWav0GotAwDd0H6IsNbFHCyRJ75ASzZr8fT8RJ9bQeTLoCsmwPXYBPeSvoWgZzOypbmLhohw0J7fBUbgVZ8fR3crhv6RDOp4/fDALWxCVPptFn0hMPeT2Dla9kbnPfVSWtciyvty5JJXnpuoqA6rLfEpMGYnMSk+SbD2R0W9O2LMRfoJ52qml+2s/aLpNKGJc2vLzDyH7CiavAgMBAAGjODA2MAwGA1UdEwEB/wQCMAAwDgYDVR0PAQH/BAQDAgeAMBYGA1UdJQEB/wQMMAoGCCsGAQUFBwMCMA0GCSqGSIb3DQEBBQUAA4IBAQAlDoCH/E43ruorgPIATCO++dOfOIb/n+NgE727UeK1acELi+dUjSdYEe+WXdY2sichgE1JqPrsMWFHCwHTUfVubmku5BTklj9k6F9jKc+XDMra1w0KGSGrxwSqwYhkhSdMOGGa9C3td+s7M/E4JV+XoQXAY3uEaB0lO4c+pckDwU/LAGrMldogT3+zE+4NRS7p8dstnww3OIHUCFfytbhcY8sH4VjqdMWGrv8R/1L0jXok8vFPEAwvXzVc3NeUClio0hOEmhTjbLgebsgToB1aNC1pnzmHTclVndTwDcnDkhImpvuWE1lX+KPkFJ54ixS4Bi2cqWud1aQ2Mqi7KHfK"
          ))));
      } catch (RuntimeException e) {
        throw e.getCause();
      }
    });

    assertThrows(CertificateExpiredException.class, () -> {
      try {
        jwt.addJWK(new JWK(new JsonObject()
        .put("kty", "RSA")
        .put("alg", "RS256")
        .put("x5c", new JsonArray().add(
          "MIIDJjCCAg6gAwIBAgIIeABc0/4wb7AwDQYJKoZIhvcNAQEFBQAwNjE0MDIGA1UEAxMrZmVkZXJhdGVkLXNpZ25vbi5zeXN0ZW0uZ3NlcnZpY2VhY2NvdW50LmNvbTAeFw0xNzEwMDkxMTQzMzRaFw0xNzEwMTIxMjEzMzRaMDYxNDAyBgNVBAMTK2ZlZGVyYXRlZC1zaWdub24uc3lzdGVtLmdzZXJ2aWNlYWNjb3VudC5jb20wggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQC3ICz+C7FKE4jbsRh/cZK1I9M5lXGlyvk8c72BuK3/uLwnRH5eSrooA1LEqwVdKV5MOTuHHnxWFb57yyBl8Ld3CGK/aeZYIGd6iV8ym/jw6rCdJhkL6yCZ3/Xj3+Un+5Vf+ObjHd04X/GbwleFRcldJilpgwtt0PKT/JBl/lKqTzzH/HWzdp3tj5gfVJzj1NxfN4K0GSFDy/5pRYsT9NebFC/JoBgSXrEEZXaigqQsYiI+lTDL59TLq8XaaT0V1sfoHnspu3DikgO51eJBP3c0wB2CvXxk+vMlSQMsnDcsztiijGPwrpxrLwDyzsm3Rs7WI9kDHPeUeKhGX0/s9AnBAgMBAAGjODA2MAwGA1UdEwEB/wQCMAAwDgYDVR0PAQH/BAQDAgeAMBYGA1UdJQEB/wQMMAoGCCsGAQUFBwMCMA0GCSqGSIb3DQEBBQUAA4IBAQAiZt536sXwNXqUs92edWsQ+uiraJblATuMSslrQhGJjUebmlpIUMe8Dv2dj+/bYK7gZyjUQKwjmtCJ+U8Z2Ec/v9yEqKpyzfYIOTF/17d31OvisnccIbjBL2X+b/OHsFDjaY5hZrs0mczr1ePaYlE/EsyIFEZCwGbgarp7FxlRrdJEBN8jnjUgK6Kig2GLtcQcHfkIjxmVDzgS47TAtxPNTBGQypWubALTWt+WTAFpQGcW6pj9nOxuV2XB4RkFg7XrHtnBvad4/KAD/kp2if6BFyvwWcyQzKqqKcjJHinaGWf7qlBLBJTQcZcWPJEzFdwBsHHejgU8vy9hR97rvU8s"
        ))));
      } catch (RuntimeException e) {
        throw e.getCause();
      }
    });

    assertThrows(CertificateExpiredException.class, () -> {
      try {
        jwt.addJWK(new JWK(new JsonObject()
        .put("kty", "RSA")
        .put("alg", "RS256")
        .put("x5c", new JsonArray().add(
          "MIIDJjCCAg6gAwIBAgIIcz32mW0b5V8wDQYJKoZIhvcNAQEFBQAwNjE0MDIGA1UEAxMrZmVkZXJhdGVkLXNpZ25vbi5zeXN0ZW0uZ3NlcnZpY2VhY2NvdW50LmNvbTAeFw0xNzEwMDcxMTQzMzRaFw0xNzEwMTAxMjEzMzRaMDYxNDAyBgNVBAMTK2ZlZGVyYXRlZC1zaWdub24uc3lzdGVtLmdzZXJ2aWNlYWNjb3VudC5jb20wggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQDDmL6MaLATK497Ce9H6UVx4FFiHiDH3X44UtonDCvzIKtJVzMCDJzXDLAUEKxQEMGEekpJWKWogYbZ8iqF1fb8gUn47Fi9cOYm1gXr2RZNp9mMW2cCXwR0iqPVf7LfU+b2BgP+th4sbcJmE0uMgT/L1+Tn8xs45zRn5uvj/DOKeDod8REhNsA4B8J3xGLT+1cOpiCL4LUL+CzYeF5gQhaqlnax7xSwa8iDa5484JXwbdrR+6+HqGCO62yl8n9Ufd54fBjDJjOJ6r6wNZzJXmoaWcmn1NmVn3PbjZZ1gePcLaS501NSDvqnqy9uzpy7VmJkD1ZmRov13yFZ4ni0tCDdAgMBAAGjODA2MAwGA1UdEwEB/wQCMAAwDgYDVR0PAQH/BAQDAgeAMBYGA1UdJQEB/wQMMAoGCCsGAQUFBwMCMA0GCSqGSIb3DQEBBQUAA4IBAQAfVSQFYR21K1IynPE/g0aYueSQHvbo7SaT/iCmLS4g4EXqpGFGSMgQZWe9FckFYqAkJZ8AS2BtlzflfNYBH9K6V++sm5xxhsH+DmS/dXUQrSWuwKc5sS385D5kg2vJlqO1snCYOg1iEMkvU36mEO3o0kAi+2g1NWOWiCFLLqoC4onmwDKv/K5qpwb2n3+IUbaS8R/cgGsq6B7ohCSrdHfErOOitNsynLO733lcFJKYxrYu4/OpvGkKBaxGf8h1BsDmNfenfYq4ak0N+8nTxPfc0fARyCkHSJPQ5WWMfi14d7J6hjc8qZHIDsAiJ50LB36Nk9p+KEQT5yh3UFbPXJO6"
        ))));
      } catch (RuntimeException e) {
        throw e.getCause();
      }
    });

    assertThrows(RuntimeException.class, () -> jwt.decode("eyJhbGciOiJSUzI1NiIsImtpZCI6Ijc0MjQzMGI2ZDRkZjQxMzVlM2JkOTgyYWM2YmVjNDNhMTE4ODhkMWIifQ.eyJhenAiOiI1ODUyMDUyMjk1NzctZGlxZ2l1NWkwbjNoN2hzZmF0cG91MzY0OXVvaGduOWkuYXBwcy5nb29nbGV1c2VyY29udGVudC5jb20iLCJhdWQiOiI1ODUyMDUyMjk1NzctZGlxZ2l1NWkwbjNoN2hzZmF0cG91MzY0OXVvaGduOWkuYXBwcy5nb29nbGV1c2VyY29udGVudC5jb20iLCJzdWIiOiIxMDI1ODI3NDEyNjA5NDc1ODQxNDQiLCJhdF9oYXNoIjoicGJWZE1Nb3l6UDl5UU9sMk54bkJDUSIsImlzcyI6ImFjY291bnRzLmdvb2dsZS5jb20iLCJpYXQiOjE1MDc1NzgyMDMsImV4cCI6MTUwNzU4MTgwM30.cU21Gu1jEcAONlQ0vf0ju8W7gsdyzPo-U3U6JCFaVqYqF5J2JmhCSk_-kJcY19WKyg8iwibOSNuuQE8PP0eCiIWDY-fq_3wOoO4IBUa5zlmTMNdz9Af4vH2h-optaG89tXE89J_-D2TjkKDdu1nPVLefX6E95vjb3P9LP5LfFJV53zT_deacFn4XiyCVMBl7sfNE0A6YG3PmZkVNgyIYJCv21bB5N_YtWTSEV_8YSFaJwDcEihqBGiFe3fO3k9-A237HuKevBRfo_xAyIQXnCHiLg8eETGTK3sfRh_ugxMI0jvgt4hBZQTioGjnaMRmQxaiJ_3IOrpSJeMu_JIg8-g"));
    assertThrows(RuntimeException.class, () -> jwt.decode("eyJhbGciOiJSUzI1NiIsImtpZCI6ImMzODM1NWU3MjA5ZTlmOTkwOWJlODUxOTIyODhkMDg1OTY1NGEyOTUifQ.eyJhenAiOiI1ODUyMDUyMjk1NzctZGlxZ2l1NWkwbjNoN2hzZmF0cG91MzY0OXVvaGduOWkuYXBwcy5nb29nbGV1c2VyY29udGVudC5jb20iLCJhdWQiOiI1ODUyMDUyMjk1NzctZGlxZ2l1NWkwbjNoN2hzZmF0cG91MzY0OXVvaGduOWkuYXBwcy5nb29nbGV1c2VyY29udGVudC5jb20iLCJzdWIiOiIxMDI1ODI3NDEyNjA5NDc1ODQxNDQiLCJhdF9oYXNoIjoiV1hJZlQ3WWVIaWZUaXVmRkt2NldJZyIsImlzcyI6ImFjY291bnRzLmdvb2dsZS5jb20iLCJpYXQiOjE1MDc1Nzk5MTEsImV4cCI6MTUwNzU4MzUxMX0.fZ_Z0Xz3Odef-1_iZbpn50h9vQ6mtY7Fqc69cWsfX_8f699252hNPnZWDvw_gfe0HU1b8hvGKIbR7ZTzzqqzgMBRW8Jy7FqNAj0zlKi2OIMaQlWFmQG7owMQOYXuc0FSI_EMCjBVe7jdbkFxZ6PTa6o0k-A88Aw2NEmLitTSp2WSPtcSu7o_oV3DawC0qUyMyP-xhG5rPEbhpn0WJ4f3NGV8qY1wY2nsV9PdO985IQQJNjp3DHoV1eWQDsg0v1ouTnGjNVLWRIxV2CZPW6T9PpkQO9eh5WBoqCAKfVg3mBGs0Am0xdh-GSqwejBpPWqVQyXVDfjCbHYTan8li3rPSg"));
  }

  @Test
  public void symmetricHMAC() {
    JsonObject jwk = new JsonObject()
      .put("kty", "oct")
      .put("k", "AyM1SysPpbyDfgZld3umj1qzKObwVMkoqQ-EstJQLr_T-1qS0gZH75aKtMN3Yj0iPS4hcgUuTwjAzZr1Z9CAow");

    new JWK(jwk);
  }

  @Test(expected = CertificateExpiredException.class)
  public void testBackportX5cSupport() throws Throwable {
    JsonObject jwk = new JsonObject(
      "{\n" +
      "  \"x5c\": [\n" +
      "    \"MIIE3jCCA8agAwIBAgICAwEwDQYJKoZIhvcNAQEFBQAwYzELMAkGA1UEBhMCVVMxITAfBgNVBAoTGFRoZSBHbyBEYWRkeSBHcm91cCwgSW5jLjExMC8GA1UECxMoR28gRGFkZHkgQ2xhc3MgMiBDZXJ0aWZpY2F0aW9uIEF1dGhvcml0eTAeFw0wNjExMTYwMTU0MzdaFw0yNjExMTYwMTU0MzdaMIHKMQswCQYDVQQGEwJVUzEQMA4GA1UECBMHQXJpem9uYTETMBEGA1UEBxMKU2NvdHRzZGFsZTEaMBgGA1UEChMRR29EYWRkeS5jb20sIEluYy4xMzAxBgNVBAsTKmh0dHA6Ly9jZXJ0aWZpY2F0ZXMuZ29kYWRkeS5jb20vcmVwb3NpdG9yeTEwMC4GA1UEAxMnR28gRGFkZHkgU2VjdXJlIENlcnRpZmljYXRpb24gQXV0aG9yaXR5MREwDwYDVQQFEwgwNzk2OTI4NzCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBAMQt1RWMnCZM7DI161+4WQFapmGBWTtwY6vj3D3HKrjJM9N55DrtPDAjhI6zMBS2sofDPZVUBJ7fmd0LJR4h3mUpfjWoqVTr9vcyOdQmVZWt7/v+WIbXnvQAjYwqDL1CBM6nPwT27oDyqu9SoWlm2r4arV3aLGbqGmu75RpRSgAvSMeYddi5Kcju+GZtCpyz8/x4fKL4o/K1w/O5epHBp+YlLpyo7RJlbmr2EkRTcDCVw5wrWCs9CHRK8r5RsL+H0EwnWGu1NcWdrxcx+AuP7q2BNgWJCJjPOq8lh8BJ6qf9Z/dFjpfMFDniNoW1fho3/Rb2cRGadDAW/hOUoz+EDU8CAwEAAaOCATIwggEuMB0GA1UdDgQWBBT9rGEyk2xF1uLuhV+auud2mWjM5zAfBgNVHSMEGDAWgBTSxLDSkdRMEXGzYcs9of7dqGrU4zASBgNVHRMBAf8ECDAGAQH/AgEAMDMGCCsGAQUFBwEBBCcwJTAjBggrBgEFBQcwAYYXaHR0cDovL29jc3AuZ29kYWRkeS5jb20wRgYDVR0fBD8wPTA7oDmgN4Y1aHR0cDovL2NlcnRpZmljYXRlcy5nb2RhZGR5LmNvbS9yZXBvc2l0b3J5L2dkcm9vdC5jcmwwSwYDVR0gBEQwQjBABgRVHSAAMDgwNgYIKwYBBQUHAgEWKmh0dHA6Ly9jZXJ0aWZpY2F0ZXMuZ29kYWRkeS5jb20vcmVwb3NpdG9yeTAOBgNVHQ8BAf8EBAMCAQYwDQYJKoZIhvcNAQEFBQADggEBANKGwOy9+aG2Z+5mC6IGOgRQjhVyrEp0lVPLN8tESe8HkGsz2ZbwlFalEzAFPIUyIXvJxwqoJKSQ3kbTJSMUA2fCENZvD117esyfxVgqwcSeIaha86ykRvOe5GPLL5CkKSkB2XIsKd83ASe8T+5o0yGPwLPk9Qnt0hCqU7S+8MxZC9Y7lhyVJEnfzuz9p0iRFEUOOjZv2kWzRaJBydTXRE4+uXR21aITVSzGh6O1mawGhId/dQb8vxRMDsxuxN89txJx9OjxUUAiKEngHUuHqDTMBqLdElrRhjZkAzVvb3du6/KFUJheqwNTrZEjYx8WnM25sgVjOuH0aBsXBTWVU+4=\",\n" +
      "    \"MIIE+zCCBGSgAwIBAgICAQ0wDQYJKoZIhvcNAQEFBQAwgbsxJDAiBgNVBAcTG1ZhbGlDZXJ0IFZhbGlkYXRpb24gTmV0d29yazEXMBUGA1UEChMOVmFsaUNlcnQsIEluYy4xNTAzBgNVBAsTLFZhbGlDZXJ0IENsYXNzIDIgUG9saWN5IFZhbGlkYXRpb24gQXV0aG9yaXR5MSEwHwYDVQQDExhodHRwOi8vd3d3LnZhbGljZXJ0LmNvbS8xIDAeBgkqhkiG9w0BCQEWEWluZm9AdmFsaWNlcnQuY29tMB4XDTA0MDYyOTE3MDYyMFoXDTI0MDYyOTE3MDYyMFowYzELMAkGA1UEBhMCVVMxITAfBgNVBAoTGFRoZSBHbyBEYWRkeSBHcm91cCwgSW5jLjExMC8GA1UECxMoR28gRGFkZHkgQ2xhc3MgMiBDZXJ0aWZpY2F0aW9uIEF1dGhvcml0eTCCASAwDQYJKoZIhvcNAQEBBQADggENADCCAQgCggEBAN6d1+pXGEmhW+vXX0iG6r7d/+TvZxz0ZWizV3GgXne77ZtJ6XCAPVYYYwhv2vLM0D9/AlQiVBDYsoHUwHU9S3/Hd8M+eKsaA7Ugay9qK7HFiH7Eux6wwdhFJ2+qN1j3hybX2C32qRe3H3I2TqYXP2WYktsqbl2i/ojgC95/5Y0V4evLOtXiEqITLdiOr18SPaAIBQi2XKVlOARFmR6jYGB0xUGlcmIbYsUfb18aQr4CUWWoriMYavx4A6lNf4DD+qta/KFApMoZFv6yyO9ecw3ud72a9nmYvLEHZ6IVDd2gWMZEewo+YihfukEHU1jPEX44dMX4/7VpkI+EdOqXG68CAQOjggHhMIIB3TAdBgNVHQ4EFgQU0sSw0pHUTBFxs2HLPaH+3ahq1OMwgdIGA1UdIwSByjCBx6GBwaSBvjCBuzEkMCIGA1UEBxMbVmFsaUNlcnQgVmFsaWRhdGlvbiBOZXR3b3JrMRcwFQYDVQQKEw5WYWxpQ2VydCwgSW5jLjE1MDMGA1UECxMsVmFsaUNlcnQgQ2xhc3MgMiBQb2xpY3kgVmFsaWRhdGlvbiBBdXRob3JpdHkxITAfBgNVBAMTGGh0dHA6Ly93d3cudmFsaWNlcnQuY29tLzEgMB4GCSqGSIb3DQEJARYRaW5mb0B2YWxpY2VydC5jb22CAQEwDwYDVR0TAQH/BAUwAwEB/zAzBggrBgEFBQcBAQQnMCUwIwYIKwYBBQUHMAGGF2h0dHA6Ly9vY3NwLmdvZGFkZHkuY29tMEQGA1UdHwQ9MDswOaA3oDWGM2h0dHA6Ly9jZXJ0aWZpY2F0ZXMuZ29kYWRkeS5jb20vcmVwb3NpdG9yeS9yb290LmNybDBLBgNVHSAERDBCMEAGBFUdIAAwODA2BggrBgEFBQcCARYqaHR0cDovL2NlcnRpZmljYXRlcy5nb2RhZGR5LmNvbS9yZXBvc2l0b3J5MA4GA1UdDwEB/wQEAwIBBjANBgkqhkiG9w0BAQUFAAOBgQC1QPmnHfbq/qQaQlpE9xXUhUaJwL6e4+PrxeNYiY+Sn1eocSxI0YGyeR+sBjUZsE4OWBsUs5iB0QQeyAfJg594RAoYC5jcdnplDQ1tgMQLARzLrUc+cb53S8wGd9D0VmsfSxOaFIqII6hR8INMqzW/Rn453HWkrugp++85j09VZw==\",\n" +
      "    \"MIIC5zCCAlACAQEwDQYJKoZIhvcNAQEFBQAwgbsxJDAiBgNVBAcTG1ZhbGlDZXJ0IFZhbGlkYXRpb24gTmV0d29yazEXMBUGA1UEChMOVmFsaUNlcnQsIEluYy4xNTAzBgNVBAsTLFZhbGlDZXJ0IENsYXNzIDIgUG9saWN5IFZhbGlkYXRpb24gQXV0aG9yaXR5MSEwHwYDVQQDExhodHRwOi8vd3d3LnZhbGljZXJ0LmNvbS8xIDAeBgkqhkiG9w0BCQEWEWluZm9AdmFsaWNlcnQuY29tMB4XDTk5MDYyNjAwMTk1NFoXDTE5MDYyNjAwMTk1NFowgbsxJDAiBgNVBAcTG1ZhbGlDZXJ0IFZhbGlkYXRpb24gTmV0d29yazEXMBUGA1UEChMOVmFsaUNlcnQsIEluYy4xNTAzBgNVBAsTLFZhbGlDZXJ0IENsYXNzIDIgUG9saWN5IFZhbGlkYXRpb24gQXV0aG9yaXR5MSEwHwYDVQQDExhodHRwOi8vd3d3LnZhbGljZXJ0LmNvbS8xIDAeBgkqhkiG9w0BCQEWEWluZm9AdmFsaWNlcnQuY29tMIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDOOnHK5avIWZJV16vYdA757tn2VUdZZUcOBVXc65g2PFxTXdMwzzjsvUGJ7SVCCSRrCl6zfN1SLUzm1NZ9WlmpZdRJEy0kTRxQb7XBhVQ7/nHk01xC+YDgkRoKWzk2Z/M/VXwbP7RfZHM047QSv4dk+NoS/zcnwbNDu+97bi5p9wIDAQABMA0GCSqGSIb3DQEBBQUAA4GBADt/UG9vUJSZSWI4OB9L+KXIPqeCgfYrx+jFzug6EILLGACOTb2oWH+heQC1u+mNr0HZDzTuIYEZoDJJKPTEjlbVUjP9UNV+mWwD5MlM/Mtsq2azSiGM5bUMMj4QssxsodyamEwCW/POuZ6lcg5Ktz885hZo+L7tdEy8W9ViH0Pd\"\n" +
      "  ],\n" +
      "  \"use\": \"sig\",\n" +
      "  \"kid\": \"somekey\"\n" +
      "}\n");

    try {
      // the chain above contains expired certificates,
      // we only test that the runtime exception cause if correct
      new JWK(jwk);
    } catch (RuntimeException e) {
      throw e.getCause();
    }
  }

}
