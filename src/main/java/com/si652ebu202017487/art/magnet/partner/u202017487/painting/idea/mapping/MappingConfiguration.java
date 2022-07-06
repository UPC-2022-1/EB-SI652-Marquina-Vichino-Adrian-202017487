package com.si652ebu202017487.art.magnet.partner.u202017487.painting.idea.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("ideasMappingConfiguration")
public class MappingConfiguration {
	@Bean
	public IdeasMapper studentMapper() {
		return new IdeasMapper();
	}
}