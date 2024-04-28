package com.apostassa.infra.util;

import com.apostassa.dominio.GeradorUUID;

import java.util.UUID;


public class GeradorUUIDImpl implements GeradorUUID {

	@Override
	public UUID gerarUUID() {
		return UUID.randomUUID();
	}

}
