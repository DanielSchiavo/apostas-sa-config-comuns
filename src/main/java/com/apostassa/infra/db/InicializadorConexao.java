package com.apostassa.infra.db;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class InicializadorConexao {

    public static ProvedorConexaoJDBC executa(HttpServletRequest req) throws ServletException, IOException {
        try {
            ServletContext servletContext = req.getServletContext();
            DataSource pool = (DataSource) servletContext.getAttribute("my-pool");
            Connection conexao = pool.getConnection();
            return new ProvedorConexaoJDBC(conexao);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException("Erro ao inicializar implementação do repositorio de usuario");
        }
    }

}
