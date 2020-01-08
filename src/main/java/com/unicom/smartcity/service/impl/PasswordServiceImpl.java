package com.unicom.smartcity.service.impl;

import com.unicom.smartcity.service.PasswordService;
import org.springframework.stereotype.Component;

/**
 * @author liukai
 */
@Component
public class PasswordServiceImpl implements PasswordService {

    @Override
    public String getDefaultPassword() {
        return "$2a$10$MRvz/BeD7LsXNFfByECtfe7mQb21z7SNw.RwUXCAkKIc2XQ22qHg2";
    }

}
