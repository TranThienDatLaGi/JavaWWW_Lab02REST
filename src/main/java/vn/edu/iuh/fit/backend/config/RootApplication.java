package vn.edu.iuh.fit.backend.config;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import vn.edu.iuh.fit.backend.converts.ObjectMapperContextResolver;
import vn.edu.iuh.fit.backend.resources.ProductPriceResource;

import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/api")
public class RootApplication extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();
        // Đăng ký các lớp resource của bạn ở đây.
        classes.add(ProductPriceResource.class);
        // Đăng ký ParamConverterProvider tùy chỉnh
        classes.add(ObjectMapperContextResolver.class);
        return classes;
    }
}
