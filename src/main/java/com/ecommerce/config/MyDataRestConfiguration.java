package com.ecommerce.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;

import com.ecommerce.entity.Product;
import com.ecommerce.entity.ProductCategory;

@Configuration
public class MyDataRestConfiguration implements RepositoryRestConfigurer {
	
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		
		HttpMethod[] theUnsupportedMethod = {HttpMethod.PUT,HttpMethod.PATCH,HttpMethod.DELETE};
		
		config.getExposureConfiguration()
		.forDomainType(Product.class)
		.withItemExposure((metadata,httpMethod) -> httpMethod.disable(theUnsupportedMethod))
		.withCollectionExposure((metadata,httpMethod) -> httpMethod.disable(theUnsupportedMethod));
		
		
		config.getExposureConfiguration()
		.forDomainType(ProductCategory.class)
		.withItemExposure((metadata,httpMethod) -> httpMethod.disable(theUnsupportedMethod))
		.withCollectionExposure((metadata,httpMethod) -> httpMethod.disable(theUnsupportedMethod));
		
	}

}
