package biz.sunce.web.controller.config;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Provider
public class JacksonConfigProvider implements ContextResolver<ObjectMapper>
{
	private final static Logger LOG = Logger.getLogger(JacksonConfigProvider.class);
	
    private final ObjectMapper objectMapper;
    
    public JacksonConfigProvider()
    {
        objectMapper = new ObjectMapper();
        
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        objectMapper.configure(SerializationFeature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED, false);
        LOG.info("ObjectMapper uspjesno inicijaliziran");
    }
    
    @Override
    public ObjectMapper getContext(Class<?> objectType)
    {
    	
        return objectMapper;
    }
}