package com.project.gestiondestock.interceptor;

import org.hibernate.EmptyInterceptor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.util.StringUtils;

import org.slf4j.MDC;
public class Interceptor extends EmptyInterceptor {
    /* @Override
    public String onPrepareStatement(String sql) {
        if (StringUtils.hasLength(sql) && sql.toLowerCase().startsWith("select")) {
            if (sql.contains("where")) {
                sql = sql + "and idEntreprise = 2";
            } else {
                sql = sql + "where idEntreprise = 2";
            }
        }
        return super.onPrepareStatement(sql);
    }*/

    @Override
    public String onPrepareStatement(String sql) {
        if (StringUtils.hasLength(sql) && sql.toLowerCase().startsWith("select")) {
            // select utilisateu0_.
            final String entityName = sql.substring(7, sql.indexOf("."));
            final String idEntreprise = MDC.get("idEntreprise");
            if (StringUtils.hasLength(entityName)
                    && !entityName.toLowerCase().contains("entreprise")
                    && !entityName.toLowerCase().contains("roles")
                    && StringUtils.hasLength(idEntreprise)) {

                if (sql.contains("where")) {
                    sql = sql + " and " + entityName + ".identreprise = " + idEntreprise;
                } else {
                    sql = sql + " where " + entityName + ".identreprise = " + idEntreprise;
                }
            }
        }
        return super.onPrepareStatement(sql);
    }
}