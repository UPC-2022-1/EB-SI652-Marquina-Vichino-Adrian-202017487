package com.si652ebu202017487.art.magnet.partner.u202017487.shared.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("enhancedModelMapperConfiguration")
public class MappingConfiguration {

	@Bean
	public EnhancedModelMapper modelMapper() {
		return new EnhancedModelMapper();
	}
}