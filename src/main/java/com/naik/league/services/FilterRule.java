package com.naik.league.services;

import com.naik.league.configuration.ConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

interface FilterRule <I,O>{
    O process(I input);
}