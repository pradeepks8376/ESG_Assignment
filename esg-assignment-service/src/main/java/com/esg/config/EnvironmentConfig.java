package com.esg.config;

import com.esg.constant.Constants;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class EnvironmentConfig {

    @Value(Constants.SAVE_URL)
    private String saveEndpoint;
}
