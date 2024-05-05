package com.apostassa.aplicacao;

public interface ProvedorConexao {

    public void fecharConexao();

    public void commitarTransacao();

    public void rollbackTransacao();
}
