package com.apostassa.infra.security;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.apostassa.dominio.usuario.exceptions.AutenticacaoException;

public class CriptografiaBCrypt {

	public static String criptografarSenha(String senha) {
		return BCrypt.withDefaults().hashToString(12, senha.toCharArray());
	}

	public static void verificarSenha(String senhaCriptografada, String senhaSemCriptografia) throws AutenticacaoException {
		BCrypt.Verifyer verifyer = BCrypt.verifyer();
		BCrypt.Result result = verifyer.verify(senhaSemCriptografia.toCharArray(), senhaCriptografada);
		if (!result.verified) {
			throw new AutenticacaoException();
		}
	}

}
