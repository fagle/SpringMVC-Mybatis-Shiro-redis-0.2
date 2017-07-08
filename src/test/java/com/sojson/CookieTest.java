package com.sojson;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.io.DefaultSerializer;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.Principal;

/**
 * Created by fagle on 2017/7/6.
 */
public class CookieTest extends TestSupport {

    @Autowired
    private CookieRememberMeManager rememberMeManager;

    @Test
    public void decryptTest() throws Exception{
        byte[]  bytes = "8sCwOqV22xGdeggzPlrOcb4iNqKC0+DfiYzDLkK/OYZpHhzZVIcdnpPWuOSE3klZM/td2wSXjX81Ryn1KTIJVLW5F3CzYFyvJVyJFbmocPmQYMbQuX2PQdMMvZpfdf7kXUzr/seigzoGNam/rghuxYIDlsa/OEOwAsC6lAanaQhVEeqkhe+jROzDoT0YfeYfJUVcQJrTnrtsBEt9FhLNHQThzOTW4D6kWIngqYgCDoWhIWirm684EJO18r/tP1H+WEFn7KDon7lq3R8rAf7Sc6lK7h2JbZWZA0Q3x3xIWtam7IEHB5xoEu89ZHqiVlYxocLL/nrsmsJERBollSq6PE8YGHuZb3lp756ycFZC7DKPAkIHE7jtpFqgsheOkKA1ANG3R61c+xPzj3fh2okbQ1QpGwUpm5qn9JrSXN7SW1XzHXm4vEYCCIp4dtbawrUj0M3AlOiAQ4m6D/0SDlN40rs9bQa6FpvVebY2Y4zMnK4N1fYVw6s4Zz6voOCL19Im1MdS8nYp7aENOJCZ7ME8pp5nOj09mySQRtBhBFFILR8FyYAFGSgCXwhjriaRHPvbKKsNKMFAvR5VVZ13nI+jimC87SkbbkR8bb8MhDcs54G6iuDo8uU7L1VGIOREMwBRUw5qDh5HIddn/iUwcgUPHpGFfE2n/I5RRntu6YgTb9t2Z34m4MagGdpzkho9zevQgq6j4L2HygNrm4eC+Q6oSymcLqcIwO5D9yjDylxQw/iUZ3m4GFjuGk/RgKbcKGcdonffnfwJ9sgR3zGYgZxdGrhh5Huyj0rpVbmhJdyVohBCo3M/0L7aAtGnogDbySuPr5MnKev11vPXRJcfkAcSqc+ZiIynuipBT+D32jSOGsPsQlE9Lsip4IiIAWvAokLONmHAOwDtClMwyGjmco+QkFi+hvVkza5h9jgS1zas7SdgP7yAq1WGqR05+o7/wLr+7ZqkgYyiB40mdAEuI6PLEXZRJvMtqpJGtMWHcwrfon4=".getBytes();
        bytes = Base64.decode(bytes);
        bytes = rememberMeManager.getCipherService().decrypt(bytes, rememberMeManager.getCipherKey()).getBytes();
        PrincipalCollection principals;
        principals = new DefaultSerializer<PrincipalCollection>().deserialize(bytes);
        for (Object p : principals) {
            logger.info(p);
        }
    }
}
