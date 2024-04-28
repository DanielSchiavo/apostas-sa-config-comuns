package com.apostassa.aplicacao;

import com.apostassa.dominio.usuario.Usuario;
import com.apostassa.dominio.usuario.exceptions.AutenticacaoException;

import java.util.Map;

public interface Token {
	
	public String gerarToken(Usuario usuario) throws AutenticacaoException;

	public void verificarToken(String token) throws AutenticacaoException;

	public String getClaimEmail(String token) throws AutenticacaoException;

	public String getSubject(String token) throws AutenticacaoException;

	public String getRoles(String token) throws AutenticacaoException;

	public Map<String, String> pegarTodosAtributos(String token) throws AutenticacaoException;
}
