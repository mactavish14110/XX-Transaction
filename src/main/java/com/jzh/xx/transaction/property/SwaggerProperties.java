package com.jzh.xx.transaction.property;

import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Configuration
public class SwaggerProperties {

    private List<String> basePackages = new ArrayList(Collections.singletonList("com.jzh.xx.transaction"));
    private List<String> basePath = new ArrayList();
    private List<String> excludePath = new ArrayList();
    private String title = "闲闲二手 接口文档系统";
    private String description = "闲闲二手 接口文档系统";
    private String version = "1.0.0.RELEASE";
    private String license = "Powered By jzh";
    private String licenseUrl = "https://gitee.com/youth_and_pig";
    private String termsOfServiceUrl = "https://gitee.com/youth_and_pig";
    private String host = "";
    private SwaggerProperties.Contact contact = new SwaggerProperties.Contact();
    private SwaggerProperties.Authorization authorization = new SwaggerProperties.Authorization();

    public SwaggerProperties() {
    }

    public List<String> getBasePackages() {
        return this.basePackages;
    }

    public List<String> getBasePath() {
        return this.basePath;
    }

    public List<String> getExcludePath() {
        return this.excludePath;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public String getVersion() {
        return this.version;
    }

    public String getLicense() {
        return this.license;
    }

    public String getLicenseUrl() {
        return this.licenseUrl;
    }

    public String getTermsOfServiceUrl() {
        return this.termsOfServiceUrl;
    }

    public String getHost() {
        return this.host;
    }

    public SwaggerProperties.Contact getContact() {
        return this.contact;
    }

    public SwaggerProperties.Authorization getAuthorization() {
        return this.authorization;
    }

    public void setBasePackages(final List<String> basePackages) {
        this.basePackages = basePackages;
    }

    public void setBasePath(final List<String> basePath) {
        this.basePath = basePath;
    }

    public void setExcludePath(final List<String> excludePath) {
        this.excludePath = excludePath;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public void setVersion(final String version) {
        this.version = version;
    }

    public void setLicense(final String license) {
        this.license = license;
    }

    public void setLicenseUrl(final String licenseUrl) {
        this.licenseUrl = licenseUrl;
    }

    public void setTermsOfServiceUrl(final String termsOfServiceUrl) {
        this.termsOfServiceUrl = termsOfServiceUrl;
    }

    public void setHost(final String host) {
        this.host = host;
    }

    public void setContact(final SwaggerProperties.Contact contact) {
        this.contact = contact;
    }

    public void setAuthorization(final SwaggerProperties.Authorization authorization) {
        this.authorization = authorization;
    }

    public static class AuthorizationScope {
        private String scope = "";
        private String description = "";

        public String getScope() {
            return this.scope;
        }

        public String getDescription() {
            return this.description;
        }

        public void setScope(final String scope) {
            this.scope = scope;
        }

        public void setDescription(final String description) {
            this.description = description;
        }

        public AuthorizationScope() {
        }
    }

    public static class Authorization {
        private String name = "";
        private String authRegex = "^.*$";
        private List<SwaggerProperties.AuthorizationScope> authorizationScopeList = new ArrayList();
        private List<String> tokenUrlList = new ArrayList();

        public String getName() {
            return this.name;
        }

        public String getAuthRegex() {
            return this.authRegex;
        }

        public List<SwaggerProperties.AuthorizationScope> getAuthorizationScopeList() {
            return this.authorizationScopeList;
        }

        public List<String> getTokenUrlList() {
            return this.tokenUrlList;
        }

        public void setName(final String name) {
            this.name = name;
        }

        public void setAuthRegex(final String authRegex) {
            this.authRegex = authRegex;
        }

        public void setAuthorizationScopeList(final List<SwaggerProperties.AuthorizationScope> authorizationScopeList) {
            this.authorizationScopeList = authorizationScopeList;
        }

        public void setTokenUrlList(final List<String> tokenUrlList) {
            this.tokenUrlList = tokenUrlList;
        }

        public Authorization() {
        }
    }

    public static class Contact {
        private String name = "youth_and_pig";
        private String url = "https://gitee.com/youth_and_pig/second-hand-trading-website";
        private String email = "1026981384@qq.com";

        public String getName() {
            return this.name;
        }

        public String getUrl() {
            return this.url;
        }

        public String getEmail() {
            return this.email;
        }

        public void setName(final String name) {
            this.name = name;
        }

        public void setUrl(final String url) {
            this.url = url;
        }

        public void setEmail(final String email) {
            this.email = email;
        }

        public Contact() {
        }
    }
}
