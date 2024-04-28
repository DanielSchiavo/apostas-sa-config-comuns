package com.apostassa.aplicacao;


import com.apostassa.dominio.usuario.exceptions.AutenticacaoException;

public interface CriptografiaSenha {

	public String criptografarSenha(String senha);

	public void verificarSenha(String senhaCriptografada, String senhaSemCriptografia) throws AutenticacaoException;
}
