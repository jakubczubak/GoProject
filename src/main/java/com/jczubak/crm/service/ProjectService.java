package com.jczubak.crm.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    public static String removeAccents(String name){

        return StringUtils.stripAccents(name).replace(" ", "-");

    }
}
