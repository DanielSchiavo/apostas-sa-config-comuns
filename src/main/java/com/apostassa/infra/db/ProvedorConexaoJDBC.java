package com.apostassa.infra.db;

import com.apostassa.aplicacao.ProvedorConexao;
import lombok.Getter;

import java.sql.Connection;
import java.sql.SQLException;

@Getter
public class ProvedorConexaoJDBC implements ProvedorConexao {

    private Connection conexao;

    public ProvedorConexaoJDBC(Connection conexao) {
        this.conexao = conexao;
    }

    @Override
    public void fecharConexao() {
        try {
            conexao.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void commitarTransacao() {
        try {
            getConexao().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void rollbackTransacao() {
        try {
            getConexao().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
