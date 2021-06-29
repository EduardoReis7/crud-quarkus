package com.er;

import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;

//public class DatabaseLifecycle implements QuarkusTestResourceLifecycleManager {

//    private static MySQLContainer<?> MYSQL = new MySQLContainer<>("mysql");
//    @Override
//    public Map<String, String> start() {
//        MYSQL.start();
//        HashMap<String, String> propriedades = new HashMap<>();
//        propriedades.put("quarkus.datasource.jdbc.url", MYSQL.getJdbcUrl());
//        propriedades.put("quarkus.datasource.username", MYSQL.getUsername());
//        propriedades.put("quarkus.datasource.password", MYSQL.getPassword());
//
//        return propriedades;
//    }
//
//    @Override
//    public void stop() {
//        if (MYSQL != null) {
//            MYSQL.stop();
//        }
//    }
//}
