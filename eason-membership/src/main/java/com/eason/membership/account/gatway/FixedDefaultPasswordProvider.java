package com.eason.membership.account.gatway;

import com.eason.membership.account.domain.DefaultPasswordProvider;
import org.springframework.stereotype.Service;

/**
 * @author colin
 */
@Service
public class FixedDefaultPasswordProvider implements DefaultPasswordProvider {
    @Override
    public String generate() {
        return "123456";
    }
}
