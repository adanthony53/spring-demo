## spring demo exercise

spring demo exercise

GitHub OAuth LogIn Info
https://developer.github.com/apps/building-oauth-apps/creating-an-oauth-app/

OkHttp
https://square.github.io/okhttp/

Session and Cookies
session - bank account
cookies - card

Use database to keep user logged in even after refresh the server
In this project, use H2 database.

Maven command for MyBatis Generator
mvn -Dmybatis.generator.overwrite=true mybatis-generator:generate

            <plugin>
                <groupId>org.mybatis.generator</groupId>
                <artifactId>mybatis-generator-maven-plugin</artifactId>
                <version>1.4.0</version>
                <dependencies>
                    <dependency>
                        <groupId>com.h2database</groupId>
                        <artifactId>h2</artifactId>
                        <version>1.4.199</version>
                    </dependency>
                </dependencies>
            </plugin>
            
            -------------------------
            
            <?xml version="1.0" encoding="UTF-8"?>
            <!DOCTYPE generatorConfiguration
                    PUBLIC "-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN"
                    "http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd">
            
            <generatorConfiguration>
            
                <context id="DB2Tables" targetRuntime="MyBatis3">
            
                    <plugin type="org.mybatis.generator.plugins.RowBoundsPlugin"></plugin>
                    <jdbcConnection driverClass="org.h2.Driver"
                                    connectionURL="jdbc:h2:~/demo"
                                    userId="user"
                                    password="123">
                    </jdbcConnection>
            
                    <javaTypeResolver>
                        <property name="forceBigDecimals" value="false"/>
                    </javaTypeResolver>
            
                    <javaModelGenerator targetPackage="com.example.demo.model" targetProject="src/main/java">
                        <property name="enableSubPackages" value="true"/>
                        <property name="trimStrings" value="true"/>
                    </javaModelGenerator>
            
                    <sqlMapGenerator targetPackage="mapper" targetProject="src/main/resources">
                        <property name="enableSubPackages" value="true"/>
                    </sqlMapGenerator>
            
                    <javaClientGenerator type="XMLMAPPER" targetPackage="com.example.demo.mapper"
                                         targetProject="src/main/java">
                        <property name="enableSubPackages" value="true"/>
                    </javaClientGenerator>
            
                    <table tableName="user" domainObjectName="User"></table>
                    <table tableName="question" domainObjectName="Question"></table>
                    <!--
                    <table tableName="comment" domainObjectName="Comment"></table>
                    <table tableName="notification" domainObjectName="Notification"></table>
                    <table tableName="nav" domainObjectName="Nav"></table>
                    <table tableName="ad" domainObjectName="Ad"></table>
                    -->
                </context>
            </generatorConfiguration>