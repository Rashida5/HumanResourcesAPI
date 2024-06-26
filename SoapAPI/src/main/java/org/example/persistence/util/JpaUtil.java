package org.example.persistence.util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.cfg.AvailableSettings;

import java.util.Map;

public class JpaUtil {
    private static final EntityManagerFactory emf;

    static {
        emf = Persistence.createEntityManagerFactory("humanresources", Map.of(AvailableSettings.DATASOURCE, createHikariCpDataSource()));
    }

    private static HikariDataSource createHikariCpDataSource() {
        HikariConfig config = new HikariConfig();
        HikariDataSource ds;
        config.setJdbcUrl("jdbc:mysql://localhost:3306/humanresources");
        config.setUsername("root");
        config.setPassword("1234");
        // max number of connections on database .
        config.setMaximumPoolSize(10);
        config.addDataSourceProperty("cachePrepStmts", true);
        // configurations exists in database .
        config.addDataSourceProperty("prepStmtCacheSize", 250);
        config.addDataSourceProperty("prepStmtCacheSqlLimit", 2048);
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds = new HikariDataSource(config);
        return ds;
    }

    public static EntityManager createEntityManager() {
        return emf.createEntityManager();
    }

    public static void closeEntityManagerFactory() {
        closeEntityManagerFactory();
    }

}
