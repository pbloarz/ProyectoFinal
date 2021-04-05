package com.seminario.auth;

public class JwtConfig {

    public static final String LLAVE_SECRETA = "alguna.clave.secreta.12345678";

    public static final String RSA_PRIVADA = "-----BEGIN RSA PRIVATE KEY-----\r\n"
            + "MIIEowIBAAKCAQEAtwYrii91mDIN/P6v8wfRI9prqcCZwU4WILyN0DjSOd4t3Ius\r\n"
            + "snPYhoL5nzKoxWCZ3P9SW9LCJGahh3YQSYBa3uKg8vjTRmlgJPPw9L2FDn64g6SU\r\n"
            + "ZR3/rgjolDX9Eqp/naFOyEHLeZJvsyQPoyuubUf4TPko6IzkDZSWgX8fRzxFXmQA\r\n"
            + "P4AP9U+/jEp/eKX4bx5FqGhu9q1rN+O22vVARkoGXF2ndg9nUUpMmCF6e5MfslvB\r\n"
            + "RS2GvyzB4bq6XDo8ZtHRw9YlVcYKavCg1ZZd9VlCY1DVBOFPJ34ZqB72+Fx4582X\r\n"
            + "ZqXduI/0XFZJWZ8e49KU28/9GWnhhz+4kWUQ9QIDAQABAoIBAE5I1VbF9gajYlhU\r\n"
            + "l+3b6hjr1CFHwHxuagiWnhHyO/mEjxlGpRevdW4Tl7IAeS/zodxlWVTtUR1AyNao\r\n"
            + "KU9HF5c+WJmU1MnJSNaFgQsuBTut+D5WpyKZMkO+i7zZWuYhB3TlCk2d1uqpOB3n\r\n"
            + "zsh8Zp9XqV1DNbxCh0lHxRiex0IwS5RDHsHpHbhAU1P88IDur+1RsS3Z/rKgX2P9\r\n"
            + "9rDlUFKRf7ZkX8oWLIcMVoIBGx6bpcJPSUGwLXogSJSdACiS/nrIcSE18/jwzQgm\r\n"
            + "hDJGnSsNlxsripghfaDHUiBbl8IRJl3D+/GvG8nwFUReOitkONGTeYGKIjK1kxCe\r\n"
            + "/fW+AgECgYEA7I4yyp3WU4rq1or6zIwSEDughEadgrzTiDpW66Rlh45Phbnqafsd\r\n"
            + "j25zFRyUj6CaqCFvPTzg16J3xrOO9l011g1t0rKbu7N0DiXwdgQ85Zvxo/LEEMPk\r\n"
            + "8AOHecCsaK5tM2HfUUKBSMJKk50u9MWDMxEnnUTVS54tx8Y4iACxxKcCgYEAxhGE\r\n"
            + "6G9Th4IVUNssAUNhMix2dpLJWNKzJZSpMHvbsTHTLPuLleVpKXIaKVMBi+F77xwh\r\n"
            + "A0r9WWR4wWsylvDQm/672d1v/amVJT9FBcT6D0ZPor5CxySHRygCbwfCs2yhKssY\r\n"
            + "tLOH0c+WVb9EkUauSy98sULIGiGXz3gYlz5ThQMCgYB5qWDCCI90hBvnn68BiIC5\r\n"
            + "zJDvtwnHdaothCO0Keb14uFPW6EORNKdNCcIEpztiaJBGoEFs8vH241SqoK6fpHz\r\n"
            + "txBmrumdjdwAcs7LQ762MJAEzBS+sqGKN6Zznf6OEDell46tUlD/xL1qUgsWZIbn\r\n"
            + "usju/7nbnEzbVD065XCIPQKBgF6qYuagxsB+aOezSS31YVAUti3n7Dn6wkrU6aRV\r\n"
            + "nmPrV24pb8ad1gxMD7ruhE+x3oUi4ZhsT/hYr+pp7Mz9ngbg0jHHx03qrnEV80xV\r\n"
            + "n9qLFWbIHqyFhe55behZQjJ1WfZVCaLcJ68c01J6TzBMIuOmd6dVLsRmh+NOGBq5\r\n"
            + "XDu3AoGBAKfY7wF0YMeO0rc9r8RLddnaTcRkUNpFdcUgtOKQSevO0ODLpRqqJiae\r\n"
            + "mIeoUnrraeCqcyaRpurM4mNQxw/TLiUsp/krXimqkWw8b7PloxbKdKCSe/SIV2Nd\r\n"
            + "4zokDfHUFlhAioayzxtgmretvFHhaxscCtnMUMrsPDxtCG6Y+Lrl\r\n" + "-----END RSA PRIVATE KEY-----";
    public static final String RSA_PUBLICA = "-----BEGIN PUBLIC KEY-----\r\n"
            + "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtwYrii91mDIN/P6v8wfR\r\n"
            + "I9prqcCZwU4WILyN0DjSOd4t3IussnPYhoL5nzKoxWCZ3P9SW9LCJGahh3YQSYBa\r\n"
            + "3uKg8vjTRmlgJPPw9L2FDn64g6SUZR3/rgjolDX9Eqp/naFOyEHLeZJvsyQPoyuu\r\n"
            + "bUf4TPko6IzkDZSWgX8fRzxFXmQAP4AP9U+/jEp/eKX4bx5FqGhu9q1rN+O22vVA\r\n"
            + "RkoGXF2ndg9nUUpMmCF6e5MfslvBRS2GvyzB4bq6XDo8ZtHRw9YlVcYKavCg1ZZd\r\n"
            + "9VlCY1DVBOFPJ34ZqB72+Fx4582XZqXduI/0XFZJWZ8e49KU28/9GWnhhz+4kWUQ\r\n" + "9QIDAQAB\r\n"
            + "-----END PUBLIC KEY-----";

    JwtConfig() {
        throw new IllegalStateException("Utility class");
    }

}
